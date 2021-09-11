package cache;

import cache.exception.NotFoundException;
import cache.policies.EvictionPolicy;
import cache.storage.Storage;

public class Cache<K, V> {

	EvictionPolicy<K> policy;
	Storage<K, V> storage;
	
	public Cache(EvictionPolicy<K> policy, Storage<K,V> storage){
		this.policy = policy;
		this.storage = storage;
	}
	
	public V get(K key) {
		V val = storage.get(key);
		if(val != null) {
			policy.setAccessed(key);
			System.out.println("Key accessed and put on head: "+ key);
		}
		return val;
	}

	public void put(K key, V value) // throws NotFoundException 
	{
		if(storage.isFull()) {
			K evicted = policy.evict();
			storage.remove(evicted);
			System.out.println("Storage is full.. evicted: "+ evicted);
		}
		
		storage.put(key, value);
		policy.setAccessed(key);
		System.out.println("Saving key: " + key);
	}
}
