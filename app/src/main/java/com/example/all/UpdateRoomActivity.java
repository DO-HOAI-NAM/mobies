package com.example.all;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UpdateRoomActivity extends AppCompatActivity {
    EditText roomname, roomday, roomtime, roomduration, roomcapacity,roomprice,roomtype,roomdescription;
    Button btnUpdate;
    String pid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_room);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        roomname = (EditText) findViewById(R.id.roomname);
        roomday = (EditText) findViewById(R.id.roomday);
        roomtime = (EditText) findViewById(R.id.roomtime);
        roomduration = (EditText) findViewById(R.id.roomduration);
        roomcapacity = (EditText) findViewById(R.id.roomcapacity);
        roomprice = (EditText) findViewById(R.id.roomprice);
        roomtype = (EditText) findViewById(R.id.roomtype);
        roomdescription = (EditText) findViewById(R.id.roomdescription);

        pid =getIntent().getStringExtra("pid").toString();

        roomname.setText(getIntent().getStringExtra("NAME").toString());
        roomday.setText(getIntent().getStringExtra("DAY").toString());
        roomtime.setText(getIntent().getStringExtra("TIME").toString());
        roomduration.setText(getIntent().getStringExtra("DURATION").toString());
        roomcapacity.setText(getIntent().getStringExtra("CAPACITY").toString());
        roomprice.setText(getIntent().getStringExtra("PRICE").toString());
        roomtype.setText(getIntent().getStringExtra("TYPE").toString());
        roomdescription.setText(getIntent().getStringExtra("DESCRIPTION").toString());



        btnUpdate = (Button) findViewById(R.id.btnUpdate);


    }
}