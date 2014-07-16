package com.exam.myweixinapp;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.exam.adapter.AppSectionsPagerAdapter;

public class MainActivity extends ActionBarActivity implements TabListener {
	
	AppSectionsPagerAdapter mAppSectionsPagerAdapter;
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 // Set up the action bar.
		final ActionBar actionBar=getActionBar();
		
		// Specify that the Home/Up button should not be enabled, since there is no hierarchical parent.
		//actionBar.setHomeButtonEnabled(false);
		
		// Specify that we will be displaying tabs in the action bar.
		actionBar.setNavigationMode(ActionBar .NAVIGATION_MODE_TABS);
		// Set up the ViewPager, attaching the adapter and setting up a listener for when the
        // user swipes between sections.
		mAppSectionsPagerAdapter=new AppSectionsPagerAdapter(getSupportFragmentManager());
		mViewPager=(ViewPager)findViewById(R.id.pager);
		mViewPager.setAdapter(mAppSectionsPagerAdapter);
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){

			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				actionBar.setSelectedNavigationItem(position);
			}
			
		});
		
		// For each of the sections in the app, add a tab to the action bar.
		//聊天
		actionBar.addTab(actionBar.newTab().setText(mAppSectionsPagerAdapter.getPageTitle(0)).setTabListener(this));
		//发现
		actionBar.addTab(actionBar.newTab().setText(mAppSectionsPagerAdapter.getPageTitle(1)).setTabListener(this));
		//通讯录
		actionBar.addTab(actionBar.newTab().setText(mAppSectionsPagerAdapter.getPageTitle(2)).setTabListener(this));
		
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
		switch (id) {
		case R.id.action_search:
			showToast("点击--搜索");
			break;
		case R.id.action_new:
			showToast("点击--添加");
			break;
			
		case R.id.action_settings:
			showToast("点击--设置");
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	/*
	 * public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	 * */
	public void showToast(String message)
	{
		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
	}

	/////////////////////////cxc
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		 // probably ignore this event
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	
}
