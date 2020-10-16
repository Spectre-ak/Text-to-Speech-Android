package com.example.texttovoice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText,editText1,editText2;
    TextToSpeech textToSpeech;
    Button US,French,HIN,UK,set,set1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.editTextTextPersonName);editText1=(EditText)findViewById(R.id.editTextTextPersonName2);editText2=(EditText)findViewById(R.id.editTextTextPersonName3);
        US=(Button)findViewById(R.id.button3);French=(Button)findViewById(R.id.button5);HIN=(Button)findViewById(R.id.button6);UK=(Button)findViewById(R.id.button7);set=(Button)findViewById(R.id.button8);set1=(Button)findViewById(R.id.button9);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float floaf=new Float(editText1.getText().toString());
                float no=(float)floaf;
                textToSpeech.setSpeechRate(no);

            }
        });
        set1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float floaf=new Float(editText2.getText().toString());
                float no=(float)floaf;
                textToSpeech.setPitch(no);

            }
        });
        textToSpeech=new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);

                   // textToSpeech.setSpeechRate(2);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=editText.getText().toString();
                textToSpeech.speak(text,TextToSpeech.QUEUE_ADD,null);

            }
        });
        US.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech.setLanguage(Locale.US);
            }
        });

        French.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech.setLanguage(Locale.FRENCH);
            }
        });
        HIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech.setLanguage(Locale.forLanguageTag("hin"));
            }
        });
        UK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech.setLanguage(Locale.UK);
            }
        });
    }

}