package com.prashant.portfolio;

import android.app.ProgressDialog;
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

import com.bumptech.glide.Glide;
import com.google.gson.GsonBuilder;
import com.prashant.portfolio.AboutMe.Profile;
import com.prashant.portfolio.Education.Education;
import com.prashant.portfolio.AboutMe.AboutMeDC;
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

    public static AboutMeDC aboutmeDC;
    ImageView blur_image, user_image;
    ActionBarDrawerToggle toggle;
    public static String TAG = "TAG";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FetchData();
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setNavigationDrawer();
//        onNavigationItemSelected(navigationView.getMenu().getItem(0));
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
    }

    private void displayScreens(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.aboutme:
                fragment = new Profile();
                toolbar.setTitle("Profile");
                break;
            case R.id.education:
                fragment = new Education();
                toolbar.setTitle("My Educaiton");
                break;
            case R.id.workex:
                fragment = new WorkEx();
                toolbar.setTitle("Work Experience");
                break;
            case R.id.training:
                fragment = new Training();
                toolbar.setTitle("Training & Courses");
                break;
            case R.id.awards:
                fragment = new Awards();
                toolbar.setTitle("Achievements");
                break;
            case R.id.por:
                fragment = new PoR();
                toolbar.setTitle("Responsibilities");
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
        ShowProgressBar();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).build();
        API profile = retrofit.create(API.class);
        Call<AboutMeDC> call = profile.aboutMe();
        call.enqueue(new Callback<AboutMeDC>() {
            @Override
            public void onResponse(Call<AboutMeDC> call, Response<AboutMeDC> response) {

                displayScreens(R.id.aboutme);

                HideProgressBar();
                navigationView.getMenu().getItem(0).setChecked(true);
                aboutmeDC = response.body();
                Glide.with(MainActivity.this).load(aboutmeDC.profile_pic)
                        .apply(bitmapTransform(new BlurTransformation(20, 1))).into(blur_image);
                Glide.with(MainActivity.this).load(aboutmeDC.profile_pic).into(user_image);
            }

            @Override
            public void onFailure(Call<AboutMeDC> call, Throwable t) {
                Log.i(TAG, t.getMessage());
            }
        });
    }

    public void ShowProgressBar() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void HideProgressBar() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
