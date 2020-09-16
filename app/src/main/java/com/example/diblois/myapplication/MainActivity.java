package com.example.diblois.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.graphics.Color;


public class MainActivity extends Activity implements View.OnClickListener, OnItemSelectedListener,SeekBar.OnSeekBarChangeListener{

    Spinner s;
    SeekBar bar1;
    SeekBar bar2;
    SeekBar bar3;
    Button b;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.relativelayout);

        textView = (TextView)findViewById(R.id.helloText);
        textView.setText("Hello Blois !");

        b = (Button) findViewById(R.id.helloButton);
        b.setOnClickListener(this);

        s = (Spinner) findViewById(R.id.helloSpinner);
        s.setOnItemSelectedListener(this);

         bar1 = (SeekBar) findViewById(R.id.seekBar);
         bar2 = (SeekBar) findViewById(R.id.seekBar2);
         bar3 = (SeekBar) findViewById(R.id.seekBar3);
        bar1.setOnSeekBarChangeListener(this);
        bar2.setOnSeekBarChangeListener(this);
        bar3.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            //si l'event clic provient du bouton
            case R.id.helloButton :
                TextView textView = (TextView)findViewById(R.id.helloText);
                EditText editText = (EditText)findViewById(R.id.helloTextField);
                textView.setText(editText.getText());
            break;

        }



    }

    public void onItemSelected(AdapterView<?> parent, View view,int pos, long id) {
        TextView textView = (TextView)findViewById(R.id.helloText);
        textView.setTypeface(textView.getTypeface(), pos+1);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        textView = (TextView)findViewById(R.id.helloText);
        
        if(seekBar==bar1)
        textView.setTextColor(Color.rgb(progress,bar2.getProgress(),bar3.getProgress()));

        if(seekBar==bar2)
            textView.setTextColor(Color.rgb(bar1.getProgress(),progress,bar3.getProgress()));

        if(seekBar==bar3)
            textView.setTextColor(Color.rgb(bar1.getProgress(),bar2.getProgress(),progress));





    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
