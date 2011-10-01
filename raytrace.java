import java.awt.Color;

import visual.*;
import math.*;
import logic.*;

public class raytrace {
	public static void main(String args[]){
		/**
		 * TODO 
		 * objekte um eine farbe erweitern
		 */
		boolean deb=false;
		Color tmpCol;
		double entf;

		//init picture
		int w=800,h=600;
		Picture Screen = new Picture(w,h);
		Screen.setOriginLowerLeft();
		
/*
		ball b1=new ball(new vec(3150,50,0),100);
		plain dree = new plain(new vec(3000,0,250),new vec(4000,-50,-100), new vec(3000,150,-100));
*/		
		//init distance of screen by angle
		int x = (int) (((double)w)/(2*Math.tan(Math.toRadians((double)30/2))));
		
		//the current ray		
		vec akt;
		akt=new vec(0,0,0);
		akt.setX(x);		
	
		//System.out.println("Abstand= "+x);
		

		//fill the list with objects
		compList rootList;
		rootList = new compList(new ball(new vec(3150,50,0),100,Color.RED));
		rootList.addEnd(rootList,new plain(new vec(3000,0,250),new vec(4000,-50,-100), new vec(3000,150,-100),Color.BLUE));
		//print the list on terminal
		rootList.printList(rootList);
		double tmpentf;	
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
		}
		Screen.show();
	}
}
