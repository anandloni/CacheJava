package cache.storage;

import cache.exception.NotFoundException;

public interface Storage <K,V>{
	void put(K key, V val);
	V get(K key);
	void remove(K key) throws NotFoundException;
	boolean isFull();
}
