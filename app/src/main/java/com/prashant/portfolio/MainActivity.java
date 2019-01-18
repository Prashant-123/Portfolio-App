package com.prashant.portfolio;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.GsonBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawerLayout)
    DrawerLayout drawer;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    public static User user;

    ImageView blur_image, user_image;
    ActionBarDrawerToggle toggle;
    public static String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setNavigationDrawer();
        navigationView.getMenu().getItem(0).setChecked(true);
        setHeaderImage();
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
        FetchData();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        displayScreens(menuItem.getItemId());
        return true;
    }

    public void setNavigationDrawer() {
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        blur_image = navigationView.getHeaderView(0).findViewById(R.id.blur_user_image);
        user_image = navigationView.getHeaderView(0).findViewById(R.id.user_profile_picture);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        drawer.setDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        toggle.syncState();
        displayScreens(R.id.aboutme);
    }

    public void setHeaderImage() {

    }

    private void displayScreens(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.aboutme:
                fragment = new Profile();
                toolbar.setTitle("Profile");
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                break;
            case R.id.education:
                fragment = new Profile();
                toolbar.setTitle("Profile");
                break;
            case R.id.workex:
                fragment = new Profile();
                toolbar.setTitle("Profile");
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.main_Frame, fragment);
            ft.commit();
        }

        drawer.closeDrawer(GravityCompat.START);
    }

    public void FetchData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).build();
        API profile = retrofit.create(API.class);
        Call<User> call = profile.fetch();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user = response.body();
                Log.i(TAG, user.getImg());
                Glide.with(MainActivity.this).load(user.img)
                        .apply(bitmapTransform(new BlurTransformation(20, 1))).into(blur_image);
                Glide.with(MainActivity.this).load(user.img).into(user_image);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.i(TAG, t.getMessage());
            }
        });
    }
}
