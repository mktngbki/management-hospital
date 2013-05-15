package com.hospital.managementhospital.data;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;

@SuppressWarnings("serial")
public class Patient implements Serializable {
	private int paId;
	private String paName;
	private int paSex;
	private Date paDateOfBith;
	private String paColorFace;

	public Patient() {
	}

	public void setPaId(int paId) {
		this.paId = paId;
	}

	public void setPaColorFace(String paColorFace) {
		this.paColorFace = paColorFace;
	}

	public void setPaDateOfBith(String input) throws ParseException {
		 SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
		 paDateOfBith =  dbFormat.parse(input);
	}

	public void setPaName(String paName) {
		this.paName = paName;
	}

	public void setPaSex(int paSex) {
		this.paSex = paSex;
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
