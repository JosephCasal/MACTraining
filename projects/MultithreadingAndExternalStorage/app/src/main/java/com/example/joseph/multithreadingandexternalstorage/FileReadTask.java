package com.example.joseph.multithreadingandexternalstorage;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by joseph on 10/4/17.
 */

public class FileReadTask extends AsyncTask<String, String, String>{

    private static final String TAG = "FileReadTaskTag";
    TextView textView;
    String data;

    public FileReadTask(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        textView.setText("Setting Up Read Task");
    }

    @Override
    protected String doInBackground(String... strings) {

        try {
            publishProgress("Reading Data");
            File myFile = new File("/sdcard/","ExternalFileTest");
            FileInputStream fis = new FileInputStream(myFile);
            byte[] dataArray = new byte[fis.available()];

            while (fis.read(dataArray) != -1) {
                data = new String(dataArray);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "there was an error reading file");
        }

        return data;

    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        textView.setText(values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText(s);
    }
}
