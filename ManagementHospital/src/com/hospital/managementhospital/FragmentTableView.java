package com.hospital.managementhospital;

import com.hospital.managementhospital.views.PopupPatient;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

public class FragmentTableView extends Activity {
	private TableLayout mTableLayout;
	private LayoutParams params;
	private PopupPatient popup;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_table_view);
		mTableLayout = (TableLayout) this.findViewById(R.id.table_layout);
		params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1.0f);
		initVariables();
		initViews();
		setRowForTable();
	}
	
	private void initViews() {
		// TODO Auto-generated method stub
	}

	private void initVariables(){
		popup = new PopupPatient(FragmentTableView.this);
	}
	
	private void setRowForTable(){
		int rows = 20;
		int columns = 10;
		mTableLayout.setWeightSum(rows+1);
		setTitleForTable(columns);
		for(int i=0; i<rows; i++){
			TableRow tableRow = new TableRow(getApplicationContext());
			tableRow.setLayoutParams(params);
			for(int j=0; j<columns; j++){
				final Button btn = new Button(getApplicationContext());
				btn.setText("Button");
				btn.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						popup.show(btn);
					}
				});
				tableRow.addView(btn);
			}
			mTableLayout.addView(tableRow);
		}
	}
	private void setTitleForTable(int columns){
		TableRow row = new TableRow(getApplicationContext());
		row.setLayoutParams(params);
		for(int i=0; i<columns; i++){
			TextView txt = new TextView(getApplicationContext());
			txt.setText("Title");
			row.addView(txt);
		}
		mTableLayout.addView(row);
	}
}
