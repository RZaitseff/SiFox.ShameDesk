package com.sifox.utils;

import java.util.Arrays;
import java.util.List;

public class DateHelper 
{
	
	private static List<String> MONTHS = Arrays.asList(new String[]{"January", "February", "March", "April", "May", "June", "July","August", "September", "October", "November", "December"});
	
	public static String monthNameByNumber(int index)
	{
		return MONTHS.get(index - 1);
	}
	
	public static int monthNumberByName(String name)
	{
		return MONTHS.indexOf(name) + 1;
	}
	
	public static String getFullDate(int day, String month)
	{
		return String.format("%d %s", day, month);
	}
	
}
