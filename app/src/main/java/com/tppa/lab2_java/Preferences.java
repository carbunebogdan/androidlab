package com.tppa.lab2_java;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileOutputStream;

public class Preferences extends AppCompatActivity implements AddUsername.UsernameListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setUsername();
            }
        });

        final Button saveFileBtn = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveFileToInternalStorage();
            }
        });
    }

    public void setUsername() {
        AddUsername exampleDialog = new AddUsername();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    public void saveFileToInternalStorage() {
        FileOutputStream fos;
        try {
            fos = openFileOutput("internal_file.txt", Context.MODE_PRIVATE);
            fos.write("test".getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void applyTexts(String username) {
        TextView userContainer = findViewById(R.id.textView3);
        userContainer.setText(username);
    }

}
