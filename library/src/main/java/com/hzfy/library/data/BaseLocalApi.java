package com.hzfy.library.data;

import android.content.Context;
import android.content.SharedPreferences;

public class BaseLocalApi {

    private static final String FILE_NAME_START = "hzfy_";
    private static final String FILE_NAME_END = "_13a2bc";

    protected SharedPreferences getSharedPreferences(Context context, String fileName) {
        return context.getSharedPreferences(getFileName(fileName), Context.MODE_PRIVATE);
    }

    private static String getFileName(String fileName) {
        return FILE_NAME_START + fileName + FILE_NAME_END;
    }
}
