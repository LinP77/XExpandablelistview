package com.linpeng.xexpandablelistview.selectcar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.linpeng.xexpandablelistview.R;
import com.linpeng.xexpandablelistview.adapter.AllCarAdapter;
import com.linpeng.xexpandablelistview.adapter.CarTypeAdapter;
import com.linpeng.xexpandablelistview.base.BaseActivity;
import com.linpeng.xexpandablelistview.base.BaseViewHolder;
import com.linpeng.xexpandablelistview.elvindex.CharacterParser;
import com.linpeng.xexpandablelistview.elvindex.ElvIndexBar;
import com.linpeng.xexpandablelistview.elvindex.PinyinComparator;
import com.linpeng.xexpandablelistview.modle.AddCarListData;
import com.linpeng.xexpandablelistview.modle.AllCarBean;
import com.linpeng.xexpandablelistview.modle.CarDetailsBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 》
 * 》Created on 15/11/5 下午4:45
 * 》
 */
public class SelectCarTypeViewHolder extends BaseViewHolder {
    private BaseActivity activity;
    private TextView title;
    private ImageButton ib_back;
    private RelativeLayout rl_ib_back;

    private ListView listView;
    private ElvIndexBar sideBar;
    private TextView dialog;
    private AllCarBean allCarBean;
    private AllCarAdapter adapter;
    private View loading;
    private View v_line;
    /**
     * 汉字转换成拼音的类
     */
    private CharacterParser characterParser;
    private List<AllCarBean.Models> allCarList;
    /**
     * 根据拼音来排列ListView里面的数据类
     */
    private PinyinComparator pinyinComparator;

    /**
     * 车系
     */
    private ExpandableListView elv_car_type;
    private List<CarDetailsBean> carStyleBean;
    private ProgressBar elv_loading;
    private CarTypeAdapter elvAdapter;

    public SelectCarTypeViewHolder(BaseActivity activity) {
        this.activity = activity;
        init();
    }

    @Override
    protected void init() {
        super.init();
        title.setText("选择车型");
        ib_back.setVisibility(View.VISIBLE);

        //实例化汉字转拼音类
        characterParser = CharacterParser.getInstance();
        pinyinComparator = new PinyinComparator();
        allCarList = new ArrayList<>();
        allCarBean = new AllCarBean();
        sideBar.setTextView(dialog);
        // 设置右侧触摸监听
        sideBar.setOnTouchingLetterChangedListener(new ElvIndexBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                // 该字母首次出现的位置
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    listView.setSelection(position);
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String _id = allCarList.get(position).id;
                String name = allCarList.get(position).name;
                getCarsData(_id,name);
            }
        });

        if(AddCarListData.getInstance().mAllCarBean==null) {

            getData();
        }else{
            allCarBean = AddCarListData.getInstance().mAllCarBean;
            showView(allCarBean);
        }



    }

    @Override
    protected void setContentView() {
        activity.setContentView(R.layout.activity_select_car_type);
    }

    @Override
    protected void findViewId() {
        title = (TextView) activity.findViewById(R.id.top_title);
        ib_back = (ImageButton) activity.findViewById(R.id.ib_back);
        rl_ib_back = (RelativeLayout) activity.findViewById(R.id.rl_ib_back);
        sideBar = (ElvIndexBar) activity.findViewById(R.id.sidrbar);
        dialog = (TextView) activity.findViewById(R.id.dialog);
        listView = (ListView) activity.findViewById(R.id.elv_car);
        loading = activity.findViewById(R.id.loading);
        elv_car_type = (ExpandableListView) activity.findViewById(R.id.elv_car_type);
        elv_loading = (ProgressBar) activity.findViewById(R.id.elv_loading);
        v_line = activity.findViewById(R.id.v_line);
    }

    @Override
    protected void registerClickListener() {
        ib_back.setOnClickListener(activity);
        rl_ib_back.setOnClickListener(activity);
    }

    private void showView(AllCarBean allCarBean){
        allCarList = allCarBean.models;
        sideBar.setVisibility(View.VISIBLE);// 显示字母索引
        v_line.setVisibility(View.VISIBLE);
        // 根据a-z进行排序源数据
        Collections.sort(allCarList, pinyinComparator);
        adapter = new AllCarAdapter(activity, allCarList);
        listView.setAdapter(adapter);

    }


    /**
     * 获取车系数据
     * @param id
     */
    private void getCarsData(String id, final String name) {


    }


    /**　
     * 获取网络数据
     */
    private void getData() {


    }
}
