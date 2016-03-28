package deals.mac.com.blackfridays;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;


import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ShareActionProvider;

import deals.mac.com.blackfridays.fragment.AmazonDealsFragment;
import deals.mac.com.blackfridays.fragment.EbayDealsFragment;

import deals.mac.com.blackfridays.fragment.MainEmptyFragment;
import deals.mac.com.blackfridays.fragment.TopFragment;

public class MainActivity extends Activity {


    private ShareActionProvider shareActionProvider;
    private ListView drawerList;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private int currentPosition = 0;
    private String[] deals_stores;
    final public static String FRAGMENT_ID="COMPONENT_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        deals_stores = getResources().getStringArray(R.array.deals_stores);
        drawerList = (ListView)findViewById(R.id.drawer);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawerList.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_activated_1, deals_stores));
        drawerList.setOnItemClickListener(new DrawerItemClickListener());

        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt("position");
            setActionBarTitle(currentPosition);
        } else {
            selectItem(0);
        }
        //Create the ActionBarDrawerToggle
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.start, R.string.back) {
            //Called when a drawer has settled in a completely closed state
            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }
            //Called when a drawer has settled in a completely open state.
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };
        //drawerLayout.setDrawerListener(drawerToggle);

        drawerLayout.addDrawerListener(drawerToggle);

        setUpActionBar();
    }



    private void selectItem(int position) {

        currentPosition = position;
        Fragment fragment;
        switch(position) {
            case 1:
                fragment = new EbayDealsFragment();
                break;
            case 2:
                fragment = new AmazonDealsFragment();
                break;
            default:
                fragment = new MainEmptyFragment();
        }
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment, FRAGMENT_ID);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        //Set the action bar title
        setActionBarTitle(position);
        //Close drawer
        drawerLayout.closeDrawer(drawerList);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        //boolean drawerOpen = drawerLayout.isDrawerOpen(drawerList);
        //menu.findItem(R.id.action_share).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", currentPosition);
    }

    private void setActionBarTitle(int position) {
        String title="Your BlackFriday App";
        if (position == 0) {
            title = getResources().getString(R.string.app_name);
        } else {
            title = deals_stores[position];
        }
        getActionBar().setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
           case R.id.action_settings:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }


    public void setUpActionBar(){


        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        getFragmentManager().addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        FragmentManager fragMan = getFragmentManager();
                        Fragment fragment = fragMan.findFragmentByTag(FRAGMENT_ID);

                        if (fragment instanceof TopFragment) {
                            currentPosition = 0;
                        }
                        if (fragment instanceof MainEmptyFragment) {
                            currentPosition = 0;
                        }
                        if (fragment instanceof EbayDealsFragment) {
                            currentPosition = 1;
                        }
                        if (fragment instanceof AmazonDealsFragment) {
                            currentPosition = 2;
                        }
                        setActionBarTitle(currentPosition);
                        drawerList.setItemChecked(currentPosition, true);
                    }
                }
        );

    }


}
