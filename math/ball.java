package math;

import logic.compObj;
import java.awt.Color;

public class ball implements compObj{
	private vec fixpoint;
	private double rad;
	private Color col;

	public Color getColor(){
		return col;
	}

	public ball(vec fixpoint, double rad, Color c) {
		super();
		this.fixpoint = fixpoint;
		this.rad = rad;
		this.col = c;
	}
	public ball(vec fixpoint, double rad) {
		super();
		this.fixpoint = fixpoint;
		this.rad = rad;
	}

	public String toString(){
		return "ball-> fix:"+fixpoint+" rad:"+rad;
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
	public double shortestDistanceTo(vec ray){
		double dist,p,q,r,erg,x1,x2;
		dist = Double.MAX_VALUE;

		p=func.scaleProd(fixpoint,fixpoint)-(rad*rad);
		q=(-2)*(func.scaleProd(ray,fixpoint));
		r=func.scaleProd(ray, ray);
				
		erg = ((q*q)-(4*p*r));
				
				
		if(erg>0){
			x1 = (-q+Math.sqrt(erg))/(2*r);
			x2 = (-q-Math.sqrt(erg))/(2*r);
			if(x1< x2){
				dist = x1*func.dist(new vec(0,0,0), ray);
			}else{
				dist = x2*func.dist(new vec(0,0,0), ray);
			}
			
		}

		return dist;
	}
	
}
