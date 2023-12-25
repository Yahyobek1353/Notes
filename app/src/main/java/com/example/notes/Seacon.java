package com.example.notes;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Seacon extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView imageView;
    private Button btn_save;
    private EditText title , desc;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seacon);
        initView();
        initLisner();

    }
    private void initView(){
        imageView = findViewById(R.id.img_add);
        btn_save = findViewById(R.id.btn_add);
        title = findViewById(R.id.tae);
        desc = findViewById(R.id.tae2);

    }
    private void getNotes(){

    }

    private void initLisner(){
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String notetitle = title.getText().toString();
                String noteDesc = desc.getText().toString();
                Date d = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy", Locale.getDefault());
                String noteDate = df + " / " + d;
                Intent i = new Intent(Seacon.this , MainActivity.class);
                Note note = new Note(notetitle , noteDesc , noteDate,0);
                i.putExtra("note");
            }
        });
    }
}
