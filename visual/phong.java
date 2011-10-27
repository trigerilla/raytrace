package visual;

import java.awt.Color;
import math.*;
import caster.*;

public class phong{
	//implement ambien/spec/diff light

	
	public static double getDiffLight(material mat, double lightVal, vec N, vec L){
		return Math.abs((mat.getKd() * lightVal * vec.scaleProd(L,N)));
	}
	
	public static double getSpecLight(material mat, double lightVal, vec N, vec L, vec V){
		// N normalen vektor auf der Oberfläche
		// L vektor vom objekt in richtung licht
		// V vektor vom objekt in richtung cam
		vec R = vec.norm(vec.sub(vec.scaleN(N, 2*(vec.scaleProd(L,N))),L));
		return Math.abs((mat.getKs() * Math.pow(vec.scaleProd(R,V),mat.getAlpha()) * lightVal));		
	}
	
	public static double getAmbiLight(double ambi, material mat){
		return ambi*mat.getKa();
	}
	
	public static Color getFullRGBLight(objectList objects, lightList lights, vec ray, vec cam){
		int r,g,b;
		r=0;b=0;g=0;
		//schnitt mit irgendeinem anderen objekt
			//schnitt mit der kürzesten distanz finden
				// für diesen punkt einen strahl in richtung jeder lichtquelle
					//wenn andere objekte getroffen werden nur ambienten teil sonst alle teile
		//ansonsten schwarz
		
		
		intersection shIn;//shortest intersection
		shIn = raycaster.getClosestObj(objects , ray, cam);
		if(shIn.hits() == false){
			return new Color(r,g,b);
		}
		
		gerade obToL; // object to light
		lightList baqLights;
		baqLights = lights;
		
		double ambiVal;
		ambiVal=lightList.getAmbiLight(lights);
		r=(int)getAmbiLight(ambiVal, shIn.getObj().getMat().getR());
		g=(int)getAmbiLight(ambiVal, shIn.getObj().getMat().getG());
		b=(int)getAmbiLight(ambiVal, shIn.getObj().getMat().getB());
		
		do{
			obToL = new gerade(shIn.getCut(), lights.getCur().getFix());
			if(raycaster.objectBetweenLight(shIn.getObj(), obToL, lights.getCur(), objects)){
				//hinderniss zwischen object und lichtquelle also nur ambient
				//System.out.println(shIn.getObj());
			}else{
				//ambient + spec + diff da kein hinderniss zwischen lichtquelle und objekt
				
				// N,L,V berechnen
				vec N, L, V;
				N = shIn.getObj().getN(shIn.getCut());
				L=vec.norm(vec.sub(lights.getCur().getFix(), shIn.getCut()));
				V=vec.norm(vec.sub(cam, shIn.getCut()));			
				
				r+=(int)(getSpecLight(shIn.getObj().getMat().getR(), lights.getCur().getI(), N, L, V)
					+getDiffLight(shIn.getObj().getMat().getR(), lights.getCur().getI(), N, L));
				g+=(int)(getSpecLight(shIn.getObj().getMat().getG(), lights.getCur().getI(), N, L, V)
					+getDiffLight(shIn.getObj().getMat().getG(), lights.getCur().getI(), N, L));
				b+=(int)(getSpecLight(shIn.getObj().getMat().getB(), lights.getCur().getI(), N, L, V)
					+getDiffLight(shIn.getObj().getMat().getB(), lights.getCur().getI(), N, L));
			}
			
		}while((lights=lights.getNext())!=null);
		
		
		if(r>255)
			r=255;
		
		if(g>255)
			g=255;
		
		if(b>255)
			b=255;
		
		return new Color(r,g,b);
	}
}
