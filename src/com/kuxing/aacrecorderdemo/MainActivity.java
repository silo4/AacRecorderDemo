package com.kuxing.aacrecorderdemo;

import com.kuxing.aacrecorderdemo.R;

import android.os.Bundle;
import android.app.Activity;

import com.kuxing.aacrecorder.Recorder;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button mBtnplay;
	private Button mBtnstop;
	private Recorder mRecorder;

	@Override
	protected void onDestroy() {
		mRecorder.release();
		super.onDestroy();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mRecorder = new Recorder();
		setContentView(R.layout.activity_main);
		mBtnplay = (Button) findViewById(R.id.btnStart);

		mBtnplay.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Toast.makeText(MainActivity.this, "CLICK start!",
						Toast.LENGTH_SHORT).show();	
				mRecorder.start("output.aac");
			}
		});

		mBtnstop = (Button) findViewById(R.id.btnStop);
		mBtnstop.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				mRecorder.stop();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
