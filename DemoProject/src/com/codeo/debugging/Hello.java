package com.codeo.debugging;

public class Hello {
	int x;
	int y;


	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int add(int a,int b) {
		int c=a+b;
		System.out.println(c);
		return c;
	}
	public static void main(String[] args) {
		
       
		int a=5;
		int b=6;
		a=a+3;
		a=a-4;
		a=a-b;
		
		String str="codeo";
		Hello h=new Hello();
		h.add(3, 5);
		System.out.println(a);

	}
	public void setRef(Hello h2) {
		System.out.println(h2.getX());
		System.out.println(h2.getY());
		
	}

}
