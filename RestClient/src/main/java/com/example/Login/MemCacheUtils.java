package com.example.Login;

import java.net.InetSocketAddress;
import java.util.HashMap;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

public class MemCacheUtils {

    //private static final Logger logger = LogManager.getLogger(MemCacheUtil.class);
    private static MemCachedClient client = null;
    

    static {
        //String[] servers = { "http://localhost:11211" };
        SockIOPool pool = SockIOPool.getInstance();
        //pool.setServers(servers);
        pool.setFailover(true);
        pool.setInitConn(1000);
        pool.setMinConn(5000);
        pool.setMaxConn(25000);
        pool.setMaxIdle( 18000 );
        pool.setMaintSleep(300);
        pool.setNagle(false);
        pool.setSocketTO(3000);
        pool.setAliveCheck(true);
        pool.initialize();
        //client = new MemCachedClient(new InetSocketAddress("127.0.0.1",11211));
        
    }
    
    public static boolean putInCache(String key, String value) {
        System.out.println("cache out");
        
        return client.add(key, value);
        //return client.set(key, value);
       
    }

 

    public static Object getFromCache(String key) {
        Object value = client.get(key);
        System.out.println(client.keyExists(key));
        System.out.println("value"+value);
        if (value == null) {
        //    logger.info("Cache miss for key:{}", key);
            System.out.println("cache miss");
            return null;
           
        } else {
            //logger.info("Cache hit for key:{}", key);
            System.out.println("cache hit");
            return (Object) value;
        }
    }

    public static void removeFromCache(String key) {
        client.delete(key);
    //    logger.info("Removing key: {} from cache", key);
        	System.out.println("key"+key);
            System.out.println("cache remove");
    }

}