package com.linpeng.xexpandablelistview.modle;

/**
 * Created by jiangwei on 15/8/23.
 */
public class AddCarListData {
    private AddCarListData(){}
    private static AddCarListData cache;
    public AllCarBean mAllCarBean;

    public static AddCarListData getInstance(){
        if(cache ==null){
            cache = new AddCarListData();
        }
        return cache;
    }
}
