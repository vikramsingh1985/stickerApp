package app.android.floupr.elgroup.activities;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import app.android.floupr.elgroup.adapters.DrawerListAdapter;
import app.android.floupr.elgroup.adapters.ImageAdapter;
import app.android.floupr.elgroup.adapters.TopImageAdapter;
import app.android.floupr.elgroup.common.NavItem;
import app.android.floupr.elgroup.fragments.GifFragment;
import app.android.floupr.elgroup.stickerapp.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    TextView tool_title;
    ActionBarDrawerToggle actionBarDrawerToggle;
    ListView mDrawerList;
    Context context;
    ArrayList<NavItem> mNavItems;
    private DrawerLayout drawer;
    String ToolTitle;
    int fragmentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tool_title = toolbar.findViewById(R.id.toolTitle);
        context =getApplicationContext();
        Bundle extras = getIntent().getExtras();
        if(extras!=  null){
            fragmentIndex = extras.getInt("index");
        }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        initViews();
    }

    private void initViews(){

        drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);

        NavigationView  navigationView = (NavigationView) findViewById(R.id.nav_view);

        mDrawerList = (ListView) findViewById(R.id.sideDrawableList);
        mNavItems = new ArrayList<>();
        mNavItems.add(new NavItem(getString(R.string.gif), R.drawable.gif_active));
        mNavItems.add(new NavItem(getString(R.string.stickers), R.drawable.sticker_active));
        mNavItems.add(new NavItem(getString(R.string.message),R.drawable.message_240));
        mNavItems.add(new NavItem(getString(R.string.facts),R.drawable.fact_sticker_active));

        DrawerListAdapter adapter = new DrawerListAdapter(this, mNavItems);

        mDrawerList.setAdapter(adapter);
        // load toolbar titles from string resources
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mDrawerList.setItemChecked(0, true);

        navigationView.setNavigationItemSelectedListener(this);
        //setUpNavigationView();
        selectItemFromDrawer(fragmentIndex);


    }

    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        // clearBackStack();
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                selectItemFromDrawer(position);
            }
        });
        //setTitle(mNavItems.get(navItemIndex).getTitle());

        Drawable drawable = ResourcesCompat.getDrawable(getResources(),   R.drawable.left_arrow, this.getTheme());

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we don't want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we don't want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);


            }
        };


        actionBarDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerVisible(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });
        //Setting the actionbarToggle to drawer layout
        assert drawer!=null;
        toolbar.setNavigationIcon(drawable);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(false);
        actionBarDrawerToggle.setHomeAsUpIndicator(drawable);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        //calling sync state is necessary or else your hamburger icon wont show up


    }

    public void selectItemFromDrawer(int position) {
        Fragment selectedFragment = null;


        switch (position) {
            //Replacing the main content with ContentFragment Which is our Inbox View;

            case 0:

                selectedFragment = new GifFragment();

                ToolTitle = getString(R.string.gif);
                break;
            case 1:

                selectedFragment = new GifFragment();

                ToolTitle = getString(R.string.stickers);
                break;
            case 2:
                selectedFragment = new GifFragment();
                ToolTitle = getString(R.string.message);
                break;
            case 3:
                selectedFragment = new GifFragment();
                ToolTitle = getString(R.string.facts);
                break;


            default:

                selectedFragment = new GifFragment();
        }

        loadFragment(selectedFragment);
        setToolBarTitle(ToolTitle);
        drawer.closeDrawers();


    }

    void loadHomeFragment(){
        // clearBackStack();


        loadFragment(new GifFragment());
    }

    void loadFragment(Fragment selectedFragment){
        // clearBackStack();
        setToolBarTitle(ToolTitle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        transaction.replace(R.id.frame_layout, selectedFragment);
        transaction.commitAllowingStateLoss();
        //return true;
    }
    public void setToolBarBackground(int id){
        toolbar.setBackgroundResource(id);
        //toolbar.setBackground(getDrawable(R.drawable.profile_about_bg));
    }

    public  void setToolBarTitle(String text){
        tool_title.setText(text);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_feedback) {
            feedback();

            return true;
        }
        if (id == R.id.action_rateus) {
            rateUs();

            return true;
        }if (id == R.id.action_share) {

        share();
            return true;
        }if (id == R.id.action_more) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void feedback(){
        Intent Email = new Intent(Intent.ACTION_SEND);
        Email.setType("text/email");
        Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "vikramcomorade@gmail.com"});
        Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
        Email.putExtra(Intent.EXTRA_TEXT, "Dear ...," + "");
        startActivity(Intent.createChooser(Email, "Send Feedback:"));


    }

    private void share(){
        Intent i=new Intent(android.content.Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject test");
        i.putExtra(android.content.Intent.EXTRA_TEXT, "extra text that you want to put");
        startActivity(Intent.createChooser(i,"Share via"));

    }

    private void rateUs(){
        Uri uri = Uri.parse("market://details?id=" + getApplicationContext().getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName())));
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_gif) {
            //rateUs();

        } else if (id == R.id.nav_stickers) {
           // share();

        } else if (id == R.id.nav_message) {


        } else if (id == R.id.nav_facts) {
           // feedback();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
