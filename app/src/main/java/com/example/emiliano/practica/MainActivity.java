package com.example.emiliano.practica;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView mVideoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoview = findViewById(R.id.videoview);

        MediaController controller = new MediaController(this);

        controller.setMediaPlayer(mVideoview);
        mVideoview.setMediaController(controller);

    }

    private void initializePlayer(){
        mVideoview.setVideoPath("https://www.ebookfrenzy.com/android_book/movie.mp4");
        mVideoview.start();
    }

    private void releasePlayer(){
        mVideoview.stopPlayback();
    }

    protected void onStart(){
        super.onStart();
        initializePlayer();
    }

    protected void onStop(){
        super.onStop();
        releasePlayer();
    }

    protected void onPause(){
        super.onPause();

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N){
            mVideoview.pause();
        }
    }
}
