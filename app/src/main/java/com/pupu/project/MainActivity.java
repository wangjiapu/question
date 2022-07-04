package com.pupu.question;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pupu.question.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    static {
        System.loadLibrary("cproject");
    }

    private ActivityMainBinding binding;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Button cBt = binding.cBt;
        Button javaBt = binding.javaBt;
        tv = binding.result;

        cBt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                tv.setText("c++:" + cMain());
            }
        });
        javaBt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                tv.setText("java:" + javaMain());
            }
        });
    }

    public String javaMain() {
        //JavaMain.main(new String[]{});
        return "";
    }

    public native String cMain();

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                Log.e("pujw",tv.getHeight()+"");
            }
        });
    }
}