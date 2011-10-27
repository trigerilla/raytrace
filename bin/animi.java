package bin;

import visual.*;
import math.*;

public class animi{ 
	public static void main(String[] args)
    {
    	    if(args.length==0){
    	    	    System.out.println("usage: java animi <scene> <outputfolder>");
    	    	    System.exit(0);
    	    }
    	    
    	    settings mySet;
    	    Picture screen;
    	    
    	    mySet=new settings(args[0]);
    	    
    	    screen = new Picture(mySet.getW(),mySet.getH());
    	    screen.setOriginLowerLeft();
    	    
    	    int count=1000;
    	    for(double t=0; t<Math.PI*2; t=t+0.03){
    	    //set light pos
    	    mySet.getLights().getCur().setFix(new vec(0,Math.sin(t)*1000,Math.cos(t)*1000));
    	    
    	    //raytrace
    	    for(int y=-(mySet.getW()/2); y<mySet.getW()/2; y++){
    	    	for(int z=-(mySet.getH()/2); z<mySet.getH()/2; z++){
    	    		
    	    		
    	    	    screen.set(y+(mySet.getW()/2)
    	    	    	    ,z+(mySet.getH()/2)
    	    	    	    ,phong.getFullRGBLight(mySet.getObj(), mySet.getLights(), new vec(0,y,z), mySet.getCam()));
    	    	}    
    	    }
    	    
    	    //save image
    	    screen.save(args[1]+count+".png");
    	    count++;
    	    }
    }

}
