package com.example.alexanderdrumond.work2.models;

import com.orm.SugarRecord;

/**
 * Created by Alexander Drumond on 02-06-2017.
 */

public class Pending extends SugarRecord {

    public Pending() {
    }

    private boolean done;
    private String name, description;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
