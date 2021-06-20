package com.learnautomation.learning;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadLocal<Integer> tl1 = new ThreadLocal<Integer>();
		tl1.set(100);

		ThreadLocal<Integer> tl2 = new ThreadLocal<Integer>();
		tl2.set(500);
		
		ThreadLocal<Integer> tl3 = new ThreadLocal<Integer>();
		tl3.set(800);
		
		ThreadLocal<Integer> tl4 = new ThreadLocal<Integer>();
		tl4.set(1000);
		
		
		System.out.println(tl1.get());

	}

}
