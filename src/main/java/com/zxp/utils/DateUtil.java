package com.zxp.utils;	
	
import java.text.DateFormat;
import java.text.ParseException;	
import java.text.SimpleDateFormat;	
import java.util.Calendar;	
import java.util.Date;	
import java.util.TimeZone;
	
public final class DateUtil {	
	/**	
	 * 得到当前时间	
	 * @return now	
	 */	
	public static Date getNow(){	
		Date now = new Date(System.currentTimeMillis());	
		return now;	
	}	
	
	/**	
	 * 得到几小时前的时间	
	 * 	
	 * @param now	
	 * @return	
	 */	
	public static Date beforeHours(Date now, int beforeHour) {	
		Calendar cal = Calendar.getInstance();	
		cal.setTime(now);	
		cal.add(Calendar.HOUR_OF_DAY, -beforeHour);	
		String str  = String.format("%1$tF %1$tT", cal);	
		return DateUtil.StringToDate(str);	
	}	
	/**	
	 * 得到几天前的时间	
	 * 	
	 * @param now	
	 * @return	
	 */	
	public static Date beforeDays(Date now, int beforeDay) {	
		Calendar cal = Calendar.getInstance();	
		cal.setTime(now);	
		cal.add(Calendar.DATE, -beforeDay);	
		String str  = String.format("%1$tF %1$tT", cal);	
		return DateUtil.StringToDate(str);	
	}	
	/**	
	 * 得到今天时间段	
	 * 	
	 * @param now	
	 * @return	
	 */	
	public static String[] getToday(Date now) {	
		String[] reDate = new String[2];	
		Calendar cal = Calendar.getInstance();	
		cal.setTime(now);	
		cal.set(Calendar.HOUR_OF_DAY, 0);	
		cal.set(Calendar.MINUTE, 0);	
		cal.set(Calendar.SECOND, 0);	
		reDate[0] = String.format("%1$tF %1$tT", cal);	
		reDate[1] = String.format("%1$tF %1$tT", now);	
		return reDate;	
	}	
	
	/**	
	 * 得到昨天的时间段	
	 * 	
	 * @param now	
	 * @return	
	 */	
	public static String[] getYesterday(Date now) {	
		Calendar cal = Calendar.getInstance();	
		String[] reDate = new String[2];	
		cal.setTime(now);	
		cal.add(Calendar.DATE, -1);	
		cal.set(Calendar.HOUR_OF_DAY, 0);	
		cal.set(Calendar.MINUTE, 0);	
		cal.set(Calendar.SECOND, 0);	
		reDate[0] = String.format("%1$tF %1$tT", cal);	
		cal.set(Calendar.HOUR_OF_DAY, 23);	
		cal.set(Calendar.MINUTE, 59);	
		cal.set(Calendar.SECOND, 59);	
		reDate[1] = String.format("%1$tF %1$tT", cal);	
		return reDate;	
	}	
	
	/**	
	 * 得到前天的时间段	
	 * 	
	 * @param now	
	 * @return	
	 */	
	public static String[] getDayBeforeYesterday(Date now) {	
		Calendar cal = Calendar.getInstance();	
		String[] reDate = new String[2];	
		cal.setTime(now);	
		cal.add(Calendar.DATE, -2);	
		cal.set(Calendar.HOUR_OF_DAY, 0);	
		cal.set(Calendar.MINUTE, 0);	
		cal.set(Calendar.SECOND, 0);	
		reDate[0] = String.format("%1$tF", cal);	
		cal.set(Calendar.HOUR_OF_DAY, 23);	
		cal.set(Calendar.MINUTE, 59);	
		cal.set(Calendar.SECOND, 59);	
		reDate[1] = String.format("%1$tF", cal);	
		return reDate;	
	}
	
	/**	
	 * 自定得到什么时候的时间	
	 * 	
	 * @param now	
	 * @return	
	 */	
	public static String[] getCustomizeday(Date now,int day) {	
		Calendar cal = Calendar.getInstance();	
		String[] reDate = new String[2];	
		cal.setTime(now);	
		cal.add(Calendar.DATE, day);	
		cal.set(Calendar.HOUR_OF_DAY, 0);	
		cal.set(Calendar.MINUTE, 0);	
		cal.set(Calendar.SECOND, 0);	
		reDate[0] = String.format("%1$tF %1$tT", cal);	
		cal.set(Calendar.HOUR_OF_DAY, 23);	
		cal.set(Calendar.MINUTE, 59);	
		cal.set(Calendar.SECOND, 59);	
		reDate[1] = String.format("%1$tF %1$tT", cal);	
		return reDate;	
	}	
	
