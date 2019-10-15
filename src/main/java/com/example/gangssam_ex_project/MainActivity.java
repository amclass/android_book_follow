package com.example.gangssam_ex_project;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
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
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

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
            case R.id.btn6:
                AlertDialog.Builder builder1=new AlertDialog.Builder(MainActivity.this)
                        .setItems(R.array.company,null);
                builder1.create().show();
                break;
            case R.id.btn7:
                Calendar c =Calendar.getInstance();
                int year=c.get(Calendar.YEAR);
                int month=c.get(Calendar.MONTH);
                final int day=c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Toast.makeText(MainActivity.this,year+"-"+(month+1)+"-"+dayOfMonth,Toast.LENGTH_LONG).show();
                    }
                }, year, month, day);
                datePickerDialog.show();
                break;
            case R.id.btn8:
                LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
                View vvv=inflater.inflate(R.layout.custom_dialog,null);
                AlertDialog.Builder builder2=new AlertDialog.Builder(MainActivity.this)
                        .setView(vvv);
                builder2.create().show();
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
        Button btn6=(Button)findViewById(R.id.btn6);
        Button btn7=(Button)findViewById(R.id.btn7);
        Button btn8=(Button)findViewById(R.id.btn8);
        btn1.setOnClickListener(onclick);
        btn2.setOnClickListener(onclick);
        btn3.setOnClickListener(onclick);
        btn4.setOnClickListener(onclick);
        btn5.setOnClickListener(onclick);
        btn6.setOnClickListener(onclick);
        btn7.setOnClickListener(onclick);
        btn8.setOnClickListener(onclick);


    }
}
