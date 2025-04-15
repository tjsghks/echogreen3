// MainActivity.java
package com.tmdghks.ecogreen;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
//            switch (item.getItemId()) {
//                case R.id.menu_shop:
//                    selectedFragment = new ShopFragment();
//                    break;
//                case R.id.menu_home:
//                    selectedFragment = new HomeFragment();
//                    break;
//                case R.id.menu_menu:
//                    selectedFragment = new MenuFragment();
//                    break;
//            }

            if (selectedFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, selectedFragment);
                transaction.commit();
            }
            return true;
        });

        // 홈 화면 기본으로 설정
        bottomNavigationView.setSelectedItemId(R.id.menu_home);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        }
    }

}