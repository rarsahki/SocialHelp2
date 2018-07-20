package com.example.android.socialhelp;

import android.Manifest;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AudioManager mAudioManager;
    MediaPlayer mediaPlayer;
    public int PERMISSION_GRANTED;
    int originalVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        originalVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
        mediaPlayer = new MediaPlayer();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int result = checkSelfPermission(Manifest.permission.SEND_SMS);
            if(result != PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},PERMISSION_GRANTED);
            }
        }
        View whatsapp = (View) findViewById(R.id.whatsapp);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WhatsappActivity.class);
                startActivity(intent);
            }
        });
        View facebook = (View) findViewById(R.id.facebook);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FacebookActivity.class);
                startActivity(intent);
            }
        });
        View news = (View) findViewById(R.id.news);
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NewsActivity.class);
                startActivity(intent);
            }
        });
        View request = (View) findViewById(R.id.request);
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:arksri14@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT,"Feature Request");
                intent.putExtra(Intent.EXTRA_TEXT,"Please Enter Details Below\n"+"Category (Whatsapp/Facebook/etc):\n"+"Feature:\n\n"+"Other Details:");
                startActivity(intent);
            }
        });
        Button sos = (Button) findViewById(R.id.sos);
        sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mediaPlayer.isPlaying()){
                    sendSMS("+917899045780","Sup nig?");
                    mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.warning);
                    mediaPlayer.start();
                }
                else{
                    mediaPlayer.stop();
                }
            }

        });
    }
    public void releaseMediaPlayer(){
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    public void sendSMS(String phoneNo, String msg) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }

}
