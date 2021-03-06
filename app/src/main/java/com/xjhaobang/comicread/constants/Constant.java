package com.xjhaobang.comicread.constants;

/**
 * Created by PC on 2017/9/25.
 */

public class Constant {

    public static final int CONNECT_TIMEOUT = 6;
    public static final int READ_TIMEOUT = 100;
    public static final int WRITE_TIMEOUT = 60;

    public static final int GRAVITY_TOP = 0;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_BOTTOM = 2;

    //首页
    public static final String GET_MIAM_DATA = "http://ac.qq.com/Jump";

    //分类
    public static final String GET_CATEGORY_ALL = "http://ac.qq.com/Comic/all/state/pink/search/time/vip/1/page/";
    public static final String GET_CATEGORY_THEME_HEAD = "http://ac.qq.com/Comic/all/theme/";
    public static final String GET_CATEGORY_THEME_TAIL = "/state/pink/search/time/vip/1/page/";
    public static final String GET_CATEGORY_JAPAN = "http://ac.qq.com/Comic/all/state/pink/nation/4/search/time/vip/1/page/";

    //搜索
    public static final String GET_SEARCH_URL = "http://ac.qq.com/Comic/searchList/search/";

    //漫画详情
    public static final String GET_COMIC_ITEM_HEAD = "http://ac.qq.com";
}
