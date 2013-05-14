package com.hospital.managementhospital.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class AbstractFragment extends Fragment {
	private View root;

	@Override
	public final View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		root = inflater.inflate(getLayoutId(), null);
		initVariables();
		initControls();
		return root;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initTask();
	}

	protected abstract void initTask();

	protected abstract void initVariables();

	protected abstract void initControls();

	protected final View findViewById(int id) {
		return root.findViewById(id);
	}

	protected abstract int getLayoutId();

	protected final Object getSystemService(String name) {
		return getActivity().getSystemService(name);
	}

	protected final Context getApplicationContext() {
		return getActivity().getApplicationContext();
	}
}
