package com.bontown;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import static com.bontown.R.string.action_about;
import static com.bontown.R.string.mail_dialog;



public class MainActivity extends AppCompatActivity {
        public static final String EXTRA_MESSAGE = "com.bontown.MESSAGE";
        private static final String TAG = "MainActivity";
        public FloatingActionButton alert_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Navigation");
        setSupportActionBar(myToolbar);
        Log.d(TAG, "onCreate(Bundle savedInstanceState)");
        onButtonClickListener();
    }

    public void onButtonClickListener(){
        alert_dialog = (FloatingActionButton) findViewById(R.id.fab);
        alert_dialog.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                        a_builder.setMessage("Sign up for email updates?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Log.d(TAG, "Email sign up--user selected Yes");
                                        //later-add action for when user selects yes on email sign up
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Log.d(TAG, "Email sign up--user selected No");
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Stay Connected");
                        alert.show();
                    }
                }
        );
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

            case R.id.action_about:
                Intent intent = new Intent(this, AboutActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;

            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    /**
     * Called when the user taps the Send button
     */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        Log.d(TAG, "sendMessage(View view)");

    }

    public void BasicToast(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Please sign up to view";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        Log.d(TAG, "BasicToast(View view)");

        toast.show();
    }
}