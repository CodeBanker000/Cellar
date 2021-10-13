package it.mtank.cellar;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import it.mtank.cellar.libs.fragment.ManagementFragment;
import it.mtank.cellar.libs.fragment.OrdersFragment;
import it.mtank.cellar.libs.fragment.PurchasedFragment;
import it.mtank.cellar.libs.fragment.SalesFragment;

public class Main extends AppCompatActivity
{

    private Context cxt;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {

            switch (item.getItemId()) {
                case R.id.navigation_sales:
                    setFragment(new SalesFragment());
                    return true;
                case R.id.navigation_purchased:
                    setFragment(new PurchasedFragment());
                    return true;
                case R.id.navigation_orders:
                    setFragment(new OrdersFragment());
                    return true;
                case R.id.navigation_management:
                    setFragment(new ManagementFragment());
                    return true;
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //sets the bottom navigation function
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setFragment(new SalesFragment());

        cxt = this;


    }

    private void setFragment(Fragment fragment)
    {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.main_content, fragment).commit();
    }
}
