package com.blogbox.util;

public class StringUtil {
	
	public static String buildUrl (String url, String paramName, String paramVal) {
		return url.replaceAll(paramName, paramVal);
	}
	
	public static String buildUrl (String url, String paramName, long paramVal) {
		return url.replace(paramName, String.valueOf(paramVal));
	}
	
}
