package com.exam.fragment;

import com.exam.myweixinapp.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentDiscover extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rooView=inflater.inflate(R.layout.fragment_discover, container, false);
		return rooView;
	}

}
