package logic;

public class compList{
	private compObj cur; 
	private compList next;
	
	public compList(compObj cO){
		cur = cO;
		
		next = null;				
	}

	public compObj getCur(){
		return cur;
	}
	
	public void setCur(compObj CUR){
		cur=CUR;
	}
	
	public compList getNext(){
		return next;
	}
	
	public void setNext(compList n){
		next = n;
	}
	
	public static void addEnd(compList list, compObj el){
		compList tmp;
		tmp = list;
		while(tmp.getNext()!=null){
			tmp = tmp.getNext();
		}
		tmp.setNext(new compList(el));
	}

	public static void printList(compList list){
		compList tmp;
		tmp = list;
		while(tmp.getNext() != null){
			System.out.println(tmp.getCur());
			tmp = tmp.getNext();
		}
		System.out.println(tmp.getCur());
	}
}
