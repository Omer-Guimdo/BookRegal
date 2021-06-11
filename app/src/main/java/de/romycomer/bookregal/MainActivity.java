package de.romycomer.bookregal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.room.Room;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.List;

import de.romycomer.bookregal.DB.AppDatabase;
import de.romycomer.bookregal.DB.Book;

public class MainActivity extends AppCompatActivity {
    //initialize variable

    private Toolbar toolbar;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign variable

        drawerLayout = findViewById(R.id.drawer_layout);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // language button

        ImageButton en = findViewById(R.id.btn_englisch);
        ImageButton de = findViewById(R.id.btn_deutsch);
        ImageButton fr = findViewById(R.id.btn_france);
        LanguageManager lang = new LanguageManager(this);

        en.setOnClickListener(view ->
        {
            lang.updateResource("en");
            recreate();
        });
        de.setOnClickListener(view ->
        {
            lang.updateResource("de");
            recreate();
        });
        fr.setOnClickListener(view ->
        {
            lang.updateResource("fr");
            recreate();
        });


        // Database

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "book.database").allowMainThreadQueries().build();

        Book Book1 = new Book("Java", "Omer");
        Book Book2 = new Book("C#", "Romi");

        db.bookDao().insertBook(Book1, Book2);
        List<Book> bookList = db.bookDao().getAllBooks();

        for (Book list: bookList){
            Log.d("books", list.titel + " " + list.autor );
        }


    }
    public void ClickMenu(View view){
        //Open drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }
    
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //close drawer layout
        //check condition
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            //when drawer is open
            //close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public void ClickHome(View view){
        //recreate activity
        recreate();
    }

    public  void ClickComputerSience(View view){
        //redirect activity to Computer Sience
        redirectActivity(this, ComputerSience.class);
    }
    public  void clickMathematic(View view){
        //redirect activity to Mathematic
        redirectActivity(this, Mathematic.class);
    }
    public  void clickBusiness_informatic(View view){
        //redirect activity to Mathematic
        redirectActivity(this, BusinessInformatic.class);
    }
    public  void clickBusiness_administration(View view){
        //redirect activity to Mathematic
        redirectActivity(this, BusinessAdministration.class);
    }
    public  void clickPhysic(View view){
        //redirect activity to Mathematic
        redirectActivity(this, Physic.class);
    }

    public static void redirectActivity(Activity activity, Class aClass) {
        //Initialize intent
        Intent intent = new Intent(activity,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //start activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause(){
        super.onPause();
        //close drawer
        closeDrawer(drawerLayout);
    }
}