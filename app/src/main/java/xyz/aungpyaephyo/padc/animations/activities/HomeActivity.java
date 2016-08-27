package xyz.aungpyaephyo.padc.animations.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.aungpyaephyo.padc.animations.R;
import xyz.aungpyaephyo.padc.animations.fragments.DrawableAnimationsFragment;
import xyz.aungpyaephyo.padc.animations.fragments.PropertyAnimationsFragment;
import xyz.aungpyaephyo.padc.animations.fragments.SceneOnePAFragment;
import xyz.aungpyaephyo.padc.animations.fragments.SceneTwoPAFragment;
import xyz.aungpyaephyo.padc.animations.fragments.ViewAnimationsFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_animation);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            navigateToViewAnimation();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                return true;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {
            case R.id.menu_view_animations:
                navigateToViewAnimation();
                return true;
            case R.id.menu_property_animations:
                navigateToPropertyAnimation();
                return true;
            case R.id.menu_drawable_animations:
                navigateToDrawableAnimation();
                return true;
            case R.id.menu_scene_one_pa:
                navigateToSceneOne();
                return true;
            case R.id.menu_scene_two_pa:
                navigateToSceneTwo();
                return true;
        }
        return false;
    }

    private void navigateToViewAnimation() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, new ViewAnimationsFragment())
                .commit();
    }

    private void navigateToPropertyAnimation() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, new PropertyAnimationsFragment())
                .commit();
    }

    private void navigateToDrawableAnimation() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, new DrawableAnimationsFragment())
                .commit();
    }

    private void navigateToSceneOne() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, new SceneOnePAFragment())
                .commit();
    }

    private void navigateToSceneTwo() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, new SceneTwoPAFragment())
                .commit();
    }
}
