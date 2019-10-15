package com.example.gangssam_ex_project;

import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
View.OnClickListener onclick=new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                //1초 동안 진동
                Vibrator vib=(Vibrator)getSystemService(VIBRATOR_SERVICE);
                vib.vibrate(1000);
                break;
            case R.id.btn2:
                //시스템 효과음
                Uri notification=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone ringtone=RingtoneManager.getRingtone(getApplicationContext(),notification);
                ringtone.play();
                break;
            case R.id.btn3:
                //저장된 음악 재생
                MediaPlayer player=MediaPlayer.create(getApplicationContext(),R.raw.weaponsound9);
                player.start();
                break;
        }
    }
};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //interfase test
        inter_test test=new inter_test();
        test.setCallback(new inter_test.TestCallback() {
            @Override
            public void onComplate() {

            }
        });
        //interfase test
        Button btn1=(Button)findViewById(R.id.btn1);
        Button btn2=(Button)findViewById(R.id.btn2);
        Button btn3=(Button)findViewById(R.id.btn3);
        btn1.setOnClickListener(onclick);
        btn2.setOnClickListener(onclick);
        btn3.setOnClickListener(onclick);


    }
}
