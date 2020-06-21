package com.example.example5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_start;
    Button btn_stop;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start = findViewById(R.id.button);
        btn_stop = findViewById(R.id.button2);
        btn_start.setOnClickListener(start);
        btn_stop.setOnClickListener(start);
    }
    Button.OnClickListener start = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            intent = new Intent(MainActivity.this,MyAudioService.class);
            intent.setPackage("com.example.example5");
            int id = v.getId();
            switch(id)
            {
                case R.id.button:
                    startService(intent);
                    Toast.makeText(MainActivity.this,"音乐播放中",Toast.LENGTH_LONG).show();
                    btn_start.setEnabled(false);
                    btn_stop.setEnabled(true);
                    break;
                case R.id.button2:
                    stopService(intent);
                    btn_stop.setEnabled(false);
                    btn_start.setEnabled(true);
                    break;
            }
        }
    };
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
//        if (intent != null)
//            stopService(intent);
        finish();
    }
}
