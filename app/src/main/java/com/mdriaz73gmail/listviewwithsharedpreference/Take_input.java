package com.mdriaz73gmail.listviewwithsharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Take_input extends MainActivity implements View.OnClickListener {

    Button btnBack;

    ListView lvList;
    String Name;

    ArrayList<String> Namelists;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_input);

        preferences = getSharedPreferences("Name_List", Context.MODE_PRIVATE);

        Namelists = new ArrayList<String>();
        Toast.makeText(Take_input.this, ""+Num, Toast.LENGTH_SHORT).show();
        for (int i = 0; i < Num; i++) {
            Name = preferences.getString("Name " + i, null);
            Namelists.add(Name);
        }

        ArrayAdapter adapters = new ArrayAdapter(Take_input.this, R.layout.listview_layout, R.id.tvListview, Namelists);
        lvList = (ListView) findViewById(R.id.lvList);
        lvList.setAdapter(adapters);

        btnBack= (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Take_input.this,MainActivity.class);
        startActivity(intent);
    }
}
