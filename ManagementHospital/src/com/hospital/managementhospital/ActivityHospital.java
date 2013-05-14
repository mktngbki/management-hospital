package com.hospital.managementhospital;

import android.app.Activity;
import android.os.Bundle;

public abstract class ActivityHospital extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());
		initViews();
		initVariables();
		initControls();

	}

	protected abstract void initViews();

	protected abstract void initVariables();

	protected abstract void initControls();

	protected abstract int getLayoutId();
}
