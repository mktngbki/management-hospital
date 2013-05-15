package com.hospital.managementhospital.db;

import java.io.File;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hospital.managementhospital.data.Menu1;
import com.hospital.managementhospital.data.Patient;
import com.hospital.managementhospital.data.UserItem;

public class HospitalDB extends SQLiteOpenHelper {
	private static final String TABLE_USER = "users";
	private static final String TABLE_PATIENT = "patients";
	public static final String TABLE_LOG = "logs";

	private static final int DB_VERSION = 1;
	private static final String DB_NAME = "HospitalDB";

	private final static String DB_PATH = "/data/data/com.hospital.managementhospital/databases/";
	private File dbFile;

	private static final String CREATE_TABLE_USER = "Create table if not exists \"users\" " //
			+ "( \"user_id\" INTEGER PRIMARY KEY ," //
			+ " \"user_name\" VARCHAR(32) ," //
			+ "\"password\" VARCHAR(32) )";

	private final String CREATE_TABLE_PATIENT = "Create table if not exists \"patients\" "
			+ "( \"pa_id\" INTEGER PRIMARY KEY," //
			+ "	\"pa_name\" VARCHAR(32),"//
			+ " \"pa_sex\" INTEGER, "//
			+ " \"pa_dob\" DATETIME, "//
			+ "	\"pa_face_color\" VARCHAR(32))";

	private final String CREATE_TABLE_MENU1 = "Create table if not exists \"menu1\" "
			+ "( \"mnu_id\" INTEGER PRIMARY KEY,"
			+ " \"pa_id\" INTEGER, "
			+ " \"user_id\" INTEGER, "
			+ " \"log_date\" DATETIME, "
			+ " \"blood_pressure_above\" INTEGER,"
			+ "\"blood_pressure_below\" INTEGER," //
			+ "\"heart_rate\" INTEGER)";

	private Context context;

	// public void updateEquipStatus(int itemId, boolean status) {
	// SQLiteDatabase database = getWritableDatabase();
	// ContentValues values = new ContentValues();
	// values.put("equipped", status);
	// database.update(TABLE_USER, values, "itm_id = ? ", new String[] { ""
	// + itemId });
	// database.close();
	// }
	//
	// public void updateTicketDaily() {
	// SQLiteDatabase liteDatabase = getWritableDatabase();
	// ContentValues values = new ContentValues();
	// values.put("ticket_daily", 5);
	// liteDatabase.update(TABLE_PATIENT, values, null, null);
	// liteDatabase.close();
	// }
	//
	// public void buyItem(int itemId, boolean isTicket) {
	// SQLiteDatabase database = getWritableDatabase();
	// ContentValues values = new ContentValues();
	// values.put("status", !isTicket);
	// database.update(TABLE_USER, values, "itm_id = ? ", new String[] { ""
	// + itemId });
	// database.close();
	// }

	public long insertUser(UserItem item) {
		SQLiteDatabase database = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("user_name", item.getUser());
		values.put("password", item.getPass());
		long id = database.insert(TABLE_USER, null, values);
		database.close();
		return id;
	}

	public long insertMenu1(Menu1 menu) {
		SQLiteDatabase database = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("pa_id", menu.getPatientItem().getPaId());
		values.put("user_id", menu.getUserItem().getUserId());
		values.put("log_date", menu.getDate());
		values.put("blood_pressure_above", menu.getBloodPressureAbove());
		values.put("blood_pressure_below", menu.getBloodPressureBelow());
		values.put("heart_rate", menu.getHeartRate());
		long id = database.insert(TABLE_PATIENT, null, values);
		database.close();
		return id;
	}

	public long insertPatient(Patient patient) {
		SQLiteDatabase database = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("pa_name", patient.getPaName());
		values.put("pa_sex", patient.getPaSex());
		values.put("pa_dob", patient.getPaDateOfBith());
		values.put("pa_face_color", patient.getColorFace());
		long id = database.insert(TABLE_PATIENT, null, values);
		database.close();
		return id;
	}

