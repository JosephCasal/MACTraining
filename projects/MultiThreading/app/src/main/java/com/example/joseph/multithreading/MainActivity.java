package com.example.joseph.multithreading;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity  implements  Handler.Callback{

    private static final String TAG = "MainActivityTag";
    private TextView tvResult;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = (TextView) findViewById(R.id.tvResult);
        seekBar = (SeekBar) findViewById(R.id.seekbar);

    }

    public void CreatingThreads(View view) {

        switch (view.getId()){

            case R.id.btnUsingRunnable:

                MyRunnable myRunnable = new MyRunnable(tvResult);
                Thread thread = new Thread(myRunnable);
                thread.start();

                break;

            case R.id.btnUsingThread:

                //create a handler by creating callback
//                Handler handler = new Handler(new Handler.Callback() {
//                    @Override
//                    public boolean handleMessage(Message message) {
//                        return false;
//                    }
//                })


                //or create handler by implementing Handler.Callback
                Handler handler = new Handler(this);


                MyThread myThread = new MyThread(handler);
                myThread.start();

                break;

            case R.id.btnAsyncTask:

                MyAsyncTask myAsyncTask = new MyAsyncTask(tvResult, seekBar);

                myAsyncTask.execute();

                Toast.makeText(this, "Started Async Task", Toast.LENGTH_SHORT).show();

                break;

        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHelloEvent(HelloEvent helloEvent){
        Log.d(TAG, "onHelloEvent: " + helloEvent.getData());
        Toast.makeText(this, "EventBus: " + helloEvent.getData(), Toast.LENGTH_SHORT).show();
        tvResult.setText(String.valueOf(helloEvent.getData()));
//        seekBar.setProgress(Integer.parseInt(helloEvent.getData()));
    }


    //called when MyThread returns a message
    @Override
    public boolean handleMessage(Message message) {

        tvResult.setText(String.valueOf(message.getData().getInt("total")));

        return false;
    }

    //register this class for Eventbus
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    //unregister this class for eventbus
    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
