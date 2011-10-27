package visual;

public class RGBmaterial
{

    private material R;
    private material G;
    private material B;
    public static final RGBmaterial blueHighSpec 
    			= new RGBmaterial(
    				new material(0, 0, 0, 0),
    				new material(0, 0, 0, 0),
    				new material(0.2, 0.5, 0.3, 100));
    
    public static final RGBmaterial greenHighSpec 
    			= new RGBmaterial(
    				new material(0, 0, 0, 0),
    				new material(0.2, 0.5, 0.3, 100),
    				new material(0, 0, 0, 0));
    public static final RGBmaterial redHighSpec 
    			= new RGBmaterial(
    				new material(0.2, 0.5, 0.3, 100),
    				new material(0, 0, 0, 0),    				
    				new material(0, 0, 0, 0));
    			public static RGBmaterial rndRGBmat(){
    				return new RGBmaterial(material.rndMat(),material.rndMat(),material.rndMat());
    				
    			}
    public RGBmaterial(material r, material g, material b)
    {
        R = r;
        G = g;
        B = b;
    }
    
    public material getR(){
	return R;
    }
    public material getG(){
	return G;
    }
    public material getB(){
	return B;
    }
}