	// public UserItem getUserItem() {
	// SQLiteDatabase database = getReadableDatabase();
	// UserItem item = new UserItem();
	// getStoryItem(database, item, BACKGROUND, 1);
	// getStoryItem(database, item, FACE, 1);
	// getStoryItem(database, item, HAIR, 1);
	// getStoryItem(database, item, HAIR_ACCESSORY, 1);
	// getStoryItem(database, item, PET, 1);
	// getStoryItem(database, item, DRESS, 1);
	// getStoryItem(database, item, HAIR_BACK, 0);
	//
	// Cursor cursor = database.query(TABLE_PROFILE, new String[] {
	// "friendly", "ticket_daily", "ticket_shop" }, null, null, null,
	// null, null);
	// cursor.moveToFirst();
	// item.setFriendly(cursor.getInt(0));
	// item.setTickDaily(cursor.getInt(1));
	// item.setTicketShop(cursor.getInt(2));
	// cursor.close();
	//
	// database.close();
	// return item;
	// }

	// private void insertMark(SQLiteDatabase db) {
	// ArrayList<MarkItem> items = ItemUtil.getMarkItem();
	// for (MarkItem item : items) {
	// ContentValues values = ItemUtil.parseMarkITemToDB(item);
	// db.insert(TABBLE_MARK, null, values);
	// }
	// }

	public HospitalDB(Context applicationContext) {
		super(applicationContext, DB_NAME, null, DB_VERSION);
		this.context = applicationContext;
		// dbFile = new File(DB_PATH + DB_NAME);
	}

	// @Override
	// public synchronized SQLiteDatabase getWritableDatabase() {
	// if (!dbFile.exists()) {
	// SQLiteDatabase db = super.getWritableDatabase();
	// copyDataBase(db.getPath());
	// }
	// return super.getWritableDatabase();
	// }
	//
	// @Override
	// public synchronized SQLiteDatabase getReadableDatabase() {
	// if (!dbFile.exists()) {
	// SQLiteDatabase db = super.getReadableDatabase();
	// copyDataBase(db.getPath());
	// }
	// return super.getReadableDatabase();
	// }

	// private void copyDataBase(String dbPath) {
	// try {
	// InputStream assestDB = context.getAssets().open(DB_NAME);
	//
	// OutputStream appDB = new FileOutputStream(dbPath, false);
	//
	// byte[] buffer = new byte[1024];
	// int length;
	// while ((length = assestDB.read(buffer)) > 0) {
	// appDB.write(buffer, 0, length);
	// }
	//
	// appDB.flush();
	// appDB.close();
	// assestDB.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// }

