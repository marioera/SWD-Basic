package com.swdbasic.fundamentals;

public class TriangleSolver {
	private double a;
	private double b;
	private double c;
	private double A;
	private double B;
	private double C;
	
	public TriangleSolver (int a, int b, int c, int A, int B, int C) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.A = A;
		this.B = B;
		this.C = C;
	}
	
	public void solve() {
		this.a = solveAngle(B, C, A);
		this.b = solveAngle(C, A, B);
		this.c = solveAngle(A, B, C);
	}
	
	private double solveAngle(double left, double right, double opposite) {
		return Math.toDegrees(Math.acos((Math.pow(left, 2) + Math.pow(right, 2) - Math.pow(opposite, 2)) / (2 * left * right)));
	}
	
	public String toString(){
		return "a: " + a + " b: " + b + " c: " + c + " A: " + A + " B: " + B + " C: " + C;
	}
	
}
