package math;

import visual.RGBmaterial;

public class ball
    implements intersectable
{
    protected RGBmaterial mat;
    private vec fix;
    private double r;
    
    public RGBmaterial getMat(){
    	    return mat;
    }
    
    public vec getN(vec p){
    	return vec.norm(vec.sub(p,fix));	    
    }
    public intersection intersectsCamRay(gerade g){
    	intersection erg;
        erg = new intersection();
        double a,b,c, disk,x1,x2,dist1;
         	a=vec.scaleProd(g.getDir(),g.getDir());
         	b=2*vec.scaleProd(g.getDir(),vec.sub(g.getFix(),this.fix));
         	c=vec.scaleProd(vec.sub(this.fix, g.getFix()),vec.sub(this.fix, g.getFix()))-(r*r);
         	
         	disk=((b*b)-(4*a*c));
         	if(disk<0){
         		erg.setHits(false);
         		return erg;
         	}else{
         		erg.setHits(true);
         		erg.setObj(this);
         		x1=(-b+Math.sqrt(disk))/(2*a);
         		x2=(-b-Math.sqrt(disk))/(2*a);
         		if(x1<0 || x2<0){
         			erg.setHits(false);
         			return erg;
         		}
         		a=vec.len(vec.add(g.getFix(),vec.scaleN(g.getDir(),x1)));
         		b=vec.len(vec.add(g.getFix(),vec.scaleN(g.getDir(),x2)));
         		
         		if(a<b){
         			erg.setCut(vec.add(g.getFix(),vec.scaleN(g.getDir(),x1)));
         			erg.setDist(a);
         			
         		}else{
         			erg.setCut(vec.add(g.getFix(),vec.scaleN(g.getDir(),x2)));
         			erg.setDist(b);
         		}
         		//System.out.println(erg.getCut());
         	}
         	return erg;
    }
    public intersection intersectsRay(gerade g, intersectable orig)
    {
    	
        intersection erg;
        erg = new intersection();

        //nur wichtig für licht
        if (orig!= null && orig.equals(this))
        {
        
            
            if (Math.acos(vec.scaleProd(vec.norm(vec.sub(this.fix,g.getFix())), 
                                        vec.norm(g.getDir()))) > Math.PI/2)
            				//es wird ein punkt der kugel betrachtet
            {
            	   
                //inverser ortsvektor des punktes auf der oberfläche und 
                //vektor von punkt auf der oberfläche in richtung licht
                //schließen einnen winkel von weniger al pi ein
                erg.setHits(false);
            }
            else
            {

                // der eingeschlossene winkel ist größer
                erg.setHits(true);
            }

            return erg;
        }
        else
        {
            // normale schnittpunkt berechnung vom ursprung/cam aus
         	double a,b,c, disk,x1,x2,dist1;
         	a=vec.scaleProd(g.getDir(),g.getDir());
         	b=2*vec.scaleProd(g.getDir(),vec.sub(g.getFix(),this.fix));
         	c=vec.scaleProd(vec.sub(this.fix, g.getFix()),vec.sub(this.fix, g.getFix()))-(r*r);
         	
         	disk=((b*b)-(4*a*c));
         	if(disk<0){
         		erg.setHits(false);
         		return erg;
         	}else{
         		erg.setHits(true);
         		erg.setObj(this);
         		x1=(-b+Math.sqrt(disk))/(2*a);
         		x2=(-b-Math.sqrt(disk))/(2*a);
         		if(x1<0 || x2<0){
         			erg.setHits(false);
         			return erg;
         		}
         		a=vec.len(vec.add(g.getFix(),vec.scaleN(g.getDir(),x1)));
         		b=vec.len(vec.add(g.getFix(),vec.scaleN(g.getDir(),x2)));
         		
         		if(a<b){
         			if(a>vec.len(g.getDir())){
         				erg.setHits(false);
         				return erg;
         			}
         			erg.setCut(vec.add(g.getFix(),vec.scaleN(g.getDir(),x1)));
         			erg.setDist(a);
         			
         		}else{
         			if(b>vec.len(g.getDir())){
         				erg.setHits(false);
         				return erg;
         			}
         			erg.setCut(vec.add(g.getFix(),vec.scaleN(g.getDir(),x2)));
         			erg.setDist(b);
         		}
         		//System.out.println(erg.getCut());
         	}
            return erg;
        }
    }
    
    public String toString(){
    	    return "ball: "+fix+" rad:"+r; 	    
    }
    
    public ball(vec F, double R)
    {
        fix = F;
        r = R;
    }

    public vec getFix()
    {

        return fix;
    }

    public double getR()
    {

        return r;
    }
}
