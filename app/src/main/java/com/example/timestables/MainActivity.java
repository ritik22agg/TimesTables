package com.example.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    public void table_gernerator(int value){
        ListView lv = findViewById(R.id.lv);
        ArrayList<String> table = new ArrayList<>();
        for(int i = 1; i <= 20;i++){
            table.add("" + (value * i));
        }
        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, table);
        lv.setAdapter(adapt);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seeker = (SeekBar) findViewById(R.id.seek);
        lv = findViewById(R.id.lv);
        seeker.setMax(20);
        seeker.setProgress(1);
        seeker.setAlpha(0.2f);
        seeker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int number = progress;
                if(progress == 0){
                    number = 1;
                }
                table_gernerator(number);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setAlpha(1.0f);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setAlpha(0.2f);
            }
        });


    }
}
