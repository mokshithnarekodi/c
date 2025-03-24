 package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random=new Random();
		int randomNum=random.nextInt(5000);
		return randomNum;
	}
	
	public long getRandomNumber(long n) {
		Random random=new Random();
		long randomNum=random.nextLong(n);
		return randomNum;
	}
	public String getSystemDate_yyyyMMdd() {
		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(dateobj);
		return date;
	}
	
	public String getRequiredDate_yyyyMMdd(int days) {
		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		sim.format(dateobj);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sim.format(cal.getTime());
		return reqDate;
	}
}
