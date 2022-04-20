package com.codeo.debugging;

public class LoopsPractice {

	public static void main(String[] args) {
	
		for(int i=1;i<=0;i++) {
			System.out.println("2*"+i+"="+(2*i));
		}
		
		Hello h1=new Hello();
		Hello h2=h1;
		h2.setRef(h1);
		h1.setX(3);
		h1.setY(0);
	}

}
