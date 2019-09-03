package com.hzfy.library.util;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;


public class KeywordUtils {

    /**
     * 将字符串中的包含的关键字 设置颜色
     *
     * @param tv      TextView
     * @param keyWord 关键字
     * @param str     整个字符串
     */
    public static void setColorForKeyWord(TextView tv, String keyWord, String str, int color) {
        if (!TextUtils.isEmpty(keyWord)) {
            if (str.contains(keyWord)) {
                SpannableString spanString = new SpannableString(str);

                int fromIndex = 0;
                int index = str.indexOf(keyWord, fromIndex);
                while (index >= 0) {
                    ForegroundColorSpan span = new ForegroundColorSpan(color);
                    spanString.setSpan(span, index, index + keyWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    fromIndex = index + keyWord.length();
                    index = str.indexOf(keyWord, fromIndex);
                }

                tv.setText("");
                tv.append(spanString);
            } else {
                tv.setText(str);
            }
        } else {
            tv.setText(str);
        }
    }


    /**
     * 将字符串中的包含的关键字 设置粗体
     *
     * @param tv      TextView
     * @param keyWord 关键字
     * @param str     整个字符串
     */
    public static void setBoldForKeyWord(TextView tv, String keyWord, String str) {
        if (!TextUtils.isEmpty(keyWord)) {
            if (str.contains(keyWord)) {
                SpannableString spanString = new SpannableString(str);

                int fromIndex = 0;
                int index = str.indexOf(keyWord, fromIndex);
                while (index >= 0) {
                    spanString.setSpan(new StyleSpan(android.graphics.Typeface.BOLD),
                            index, index + keyWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    fromIndex = index + keyWord.length();
                    index = str.indexOf(keyWord, fromIndex);
                }

                tv.setText("");
                tv.append(spanString);
            } else {
                tv.setText(str);
            }
        } else {
            tv.setText(str);
        }
    }


}
