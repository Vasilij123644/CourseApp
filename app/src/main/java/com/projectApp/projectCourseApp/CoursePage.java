package com.projectApp.projectCourseApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.projectApp.projectCourseApp.model.Order;

public class CoursePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);

        ConstraintLayout courseBg = findViewById(R.id.coursePageBg);
        ImageView courseImage = findViewById(R.id.coursePageImage);
        TextView courseTitle = findViewById(R.id.coursePageTitle);
        TextView courseDate = findViewById(R.id.coursePageDate);
        TextView courseLevel = findViewById(R.id.coursePageLevel);
        TextView courseText = findViewById(R.id.coursePageText);

        courseBg.setBackgroundColor(getIntent().getIntExtra("courseBg", 0));
        courseImage.setImageResource(getIntent().getIntExtra("courseImage", 0));
        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        courseDate.setText(getIntent().getStringExtra("courseDate"));
        courseLevel.setText(getIntent().getStringExtra("courseLevel"));
        courseText.setText(getIntent().getStringExtra("courseText"));

    }

    public void addToCart(View view) {
        int itemId = getIntent().getIntExtra("courseId", 0);
        Order.itemIds.add(itemId);
        Toast.makeText(this, "Добавлено", Toast.LENGTH_LONG).show();
    }

    public  void  GotoCredits (View view) {
        Intent credits = new Intent(this, credits.class);
        startActivity(credits);
    }

    public  void  MainMenu (View view) {
        Intent menuBack = new Intent(this, MainActivity.class);
        startActivity(menuBack);
    }
    public  void  Contacts (View view) {
        Intent menuBack = new Intent(this, Contacts.class);
        startActivity(menuBack);
    }
}