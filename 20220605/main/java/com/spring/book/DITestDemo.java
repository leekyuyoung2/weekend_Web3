package com.spring.book;

class Member{
	int memberId;
}

public class DITestDemo {
	

	public static void main(String[] args) {
		// 일반적인 방식.... 커플링 coupling
		Member m = new Member();
		m.memberId = 100;
		
		// DI
		Member m2 = getMember();		
		
	}
	
	public static Member getMember() {
		return new Member();
	}

}
