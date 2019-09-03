package com.hzfy.library.util;

public class PayUtil {

    public static boolean isALiBarcode(String barcode) {
        if (TextUtil.isEmpty(barcode)) {
            return false;
        }
        return barcode.startsWith("28") && barcode.length() == 18;
    }


    public static boolean isWXBarcode(String barcode) {
        if (TextUtil.isEmpty(barcode)) {
            return false;
        }
        return barcode.length() == 18;
    }
}
