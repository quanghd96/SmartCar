package com.quang.smartcar.acitivities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.quang.smartcar.R;
import com.quang.smartcar.fragments.DashBoardFragment;
import com.quang.smartcar.fragments.HealthFragment;
import com.quang.smartcar.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSIONS_MULTIPLE_REQUEST = 1000;
    private FragmentManager fragmentManager = getSupportFragmentManager();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentTransaction.replace(R.id.layout_content, new HomeFragment());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_dashboard:
                    fragmentTransaction.replace(R.id.layout_content, new DashBoardFragment());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_notifications:
                    fragmentTransaction.replace(R.id.layout_content, new HealthFragment());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_content, new HomeFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        Toast.makeText(MainActivity.this, "Đã kết nối tới ô tô của bạn!", Toast.LENGTH_LONG).show();

        //Check permision
        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission_group.LOCATION);
        if (permissionCheck != PermissionChecker.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        PERMISSIONS_MULTIPLE_REQUEST);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(MainActivity.this);
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.btnSetting) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_MULTIPLE_REQUEST: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(getApplicationContext(), "Bạn cần cấp quyền truy cập vị trí để tiếp tục sử dụng!", Toast.LENGTH_LONG).show();
                    finish();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

}
