package com.example.all;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.all.helper.DatabaseHepler;

import java.util.ArrayList;
import java.util.List;

public class ListRoomActivity extends AppCompatActivity {
    ListView mylistroom;
    List<String> room_names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_room);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        room_names = new ArrayList<>();
        mylistroom = (ListView) findViewById(R.id.mylistroom);
        DatabaseHepler db = new DatabaseHepler(ListRoomActivity.this);
        room_names = db.getAllRoomTitile();
        ArrayAdapter adapter = new ArrayAdapter<>(
                ListRoomActivity.this,
                android.R.layout.simple_expandable_list_item_1,
                room_names // Truyền danh sách room_names vào adapter
        );
        mylistroom.setAdapter(adapter);

    }
}

