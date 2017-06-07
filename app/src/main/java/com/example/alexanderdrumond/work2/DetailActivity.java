package com.example.alexanderdrumond.work2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.alexanderdrumond.work2.models.Pending;

public class DetailActivity extends AppCompatActivity {

    private Pending pending;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Button button = (Button) findViewById(R.id.sendBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("*/*");
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Recordatorio");
                intent.putExtra(Intent.EXTRA_TEXT, editText.getText().toString());
                startActivity(intent);
            }
        });

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

