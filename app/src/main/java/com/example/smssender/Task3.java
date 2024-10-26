package com.example.smssender;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Task3 extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);
        Button b1=findViewById(R.id.msgsend);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Task3.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }


    public void openLinkedIn(View view) {

        String linkedInUrl = "https://www.linkedin.com/company/c-cube-geca/";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedInUrl));
        startActivity(intent);
    }


    public void openInstagram(View view) {
        String instagramUrl = "https://www.instagram.com/ccube_community/";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl));
        startActivity(intent);
    }


    public void openGoogle(View view) {
        String googleUrl = "https://c-cube.geca.ac.in/";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(googleUrl));
        startActivity(intent);
    }

}