	// public MarkItem getMarkItem(int storyId) {
	// SQLiteDatabase database = getWritableDatabase();
	// Cursor cursor = database.rawQuery(
	// "SELECT mark_1,mark_2,mark_3 FROM mark WHERE storyId = ?",
	// new String[] { "" + storyId });
	// cursor.moveToNext();
	// MarkItem item = new MarkItem(storyId, cursor.getInt(0),
	// cursor.getInt(1), cursor.getInt(2));
	// cursor.close();
	// database.close();
	// return item;
	// }

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_USER);
		db.execSQL(CREATE_TABLE_PATIENT);
		db.execSQL(CREATE_TABLE_MENU1);
	}

	// private void insertStoryRes(SQLiteDatabase db) {
	// ArrayList<StoryResource> items = ItemUtil.getStoryResource();
	// for (StoryResource resource : items) {
	// ContentValues values = ItemUtil.parseStoryRescoure(resource);
	// db.insert(TABLE_STORY_RES, null, values);
	// }
	// }

	private void insertUser(SQLiteDatabase db) {
		ContentValues values = new ContentValues();
		values.put("friendly", 0);
		values.put("ticket_daily", 5);
		values.put("ticket_shop", 0);
		// db.insert(TABLE_PROFILE, null, values);
		db.update(TABLE_PATIENT, values, null, null);
	}

	// private void insertItem(SQLiteDatabase db, Context context) {
	// long refId = 0;
	// ArrayList<LoveStoryItem> items = ItemUtil.getAppItem(context);
	// for (LoveStoryItem item : items) {
	// if (item.getItemCategory() == HospitalDB.HAIR_BACK) {
	// item.setItemRefId(refId);
	// }
	// ContentValues contentValues = ItemUtil.parseLoveStoryItemToDB(item);
	// refId = db.insert(TABLE_ITEM, null, contentValues);
	// }
	// }

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// insertStoryRes(db);
		// insertItem(db, context);
	}

	public int getStoryResource(String resName, SQLiteDatabase database) {
		Cursor cursor = database.rawQuery(
				"Select str_source FROM story_res WHERE str_name LIKE \""
						+ resName + "\" ", null);
		cursor.moveToFirst();
		if (cursor.getCount() == 0) {
			// @TODO : Thieu tai nguyen character 2
			return -1;
		}
		int strSource = cursor.getInt(0);
		cursor.close();
		return strSource;
	}

	public int getTotalScene(int currentStory) {
		String query = "Select DISTINCT scene FROM stories WHERE storyId = "
				+ currentStory;
		SQLiteDatabase database = getReadableDatabase();
		Cursor cursor = database.rawQuery(query, null);
		cursor.moveToNext();
		int countScene = cursor.getCount();
		cursor.close();
		database.close();
		return countScene;
	}

	public int getTotalStory() {
		// TODO Auto-generated method stub
		String query = "Select DISTINCT storyId FROM stories";
		SQLiteDatabase database = getReadableDatabase();
		Cursor cursor = database.rawQuery(query, null);
		cursor.moveToNext();
		int countStory = cursor.getCount();
		cursor.close();
		database.close();
		return countStory;
	}

	public void updateMark(int mark) {
		SQLiteDatabase database = getWritableDatabase();
		Cursor cursor = database.rawQuery("SELECT friendly FROM profile", null);
		cursor.moveToFirst();
		int friendly = cursor.getInt(0);
		friendly += mark;

		cursor.close();
		ContentValues values = new ContentValues();
		values.put("friendly", friendly);
		database.update(TABLE_PATIENT, values, null, null);
		database.close();
	}

	public void useTicketDaily(int ticket) {
		SQLiteDatabase database = getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("ticket_daily", ticket);
		database.update(TABLE_PATIENT, contentValues, null, null);
		database.close();
	}

	public void increTicketShop(int ticket) {
		SQLiteDatabase database = getWritableDatabase();
		Cursor cursor = database.query(TABLE_PATIENT,
				new String[] { "ticket_shop" }, null, null, null, null, null);
		cursor.moveToFirst();
		int ticketShop = cursor.getInt(0);
		ticketShop += ticket;
		cursor.close();
		database.close();
		useTicketShop(ticketShop);
	}

	public void useTicketShop(int ticket) {
		SQLiteDatabase database = getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("ticket_shop", ticket);
		database.update(TABLE_PATIENT, contentValues, null, null);
		database.close();
	}

	public void resetData() {
		SQLiteDatabase database = getWritableDatabase();
		resetProfile(database);
		// resetItem(database);
		database.close();
	}

	public void resetFriendly() {
		SQLiteDatabase database = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("friendly", 0);
		database.update(TABLE_PATIENT, values, null, null);
		database.close();
	}

	private void resetProfile(SQLiteDatabase database) {
		ContentValues values = new ContentValues();
		values.put("friendly", 0);
		values.put("ticket_daily", 5);
		database.update(TABLE_PATIENT, values, null, null);
	}

	private void resetItem(SQLiteDatabase database) {
		ContentValues values = new ContentValues();
		values.put("status", false);
		values.put("equipped", false);
		database.update(TABLE_USER, values, "itm_default = ?",
				new String[] { "0" });
	}

	public void initStories() {
		SQLiteDatabase database = getWritableDatabase();
		database.close();
	}

	public int getCurrentTicketShop() {
		SQLiteDatabase database = getReadableDatabase();
		Cursor cursor = database.query(TABLE_PATIENT,
				new String[] { "ticket_shop" }, null, null, null, null, null);
		cursor.moveToFirst();
		int currentTicketShop = cursor.getInt(0);
		cursor.close();
		database.close();
		return currentTicketShop;
	}

	public ArrayList<Patient> getListPatient() {
		ArrayList<Patient> list = new ArrayList<Patient>();
		SQLiteDatabase database = getReadableDatabase();
		String query = "Select pa_id,pa_name,pa_sex,pa_dob,pa_face_color FROM patients";
		Cursor cursor = database.rawQuery(query, null);
		int id;
		String paName;
		int paSex;
		String fc;
		String strDob;

		while (cursor.moveToNext()) {
			id = cursor.getInt(0);
			paName = cursor.getString(1);
			paSex = cursor.getInt(2);
			strDob = cursor.getString(3);
			fc = cursor.getString(4);
			Patient patient = new Patient();
			patient.setPaId(id);
			patient.setPaName(paName);
			try {
				patient.setPaDateOfBith(strDob);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			patient.setPaColorFace(fc);
			patient.setPaSex(paSex);

			list.add(patient);
		}
		database.close();
		return list;
	}
}
