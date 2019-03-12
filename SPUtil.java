package com.wxkj.tongcheng.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.wxkj.tongcheng.MyApp;
import com.wxkj.tongcheng.bean.UserInfo;

import cn.jpush.android.api.JPushInterface;

/**
 * sp类
 * Created by cheng on 2018/10/09.
 */

public class SPUtil {
    private volatile static SPUtil instance = null;
    private Context context;
    private SharedPreferences userinfo;

    private SPUtil(Context context) {
        this.context = context.getApplicationContext();
        userinfo = this.context.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
    }

    public static SPUtil getInstance(Context context) {
        if (null == instance) {
            synchronized (SPUtil.class) {
                if (null == instance) {
                    instance = new SPUtil(context);
                }
            }
        }
        return instance;
    }

    public void saveIntInfo(String key, int value) {
        userinfo.edit().putInt(key, value).apply();
    }

    public void saveStringInfo(String key, String value) {
        userinfo.edit().putString(key, value).apply();
    }

    public String getStringByKey(String key) {
        return userinfo.getString(key, "");
    }

    public int getIntByKey(String key) {
        return userinfo.getInt(key, 0);
    }


    /**
     * 清空某个键的值
     *
     * @param key
     */
    public void removeByKey(String key) {
        userinfo.edit().remove(key).apply();
    }

    public int getShopId() {
        return userinfo.getInt("shop_id", 0);
    }



}
