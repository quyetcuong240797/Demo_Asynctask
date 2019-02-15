package com.example.demo_asynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mBtnCount;
    private TextView mTvNumber;
    private ProgressBar mProgressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mBtnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountNumber().execute();
            }
        });

    }

    private void initViews() {
        mBtnCount = findViewById(R.id.btn_count);
        mTvNumber = findViewById(R.id.tv_number);
        mProgressbar = findViewById(R.id.progress_bar);

    }

    public class CountNumber extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 1; i <= 10; i++) {
                SystemClock.sleep(1000);
                publishProgress(i);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mProgressbar.setProgress(values[0]);
            mTvNumber.setText(String.valueOf(values[0]));
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

        }
    }

}
