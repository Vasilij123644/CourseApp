package com.projectApp.projectCourseApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

    }


    public  void  MainMenu (View view) {
        Intent menuBack = new Intent(this, MainActivity.class);
        closeActivity();
        startActivity(menuBack);
    }
    public  void  Contacts (View view) {
        Intent menuBack = new Intent(this, Contacts.class);
        closeActivity();
        startActivity(menuBack);
    }

    public void closeActivity() {
        this.finish();
    }
}