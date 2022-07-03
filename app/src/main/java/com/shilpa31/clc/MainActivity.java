
package com.shilpa31.clc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shilpa31.clc.Database.RoomDB;
import com.shilpa31.clc.Models.Notes;
import com.shilpa31.clc.adapters.noteslistadp;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
noteslistadp noteslistadp;
List<Notes> notes =new ArrayList<>();
RoomDB database;
FloatingActionButton fab_add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
recyclerView =findViewById(R.id.recycler_home);
    fab_add =findViewById(R.id.fab_add);
    database=RoomDB.getInstance(this);
    notes=database.dbo().getAll();

    updateRecycler(notes);
    fab_add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
              Intent intent=new Intent(MainActivity.this,NotesTickerActivity.class);
              startActivityForResult(intent,101);
        }
    });


    }

    private void updateRecycler(List<Notes> notes) {

    recyclerView.setHasFixedSize(true);
    noteslistadp=new noteslistadp(MainActivity.this,notes,notesClickListener);
    recyclerView.setAdapter(noteslistadp);
    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL));

    }
    private final NotesClickListener notesClickListener=new NotesClickListener() {
        @Override
        public void onCick(Notes notes) {

        }

        @Override
        public void onLongClick(Notes notes, CardView cardView) {

        }

        @Override
        public void onClick(Notes notes) {

        }
    };
}