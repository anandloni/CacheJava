package cache;

import cache.exception.NotFoundException;
import cache.factory.CacheFactory;

public class CacheTest {
	public static void main(String[] args) throws NotFoundException {
		CacheFactory<String, String> factory = new CacheFactory<String, String>();
		Cache<String, String> cache = factory.createCache(3);
		
		cache.put("name", "aloni");
		//System.out.println(cache.get("name"));
		cache.put("age", "38");
		//System.out.println(cache.get("name"));
		cache.put("exp", "16");
		//System.out.println(cache.get("name"));
		cache.put("place", "Pune");
		
		System.out.println("Name: "+ cache.get("name")); // place exp age
		System.out.println("Age: "+ cache.get("age")); // age place exp
		cache.put("comp", "Vmware"); // comp age place
		System.out.println("Exp: "+cache.get("exp")); // null
		System.out.println("Place: "+cache.get("place")); //place comp age
		System.out.println("Age: "+cache.get("age"));// age place comp
		cache.put("name", "Vmware"); 
		
		
	}
}
