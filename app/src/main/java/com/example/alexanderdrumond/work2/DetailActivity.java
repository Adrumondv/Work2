package com.example.alexanderdrumond.work2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.alexanderdrumond.work2.models.Pending;

public class DetailActivity extends AppCompatActivity {

    private Pending pending;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        long id = getIntent().getLongExtra(PendingsListFragment.PENDING_ID,0);
        pending = Pending.findById(Pending.class,id);

        getSupportActionBar().setTitle(pending.getName());

        editText = (EditText) findViewById(R.id.descriptionEt);

        String description = pending.getDescription();
        if (description != null){
            editText.setText(description);
        }
        }

    @Override
    protected void onPause() {
        super.onPause();
        pending.setDescription(editText.getText().toString());
        pending.save();
    }
}

