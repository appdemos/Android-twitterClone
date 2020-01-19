package com.app.mytwitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {
    // TODO autofill username
    // TODO hide keyboard on tap to screen
    // TODO enter presses signup/login button
    // TODO replace toasts with actual action


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }

    public void signUpLogin(View v) {
        final EditText username = findViewById(R.id.usernameEditText);
        final EditText password = findViewById(R.id.passwordEditText);

        ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e == null && user != null){
                    Toast.makeText(MainActivity.this, "Login ok", Toast.LENGTH_SHORT).show();
                }else{
                    ParseUser newUser = new ParseUser();
                    newUser.setUsername(username.getText().toString());
                    newUser.setPassword(password.getText().toString());
                    newUser.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if(e == null){
                                Toast.makeText(MainActivity.this, "Sign up success", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(MainActivity.this, e.getMessage().substring(e.getMessage().indexOf(" ")) + " Sign up failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
