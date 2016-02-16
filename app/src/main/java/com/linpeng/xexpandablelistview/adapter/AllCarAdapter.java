package com.linpeng.xexpandablelistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.linpeng.xexpandablelistview.R;
import com.linpeng.xexpandablelistview.modle.AllCarBean;

import java.util.List;

public class AllCarAdapter extends BaseAdapter implements SectionIndexer {
	private List<AllCarBean.Models> carLists;
	private Context mContext;
	private AllCarBean allCarBean;

	public AllCarAdapter(Context mContext, List<AllCarBean.Models> carLists) {
		this.mContext = mContext;
		 this.carLists = carLists;
	}

	/**
	 * 当ListView数据发生变化时,调用此方法来更新ListView
	 * @param carLists
	 */
	public void updateListView(List<AllCarBean.Models> carLists){
		this.carLists = carLists;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return carLists == null?0:carLists.size();
	}

	@Override
	public Object getItem(int position) {
		return carLists.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder viewHolder = null;
		final AllCarBean.Models models = carLists.get(position);
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(mContext).inflate(R.layout.group_automobile_brand, null);
			viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.title);
			viewHolder.letter = (TextView) convertView.findViewById(R.id.iv_car_logo);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		//根据position获取分类的首字母的char ascii值
		int section = getSectionForPosition(position);

		//如果当前位置等于该分类首字母的Char的位置 ，则认为是第一次出现
		if(position == getPositionForSection(section)){
			//viewHolder.tvLetter.setVisibility(View.VISIBLE);
			//viewHolder.tvLetter.setText(models.firstLetter.toUpperCase());
		}else{
			//viewHolder.tvLetter.setVisibility(View.GONE);
		}
		String title = carLists.get(position).name;
		viewHolder.letter.setText(models.firstLetter.toUpperCase());
		viewHolder.tvTitle.setText(title);


		return convertView;
	}

	final static class ViewHolder {
		//TextView tvLetter;
		TextView tvTitle;
		TextView letter;
	}

	/**
	 * 根据ListView的当前位置获取分类的首字母的char ascii值
	 */
	public int getSectionForPosition(int position) {
		return carLists.get(position).firstLetter.toUpperCase().charAt(0);
	}

	@Override
	public Object[] getSections() {
		return new Object[0];
	}

	/**
	 * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
	 */
	public int getPositionForSection(int section) {
		for (int i = 0; i < getCount(); i++) {
			String sortStr = carLists.get(i).firstLetter;
			char firstChar = sortStr.toUpperCase().charAt(0);
			if (firstChar == section) {
				return i;
			}
		}

		return -1;
	}


}