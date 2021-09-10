package cache.storage;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import cache.exception.NotFoundException;

public class HashMapBasedStorage<K, V> implements Storage<K, V> {

	ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock writeLock = lock.writeLock();
    Lock readLock = lock.readLock();
	
    ConcurrentHashMap<K,V> map;
	int capacity;
	
	public HashMapBasedStorage(int capacity) {
		map = new ConcurrentHashMap<>();
		this.capacity = capacity;
	}
	
	@Override
	public V get(K key) {
		try {
			readLock.lock();
			return map.get(key);
		}
		finally {
			readLock.unlock();
		}
	}
	
	@Override
	public void put(K key, V val) {
		try {
			writeLock.lock();
			map.put(key, val);
		}
		finally {
			writeLock.unlock();
		}
	}
	
	@Override
	public void remove(K key) throws NotFoundException {
		if(map.containsKey(key))
			throw new NotFoundException("Key {} does not exists", key);
		map.remove(key);
	}
	
	@Override
	public boolean isFull() {
		return map.size() == capacity;
	}
}
