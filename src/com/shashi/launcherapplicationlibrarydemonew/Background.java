package com.shashi.launcherapplicationlibrarydemonew;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import com.shashi.lib.launcherapps.LauncherAppDetails;

public class Background extends AsyncTask<Void, Void, Void>{

	Context mcontext;
	LauncherAppDetails mlauncherdetails;
	ListView mlistview;
	public Background(Context context,ListView listview,LauncherAppDetails launcherapp) {
		// TODO Auto-generated constructor stub
		mcontext = context;
		mlistview = listview;
		mlauncherdetails = launcherapp;
	}
	
	ProgressDialog mdialog;
	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		mlauncherdetails = LauncherAppDetails.getInstance(mcontext);
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		mlistview.setAdapter(new ListAdapter(mcontext,mlauncherdetails));
		mlistview.setOnItemClickListener(new ListItemClickListener(mcontext));
		if(mdialog != null)
			mdialog.dismiss();
	}
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		mdialog = new ProgressDialog(mcontext);
		mdialog.setMessage("Loading...");
		mdialog.setCancelable(false);
		mdialog.show();
	}
}