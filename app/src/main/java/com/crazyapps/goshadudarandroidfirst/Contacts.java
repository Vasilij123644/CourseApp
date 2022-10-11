package com.crazyapps.goshadudarandroidfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Contacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
    }


    public  void  MainMenu (View view) {
        Intent menuBack = new Intent(this, MainActivity.class);
        startActivity(menuBack);
    }


    public  void  GotoCredits (View view) {
        Intent credits = new Intent(this, credits.class);
        startActivity(credits);
    }

    public void closeActivity() {
        this.finish();
    }
}