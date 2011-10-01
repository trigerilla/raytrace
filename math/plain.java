package math;

import logic.compObj;
import java.awt.Color;

public class plain implements compObj{
	private vec fixpoint;
	private vec dir1,dir2;
	private Color col;

	public Color getColor(){
		return col;
	}

	public String toString(){
		return "triangle-> fix:"+fixpoint+" dir1:"+dir1+" dir2:"+dir2;
	}
	
	public vec getFixpoint() {
		return fixpoint;
	}
	public void setFixpoint(vec fixpoint) {
		this.fixpoint = fixpoint;
	}
	public vec getDir1() {
		return dir1;
	}
	public void setDir1(vec dir1) {
		this.dir1 = dir1;
	}
	public vec getDir2() {
		return dir2;
	}
	public void setDir2(vec dir2) {
		this.dir2 = dir2;
	}
	public plain(vec a, vec b, vec c, Color co) {
		this.fixpoint = a;
		this.dir1 = func.sub(b, a);
		this.dir2 = func.sub(c, a);
		this.col = co;
	}
	public plain(vec a, vec b, vec c) {
		this.fixpoint = a;
		this.dir1 = func.sub(b, a);
		this.dir2 = func.sub(c, a);
	}
	
	public double shortestDistanceTo(vec ray){
		double dist, deta,x1,x2;
		vec tmpV,tmp1,tmp2;
		dist = Double.MAX_VALUE;
		deta= func.det(ray, dir1, dir2);
				
		tmpV = new vec(fixpoint.getX(),fixpoint.getY(),fixpoint.getZ());
		func.scale(tmpV, -1);

		x1=func.det(ray, tmpV, dir2)/deta;
		x2=func.det(ray, dir1, tmpV)/deta;
				
				
		tmp1 = new vec(dir1.getX(),dir1.getY(),dir1.getZ());
		tmp2 = new vec(dir2.getX(),dir2.getY(),dir2.getZ());
		func.scale(tmp1, x1);
		func.scale(tmp2, x2);
				
		if(x1>0 && x2>0 && (x1+x2)<=1){			
			dist = func.dist(new vec(0,0,0), func.add(fixpoint,func.add(tmp1, tmp2)));			
		}


		return dist;
	}	
}
