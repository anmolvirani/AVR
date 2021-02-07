package com.example.animalvirtualworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class IndexPage extends AppCompatActivity {

    Button tiger,lion,zebra,fox,deer;
    TextToSpeech mTTS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_page);

        tiger = findViewById(R.id.tiger);
        lion = findViewById(R.id.Lion);
        zebra = findViewById(R.id.zebra);
        fox = findViewById(R.id.fox);
        deer = findViewById(R.id.deer);

        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS)
                {
                    int result = mTTS.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TTS","Langauge not supported");
                    }
                    else
                    {
                        tiger.setEnabled(true);
                        lion.setEnabled(true);
                        zebra.setEnabled(true);
                        fox.setEnabled(true);
                        deer.setEnabled(true);
                    }
                }
                else
                {
                    Log.e("TTS","Initialization failed");
                }

            }
        });

        tiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakTiger();
                openTiger();


            }
        });




    }

    public void openTiger()
    {
        Intent intent = new Intent(this,Tiger.class);
        startActivity(intent);
    }

    public void speakTiger()
    {
        String text = "Tiger is one of the most dangerous species in the world...";
        float pitch = 1/2;
        float speed = 1/2;

        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);

        mTTS.speak(text , TextToSpeech.QUEUE_FLUSH,null);
    }





}
