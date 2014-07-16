package com.exam.adapter;

import com.exam.fragment.FragmentChat;
import com.exam.fragment.FragmentContact;
import com.exam.fragment.FragmentDiscover;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AppSectionsPagerAdapter extends FragmentPagerAdapter  {
	 public AppSectionsPagerAdapter(FragmentManager fm) {
         super(fm);
     }

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		Fragment fragment=null;
		switch (position) {
		case 0://聊天 
			fragment=new FragmentChat();
			break;
		case 1://发现
			fragment=new FragmentDiscover();
			break;
		case 2://通讯录
			fragment=new FragmentContact();
			break;

		default:
			fragment=new FragmentChat();//默认--聊天
			break;
		}
		return fragment;
	}

	 @Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;//总共3个Tab
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		switch (position) {//cxc返回的值最好可以使用资源文件string.xml中的值
		case 0:
			return "聊天";
		case 1:
			return "发现";
		case 2:
			return "通讯录";

		default:
			return null;
		}
	}
	

}
