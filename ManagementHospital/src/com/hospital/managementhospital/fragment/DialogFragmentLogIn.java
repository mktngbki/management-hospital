package com.hospital.managementhospital.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.hospital.managementhospital.R;

public class DialogFragmentLogIn extends DialogFragment implements
		OnEditorActionListener {
	private EditText edtUser;

	public interface LoginDialogListener {
		void onFinishEditDialog(String inputText);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_login, container);
		Button login = (Button) view.findViewById(R.id.btnLogin);
		edtUser = (EditText) view.findViewById(R.id.edtUserName);
		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String userName = edtUser.getText().toString();
				((LoginDialogListener) getActivity())
						.onFinishEditDialog(userName);
			}
		});
		return view;
	}

	@Override
	public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
		return false;
	}

}
