package com.linpeng.xexpandablelistview.adapter;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.linpeng.xexpandablelistview.R;
import com.linpeng.xexpandablelistview.modle.CarDetailsBean;
import com.linpeng.xexpandablelistview.widgets.KMListView;

import java.util.List;


public class CarTypeAdapter extends BaseExpandableListAdapter {
	private String TAG = "CarTypeAdapterTagInfo";
	private Activity activity;
	private List<CarDetailsBean> list;

	private CarStyleAdapter adapter;
	private List<CarDetailsBean> carStyleBean;
	private String name;

	public CarTypeAdapter(Activity activity, List<CarDetailsBean> list, String name) {
		this.activity = activity;
		this.list = list;
		this.name = name;
	}

	@Override
	public int getGroupCount() {
		return this.list.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return 1;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return null;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return null;
	}

	@Override
	public long getGroupId(int groupPosition) {
		return 0;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return 0;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
							 View convertView, ViewGroup parent) {
		GroupViewHolder groupViewHolder = null;
		if (convertView == null) {
			groupViewHolder = new GroupViewHolder();
			convertView = LayoutInflater.from(activity).inflate(
					R.layout.group_car_series, null);
			groupViewHolder.tv_group_title = (TextView) convertView
					.findViewById(R.id.tv_group_title);
			convertView.setTag(groupViewHolder);
		} else {
			groupViewHolder = (GroupViewHolder) convertView.getTag();
		}

		groupViewHolder.tv_group_title.setText(list.get(groupPosition).name);
		return convertView;

	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
							 boolean isLastChild, View convertView, ViewGroup parent) {
		ChildViewHolder holder = new ChildViewHolder();
		if (convertView == null) {

			convertView = LayoutInflater.from(activity).inflate(
					R.layout.child_car_series, null);
			holder.lvCarSeries = (KMListView) convertView
					.findViewById(R.id.child_lv_cars);
			convertView.setTag(holder);

		} else {
			holder = (ChildViewHolder) convertView.getTag();
		}

		String seriesId = list.get(groupPosition).id;
		getData(seriesId,holder.lvCarSeries,groupPosition);

		return convertView;
	}


	public void openActivity(Class<?> pClass, Bundle pBundle) {
		Intent intent = new Intent(activity, pClass);
		if (pBundle != null) {
			intent.putExtras(pBundle);
		}
		activity.startActivity(intent);
	}


	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

	public int getCount() {
		return this.list.size();
	}

	final static class GroupViewHolder {
		TextView tv_group_title;
	}

	final static class ChildViewHolder {
		KMListView lvCarSeries;
	}

	private void getData(String id, final KMListView lvCarSeries, final int groupPosition) {


	}



}