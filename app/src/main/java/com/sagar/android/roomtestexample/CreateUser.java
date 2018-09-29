package com.sagar.android.roomtestexample;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateUser extends AppCompatActivity {
    private static final String TAG = "CreateUser";

    TextInputEditText mFirstName;
    TextInputEditText mLastName;
    EditText mEmail;
    Button mAddButton;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        //define all elements
        mFirstName = findViewById(R.id.first_name);
        mLastName = findViewById(R.id.last_name);
        mEmail = findViewById(R.id.email);
        mAddButton = findViewById(R.id.addUser_button);

        db = AppDatabase.getAppDatabase(this);

        //Add User button on click listner
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "add user button pressed");
                User mUser = new User(mFirstName.getText().toString(), mLastName.getText().toString(), mEmail.getText().toString());
                DatabaseInitializer.populatAsync(db, mUser);
                startActivity(new Intent(CreateUser.this, MainActivity.class));
            }
        });
    }
}
