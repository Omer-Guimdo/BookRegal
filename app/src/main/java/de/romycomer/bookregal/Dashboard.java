package de.romycomer.bookregal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    //Initialize variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
    }
    public void ClickMenu(View view){
        //open drawer
        MainActivity.openDrawer(drawerLayout);
    }
    public void clickLogo(View view){
        //close drawer
        MainActivity.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        //redirect Activity to home
        MainActivity.redirectActivity(this,MainActivity.class);
    }
    public void ClickDashboard(View view){
        //recreate activity
        recreate();
    }
}