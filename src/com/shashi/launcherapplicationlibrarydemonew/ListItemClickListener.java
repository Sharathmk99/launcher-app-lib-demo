package com.shashi.launcherapplicationlibrarydemonew;

import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;
import com.shashi.lib.launcherapps.LauncherAppDetails;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ListItemClickListener implements OnItemClickListener{

	Context mcontext;
	LauncherAppDetails mlauncher;
	GoogleAnalytics mgoogle;
	Tracker mtracker;
	
	public ListItemClickListener(Context context) {
		// TODO Auto-generated constructor stub
		mcontext = context ;
		mlauncher = LauncherAppDetails.getInstance(mcontext);
		mgoogle = GoogleAnalytics.getInstance(mcontext);
		mtracker = mgoogle.getTracker("UA-44995811-8");
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		mtracker.sendView("/List Item Click");
		ShowDailog(mlauncher.getAppName(position), mlauncher.getPackageName(position), mlauncher.getActivityName(position),
				mlauncher.getIcon(position), mlauncher.gettargetSdkVersion(position), mlauncher.getuid(position));
	}

	private void ShowDailog(String appname,String packagename,String activityname,Drawable icon,int targetsdk,int uid){
		final View layout = View.inflate(mcontext, R.layout.dailog_support, null);
		TextView name = (TextView)layout.findViewById(R.id.app_name);
		name.setText("App Name: "+appname);
		TextView pac = (TextView)layout.findViewById(R.id.package_name);
		pac.setText("Package Name: "+packagename);
		TextView act = (TextView)layout.findViewById(R.id.activity_name);
		act.setText("Activity Name: "+activityname);
		TextView tar = (TextView)layout.findViewById(R.id.target_sdk);
		tar.setText("TargetSdk: "+targetsdk);
		TextView ui = (TextView)layout.findViewById(R.id.uid);
		ui.setText("Uid: "+uid);
        AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
        builder.setIcon(icon);
        builder.setTitle(appname);
        builder.setCancelable(true);
        builder.setPositiveButton("Done",
            new Dialog.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                	if(dialog != null)
                		dialog.dismiss();
                }
            }
        );
        builder.setView(layout);
        builder.create();
        builder.show();
	}
}
