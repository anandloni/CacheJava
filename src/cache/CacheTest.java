package cache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cache.exception.NotFoundException;
import cache.factory.CacheFactory;

public class CacheTest {
	public static void main(String[] args) throws NotFoundException {
		Cache<Integer, Integer> intCache = new CacheFactory<Integer, Integer>().createCache(5);
		ExecutorService service = Executors.newFixedThreadPool(2);
		Runnable producer = () -> {
			for(int i=0; i< 10; i++) {
				intCache.put(i, i);
				System.out.println("Added: "+i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable consumer = () -> {
			for(int i=0; i< 10; i++) {
				Integer val = intCache.get(i);
				System.out.println("Accessed: "+i+ " Got:"+val);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		service.submit(producer);
		//service.submit(producer);
		service.submit(consumer);
		//service.submit(consumer);
		
		service.shutdown();
	}
}
