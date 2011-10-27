package math;

public class gerade
{

    vec fix;
    vec dir;

    public gerade(vec a, vec b)
    {                        
        fix = a;
        dir = vec.sub(b, a);
    }

    public vec getFix()
    {

        return fix;
    }

    public vec getDir()
    {

        return dir;
    }
    
    public String toString(){
    	    return "fix:"+fix+" dir:"+dir;    
    }
}
