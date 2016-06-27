package com.mdriaz73gmail.listviewwithsharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ListView lvListview;

    String[] Names = {"asdasdf", "rtefdfd", "eftwverg", "sdfsdfew", "ewcvwerfw", "gergevv", "rrdgbc", "ewverve", "rweverv", "ebddsfjl"};

    static ArrayList<String> Namelist;

    String Name;
    String NewName;

    EditText etNewName;

    Button btnGotonextPage;
    Button btnSave;

    static int Num;

    SharedPreferences preferences;
    SharedPreferences preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("Name_List", Context.MODE_PRIVATE);
        preference = getSharedPreferences("Login", Context.MODE_PRIVATE);

        lvListview = (ListView) findViewById(R.id.lvListview);
        btnGotonextPage = (Button) findViewById(R.id.btnGotonextPage);
        btnSave = (Button) findViewById(R.id.btnSave);
        etNewName = (EditText) findViewById(R.id.etNewName);

        btnSave.setOnClickListener(this);
        btnGotonextPage.setOnClickListener(this);


        Initialization();
        StartSharedPreference();
        SavingNameIntoString();
        ShowListView();
    }

    private void Initialization() {
        Num = preference.getInt("Number", 0);
    }

    public void StartSharedPreference() {
        Editor editor = preferences.edit();

        for (int i = 0; i < Names.length; i++) {
            editor.putString("Name " + i, Names[i]);
        }
        editor.commit();
    }

    private void SavingNameIntoString() {
        Namelist = new ArrayList<String>();
        if(Num==0) {
            for (int i = 0; i < Names.length; i++) {
                Name = preferences.getString("Name " + i, null);
                Namelist.add(Name);
            }
        }
        else {
            for (int i = 0; i < Num; i++) {
                Name = preferences.getString("Name " + i, null);
                Namelist.add(Name);
            }
        }
    }

    private void ShowListView() {
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.listview_layout, R.id.tvListview, Namelist);
        lvListview.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGotonextPage: {
                Intent intent = new Intent(MainActivity.this, Take_input.class);
                startActivity(intent);
            }
            break;

            case R.id.btnSave: {
                NewName = etNewName.getText().toString();
                Toast.makeText(MainActivity.this, "" + NewName, Toast.LENGTH_SHORT).show();
                Namelist.add(NewName);

                NewArrayList();
                ShowListView();
                Toast.makeText(MainActivity.this, ""+Namelist.size(), Toast.LENGTH_SHORT).show();
                Num=Namelist.size();

                Editor editor = preference.edit();
                    editor.putInt("Number", Num);
                editor.commit();

            }
            break;
        }
    }

    public void NewArrayList(){

        Editor editor = preferences.edit();
        for (int i = 0; i < Namelist.size(); i++) {
            editor.putString("Name " + i, Namelist.get(i));
        }
        editor.commit();
    }
}
