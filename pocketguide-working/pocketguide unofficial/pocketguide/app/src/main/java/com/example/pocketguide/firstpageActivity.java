package com.example.pocketguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.*;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class firstpageActivity extends AppCompatActivity {

    ProgressBar pb;
    Handler handler;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);

        prog();
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(firstpageActivity.this,user.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }

    public void prog(){
        pb = (ProgressBar)findViewById(R.id.pb);

        Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter++;
                pb.setProgress(counter);

                if (counter == 100)
                    t.cancel();
            }
        };
        t.schedule(tt,0,100);
    }



}