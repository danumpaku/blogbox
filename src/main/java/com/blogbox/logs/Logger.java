package com.blogbox.logs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Logger{
	
	//TODO Usar log4j en vez de apache
	public Log log;
	
	public Logger(Class<?> t) {
		log = LogFactory.getLog(t);
	}
	
	private String wrapMethod (String method){
		return "[" + method + "] ";
	}

	public void info (String method, String message) {
		log.info(wrapMethod(method) + message);
	}
	
	public void warn (String method, String message) {
		log.warn(wrapMethod(method) + message);
	}
	
	public void error (String method, String message) {
		log.error(wrapMethod(method) + message);
	}
	
	public void debug (String method, String message) {
		log.debug(wrapMethod(method) + message);
	}
}
