package com.hzfy.library.util;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期处理工具类
 * @author lifeng
 *
 */
public class DateUtil {


	private static SimpleDateFormat getDateFormat(String pattern) {
		return new SimpleDateFormat(pattern, Locale.getDefault());
	}


	public static String format(Date date, String pattern) {
		return getDateFormat(pattern).format(date);
	}

	public static String format(long date, String pattern) {
		return format(new Date(date), pattern);
	}

	public static Date getCurrentDate() {
		return new Date();
	}

	public static long getCurrentDateTime() {
		return getCurrentDate().getTime();
	}

	// 格式：年－月－日 小时：分钟：秒
	public static final String FORMAT_ONE = "yyyy-MM-dd HH:mm:ss";

	// 格式：年－月－日 小时：分钟
	public static final String FORMAT_TWO = "yyyy-MM-dd HH:mm";

	// 格式：年月日 小时分钟秒
	public static final String FORMAT_THREE = "yyyyMMdd-HHmmss";

	// 格式：年月日 小时分钟秒
	public static final String FORMAT_FOUR = "yyyyMMddHHmmss";
	
	// 格式：年月日
	public static final String FORMATE_FIVE = "yyyyMMdd";
	public static final String FORMATE_FIVE_1 = "yyyy.MM.dd";

	// 格式：年－月－日
	public static final String LONG_DATE_FORMAT = "yyyy-MM-dd";

	// 格式：月－日
	public static final String SHORT_DATE_FORMAT = "MM-dd";

	// 格式：小时：分钟：秒
	public static final String LONG_TIME_FORMAT = "HH:mm:ss";

	// 格式：年-月
	public static final String MONTG_DATE_FORMAT = "yyyy-MM";
	public static final String YYMMDD_FORMAT = "yyMMdd";


	public static String getYYMMDD() {
		return format(getCurrentDate(), YYMMDD_FORMAT);
	}

	// 年的加减
	public static final int SUB_YEAR = Calendar.YEAR;

	// 月加减
	public static final int SUB_MONTH = Calendar.MONTH;

	// 天的加减
	public static final int SUB_DAY = Calendar.DATE;

	// 小时的加减
	public static final int SUB_HOUR = Calendar.HOUR;

	// 分钟的加减
	public static final int SUB_MINUTE = Calendar.MINUTE;

	// 秒的加减
	public static final int SUB_SECOND = Calendar.SECOND;

	static final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四",
			"星期五", "星期六" };

	@SuppressWarnings("unused")
	private static final SimpleDateFormat timeFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public DateUtil() {
	}
	

	/**
	 * 把符合日期格式的字符串转换为日期类型
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date stringToDate(String dateStr, String format) {
		Date d = null;
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			formater.setLenient(false);
			d = formater.parse(dateStr);
		} catch (Exception e) {
			// log.error(e);
			d = null;
		}
		return d;
	}
	
	/**
	 * 把日期转换为字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date, String format) {
		String result = "";
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			result = formater.format(date);
		} catch (Exception e) {
			// log.error(e);
		}
		return result;
	}
	
	/**
	 * 获取当前时间的指定格式
	 * 
	 * @param format
	 * @return
	 */
	public static String getCurrDate(String format) {
		return dateToString(new Date(), format);
	}
	
	/**
	 * 获取当前时间的指定格式
	 * 
	 * @param
	 * @return
	 */
	public static String getCurrDate() {
		return dateToString(new Date(), FORMAT_ONE);
	}
	
	/**
	 * 获取当前时间，Date格式
	 * @return
	 */
	public static Date getNowDate(){
		Date date = new Date();
		
		return date;
	}
	
	/**
	 * 两个日期相减
	 * 
	 * @param firstTime String "yyyy-MM-dd HH:mm:ss"
	 * @param secTime String "yyyy-MM-dd HH:mm:ss"
	 * @return 相减得到的秒数
	 */
	public static long timeSub(String firstTime, String secTime) {
		long first = stringToDate(firstTime, FORMAT_ONE).getTime();
		long second = stringToDate(secTime, FORMAT_ONE).getTime();
		return (second - first) / 1000;
	}
	
	/**
	 * 获得某月的天数
	 * 
	 * @param year int
	 * @param month int
	 * @return int
	 */
	public static int getDaysOfMonth(String year, String month) {
		int days = 0;
		if (month.equals("1") || month.equals("3") || month.equals("5")
				|| month.equals("7") || month.equals("8") || month.equals("10")
				|| month.equals("12")) {
			days = 31;
		} else if (month.equals("4") || month.equals("6") || month.equals("9")
				|| month.equals("11")) {
			days = 30;
		} else {
			if ((Integer.parseInt(year) % 4 == 0 && Integer.parseInt(year) % 100 != 0)
					|| Integer.parseInt(year) % 400 == 0) {
				days = 29;
			} else {
				days = 28;
			}
		}

		return days;
	}

}