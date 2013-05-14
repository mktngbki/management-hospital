package com.hospital.managementhospital.data;

import android.annotation.SuppressLint;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

@SuppressWarnings("serial")
public class Patient implements Serializable {
	private int paId;
	private String paName;
	private int paSex;
	private Date paDateOfBith;
	private String paColorFace;

	public Patient() {
	}

	@SuppressLint("SimpleDateFormat")
	public String getPaDateOfBith() {
		SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
		String rs = dbFormat.format(paDateOfBith);
		return rs;
	}

	public int getPaId() {
		return paId;
	}

	public String getPaName() {
		return paName;
	}

	public int getPaSex() {
		return paSex;
	}

	public String getColorFace() {
		return paColorFace;
	}
}
