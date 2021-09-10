package cache.factory;

import cache.Cache;
import cache.policies.LRUEvictionPolicy;
import cache.storage.HashMapBasedStorage;

public class CacheFactory<K, V> {
	public Cache<K, V> createCache(String evictionPolicy) {
		return null;
	}
	
	public Cache<K, V> createCache(int capacity) {
		return new Cache<K, V>(new LRUEvictionPolicy<>(), 
				new HashMapBasedStorage<>(capacity));
	}
}
