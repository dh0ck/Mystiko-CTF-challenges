package com.example.kryptonite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class H1dD3N extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h1d_d3_n);

        ImageButton krypton = (ImageButton) findViewById(R.id.Krypton);

        krypton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("test1", getResources().getString(R.string.a1));
                Log.e("test2", getResources().getString(R.string.a2));
                Log.e("test3", getResources().getString(R.string.a3));
                Log.e("test4", getResources().getString(R.string.a4));
                Log.e("test5", getResources().getString(R.string.b1));
                Log.e("test6", getResources().getString(R.string.b2));
                Log.e("test7", getResources().getString(R.string.b3));
                Log.e("test8", getResources().getString(R.string.c1));
                Log.e("test9", getResources().getString(R.string.c2));
                Log.e("test10", getResources().getString(R.string.c3));
                Log.e("test11", getResources().getString(R.string.c4));
                Log.e("test12", getResources().getString(R.string.c5));
                Log.e("test12 (re-testing...)", getResources().getString(R.string.c6));
                Log.e("test13", getResources().getString(R.string.d1));
                Log.e("test14", getResources().getString(R.string.d2));
                Log.e("test15", getResources().getString(R.string.d3));
                Log.e("test16", getResources().getString(R.string.d4));
                Log.e("test17", getResources().getString(R.string.d5));
                Log.e("test18", getResources().getString(R.string.e1));
                Log.e("test19", getResources().getString(R.string.e2));
                Log.e("test20", getResources().getString(R.string.e3));
                Log.e("test21", getResources().getString(R.string.e4));
                Log.e("test22", getResources().getString(R.string.e5));
                Toast toast = Toast.makeText(getApplicationContext(), "An error occurred. Check the logs for more information.", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}