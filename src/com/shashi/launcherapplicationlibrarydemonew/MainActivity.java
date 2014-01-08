package com.shashi.launcherapplicationlibrarydemonew;

import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;
import com.shashi.lib.launcherapps.LauncherAppDetails;
import android.os.Bundle;
import android.widget.ListView;
import android.app.Activity;

public class MainActivity extends Activity {

	ListView lt;
	LauncherAppDetails mlauncherdetails;
	GoogleAnalytics mgoogle;
	Tracker mtracker;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lt = (ListView)findViewById(R.id.listView1);
		new Background(this,lt,mlauncherdetails).execute();
		mgoogle = GoogleAnalytics.getInstance(this);
		mtracker = mgoogle.getTracker("UA-44995811-8");
		mtracker.sendView("/Main Screen");
	}
}
