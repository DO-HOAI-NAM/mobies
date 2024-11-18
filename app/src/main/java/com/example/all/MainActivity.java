package com.example.all;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.all.helper.DatabaseHepler;

public class MainActivity extends AppCompatActivity {
    EditText editNameRoom,editDayOfWeek,editCourseTime,editCapacity,editDuration,editPricePerClass,editClassType,editDescription;
    Button btnAdd,btnListRoom,btnDetailRoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editNameRoom = (EditText) findViewById(R.id.editNameRoom);
        editDayOfWeek = (EditText) findViewById(R.id.editDayOfWeek);
        editCourseTime = (EditText) findViewById(R.id.editCourseTime);
        editCapacity = (EditText) findViewById(R.id.editCapacity);
        editDuration = (EditText) findViewById(R.id.editDuration);
        editPricePerClass = (EditText) findViewById(R.id.editPricePerClass);
        editClassType = (EditText) findViewById(R.id.editClassType);
        editDescription = (EditText) findViewById(R.id.editDescription);

        //BUTTON
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnListRoom = (Button) findViewById(R.id.btnListRoom);
        btnDetailRoom = (Button) findViewById(R.id.btnDetailRoom);

        //

        btnDetailRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CustomRoomActivity.class);
                startActivity(intent);


            }
        });

        btnListRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListRoomActivity.class);
                startActivity(intent);

            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name  = editNameRoom.getText().toString();
                String day  = editDayOfWeek.getText().toString();
                String time  = editCourseTime.getText().toString();
                String capacity = editCapacity.getText().toString();
                String duration = editDuration.getText().toString();
                String price = editPricePerClass.getText().toString();
                String type = editClassType.getText().toString();
                String description = editDescription.getText().toString();


                DatabaseHepler db = new DatabaseHepler(MainActivity.this);
                db.add_room(name,day,time,capacity,duration,price,type,description);

                Toast.makeText(MainActivity.this, "Insert Succestfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}