	/**	
	 * 得到上周的时间段	
	 * 	
	 * @param now	
	 * @return	
	 */	
	public static String[] getLastWeek(Date now) {	
		Calendar cal = Calendar.getInstance();	
		String[] reDate = new String[2];	
		cal.setTime(now);	
		cal.setFirstDayOfWeek(Calendar.MONDAY);	
		cal.add(Calendar.WEEK_OF_MONTH, -1);	
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);	
		cal.set(Calendar.HOUR_OF_DAY, 0);	
		cal.set(Calendar.MINUTE, 0);	
		cal.set(Calendar.SECOND, 0);	
		reDate[0] = String.format("%1$tF", cal);	
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);	
		cal.set(Calendar.HOUR_OF_DAY, 23);	
		cal.set(Calendar.MINUTE, 59);	
		cal.set(Calendar.SECOND, 59);	
		reDate[1] = String.format("%1$tF", cal);	
		return reDate;	
	}	
	
	/**
	 * 自定义前后多少周
	 * @param now
	 * @param week
	 * @return
	 */
	public static String[] getCustomizeWeek(Date now,int week){
		Calendar cal = Calendar.getInstance();	
		String[] reDate = new String[2];	
		cal.setTime(now);	
		cal.setFirstDayOfWeek(Calendar.MONDAY);	
		cal.add(Calendar.WEEK_OF_MONTH, week);	
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);	
		cal.set(Calendar.HOUR_OF_DAY, 0);	
		cal.set(Calendar.MINUTE, 0);	
		cal.set(Calendar.SECOND, 0);	
		reDate[0] = String.format("%1$tF", cal);	
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);	
		cal.set(Calendar.HOUR_OF_DAY, 23);	
		cal.set(Calendar.MINUTE, 59);	
		cal.set(Calendar.SECOND, 59);	
		reDate[1] = String.format("%1$tF", cal);	
		return reDate;	
	}
	/**	
	 * 得到这周的时间段(从本周开始到现在的时间段)	
	 * 	
	 * @param now	
	 * @return	
	 */	
	public static String[] getThisWeek(Date now) {	
		Calendar cal = Calendar.getInstance();	
		String[] reDate = new String[2];	
		cal.setTime(now);	
		cal.setFirstDayOfWeek(Calendar.MONDAY);	
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);	
		cal.set(Calendar.HOUR_OF_DAY, 0);	
		cal.set(Calendar.MINUTE, 0);	
		cal.set(Calendar.SECOND, 0);	
		reDate[0] = String.format("%1$tF %1$tT", cal);	
		reDate[1] = String.format("%1$tF %1$tT", now);	
		return reDate;	
	}	
	
	/**	
	 * 得到上月的时间段	
	 * 	
	 * @param now	
	 * @return	
	 */	
	public static String[] getLastMonth(Date now) {	
		Calendar cal = Calendar.getInstance();	
		String[] reDate = new String[2];	
		cal.setTime(now);	
		cal.add(Calendar.MONTH, -1);	
		cal.set(Calendar.DAY_OF_MONTH, 1);	
		cal.set(Calendar.HOUR_OF_DAY, 0);	
		cal.set(Calendar.MINUTE, 0);	
		cal.set(Calendar.SECOND, 0);
		reDate[0] = String.format("%1$tF %1$tT", cal);	
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));	
		cal.set(Calendar.HOUR_OF_DAY, 23);	
		cal.set(Calendar.MINUTE, 59);	
		cal.set(Calendar.SECOND, 59);	
		reDate[1] = String.format("%1$tF %1$tT", cal);	
		return reDate;	
	}	
	/**	
	 * 自定义月的时间段	
	 * 	
	 * @param now	
	 * @return	
	 */	
	public static String[] getCustomizeMonth(Date now,int month) {	
		Calendar cal = Calendar.getInstance();	
		String[] reDate = new String[2];	
		cal.setTime(now);	
		cal.add(Calendar.MONTH, month);	
		cal.set(Calendar.DAY_OF_MONTH, 1);	
		cal.set(Calendar.HOUR_OF_DAY, 0);	
		cal.set(Calendar.MINUTE, 0);	
		cal.set(Calendar.SECOND, 0);
		reDate[0] = String.format("%1$tF", cal);	
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));	
		cal.set(Calendar.HOUR_OF_DAY, 23);	
		cal.set(Calendar.MINUTE, 59);	
		cal.set(Calendar.SECOND, 59);	
		reDate[1] = String.format("%1$tF", cal);	
		return reDate;	
	}	
	
	/**	
	 * 得到本月的时间段（从本月开始到现在的时间段）	
	 * 	
	 * @param now	
	 * @return	
	 */	
	public static String[] getThisMonth(Date now) {	
		Calendar cal = Calendar.getInstance();	
		String[] reDate = new String[2];	
		cal.setTime(now);	
		cal.set(Calendar.DAY_OF_MONTH, 1);	
		cal.set(Calendar.HOUR_OF_DAY, 0);	
		cal.set(Calendar.MINUTE, 0);	
		cal.set(Calendar.SECOND, 0);	
		reDate[0] = String.format("%1$tF %1$tT", cal);	
		reDate[1] = String.format("%1$tF %1$tT", now);	
		return reDate;	
	}	
	
	/**	
	 * 字符串转换时间	
	 * 	
	 * @return	
	 */	
	public static Date StringToDate(String str) {	
		SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd");	
		Date date = null;	
		try {	
			date = myFmt.parse(str);	
		} catch (ParseException e) {	
			e.printStackTrace();	
		}	
		return date;	
	}
	
	/**	
	 * 字符串转换时间	
	 * 	
	 * @return	
	 */	
	public static Date StringToDate(String str,String fmt) {	
		SimpleDateFormat myFmt = new SimpleDateFormat(fmt);	
		Date date = null;	
		try {	
			date = myFmt.parse(str);	
		} catch (ParseException e) {	
			e.printStackTrace();	
		}	
		return date;	
	}	
	
	/**
	 * 时间转换为字符串
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = null;
		try {
		time = df.format(date);
		} catch (NullPointerException e){
			time = df.format(new Date());
		}
		return time;
	}
	/**	
	 * 得到时间的数组。【年，月，日，小时，分钟,秒】	
	 * 	
	 * @param now	
	 * @return	
	 */	
	public static int[] getDateArray(Date now) {	
		if (null == now)	
			now = DateUtil.getNow();	
		Calendar cal = Calendar.getInstance();	
		cal.setTime(now);	
		int[] re = new int[6];	
		re[0] = cal.get(Calendar.YEAR);	
		re[1] = cal.get(Calendar.MONTH) + 1;	
		re[2] = cal.get(Calendar.DATE);	
		re[3] = cal.get(Calendar.HOUR_OF_DAY);	
		re[4] = cal.get(Calendar.MINUTE);	
		re[5] = cal.get(Calendar.SECOND);	
		return re;	
	}	
	
	public static int getYear(Date now) {	
		return DateUtil.getDateArray(now)[0];	
	}	
	
	public static int getMonth(Date now) {	
		return DateUtil.getDateArray(now)[1];	
	}	
	
	public static int getDay(Date now) {	
		return DateUtil.getDateArray(now)[2];	
	}	
	
	public static int getHour(Date now) {	
		return DateUtil.getDateArray(now)[3];	
	}	
	
	public static int getMinute(Date now) {	
		return DateUtil.getDateArray(now)[4];	
	}	
	
	public static int getSecond(Date now) {	
		return DateUtil.getDateArray(now)[5];	
	}
	
	/**
	 * 返回小时数
	 * @param time
	 * @return
	 */
	public static int getHour(java.sql.Timestamp time){
		Calendar cal = Calendar.getInstance();	
		cal.setTime(time);	
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * 格式化时间字符串
	 * @param time
	 * @return
	 */
	public static String formatStringTime(String[] time){
		StringBuffer reTime = new StringBuffer();
		reTime.append(time[0].substring(0,10)).append("/").append(time[1].substring(0,10));
		return reTime.toString();
	}
	/**
	 * 得到当前日期是周几
	 * @param time
	 * @return
	 */
	public static int getDayOfWeek(String time){
		Calendar   calendar   =   Calendar.getInstance(TimeZone.getTimeZone("CTT"));   
		calendar.setTime(StringToDate(time));   
		return calendar.get(Calendar.DAY_OF_WEEK); 
	}
	/**
	 * 得到当前日期加一天是几号
	 * @param time
	 * @return
	 */
	public static int getDate(String time){
		Calendar   calendar   =   Calendar.getInstance(TimeZone.getTimeZone("CTT"));   
		calendar.setTime(StringToDate(time));
		calendar.add(Calendar.DATE, 1); 
		return calendar.get(Calendar.DATE); 
	}
	
	public static Date testTime(String time){
		SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd");	
		Date n = null;	
		try {	
			n = myFmt.parse(time);	
		} catch (ParseException e) {	
			e.printStackTrace();	
		}
		return n;
	}
	
	public static void main(String[] arg) {
		String s = "2010-06-22";
//		Date date = DateUtil.StringToDate(s);
		System.out.println(DateUtil.testTime(s));
	
	}	
}	
