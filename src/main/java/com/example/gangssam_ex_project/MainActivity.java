package com.example.gangssam_ex_project;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
//import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Context context=this;
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
            case R.id.btn4:
                //토스트 실행
                Toast.makeText(getApplicationContext(),"테스트입니다.",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn5:
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("d알람")
                        .setMessage("정말 종료 하시겟습니까?")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"button1111",Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("no",null);
                AlertDialog alertDialog=builder.create();
                alertDialog.show();

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
        Button btn4=(Button)findViewById(R.id.btn4);
        Button btn5=(Button)findViewById(R.id.btn5);
        btn1.setOnClickListener(onclick);
        btn2.setOnClickListener(onclick);
        btn3.setOnClickListener(onclick);
        btn4.setOnClickListener(onclick);
        btn5.setOnClickListener(onclick);


    }
}
