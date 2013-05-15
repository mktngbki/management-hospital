package com.hospital.managementhospital.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;

import com.hospital.managementhospital.R;
import com.hospital.managementhospital.views.PopupPatient;

public class FragmentListTask extends AbstractFragment {

	private TableLayout mTableLayout;
	private LayoutParams params;
	private PopupPatient popup;

	@Override
	protected void initTask() {

	}

	@Override
	protected void initVariables() {
		params = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT, 1.0f);
	}

	@Override
	protected void initControls() {
		mTableLayout = (TableLayout) this.findViewById(R.id.table_layout);
		popup = new PopupPatient(getApplicationContext());
		setRowForTable();
	}

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_table_view;
	}

	private void setRowForTable() {
		int rows = 20;
		int columns = 10;
		mTableLayout.setWeightSum(rows + 1);
		setTitleForTable(columns);
		for (int i = 0; i < rows; i++) {
			TableRow tableRow = new TableRow(getApplicationContext());
			tableRow.setLayoutParams(params);
			for (int j = 0; j < columns; j++) {
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

	private void setTitleForTable(int columns) {
		TableRow row = new TableRow(getApplicationContext());
		row.setLayoutParams(params);
		for (int i = 0; i < columns; i++) {
			TextView txt = new TextView(getApplicationContext());
			txt.setText("Title");
			row.addView(txt);
		}
		mTableLayout.addView(row);
	}

}
