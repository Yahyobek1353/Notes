package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private RecyclerView recyclerView;
    private NoteAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
     private void initView(){
         button = findViewById(R.id.btn_add);
        recyclerView = findViewById(R.id.Data_et);
        adapter = new NoteAdapter(this);
        recyclerView.setAdapter(adapter);

    }
    private void getNotes(){
        if (getIntent() != null) {
            Note n;
            n = (Note) getIntent().putExtra("note");
            adapter.addNote(n);
        }
    }

    private void btnListener(){
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this, Seacon.class);
               startActivity(intent);
           }
       });
    }

}