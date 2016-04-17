package com.chris.util;

public class StringUtil {
	public static String padLeft(String str, int len, String ch) {
		if (str.length() >= len) {
			return str;
		} else {
			StringBuilder sb = new StringBuilder(str);
			sb.insert(0, ch);
			return padLeft(sb.toString(), len, ch);
		}
	}

	public static String padRright(String str, String ch, int len) {
		if (str.length() >= len) {
			return str;
		} else {
			StringBuilder sb = new StringBuilder(str);
			sb.append(ch);
			return padRright(sb.toString(), ch, len);
		}
	}
}
