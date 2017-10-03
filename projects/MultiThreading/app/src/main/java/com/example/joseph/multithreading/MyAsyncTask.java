package com.example.joseph.multithreading;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by joseph on 10/3/17.
 */

public class MyAsyncTask extends AsyncTask<String, Integer, String> {
    private static final String TAG = "MyAsyncTask";

    TextView textView;
    SeekBar seekBar;

    public MyAsyncTask(TextView textView, SeekBar seekBar) {
        this.textView = textView;
        this.seekBar = seekBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: " + Thread.currentThread());
        textView.setText("0");
    }

    @Override
    protected String doInBackground(String... strings) {
        Log.d(TAG, "doInBackground: " + Thread.currentThread());
        Integer total = 0;
        for (int i = 0; i < 5; i++) {
            total = total + 5;
            publishProgress(total);
            // Escape early if cancel() is called
            if (isCancelled()) break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return String.valueOf(total);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d(TAG, "onProgressUpdate: " + values[0] + " " + Thread.currentThread());
        textView.setText(String.valueOf(values[0]));
        seekBar.setProgress(values[0]);

//        EventBus.getDefault().post(new HelloEvent(String.valueOf(values[0])));
    }


    @Override
    protected void onPostExecute(String string) {
        super.onPostExecute(string);
        Log.d(TAG, "MyAsyncTask: " + string + " " + Thread.currentThread());
//        EventBus.getDefault().post(new HelloEvent(String.valueOf(string)));
        textView.setText(string);
    }
}
