package com.example.recognize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class LinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ArrayList<String> links = getIntent().getStringArrayListExtra("links");

        LinearLayout buttonLayout = findViewById(R.id.button_layout);

        for (final String link : links) {
            Button button = new Button(this);
            button.setText(link);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                    startActivity(intent);
                }
            });
            buttonLayout.addView(button);
        }
    }
}
