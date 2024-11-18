package com.example.all;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.all.adapters.CustomAdapter;
import com.example.all.helper.DatabaseHepler;
import com.example.all.model.Rooms;

import java.util.ArrayList;
import java.util.List;

public class CustomRoomActivity extends AppCompatActivity {
    ListView myCustomView;
    List<Rooms> mydata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_room);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mydata = new ArrayList<>();
        myCustomView = (ListView) findViewById(R.id.myCustomView);
        getAllRooms();

    }

    public void getAllRooms(){
        DatabaseHepler db = new DatabaseHepler(this);
        mydata = db.getAllRooms();
        CustomAdapter adapter = new CustomAdapter(this,mydata);
        myCustomView.setAdapter(adapter);
    }
//    public void deleteRoom(String pid){
//        DatabaseHepler db = new DatabaseHepler(CustomRoomActivity.this);
//        db.deleteRoomData(pid);
//        Toast.makeText(this, ""+pid, Toast.LENGTH_SHORT).show();
//        getAllRooms();
//    }

    public void deleteRooms(String pid)
    {
        DatabaseHepler db = new DatabaseHepler(CustomRoomActivity.this);
        db.deleteRoomData(pid);
        getAllRooms();
    }
    public void editRooms(String pid, String name, String day,String time, String capacity,String duration,String price,String type, String description)
    {
        Intent intent = new Intent(CustomRoomActivity.this,UpdateRoomActivity.class);
        intent.putExtra("pid",pid);
        intent.putExtra("name",name);
        intent.putExtra("day",day);
        intent.putExtra("time",time);
        intent.putExtra("capacity",capacity);
        intent.putExtra("duration",duration);
        intent.putExtra("price",price);
        intent.putExtra("type",type);
        intent.putExtra("description",description);
        startActivity(intent);


    }

}