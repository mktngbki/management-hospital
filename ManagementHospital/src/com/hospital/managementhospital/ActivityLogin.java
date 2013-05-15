package com.hospital.managementhospital;

import android.app.DialogFragment;
import android.content.Intent;

import com.hospital.managementhospital.fragment.DialogFragmentLogIn;
import com.hospital.managementhospital.fragment.DialogFragmentLogIn.LoginDialogListener;

public class ActivityLogin extends ActivityHospital implements
		LoginDialogListener {

	@Override
	protected void initViews() {
	}

	@Override
	protected void initVariables() {

	}

	@Override
	protected void initControls() {
		showEditDialog();
	}

	@Override
	protected int getLayoutId() {
		return 1;
	}

	@Override
	public void setContentView(int layoutResID) {
	}

	private void showEditDialog() {
		DialogFragmentLogIn editNameDialog = new DialogFragmentLogIn();
		editNameDialog.setCancelable(false);
		editNameDialog.setStyle(DialogFragment.STYLE_NO_TITLE,
				android.R.style.Theme_Holo_Light_Dialog_MinWidth);
		editNameDialog.show(getFragmentManager(), "fragment_edit_name");
	}

	@Override
	public void onFinishEditDialog(String inputText) {
		Intent intent = new Intent(getApplicationContext(), ActivityHome.class);
		startActivity(intent);
	}

}
