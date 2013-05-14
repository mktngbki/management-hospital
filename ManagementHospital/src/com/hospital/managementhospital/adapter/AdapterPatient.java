package com.hospital.managementhospital.adapter;

import java.util.List;

import com.hospital.managementhospital.data.Patient;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class AdapterPatient extends ArrayAdapter<Patient> {

	public AdapterPatient(Context context, int textViewResourceId,
			List<Patient> objects) {
		super(context, textViewResourceId, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return super.getView(position, convertView, parent);
	}

}
