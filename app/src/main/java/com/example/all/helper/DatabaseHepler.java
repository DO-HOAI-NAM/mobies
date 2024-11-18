package com.example.all.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.all.CustomRoomActivity;
import com.example.all.model.Rooms;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHepler extends SQLiteOpenHelper {


    public DatabaseHepler(Context context){
        super(context,"YOGA",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table rooms(pid INTEGER PRIMARY KEY AUTOINCREMENT, room_name TEXT, room_day TEXT, room_time TEXT,room_capacity INTEGER,room_duration INTEGER,room_price INTEGER,room_type TEXT,room_description TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db , int i, int i1) {
        db.execSQL(" DROP table if exists rooms ");
    }

    public void add_room(String name,String day,String time,String capacity,String duration,String price,String type, String description){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("room_name",name);
        values.put("room_day",day);
        values.put("room_time",time);
        values.put("room_capacity",capacity);
        values.put("room_duration",duration);
        values.put("room_price",price);
        values.put("room_type",type);
        values.put("room_description",description);

        db.insert("rooms",null,values);
        db.close();

    }

    public List<String> getAllRoomTitile()
    {
        List<String> temp = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(" select * from rooms", null);
        if (cursor.moveToFirst()) {

            do{
                String name = cursor.getString(1).toString();
                temp.add(name);
            }while(cursor.moveToNext());
        }
        return temp;
    }

    public List<Rooms>getAllRooms()
    {
        List<Rooms> temp = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(" select * from rooms", null);
        if (cursor.moveToFirst()) {

            do{
                String pid = cursor.getString(0).toString();
                String room_name = cursor.getString(1).toString();
                String room_day = cursor.getString(2).toString();
                String room_time = cursor.getString(3).toString();
                String room_capacity = cursor.getString(4).toString();
                String room_duration = cursor.getString(5).toString();
                String room_price = cursor.getString(6).toString();
                String room_type = cursor.getString(7).toString();
                String room_description = cursor.getString(8).toString();

                Rooms obj = new Rooms();
                obj.pid = pid;
                obj.room_name = room_name;
                obj.room_day = room_day;
                obj.room_time = room_time;
                obj.room_capacity = room_capacity;
                obj.room_duration = room_duration;
                obj.room_price = room_price;
                obj.room_type = room_type;
                obj.room_description = room_description;

                temp.add(obj);

            }while(cursor.moveToNext());
        }
        return temp;
    }
    public void deleteRoomData(String pid){

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from rooms where pi'"+pid+"'");
        db.close();
    }
}
