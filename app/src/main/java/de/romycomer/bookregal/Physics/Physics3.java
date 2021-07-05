package de.romycomer.bookregal.Physics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import de.romycomer.bookregal.BusinessAdministration.BusinessAdministration;
import de.romycomer.bookregal.BusinessInformatic.BusinessInformatic;
import de.romycomer.bookregal.ComputerSience.ComputerSience;
import de.romycomer.bookregal.LanguageManager;
import de.romycomer.bookregal.MainActivity;
import de.romycomer.bookregal.Mathematics.Mathematic;
import de.romycomer.bookregal.R;


public class Physics3 extends AppCompatActivity {

    //Initialize variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics3);

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
        //recreate activity
        MainActivity.redirectActivity(this, ComputerSience.class);
    }
    public void clickMathematic(View view){
        MainActivity.redirectActivity(this, Mathematic.class);
    }

    public void clickBusiness_administration(View view) {
        MainActivity.redirectActivity(this, BusinessAdministration.class);
    }

    public void clickBusiness_informatic(View view) {
        MainActivity.redirectActivity(this, BusinessInformatic.class);
    }

    public void clickPhysic(View view) {
        MainActivity.redirectActivity(this, Physics.class);
    }


    @Override
    protected void onPause(){
        super.onPause();
        //close drawer
        MainActivity.closeDrawer(drawerLayout);
    }
}