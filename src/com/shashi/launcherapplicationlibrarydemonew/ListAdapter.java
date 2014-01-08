package com.shashi.launcherapplicationlibrarydemonew;

import com.shashi.lib.launcherapps.LauncherAppDetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter{

	Context mcontext;
	LauncherAppDetails mlauncherdetails;
	
	public ListAdapter(Context context,LauncherAppDetails launcherapp) {
		// TODO Auto-generated constructor stub
		mcontext = context;
		mlauncherdetails = launcherapp;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mlauncherdetails.Size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	Holder mholder;
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater li = (LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if(convertView == null){
			convertView = li.inflate(R.layout.list_support, null);
			mholder = new Holder();
			mholder.im = (ImageView)convertView.findViewById(R.id.app_icon);
			mholder.tx = (TextView)convertView.findViewById(R.id.app_text);
			convertView.setTag(mholder);
		}else{
			mholder = (Holder)convertView.getTag();
		}
		mholder.im.setImageDrawable(mlauncherdetails.getIcon(position));
		mholder.tx.setText(mlauncherdetails.getAppName(position));
		return convertView;
	}
	
}