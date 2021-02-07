package com.example.animalvirtualworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button start;
    TextToSpeech mTTS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.button);
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
                        start.setEnabled(true);
                    }
                }
                else
                {
                    Log.e("TTS","Initialization failed");
                }

            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
                openIndex();

            }
        });


    }
    public void speak()
    {
        String text = "Welcome to our app of Animal Virtual World, here you will see various wild animals in Augmented Reality form.Click on the animal which you want to see and know about";
        float pitch = 1/2;
        float speed = 1/2;

        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);

        mTTS.speak(text , TextToSpeech.QUEUE_FLUSH,null);


    }

    public void openIndex()
    {
        Intent intent = new Intent(this,IndexPage.class);
        startActivity(intent);
    }
}
