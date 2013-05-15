package com.hospital.managementhospital.fragment;

import java.util.List;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.hospital.managementhospital.R;
import com.hospital.managementhospital.adapter.AdapterPatient;
import com.hospital.managementhospital.data.Patient;
import com.hospital.managementhospital.db.HospitalDB;
import com.hospital.managementhospital.db.task.GetListPatientTask;

public class FragmentListPatient extends AbstractFragment implements
		OnItemClickListener {
	private ListView listPatient;
	private AdapterPatient adapterPatient;
	private HospitalDB db;

	@Override
	protected void initTask() {
		GetListPatientTask task = new GetListPatientTask() {
			@Override
			protected void onPostExecute(List<Patient> result) {
				adapterPatient = new AdapterPatient(getApplicationContext(),
						-1, result);
				listPatient.setAdapter(adapterPatient);
				listPatient.setOnItemClickListener(FragmentListPatient.this);
			}
		};
		task.execute(db);
	}

	@Override
	protected void initVariables() {
		db = new HospitalDB(getApplicationContext());
	}

	@Override
	protected void initControls() {
		listPatient = (ListView) findViewById(R.id.listPatient);
	}

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_list_patient;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		
	}

}
