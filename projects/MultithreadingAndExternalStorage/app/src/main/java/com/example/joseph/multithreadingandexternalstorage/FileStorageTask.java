package com.example.joseph.multithreadingandexternalstorage;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by joseph on 10/4/17.
 */

public class FileStorageTask extends AsyncTask<String, Integer, String> {

    private static final String TAG = "FileStorageTaskTag";
    String writeData;

    public FileStorageTask(String writeData) {
        this.writeData = writeData;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {

        int len = writeData.length();
        if (len == 0) {
            return "Please write data in text field";
        } else {
            try {
                File myFile = new File("/sdcard/","ExternalFileTest");
                myFile.createNewFile();
                FileOutputStream fos = new FileOutputStream(myFile);
                fos.write(writeData.getBytes());
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, "there was an error saving the file");
            }
        }

        return "File Saved";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

}
