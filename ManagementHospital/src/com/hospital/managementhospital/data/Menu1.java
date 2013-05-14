package com.hospital.managementhospital.data;

import android.annotation.SuppressLint;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

@SuppressLint("SimpleDateFormat")
@SuppressWarnings("serial")
public class Menu1 implements Serializable {

	private int menuId;
	private UserItem userItem;
	private Patient patientItem;
	private Date date;
	private int bloodPressureAbove;
	private int bloodPressureBelow;
	private int heartRate;

	public Menu1() {
	}

	public Patient getPatientItem() {
		return patientItem;
	}

	public void setPatientItem(Patient patientItem) {
		this.patientItem = patientItem;
	}

	public int getMenuId() {
		return menuId;
	}

	public String getDate() {
		SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
		String rs = dbFormat.format(date);
		return rs;
	}

	public int getBloodPressureAbove() {
		return bloodPressureAbove;
	}

	public int getBloodPressureBelow() {
		return bloodPressureBelow;
	}

	public int getHeartRate() {
		return heartRate;
	}

	public UserItem getUserItem() {
		return userItem;
	}

}
