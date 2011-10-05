package cast;

import java.awt.Color;
import visual.*;
import math.*;
import logic.*;
import data.*;

public class raytrace {
	public static int w,h;
	public static double phi;
	public static void main(String args[]){
		/**
		 * TODO 
		 * watch at README
		 */
		w=0;h=0;phi=0;
		boolean deb=false;
		Color tmpCol;
		double entf;
		compList rootList;
		rootList = new compList(null);
		double tmpentf;
		
		//read out of file
		System.out.println("loding file: "+args[0]);
		read3dObj.readMe(rootList,args[0]);
		//System.out.println("w="+w+" h="+h+" phi="+phi);
		
		//init picture		
		Picture Screen = new Picture(w,h);
		Screen.setOriginLowerLeft();
		
		//init distance of screen by angle
		int x = (int) (((double)w)/(2*Math.tan(Math.toRadians((double)phi/2))));
		
		//the current ray		
		vec akt;
		akt=new vec(x,0,0);
		//akt.setX(x);		
		
		//print the list/all elements on terminal
		rootList.printList(rootList);
		
			
		/*
		for(int y=(-w/2); y<(w/2);y++){
			for(int z=-(h/2);z<h/2;z++){
				//set max dist and maxdist-color				
				entf = Double.MAX_VALUE;
				tmpCol = Color.BLACK;
				
				//set current ray		
				akt.setY(y);
				akt.setZ(z);
				
				//check all objects in the list for the shortest distance
				compList tmpList;
				tmpList=rootList;
				while(tmpList.getNext() != null){
					tmpentf=tmpList.getCur().shortestDistanceTo(akt);
					if(tmpentf<entf){
						entf=tmpentf;
						tmpCol = tmpList.getCur().getColor();
					}
					tmpList = tmpList.getNext();
				}
				tmpentf=tmpList.getCur().shortestDistanceTo(akt);
				if(tmpentf<entf){
					entf=tmpentf;
					tmpCol = tmpList.getCur().getColor();
				}
				
				//draw in the right color
				Screen.set(y+(w/2),z+(h/2),tmpCol);
			}
		}*/
		Screen.show();
	}
}
