package visual;

public class lightList{
	private light cur;
	private lightList next;

	public lightList(){
		cur=null;
		next=null;
	}
	
	public String toString(){
		return ""+cur;
	}
	
	public static void printList(lightList root){
		while(root.getNext() != null){
			System.out.println(root);
			root = root.getNext();
		}
		System.out.println(root);
	}
	
	public static double getAmbiLight(lightList root){
		/*
			mittelwert aller lichtquellen
		*/
		
		double erg=0;
		int count=1;
		
		while(root.getNext() != null){
			count++;
			erg+=root.getCur().getI();
			root = root.getNext();
		}
		erg+=root.getCur().getI();
		return (erg/count);
	}
	
	public static void addLight(lightList root, light l){
		if(root.getCur()==null){
			root.setCur(l);
		}else{
			lightList nlL;
			nlL = new lightList();
			nlL.setCur(l);
			while(root.getNext() != null){
				root = root.getNext();
			}
			root.setNext(nlL);
		}
	}
	
	public light getCur(){
		return cur;	
	}
	
	public lightList getNext(){
		return next;	
	}
	
	public void setNext(lightList n){
		this.next = n;
	}
	
	public void setCur(light l){
		this.cur = l;
	}
		
	public static void main(String args[]){
		lightList testL;
		testL = new lightList();
		lightList.addLight(testL,new light(math.vec.NULL,180));
		lightList.addLight(testL,new light(math.vec.NULL,255));	
		lightList.printList(testL);
	}
}
