package com.linpeng.xexpandablelistview.modle;

import java.util.List;

/**
 * Created by jiangwei on 15/8/7.
 */
public class AllCarBean {
        public List<Models> models;
        public static List<String> letters;

        public class Models{
            public int pageIndex;
            public int pageSize;
            public String modifyDate;
            public String id;
            public String name;//显示的数据
            public int pid;
            public int level;
            public String firstLetter;//显示数据拼音的首字母
            public String logo;
            public String ename;
            public int is_show;
            public boolean isLeaf;
            public boolean expanded;
        }
    }
