package com.future.calculator;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * ProjectName: Future
 * Function: 记录.
 * Date: 2019-12-27 18:07
 * <p>
 * Created by jiangrh@solutionexp.com
 */
class SharePreUtil {

    private static final String SHARE_PRE = "value_info";
    static final String KEY_X1 = "X1";
    static final String KEY_X2 = "X2";
    static final String KEY_Y1 = "Y1";
    static final String KEY_Y2 = "Y2";
    static final String KEY_SUB_ALL = "SUB_ALL";
    static final String KEY_RESULT = "RESULT";
    static final String KEY_SUB_DEMAND_ALL = "SUB_DEMAND_ALL";
    static final String KEY_ALL = "ALL";

    private volatile static SharePreUtil instance;

    private SharePreUtil() {
    }

    static SharePreUtil getInstance() {
        if (instance == null) {
            synchronized (SharePreUtil.class) {
                if (instance == null) {
                    instance = new SharePreUtil();
                }
            }
        }
        return instance;
    }

    void saveValue(Context context, String key, float value) {
        SharedPreferences sp = context.getSharedPreferences(SHARE_PRE, Context.MODE_PRIVATE);
        sp.edit().putFloat(key, value).apply();
    }

    float getValue(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SHARE_PRE, Context.MODE_PRIVATE);
        return sp.getFloat(key, 0F);
    }
}
