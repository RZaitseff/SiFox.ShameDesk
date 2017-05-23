package com.sifox.utils;

public class Logger {

	private final org.apache.log4j.Logger logger;
	
	public Logger(Class<?> clazz) {
		logger = org.apache.log4j.Logger.getLogger(clazz);
	}
	
	public void info(String message) {
		logger.info(message);
	}
	
	public void error(String message) {
		logger.error(message);
	}
	
	public void error(Exception e) {
		StringBuilder sb = new StringBuilder();
		for(StackTraceElement ste: e.getStackTrace()) {
			sb.append(ste.toString()).append("\n");
		}
			
		logger.error(sb.toString());
	}

}