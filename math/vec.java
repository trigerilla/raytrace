package math;

public class vec
{

    private double x;
    private double y;
    private double z;

    public final static vec NULL = new vec(0,0,0);
    
    public String toString(){
    	return "x="+x+" y="+y+" z="+z+" ";    
    }
    
    public vec(double X, double Y, double Z)
    {
        x = X;
        y = Y;
        z = Z;
    }

    public double getX()
    {

        return x;
    }

    public double getY()
    {

        return y;
    }

    public double getZ()
    {

        return z;
    }

    public void setX(double X)
    {
        x = X;
    }

    public void setY(double Y)
    {
        y = Y;
    }

    public void setZ(double Z)
    {
        z = Z;
    }

    public static vec add(vec a, vec b)
    {

        return new vec(a.getX() + b.getX(), a.getY() + b.getY(), 
                       a.getZ() + b.getZ());
    }

    public static vec sub(vec a, vec b)
    {

        return new vec(a.getX() - b.getX(), a.getY() - b.getY(), 
                       a.getZ() - b.getZ());
    }

    public static void scale(vec a, double k)
    {
        a.setX(a.getX() * k);
        a.setY(a.getY() * k);
        a.setZ(a.getZ() * k);
    }

    public static vec scaleN(vec a, double k)
    {

        return new vec(a.getX() * k, a.getY() * k, a.getZ() * k);
    }

    public static double scaleProd(vec a, vec b)
    {

        return ((a.getX() * b.getX()) + (a.getY() * b.getY()) + 
               (a.getZ() * b.getZ()));
    }

    public static double det(vec a, vec b, vec c)
    {

        return (a.getX() * b.getY() * c.getZ()) + 
               (b.getX() * c.getY() * a.getZ()) + 
               (c.getX() * a.getY() * b.getZ()) - 
               (c.getX() * b.getY() * a.getZ()) - 
               (b.getX() * a.getY() * c.getZ()) - 
               (a.getX() * c.getY() * b.getZ());
    }
    public static double len(vec a){
    	    return Math.sqrt((a.getX()*a.getX())+(a.getY()*a.getY())+(a.getZ()*a.getZ()));
    }
    public static vec norm(vec a){
    	    return scaleN(a,1/len(a));
    }
}
