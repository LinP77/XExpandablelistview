package com.linpeng.xexpandablelistview.selectcar;

import android.os.Bundle;
import android.view.View;

import com.linpeng.xexpandablelistview.R;
import com.linpeng.xexpandablelistview.base.BaseActivity;

/**
 * 》
 * 》Created on 15/11/5 下午4:45
 * 》
 */
public class SelectCarType extends BaseActivity<SelectCarTypeViewHolder> {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewHolder = new SelectCarTypeViewHolder(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_back:
            case R.id.rl_ib_back:
                finish();
                break;
            default:
                break;
        }
    }

}
