package visual;

import math.ball;
import math.vec;

public class vBall
    extends ball
{
    public vBall(vec a, double r, RGBmaterial m)
    {
        super(a,r);
        this.mat = m;
    }
}
