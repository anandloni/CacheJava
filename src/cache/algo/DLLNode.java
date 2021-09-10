package cache.algo;

public class DLLNode<K> {
	DLLNode<K> next;
	DLLNode<K> prev;
	K val;
	
	public DLLNode(K val){
		this.val = val;
	}
	
	@Override
	public String toString() {
		return val.toString();
	}
	
	public K getVal() {
		return val;
	}
}
