/**
 *
 */
package com.hzfy.library.util;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @author crc
 * @time 2015-9-15 上午10:00:10
 * @description <pre>
 * <p>
 * </pre>
 */
public class OrderUtil {

    public static BigDecimal EXCISE_TAX_DISCOUNT = new BigDecimal("0.7"); //消费税折扣率
    public static BigDecimal INCREMENT_TAX_DISCOUNT = new BigDecimal("0.7"); //增值税折扣率
    private static String PRE_SELL_SUFFIX = "P";

    /**
     * @return
     * @description <pre>
     * 获取订单编号
     * </pre>
     */
    public static String getOrderCode(Long userId) {
        String rq = DateUtil.getYYMMDD(); // 6位日期 YYMMDD
        int randomNum = random8(); // 8位随机数
        String userId3 = splitUserIdtoThreelength(userId);
        String check = getCheckCode(rq, randomNum + "", userId3);
        return rq + randomNum + check + userId3;
    }

    /**
     * @return
     * @description <pre>
     * 获取预售订单批次号
     * </pre>
     */
    public static String getPresellOrderCode(String orderCode) {
        return orderCode + PRE_SELL_SUFFIX;
    }

    /**
     * @param rq
     * @param randomNum
     * @param userId3
     * @return
     * @description <pre>
     * 获取校验位
     * </pre>
     */
    private static String getCheckCode(String rq, String randomNum, String userId3) {
        int rqInt = Integer.parseInt(rq);
        int userIdInt = Integer.parseInt(userId3);
        int randomNumInt = Integer.parseInt(randomNum);
        int complementation = (userIdInt + randomNumInt) / rqInt;
        return getLast(complementation);
    }

    private static String getLast(int complementation) {
        String str = complementation + "";
        return str.substring(str.length() - 1, str.length());
    }

    public static boolean checkOrderCode(String code) {

        if (code.length() != 18) {
            return false;
        }

        String rq = code.substring(0, 6); // 6位日期 YYMMDD
        String randomNum = code.substring(6, 14); // 8位随机数
        String checkCode = code.substring(14, 15);
        String userId3 = code.substring(15);

        String checkCodeNum = getCheckCode(rq, randomNum, userId3);
        if (checkCode.equals(checkCodeNum)) {
            return true;
        }
        return false;
    }

    /**
     * @return
     * @description <pre>
     * 随机生成8位整数
     * </pre>
     */
    public static int random8() {
        Random random = new Random();
        return 10000000 + random.nextInt(90000000);
    }

    /**
     * @return
     * @description <pre>
     * 随机生成4位整数
     * </pre>
     */
    public static int random4() {
        Random random = new Random();
        return 1000 + random.nextInt(9000);
    }

    /**
     * @param userId
     * @return
     * @description <pre>
     * 截取三位长度的用户id
     * </pre>
     */
    public static String splitUserIdtoThreelength(Long userId) {
        userId = Math.abs(userId);

        if ((userId + "").length() == 3) {
            return userId + "";
        } else if ((userId + "").length() > 3) {
            return (userId + "").substring((userId + "").length() - 3, (userId + "").length());
        } else {
            return String.format("%03d", userId);
        }
    }


    public static void main(String[] args) {
        System.out.println(getOrderCode(10001L));
    }

    //订单追加 目前只支持数字
    public static String addOrderNumber(String old, String add) {
        if (add.equals(KeyboardConstant.ZERO) || add.equals(KeyboardConstant.ONE) || add.equals(KeyboardConstant.TWO) || add.equals(KeyboardConstant.THREE)
                || add.equals(KeyboardConstant.FOUR) || add.equals(KeyboardConstant.FIVE) || add.equals(KeyboardConstant.SIX) || add.equals(KeyboardConstant.SEVEN)
                || add.equals(KeyboardConstant.EIGHT) || add.equals(KeyboardConstant.NINE)) {
            return old + add;
        } else {
            return old;
        }
    }

    //删除订单最后一位
    public static String deleteOrderNumberLast(String order) {
        if (TextUtil.isEmpty(order)) {
            return "";
        } else {
            return order.substring(0, order.length() - 1);
        }
    }
}
