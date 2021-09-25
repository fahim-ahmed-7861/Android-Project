package com.example.asus.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton media,pause;

    private MediaPlayer mediaPlayerl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        media=findViewById(R.id.mediaplay);

        pause=findViewById(R.id.mediapause);

        mediaPlayerl=MediaPlayer.create(this,R.raw.ahdil);





    }
}
