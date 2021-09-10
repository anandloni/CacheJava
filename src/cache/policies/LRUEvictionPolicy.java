package cache.policies;

import java.util.HashMap;

import cache.algo.DLL;
import cache.algo.DLLNode;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K>{
	DLL<K> dll;
	HashMap<K, DLLNode<K>> map;
	
	public LRUEvictionPolicy() {
		dll = new DLL<>();
		map = new HashMap<>();
	}
	
	@Override
	public void setAccessed(K key) {
		if(map.containsKey(key)) {
			dll.detachNode(map.get(key));
			dll.addToFront(map.get(key));
		}
		else {
			DLLNode<K> node = new DLLNode<K>(key);
			map.put(key, node);
			dll.addToFront(node);
		}
	}

	@Override
	public K evict() {
		DLLNode<K> node= dll.getLast();
		dll.detachNode(node);
		map.remove(node.getVal());
		return node.getVal();
	}

}
