package data;

import math.*;
import logic.*;
import java.awt.Color;
import java.io.*;

public class read3dObj{
	public static void readMe(compList rootList, String path){
		String line;
		String[] sp;
		boolean first=true;
		double x1,x2,x3,y1,y2,y3,z1,z2,z3,r;
		Color tmpC;
		try{
		File file = new File(path);
		BufferedReader in = new BufferedReader(new FileReader(file));
			
		
		while ((line = in.readLine()) != null)
		{
			sp = line.split("_");
			if(sp[0].equals("a")){
				cast.raytrace.phi=Double.parseDouble(sp[1]);
				cast.raytrace.w=Integer.parseInt(sp[2]);
				cast.raytrace.h=Integer.parseInt(sp[3]);
			}else if(sp[0].equals("b")){
			
				x1=Double.parseDouble(sp[1]);
				y1=Double.parseDouble(sp[2]);
				z1=Double.parseDouble(sp[3]);
				r=Double.parseDouble(sp[4]);
				//farbe
				tmpC=new Color(Integer.parseInt(sp[5]),Integer.parseInt(sp[6]),Integer.parseInt(sp[7]));
			
				if(first){
					//rootList = new compList();
					rootList.setCur(new ball(new vec(x1,y1,z1),r,tmpC));
					first = false;
				}else{
					rootList.addEnd(rootList,new ball(new vec(x1,y1,z1),r,tmpC));
				}
			}else if(sp[0].equals("t")){
			
				x1=Double.parseDouble(sp[1]);
				y1=Double.parseDouble(sp[2]);
				z1=Double.parseDouble(sp[3]);
				x2=Double.parseDouble(sp[4]);
				y2=Double.parseDouble(sp[5]);
				z2=Double.parseDouble(sp[6]);
				x3=Double.parseDouble(sp[7]);
				y3=Double.parseDouble(sp[8]);
				z3=Double.parseDouble(sp[9]);
				//farbe
				tmpC=new Color(Integer.parseInt(sp[10]),Integer.parseInt(sp[11]),Integer.parseInt(sp[12]));
			
				if(first){
					//rootList = new compList(new plain(new vec(x1,y1,z1),new vec(x2,y2,z2), new vec(x3,y3,z3),tmpC));
					rootList.setCur(new plain(new vec(x1,y1,z1),new vec(x2,y2,z2), new vec(x3,y3,z3),tmpC));
					first = false;
				}else{
					rootList.addEnd(rootList,new plain(new vec(x1,y1,z1),new vec(x2,y2,z2), new vec(x3,y3,z3),tmpC));
				}
			}
		}
		}catch (Exception e){}
	}

}