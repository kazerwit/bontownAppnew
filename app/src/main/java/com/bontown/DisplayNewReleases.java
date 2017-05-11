package com.bontown;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.Window;
import android.widget.RelativeLayout;


public class DisplayNewReleases extends AppCompatActivity {
    Context context;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;

    String[] leftColumn = {"Run The Jewels", "The XX", "Foxygen",
            "Depeche Mode", "Aimee Mann", "Wire", "Danzig", "H09909"};

    String[] rightColumn = {"RTJ3", "I See You", "Hang", "Spirit", "Mental Illness",
            "Silver/Lead", "Black Laden Crown", "United States of Horror"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_display_new_releases);
        context = getApplicationContext();
        relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout1);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        recylerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter = new Adapter(context, leftColumn, rightColumn);
        recyclerView.setAdapter(recyclerViewAdapter);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_home:
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;

            case R.id.action_about:
                Intent intent1 = new Intent(this, AboutActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent1);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

    }
}