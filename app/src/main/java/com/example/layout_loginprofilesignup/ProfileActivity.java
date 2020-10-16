package com.example.layout_loginprofilesignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    ImageView iv;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        iv = (ImageView) findViewById(R.id.pre2);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileActivity.this, CustomList.class);
                startActivity(i);
            }
        });
        bt = (Button) findViewById(R.id.bt_logout);
        bt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) { openMainActivity2();
            }
        });
    }
    public void openMainActivity2 () {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}