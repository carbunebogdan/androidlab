package com.tppa.lab2_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

public class Product extends AppCompatActivity {
    Toolbar mToolbar;
    TextView mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        mToolbar = (Toolbar) findViewById(R.id.toolbar1);
        mText = (TextView) findViewById(R.id.textView1);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            mToolbar.setTitle(bundle.getString("product"));
            mText.setText(bundle.getString("description"));
        }
    }
}
