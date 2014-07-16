package com.exam.fragment;

import com.exam.myweixinapp.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentChat extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		System.out.println("FragmentChat.onCreateView()--cxc");
		View rooView =inflater.inflate(R.layout.fragment_chat, container, false);
		return rooView;
	}

}

