package com.pbw.main.file;

import java.io.File;

import org.junit.Test;

import com.pbw.main.Mytest;


public class FileTest extends Mytest {
	@Test
	public void test() {
		File file = new File("C:\\study\\study.txt");
		System.out.println(file.exists());
		System.out.println(file.isFile());
		file = new File("C:\\study","study.txt");
		
		file = new File("C:\\study");
		System.out.println(file.exists());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		file = new File(file,"ex");
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		file.delete();
		file = new File("C:\\study\\study.txt");
		file.delete();
		file = new File("C:\\study");
//		file.delete();
		String [] list = file.list();
		//향상된 for문
		//for(Collection에서모은타입 변수명:Collection변수명)
		for(String str:list) {
			System.out.println(str);
		}
		
		file = new File(file, "t1");
		file.mkdir();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
