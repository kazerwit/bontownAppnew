package com.bontown;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class AboutActivity extends AppCompatActivity {

    private static final String TAG = "AboutActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate(Bundle savedInstanceState)");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_about_toolbar);
        myToolbar.setTitle("Navigation");
        setSupportActionBar(myToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button and home button
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeButtonEnabled(true);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}

