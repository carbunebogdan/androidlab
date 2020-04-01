package com.tppa.lab2_java;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

class ProductItem {
    private String name;
    private String description;
    ProductItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class ListDisplay extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ArrayList<ProductItem> productList = new ArrayList<ProductItem>();
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    public static final String TAG = "MainActivity";
    private int CLICKS;



    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        this.setUpNavigation();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        productList.add(new ProductItem("freelance", "am invatat sa fac aplicatii android"));
        productList.add(new ProductItem("laptop", "vand laptop bun"));
        productList.add(new ProductItem("tractari", "ofer servicii de tractare"));
        productList.add(new ProductItem("cantaret ocazional", "am invatat sa cant, deci cant"));
        productList.add(new ProductItem("smart meniu", "smart meniu KFC picant"));
        productList.add(new ProductItem("telefon", "vand telefon bun"));
        productList.add(new ProductItem("produs", "exemplu de produs"));

        ArrayAdapter adapter = new ArrayAdapter<ProductItem>(this,
                R.layout.activity_listview, productList);

        final ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListDisplay.this, Product.class);
                ProductItem item = productList.get(position);
                intent.putExtra("product", item.getName());
                intent.putExtra("description", item.getDescription());
                startActivity(intent);
            }
        });
    }

    private void setUpNavigation(){
        navigationView = findViewById(R.id.navigationView);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Intent intent;
                switch (menuItem.getItemId()) {
                    case R.id.sensors:
                        intent = new Intent(ListDisplay.this, SensorActivity.class);
                        startActivity(intent);
//                newGame();
                        return true;
                    case R.id.preferences:
                        intent = new Intent(ListDisplay.this, Preferences.class);
                        startActivity(intent);
//                newGame();
                        return true;
                    case R.id.contact:
//                showHelp();
                        return true;
                    case R.id.aboutus:
//                showHelp();
                        return true;
                    case R.id.settings:
                        intent = new Intent(ListDisplay.this, SettingsActivity.class);
                        startActivity(intent);
                    default:
                        return false;
                }
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent;
        switch (menuItem.getItemId()) {
            case R.id.sensors:
                intent = new Intent(ListDisplay.this, SensorActivity.class);
                startActivity(intent);
//                newGame();
                return true;
            case R.id.preferences:
                intent = new Intent(ListDisplay.this, Preferences.class);
                startActivity(intent);
//                newGame();
                return true;
            case R.id.contact:
//                showHelp();
                return true;
            case R.id.aboutus:
//                showHelp();
                return true;
            case R.id.settings:
                intent = new Intent(ListDisplay.this, SettingsActivity.class);
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("clicks", this.CLICKS);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, String.valueOf(CLICKS));
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy");
    }

}