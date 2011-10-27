package bin;

import visual.*;
import math.*;
public class run
{
 
	public static void main(String[] args)
    {
    	    settings mySet;
    	    Picture screen;
    	    
    	    mySet=new settings(args[0]);
    	    
    	    screen = new Picture(mySet.getW(),mySet.getH());
    	    screen.setOriginLowerLeft();
    	    
    	    for(int y=-(mySet.getW()/2); y<mySet.getW()/2; y++){
    	    	for(int z=-(mySet.getH()/2); z<mySet.getH()/2; z++){
    	    		
    	    		
    	    	    screen.set(y+(mySet.getW()/2)
    	    	    	    ,z+(mySet.getH()/2)
    	    	    	    ,phong.getFullRGBLight(mySet.getObj(), mySet.getLights(), new vec(0,y,z), mySet.getCam()));
    	    	}    
    	    }
    	    screen.show();
    }
}
