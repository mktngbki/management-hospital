package com.hospital.managementhospital.db.task;

import java.util.List;

import android.os.AsyncTask;
import android.util.Log;

import com.hospital.managementhospital.data.Patient;
import com.hospital.managementhospital.db.HospitalDB;

public class GetListPatientTask extends
		AsyncTask<HospitalDB, Void, List<Patient>> {

	private static final String TAG = "GetListPatientTask";

	@Override
	protected List<Patient> doInBackground(HospitalDB... params) {
		HospitalDB db = params[0];
		return db.getListPatient();

	}

	protected void finalize() throws Throwable {
		Log.e(TAG, "GC - GetListPatientTask");
	};
}
