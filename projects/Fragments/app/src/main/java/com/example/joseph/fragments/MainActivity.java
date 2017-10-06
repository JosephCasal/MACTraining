package com.example.joseph.fragments;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements YellowFragment.OnFragmentInteractionListener{

    private static final String BLUE_FRAG_TAG = "BlueFragmentTag";
    private static final String GREEN_FRAG_TAG = "GreenFragmentTag";
    private static final String YELLOW_FRAG_TAG = "YellowFragTag";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addingFragments(View view) {


        switch (view.getId()){

            case R.id.btnAddBlueFragment:

                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameBlue, new BlueFragment(), BLUE_FRAG_TAG)
                        .addToBackStack(BLUE_FRAG_TAG)
                        .commit();

                break;

            case R.id.btnAddGreenFragment:

                GreenFragment greenFragment = GreenFragment.newInstance("first", "second");

                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameBlue, greenFragment, GREEN_FRAG_TAG)
                        .addToBackStack(GREEN_FRAG_TAG)
                        .commit();

                break;

            case R.id.btnAddYellowFragment:

                YellowFragment yellowFragment = YellowFragment.newInstance("asdf","asdf");

                //using .setRetainInstance(true);
                //fragment wont be destroyed and recreated (like for changing orientation) and can keep the data
                //if device rotated main activity will still be destroyed and recreated and fragment will detach
                // and attach itself to new main activity
                yellowFragment.setRetainInstance(true);

                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameYellow, yellowFragment, YELLOW_FRAG_TAG)
                        .addToBackStack(YELLOW_FRAG_TAG)
                        .commit();

                break;

            case R.id.btnAddTextYellowFragment:

                //updating textview in yellow fragment
                YellowFragment fragment = (YellowFragment) getSupportFragmentManager().findFragmentByTag(YELLOW_FRAG_TAG);

                fragment.setText("Hello from MainActivity");

                //show toast from red fragment
                RedFragment redFragment = (RedFragment) getSupportFragmentManager().findFragmentById(R.id.fragRed);

                redFragment.showToast("Hello!!!");

                break;

            case R.id.removeBlue:

                BlueFragment blueFragment = (BlueFragment) getSupportFragmentManager().findFragmentByTag(BLUE_FRAG_TAG);

                getSupportFragmentManager().beginTransaction().remove(blueFragment).commit();

                break;

        }

    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d(TAG, "onFragmentInteraction: ");

    }

    @Override
    public void setData(String data) {
        Log.d(TAG, "setData: ");
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

}
