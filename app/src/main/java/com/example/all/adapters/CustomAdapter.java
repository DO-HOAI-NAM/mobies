package com.example.all.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.all.CustomRoomActivity;
import com.example.all.R;
import com.example.all.model.Rooms;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Activity activity;
    List<Rooms> mydata;
    Button btnEdit,btnDelete;
    public CustomAdapter( Activity activity,List<Rooms>mydata ){
        this.activity = activity;
        this.mydata = mydata;
    }
    @Override
    public int getCount() {
        return mydata.size();
    }

    @Override
    public Object getItem(int i) {
        return mydata.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View rootView = inflater.inflate(R.layout.singledesign,null);

        TextView roomname = (TextView) rootView.findViewById(R.id.roomname);
        TextView roomday = (TextView) rootView.findViewById(R.id.roomday);
        TextView roomtime = (TextView) rootView.findViewById(R.id.roomtime);
        TextView roomcapacity = (TextView) rootView.findViewById(R.id.roomcapacity);
        TextView roomduration = (TextView) rootView.findViewById(R.id.roomduration);
        TextView roomprice = (TextView) rootView.findViewById(R.id.roomprice);
        TextView roomtype = (TextView) rootView.findViewById(R.id.roomtype);
        TextView roomdescription = (TextView) rootView.findViewById(R.id.roomdescription);


        Button btnDelete = (Button) rootView.findViewById(R.id.btnDelete);
        Button btnEdit = (Button) rootView.findViewById(R.id.btnEdit);


        Rooms obj  = mydata.get(i);

        roomname.setText("ROOM :"+obj.room_name.toString());
        roomday.setText("DAY :"+obj.room_day.toString());
        roomtime.setText("TIME :"+obj.room_time.toString());
        roomcapacity.setText("CAPACITY :"+obj.room_capacity.toString());
        roomduration.setText("DURATION :"+obj.room_duration.toString());
        roomprice.setText("PRICE ;"+obj.room_price.toString());
        roomtype.setText("TYPE :"+obj.room_type.toString());
        roomdescription.setText("DESCRIPTION :"+obj.room_description.toString());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((CustomRoomActivity)activity).deleteRooms(obj.pid.toString());
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((CustomRoomActivity)activity).editRooms(obj.pid.toString(),obj.room_name.toString(),obj.room_day.toString(),obj.room_time.toString(),obj.room_capacity.toString(),obj.room_duration.toString(),obj.room_price.toString(),obj.room_type.toString(),obj.room_description.toString());
            }
        });

        return rootView;

    }
}
