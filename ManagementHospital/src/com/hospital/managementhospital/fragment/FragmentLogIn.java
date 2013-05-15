package com.hospital.managementhospital.fragment;

import com.hospital.managementhospital.R;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentLogIn extends DialogFragment {

	public interface EditNameDialogListener {
		void onFinishEditDialog(String inputText);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_login, container);
		getDialog().setTitle("Hello");

		return view;
	}

	// @Override
	// public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
	// if (EditorInfo.IME_ACTION_DONE == actionId) {
	// // Return input text to activity
	// EditNameDialogListener activity = (EditNameDialogListener) getActivity();
	// activity.onFinishEditDialog(mEditText.getText().toString());
	// this.dismiss();
	// return true;
	// }
	// return false;
	// }

}
