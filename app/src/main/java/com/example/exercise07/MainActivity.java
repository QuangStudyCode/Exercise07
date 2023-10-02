package com.example.exercise07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.contentLoadingProgressBar);
        textView = findViewById(R.id.textView);

        CaculateSumAyncTask task = new CaculateSumAyncTask(progressBar,textView);
        task.execute();
    }
}