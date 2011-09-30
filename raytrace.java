import java.awt.Color;

import visual.*;
import math.*;

public class raytrace {
	public static void main(String args[]){
		/**
		 * TODO 
		 * objekte um eine farbe erweitern
		 */
		boolean deb=false;
		Color tmpCol;
		double entf;
		int w=800,h=600;
		Picture Screen = new Picture(w,h);
		Screen.setOriginLowerLeft();
		
		ball b1=new ball(new vec(3150,50,0),100);
		plain dree = new plain(new vec(3000,0,250),new vec(4000,-50,-100), new vec(3000,150,-100));
		
		int x = (int) (((double)w)/(2*Math.tan(Math.toRadians((double)30/2))));
		
		double p,q,r;
		vec akt;
		akt=new vec(0,0,0);
		
		System.out.println("Abstand= "+x);
		akt.setX(x);
		
		for(int y=(-w/2); y<(w/2);y++){
			for(int z=-(h/2);z<h/2;z++){
				entf = Double.MAX_VALUE;
				tmpCol = Color.BLACK;
				double tmpentf,x1,x2;
				vec tmp1,tmp2,tmp3;
				
				
				akt.setY(y);
				akt.setZ(z);
				
				//kugel
				//vec tmp = new vec(b1.getfixpoint().getX(),b1.getfixpoint().getY(),b1.getfixpoint().getZ());
				//func.scale(tmp, -1);				
				p=func.scaleProd(b1.getfixpoint(),b1.getfixpoint())-(b1.getRad()*b1.getRad());
				q=(-2)*(func.scaleProd(akt,b1.getfixpoint()));
				r=func.scaleProd(akt, akt);
				
				double erg = ((q*q)-(4*p*r));
				if(deb){
					System.out.print(" erg= "+erg);
					System.out.print("p= "+p);
					System.out.print(" q= "+q);
					System.out.print(" r= "+r+"; @");
					System.out.println(y+(w/2)+" ,"+(z+(h/2)));
				}
				
				if(erg>0){
					x1 = (-q+Math.sqrt(erg))/(2*r);
					x2 = (-q-Math.sqrt(erg))/(2*r);
					if(x1< x2){
						tmpentf = x1*func.dist(new vec(0,0,0), akt);
					}else{
						tmpentf = x2*func.dist(new vec(0,0,0), akt);
					}
					if(tmpentf<entf){
						tmpCol = Color.BLUE;
						entf = tmpentf;
					}
					
				}
				
				
				//dreieck
				
				double deta;
				deta= func.det(akt, dree.getDir1(), dree.getDir2());
				
				tmp3 = new vec(dree.getFixpoint().getX(),dree.getFixpoint().getY(),dree.getFixpoint().getZ());
				func.scale(tmp3, -1);
				
				x1=func.det(akt, tmp3, dree.getDir2())/deta;
				x2=func.det(akt, dree.getDir1(), tmp3)/deta;
				
				
				tmp1 = new vec(dree.getDir1().getX(),dree.getDir1().getY(),dree.getDir1().getZ());
				tmp2 = new vec(dree.getDir2().getX(),dree.getDir2().getY(),dree.getDir2().getZ());
				func.scale(tmp1, x1);
				func.scale(tmp2, x2);
				
				if(x1>0 && x2>0 && (x1+x2)<=1){
					
					tmpentf = func.dist(new vec(0,0,0), func.add(dree.getFixpoint(),func.add(tmp1, tmp2)));
					if(tmpentf < entf){
						tmpCol = Color.CYAN;
						entf = tmpentf;
					}
					
				}
				Screen.set(y+(w/2), z+(h/2), tmpCol);
			}
		}
		System.out.println("fix:"+ dree.getFixpoint()+" dir1:"+dree.getDir1()+" dir2:"+dree.getDir2());
		Screen.show();
	}
}
