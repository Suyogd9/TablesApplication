package com.suyog.tables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    ListView tableslist;
    public void generate(int TT){

        int j;
        ArrayList<String> TTC = new ArrayList<String>();
        for (j =1; j<=20 ;j++){

            TTC.add(Integer.toString(j*TT));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,TTC);
        tableslist.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar tablechange = (SeekBar) findViewById(R.id.seekBar);
        tablechange.setMax(20);
        tablechange.setProgress(10);
        tableslist=(ListView) findViewById(R.id.myListview);


        tablechange.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                 int min = 1;
                 int TT;

                if(i < min){
                    TT=min;
                    tablechange.setProgress(min);
                }else{
                    TT = i;
                }

            generate(TT);
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generate(10);


    }
}
