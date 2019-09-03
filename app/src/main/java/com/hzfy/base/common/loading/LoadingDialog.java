package com.hzfy.base.common.loading;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.hzfy.base.R;


public class LoadingDialog extends Dialog{
    public LoadingDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
    }
}
