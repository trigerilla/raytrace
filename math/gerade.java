package math;

public class gerade {
	private vec fixpoint;
	private vec dir;
	public vec getFixpoint() {
		return fixpoint;
	}
	public void setFixpoint(vec fixpoint) {
		this.fixpoint = fixpoint;
	}
	public vec getDir() {
		return dir;
	}
	public void setDir(vec dir) {
		this.dir = dir;
	}
	public gerade(vec point_a, vec point_b) {
		this.fixpoint = point_a;
		this.dir = func.sub(point_b, point_a);
	}
	
}
