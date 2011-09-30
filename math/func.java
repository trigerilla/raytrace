package math;

public class func {
	public static vec sub(vec a, vec b){
		return new vec(a.getX()-b.getX(),a.getY()-b.getY(),a.getZ()-b.getZ());
	}
	
	public static vec add(vec a, vec b){
		return new vec(a.getX()+b.getX(),a.getY()+b.getY(),a.getZ()+b.getZ());
	}
	
	public static void scale(vec a, double k){
		a.setX(a.getX()*k);
		a.setY(a.getY()*k);
		a.setZ(a.getZ()*k);
	}
	
	public static double scaleProd(vec a, vec b){
		return ((a.getX()*b.getX())+(a.getY()*b.getY())+(a.getZ()*b.getZ()));
	}
	
	public static double dist(vec a, vec b){
		vec c =sub(a,b);
		return Math.sqrt((c.getX()*c.getX())+(c.getY()*c.getY())+(c.getZ()*c.getZ()));
	}
	
	public static double det(vec a, vec b, vec c){
		return a.getX()*b.getY()*c.getZ() + b.getX()*c.getY()*a.getZ() + c.getX()*a.getY()*b.getZ()
				- ( a.getX()*c.getY()*b.getZ() + c.getX()*b.getY()*a.getZ() + b.getX()*a.getY()*c.getZ() );
	}
}
