package com.linpeng.xexpandablelistview.elvindex;


import com.linpeng.xexpandablelistview.modle.AllCarBean;

import java.util.Comparator;

/**
拼音排序
 * Created by jiangwei on 15/8/10.
 */
public class PinyinComparator implements Comparator<AllCarBean.Models> {


    @Override
    public int compare(AllCarBean.Models lhs, AllCarBean.Models rhs) {
        //这里主要是用来对ListView里面的数据根据ABCDEFG...来排序
        if (rhs.firstLetter.equals("#")) {
            return -1;
        } else if (lhs.firstLetter.equals("#")) {
            return 1;
        } else {
            return lhs.firstLetter.compareTo(rhs.firstLetter);
        }    }
}
