package com.hospital.managementhospital.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.hospital.managementhospital.R;
import com.hospital.managementhospital.data.Patient;

public class AdapterPatient extends ArrayAdapter<Patient> {
	private LayoutInflater inflater;

	public AdapterPatient(Context context, int textViewResourceId,
			List<Patient> objects) {
		super(context, textViewResourceId, objects);
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		Patient patient = getItem(position);
		if (null == convertView) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_patient, null);
			holder.chkPatient = (CheckBox) convertView
					.findViewById(R.id.chkPatient);
			holder.txtPatientName = (TextView) convertView
					.findViewById(R.id.txtPatientName);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
			holder.chkPatient.setChecked(false);
		}
		holder.txtPatientName.setText(patient.getPaName());
		return convertView;
	}

	private class ViewHolder {
		private CheckBox chkPatient;
		private TextView txtPatientName;
	}

}
