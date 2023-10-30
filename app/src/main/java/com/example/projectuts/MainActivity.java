package com.example.projectuts;

import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvList;
    private ArrayList<List> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvList = findViewById(R.id.rv_ListMain);
        rvList.setHasFixedSize(true);

        list.addAll(getListHeroes());
        showRecyclerList();
    }

    public ArrayList<List> getListHeroes() {
        String[] dataName = getResources().getStringArray(R.array.nama_user);
        String[] dataDescription = getResources().getStringArray(R.array.desc_user);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.photo_user);
        ArrayList<List> listUser = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            List user = new List();
            user.setName(dataName[i]);
            user.setDescription(dataDescription[i]);
            user.setPhoto(dataPhoto.getResourceId(i, -1));
            listUser.add(user);
        }
        return listUser;
    }

    private void showRecyclerList() {
        rvList.setLayoutManager(new GridLayoutManager(this, 2));
        if(getApplicationContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvList.setLayoutManager(new GridLayoutManager(this, 2));
        } else {

            rvList.setLayoutManager(new LinearLayoutManager(this));
        }
        List_Adapter listAdapter = new List_Adapter(list);
        rvList.setAdapter(listAdapter);
    }
}