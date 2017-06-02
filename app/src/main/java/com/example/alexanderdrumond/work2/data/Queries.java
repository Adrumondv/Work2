package com.example.alexanderdrumond.work2.data;

import com.example.alexanderdrumond.work2.models.Pending;

import java.util.List;

/**
 * Created by Alexander Drumond on 02-06-2017.
 */

public class Queries {

    public List<Pending> pendings()
     {
        return Pending.find(Pending.class, "done = 0");
    }
}
