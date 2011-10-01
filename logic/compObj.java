package logic;

import math.vec;
import java.awt.Color;

public interface compObj {
	double shortestDistanceTo(vec ray);
	Color getColor();
}
