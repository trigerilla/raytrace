package visual;

public class material
{

    private double ka;
    private double kd;
    private double ks;
    private double alpha;
    public static material rndMat(){
    	double Ka,Kd,Ks,Alpha;
    	Ka = Math.random()*0.7;
    	Ks = Math.random();
    	while((Kd=Math.random())> 1-Ks){}
    	Alpha = (int)(Math.random() * 150)+20;
    	//System.out.println(" "+Ka+" "+Kd+" "+Ks+" "+Alpha);
    	return new material(Ka,Kd,Ks,Alpha);
    }
    public material(double A, double D, double S, double AL)
    {
        ka = A;
        kd = D;
        ks = S;
        alpha = AL;
    }

    public double getKs()
    {

        return ks;
    }

    public double getKd()
    {

        return kd;
    }

    public double getKa()
    {

        return ka;
    }

    public double getAlpha()
    {

        return alpha;
    }
}
