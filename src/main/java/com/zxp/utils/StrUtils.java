package com.zxp.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.springframework.util.StringUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class StrUtils extends StringUtils {

	public static boolean isEmpty(String s) {
		return (s == null || s.length() == 0);
	}

	public static boolean parseboolean(String s, boolean dft) {
		try {
			return Boolean.parseBoolean(s.trim());
		} catch (Exception e) {
			return dft;
		}
	}

	public static int parseint(String s, int dft) {
		try {
			return Integer.valueOf(s.trim()).intValue();
		} catch (Exception e) {
			return dft;
		}
	}

	public static long parselong(String s, long dft) {
		try {
			return Long.valueOf(s.trim()).longValue();
		} catch (Exception e) {
			return dft;
		}
	}

	public static float parseFloat(String s, float dft) {
		try {
			return Float.valueOf(s.trim()).floatValue();
		} catch (Exception e) {
			return dft;
		}
	}

	public static double parseDouble(String s, double dft) {
		try {
			return Double.valueOf(s.trim()).doubleValue();
		} catch (Exception e) {
			return dft;
		}
	}

	public static byte[] stringToBytes(String s, String charset) {
		if (s == null || s.length() <= 0)
			return null;

		try {
			return s.getBytes(charset != null ? charset : "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String[] simpleSplit(String str, String separatorChars) {
		if (str == null || str.length() == 0)
			return new String[0];
		if (separatorChars == null || separatorChars.length() == 0)
			return new String[] { str };

		List<String> list = new ArrayList<String>();
		char[] tmpSpChars = separatorChars.toCharArray();
		int len = str.length();
		int i = 0;
		int j = 0;
		int start = 0;
		char currentChar = 0;
		boolean match = false;
		boolean found = false;
		while (i < len) {
			currentChar = str.charAt(i);
			found = false;
			for (j = 0; (!found) && j < tmpSpChars.length; j++) {
				found = (currentChar == tmpSpChars[j]);
			}
			if (found) {
				if (match) {
					list.add(str.substring(start, i));
					match = false;
				}
				start = ++i;
			} else {
				match = true;
				i++;
			}
		}
		if (match)
			list.add(str.substring(start, i));
		return (String[]) list.toArray(new String[list.size()]);
	}

	public static String base64Encode(String str) {
		if (str != null && str.length() > 0)
			str = (new BASE64Encoder()).encode(str.getBytes());
		return str;
	}

	public static String base64Decode(String str) {
		if (str != null && str.length() > 0)
			try {
				byte buf[] = (new BASE64Decoder()).decodeBuffer(str);
				str = new String(buf);
			} catch (IOException e) {
				String errorCode = "Error occurs when do the method of String base64Decode. Error Prompt: "
						+ e.toString() + "Input String: " + str;
				System.out.println(errorCode);
			}
		return str;
	}

	public static String nvl(String str) {
		if (isEmpty(str))
			return "";
		else
			return str;
	}

	public static Properties parseParamList(String paramlist, Properties refproperties) {
		if (paramlist != null && paramlist.length() > 0 && refproperties != null) {
			String[] tmpParams = paramlist.split("[&]");
			for (int i = 0; i < tmpParams.length; i++) {
				String tmpParamItem = tmpParams[i];
				int tmpPos = tmpParamItem.indexOf('=');
				if (tmpPos > 0)
					refproperties.setProperty(tmpParamItem.substring(0, tmpPos), tmpParamItem.substring(tmpPos + 1));
			}
		}
		return refproperties;
	}

	public static String newUUID() {
		String uuidStr = UUID.randomUUID().toString();
		return uuidStr.substring(0, 8) + uuidStr.substring(9, 13) + uuidStr.substring(14, 18)
				+ uuidStr.substring(19, 23) + uuidStr.substring(24);
	}

	public static String currentStackInfo() {
		StackTraceElement[] traceList = Thread.currentThread().getStackTrace();
		if (traceList != null && traceList.length > 0) {
			StringBuilder buf = new StringBuilder();
			for (int i = 0; i < traceList.length; i++) {
				buf.append(traceList[i].toString()).append("\r\n");
			}
			return buf.toString();
		}
		return "";
	}
}
