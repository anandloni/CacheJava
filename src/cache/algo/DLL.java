package cache.algo;

public class DLL<K> {
	DLLNode<K> head;
	DLLNode<K> tail;
	
	public DLL(){
		head = new DLLNode<>(null);
		tail = new DLLNode<>(null);
		head.next = tail;
		tail.prev = head;
	}

	public void addToFront(DLLNode<K> node) {
		DLLNode<K> next = head.next;
		head.next = node;
		node.prev = head;
		node.next = next;
		node.next.prev = node;
	}
	
	public void detachNode(DLLNode<K> node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	
	public DLLNode<K> getLast() {
		if(tail.prev == head) {
			return null;
		}
		return tail.prev;
	}
	
}
