package de.romycomer.bookregal.BisinessInformatic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import de.romycomer.bookregal.BusinessAdministration;
import de.romycomer.bookregal.ComputerSience.ComputerSience;
import de.romycomer.bookregal.ComputerSience.ComputerSience1;
import de.romycomer.bookregal.ComputerSience.ComputerSience2;
import de.romycomer.bookregal.ComputerSience.ComputerSience3;
import de.romycomer.bookregal.ComputerSience.ComputerSience4;
import de.romycomer.bookregal.ComputerSience.ComputerSience5;
import de.romycomer.bookregal.ComputerSience.ComputerSience6;
import de.romycomer.bookregal.LanguageManager;
import de.romycomer.bookregal.MainActivity;
import de.romycomer.bookregal.Mathematics.Mathematic;
import de.romycomer.bookregal.Physic;
import de.romycomer.bookregal.R;

public class BusinessInformatic extends AppCompatActivity {

    //Initialize variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_informatic);

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


        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
    }
    public void ClickMenu(View view){
        //open drawer
        MainActivity.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        //close drawer
        MainActivity.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        //redirect Activity to home
        MainActivity.redirectActivity(this,MainActivity.class);
    }
    public void ClickComputerSience(View view){
        MainActivity.redirectActivity(this, ComputerSience.class);
    }
    public void clickMathematic(View view){
        MainActivity.redirectActivity(this, Mathematic.class);
    }
    public void clickBusiness_informatic(View view){
        //recreate activity
        recreate();
    }
    public void clickBusiness_administration(View view) {
        MainActivity.redirectActivity(this, BusinessAdministration.class);
    }

    public void clickPhysic(View view) {
        MainActivity.redirectActivity(this, Physic.class);
    }

    public void ClickBusinessInformatic1(View view) { MainActivity.redirectActivity(this, ComputerSience.class); }
    public void ClickBusinessInformatic2(View view) { MainActivity.redirectActivity(this, ComputerSience2.class); }
    public void ClickBusinessInformatic3(View view) { MainActivity.redirectActivity(this, ComputerSience3.class); }
    public void ClickBusinessInformatic4(View view) { MainActivity.redirectActivity(this, ComputerSience4.class); }
    public void ClickBusinessInformatic5(View view) { MainActivity.redirectActivity(this, ComputerSience5.class); }
    public void ClickBusinessInformatic6(View view) { MainActivity.redirectActivity(this, ComputerSience6.class); }

    @Override
    protected void onPause(){
        super.onPause();
        //close drawer
        MainActivity.closeDrawer(drawerLayout);
    }
}