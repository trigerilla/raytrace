package bin;

public class specialScene{
	public static void special1(){
		System.out.println("global_550_550_30");
		System.out.println("light_0_1000_0_255");

		double y,z;
		y=200;
		z=200;
		for(double i=0;i<Math.PI*2;i=i+(Math.PI/10)){
			System.out.println("ball_"+(3000+i*200)+"_"+(30+i*y*Math.sin(i))+"_"+(30+i*z*Math.cos(i))+"_50_rnd");
		}
		
	}
	
	public static void main(String[] args){
		special1();
	}
}
