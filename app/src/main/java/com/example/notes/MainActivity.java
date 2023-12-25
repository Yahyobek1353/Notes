package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnAdd;
    private NoteAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        btnListener();
        getNotes();
    }

    private void initViews() {
        RecyclerView recyclerView = findViewById(R.id.rv_list);
        adapter = new NoteAdapter(this);
        recyclerView.setAdapter(adapter);
        btnAdd = findViewById(R.id.btn_add);
    }

    private void getNotes() {
        if (getIntent() != null) {
            Note note = (Note) getIntent().getSerializableExtra("note");
            if (note != null) {
                adapter.addNote(note);
            }
        }
    }

    private void btnListener() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Seacon.class);
                startActivity(intent);
            }
        });
    }
}

