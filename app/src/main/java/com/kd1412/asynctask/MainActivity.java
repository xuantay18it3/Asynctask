package com.kd1412.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnSave;
    private Button btnRead;
    private TextView tvData;
    private final String NAME ="name";
    private final String AGE ="age";
    private final String GENDER ="gender";
    private final String PHONE_NUMBER ="phone_number";
    private final String SharedPreferences_name ="KDCoder";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWWidgets();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveData();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadData();
            }
        });
    }

    public void setWWidgets() {
        btnSave = findViewById(R.id.btnSave);
        btnRead = findViewById(R.id.btnRead);
        tvData = findViewById(R.id.tvData);
    }

    public void SaveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SharedPreferences_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME,"Hồ Nguyễn Xuân Tây");
        editor.putInt(AGE,20);
        editor.putBoolean(GENDER,true);
        editor.putString(PHONE_NUMBER,"0354122241");
        editor.apply();
        Toast.makeText(MainActivity.this,"Save Successfully",Toast.LENGTH_SHORT).show();
    }

    public void ReadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SharedPreferences_name,Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(NAME,null);
        int age = sharedPreferences.getInt(AGE,0);
        boolean gender = sharedPreferences.getBoolean(GENDER,true);
        String phone_number = sharedPreferences.getString(PHONE_NUMBER,null);
        String address = sharedPreferences.getString("Address",null);
        tvData.setText("Data \n Name: "+name+"\n Age: "+age+"\n Gender: "+gender+"\n Phone: "+phone_number+"\n Address: "+address);
    }
}
