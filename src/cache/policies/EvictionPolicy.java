package cache.policies;

public interface EvictionPolicy<K>{
	void setAccessed(K key);
	K evict();
}
