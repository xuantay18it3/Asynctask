package com.kd1412.asynctask;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity  {
    private TextView tvPercent;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        SetWidget();
        AsyncTask task = new AsyncTask();
        task.execute(50);

    }

    public void SetWidget() {
        tvPercent = findViewById(R.id.tvPercent);
        progressBar=findViewById(R.id.progressBar);
    }

    public class AsyncTask extends android.os.AsyncTask{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setProgress(0);
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            progressBar.setProgress(100);
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            SplashActivity.this.finish();
        }

        @Override
        protected void onProgressUpdate(Object[] values) {
            super.onProgressUpdate(values);
            int percent= (int) values[0];
            tvPercent.setText(percent +" %");
            progressBar.setProgress(percent);
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            int n = (int) objects[0];
            for(int i = 0; i < n; i++){
                int percent = i*100/n;
                publishProgress(percent);
                SystemClock.sleep(100);
            }
            return null;
        }
    }
}
