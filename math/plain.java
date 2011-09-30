package math;

public class plain {
	private vec fixpoint;
	private vec dir1,dir2;
	public vec getFixpoint() {
		return fixpoint;
	}
	public void setFixpoint(vec fixpoint) {
		this.fixpoint = fixpoint;
	}
	public vec getDir1() {
		return dir1;
	}
	public void setDir1(vec dir1) {
		this.dir1 = dir1;
	}
	public vec getDir2() {
		return dir2;
	}
	public void setDir2(vec dir2) {
		this.dir2 = dir2;
	}
	public plain(vec a, vec b, vec c) {
		this.fixpoint = a;
		this.dir1 = func.sub(b, a);
		this.dir2 = func.sub(c, a);
	}
	
	
}
