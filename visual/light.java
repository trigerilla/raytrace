package visual;

import math.vec;

public class light
{

    private vec fix; // position of the light
    private double i;//intensity of light (white light)

    public light(vec F, double I)
    {
        i = I;
        fix = F;
    }

    public void setFix(vec F){
    	fix=F;    
    }
    public vec getFix()
    {

        return fix;
    }

    public double getI()
    {

        return i;
    }
    
    public String toString(){
    	    return "light: "+fix+" lum:"+i;
    }
}
