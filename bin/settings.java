package bin;

import java.io.*;

import visual.*;
import math.*;

public class settings{
	private lightList lights;
	private objectList objects;
	private int w,h;
	private double phi, dist;
	private vec cam;
	public int getW(){
		return w;
	}
	
	public int getH(){
		return h;
	}
	
	public vec getCam(){
		return cam;
	}
	
	public objectList getObj(){
		return objects;	
	}
	
	public lightList getLights(){
		return lights;
	}
	
	public settings(String SceneFileName){
		lights = new lightList();
		objects = new objectList();
		
		//lightList.addLight(lights, new light(vec fix, double I));
		//objectList.addObject(objects,  new vBall(vec fix, double r, RGBmaterial));
		
		try{
			//FileInputStream fstream = new FileInputStream(SceneFileName);
			//DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(SceneFileName))));
			
			String red;
			while((red = br.readLine())!=null){
				if(red.length()>0){ // read no empty line
					if(red.charAt(0)!='#'){ // read no comment line
						String[] splitter;
						splitter = red.split("_");
						if(splitter[0].equals("ball")){			// line contains a ball
							//System.out.println("gotcha ball!");
							double r;
							vec fix;
							RGBmaterial mat;
							vBall vB;
														
							//default of mat is blue
							mat=RGBmaterial.blueHighSpec ;
							fix = new vec(Double.parseDouble(splitter[1]),Double.parseDouble(splitter[2]),Double.parseDouble(splitter[3]));
							r = Double.parseDouble(splitter[4]);
							
							if(splitter[5].equals("rnd")){
								// pick random material...
				//---->				// TODO
								mat=RGBmaterial.rndRGBmat();
							}else if(splitter[5].equals("blue")){
								//pick material by name
								
								mat = RGBmaterial.blueHighSpec ;
							}else if(splitter[5].equals("green")){
								//pick material by name
								
								mat = RGBmaterial.greenHighSpec ;
							}else if(splitter[5].equals("red")){
								//pick material by name
								
								mat = RGBmaterial.redHighSpec ;
							}
							vB = new vBall(fix, r, mat);
							objectList.addObject(objects, vB );
							System.out.println("added "+vB+" to scene");
						}else if(splitter[0].equals("global")){		//line contains global settings
							//System.out.println("gotcha global");
							w = Integer.parseInt(splitter[1]);
							h = Integer.parseInt(splitter[2]);
							phi = Double.parseDouble(splitter[3]);
							if(w>h){
								dist =((double)w)/(2*Math.tan(Math.toRadians(phi/2)));
							}else{
								dist =((double)h)/(2*Math.tan(Math.toRadians(phi/2)));
							}
							cam = new vec(-dist,0,0);
							
							System.out.println("width:"+w+" height:"+h+" cam:"+cam+" with angle of "+phi);
						}else if(splitter[0].equals("light")){		//line contains a light
							vec fix;
							double I;
							light l;
							
							fix = new vec(Double.parseDouble(splitter[1]),Double.parseDouble(splitter[2]),Double.parseDouble(splitter[3]));
							I = Double.parseDouble(splitter[4]);
							
							l=new light(fix, I);
							lightList.addLight(lights, l);
							
							System.out.println("added "+l+" to scene");
						}
					}	
				}
			}
			
		}catch (Exception e){}
	}
}
