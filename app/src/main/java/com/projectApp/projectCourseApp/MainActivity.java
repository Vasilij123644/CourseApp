package com.projectApp.projectCourseApp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.projectApp.projectCourseApp.adapter.CategoryAdapter;
import com.projectApp.projectCourseApp.adapter.CourseAdapter;
import com.projectApp.projectCourseApp.model.Category;
import com.projectApp.projectCourseApp.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCourseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(0, "Все"));
        categoryList.add(new Category(1, "Игры"));
        categoryList.add(new Category(2, "Сайты"));
        categoryList.add(new Category(3, "Языки"));
        categoryList.add(new Category(4, "Прочее"));

        setCategoryRecycler(categoryList);

        courseList.add(new Course(1, "java", "Профессия Java\nразработчик", "11 декабря", "Начальный", "#424345", "Cпециалист, в обязанности которого входит программирование продуктов с использованием языка Java. Сфера применения последнего – это backend-разработка, то есть создание программного обеспечения, ответственного за функционирование внутренних систем сервера, получения и обработки ими запросов..", 3));
        courseList.add(new Course(2, "python", "Профессия Python\nразработчик", "12 декабря", "Начальный", "#9FA52D", "Cпециалист, создающий программы, приложения и код вообще на языке программирования Python. Он пишет мобильные и десктопные приложения, создает программное обеспечение для банкоматов, ЧПУ-станков, телекоммуникационного и другого высокотехнологичного оборудования. С его участием происходит разработка сайтов, онлайн-сервисов, клиент-серверных программ, алгоритмов для Яндекса, ботов для соцсетей и т.д.", 3));
        courseList.add(new Course(3, "unity", "Профессия Unity\nразработчик", "13 декабря", "Начальный", "#65173D", "Cпециалист, который создает игры на движке Unity. Профессия интересная, востребованная и главное, хорошо оплачиваемая. Если вы решили погрузиться в мир геймдева, но не знаете, с чего начать..", 1));
        courseList.add(new Course(4, "front_end", "Профессия Front-end\nразработчик", "14 декабря", "Начальный", "#B04935", "Программист, отвечающий за разработку внешней, клиентской части сайта или приложения, которая отражается в любом браузере. Он также отвечает за вёрстку сайта, его интерфейс, включая фильтры, кнопки, анимации, формы, рекламные блоки и т.п. Всё, с чем работает этот специалист, видят пользователи.", 2));
        courseList.add(new Course(5, "back_end", "Профессия Back-end\nразработчик", "15 декабря", "Начальный", "#2D55A5", "Программист, который отвечает за внутреннюю и вычислительную логику веб-сайта или веб-приложения, а также иного программного обеспечения и информационных систем. Строго говоря, бэкенд бывает не только у веб-решений, он есть и у десктопа, и у мобильных приложений, т.к. по сути бэкенд — это всё, что относится к программно-аппаратной части сервиса.", 2));
        courseList.add(new Course(6, "full_stack", "Профессия Full Stack\nразработчик", "16 декабря", "Средний", "#FFC007", "Мастер на все руки в мире веб-разработки. Ему под силу реализовать как клиентскую, так и серверную сторону приложения, которыми, обычно, занимаются FrontEnd и BackEnd разработчики раздельно друг от друга. Таким образом, Full-stack специалист способен в одиночку вести проект от начала до конца.", 2));
        fullCourseList.addAll(courseList);
        setCourseRecycler(courseList);
    }

    public void openCart(View view) {
        Intent intent = new Intent(this, OrderPage.class);
        closeActivity();
        startActivity(intent);
    }

    public  void MainMenu (View view) {

    }

    public  void  GotoCredits (View view) {
        Intent credits = new Intent(this, credits.class);
        closeActivity();
        startActivity(credits);
    }


    public  void  Contacts (View view) {
        Intent menuBack = new Intent(this, Contacts.class);
        closeActivity();
        startActivity(menuBack);
    }

    public void closeActivity() {
        this.finish();
    }
    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    @SuppressLint("NotifyDataSetChanged")
    public static void showCoursesByCategory(int category) {
        courseList.clear();
        if (category == 0) {
            courseList.addAll(fullCourseList);
        }
        else
        {
            for (Course course : fullCourseList) {
                if (course.getCategory() == category) {
                    courseList.add(course);
                }
            }
        }
        courseAdapter.notifyDataSetChanged();
    }

}