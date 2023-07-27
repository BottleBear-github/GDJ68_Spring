package com.pbw.main.file;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import com.pbw.main.Mytest;

public class CalendarTest extends Mytest{

	@Test
	public void test() {
		
		Calendar ca = Calendar.getInstance();
		System.out.println(ca);
		System.out.println(ca.getTime());
		
		System.out.println(ca.get(Calendar.YEAR));
		System.out.println(ca.get(Calendar.DATE));
		System.out.println(ca.get(Calendar.MONTH));
		
		ca.set(Calendar.YEAR, 1994);
		ca.set(Calendar.MONTH, 0);
		System.out.println(ca.getTime());
		
		System.out.println("===============================");
		ca = Calendar.getInstance();
		Calendar ca2 = Calendar.getInstance();
		ca2.set(1992, 6, 22, 3, 20);
		
		long l1 = ca.getTimeInMillis();
		long l2 = ca2.getTimeInMillis();
		long result = l1 - l2;
		System.out.println(result/(1000*60));
	}

}
