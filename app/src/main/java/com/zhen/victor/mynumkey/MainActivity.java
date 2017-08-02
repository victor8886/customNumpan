package com.zhen.victor.mynumkey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = (EditText) findViewById(R.id.et);
        MyNumPan numPan = (MyNumPan) findViewById(R.id.pan);
        numPan.bindEditText(editText);
        numPan.setOnCompleteListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "complete", Toast.LENGTH_SHORT).show();
    }
}
