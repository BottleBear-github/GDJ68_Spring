package com.pbw.main.di;

public class Main {

	public static void main(String[] args) {
		//Dependency Injection(의존성 주입)
		//1. method
		//2. 생성자
		
		Robot robot = new Robot();
		
		
		Arm arm = new Arm();
		robot.setArm(arm);
		
		System.out.println(robot.getArm());
	}

}
