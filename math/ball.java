package math;

public class ball {
	private vec fixpoint;
	private double rad;
	public ball(vec fixpoint, double rad) {
		super();
		this.fixpoint = fixpoint;
		this.rad = rad;
	}
	public double getRad() {
		return rad;
	}
	public void setRad(double rad) {
		this.rad = rad;
	}
	public vec getfixpoint() {
		return fixpoint;
	}	
	
}
