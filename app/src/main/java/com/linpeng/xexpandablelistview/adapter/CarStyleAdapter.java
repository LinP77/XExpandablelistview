package com.linpeng.xexpandablelistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.linpeng.xexpandablelistview.R;
import com.linpeng.xexpandablelistview.modle.CarDetailsBean;

import java.util.List;

public class CarStyleAdapter extends BaseAdapter {
	private Context mContext;

	private List<CarDetailsBean> chidrenList;

	public CarStyleAdapter(Context mContext, List<CarDetailsBean> chidrenList) {
		this.mContext = mContext;
		this.chidrenList = chidrenList;
	}
	@Override
	public int getCount() {
		return chidrenList.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder childViewHolder = null;
		if (convertView == null) {
			childViewHolder = new ViewHolder();
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.item_carseries, null);
			childViewHolder.CarSeries = (TextView) convertView
					.findViewById(R.id.tv_child_title);
			convertView.setTag(childViewHolder);
		} else {
			childViewHolder = (ViewHolder) convertView.getTag();
		}
		
		childViewHolder.CarSeries.setText(chidrenList.get(position).name);
		
		return convertView;
	}
	
	final static class ViewHolder {
		TextView CarSeries;
	}
}