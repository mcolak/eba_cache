/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.eba.cache;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;
import tr.gov.eba.util.ProbsValues;

/**
 *
 * @author murat
 */
public class EbaCacheMemcache implements EbaCache {

    static MemcachedClient c = null;

    public static MemcachedClient getInstance() {
        if (c != null) {
            return c;
        } else {
            initialize();
            return c;
        }
    }

    private static void initialize() {

        /*
         List<String> memservices = new ArrayList<String>();
         //memservices.add("10.7.112.25:11211");
         //memservices.add("10.7.112.25:11212");
         // memservices.add("10.7.112.25:11213");  
         memservices.add("localhost:5701");
         memservices.add("localhost:5702");
         c = new MemcachedClient(
         // AddrUtil.getAddresses("10.101.55.101:11211"));
         */
        AddrUtil.getAddresses(ProbsValues.MEMCACHE_SERVER_ADRESSES);

    }

    @Override
    public Object getValue(String key, CacheTime cacheTime) {
        return c.get(key);
    }

    @Override
    public void putValue(String key, Serializable object, CacheTime cacheTime) {
        int expriteTimeSecond = cacheTime.getMin() * 60;
        c.add(key, expriteTimeSecond, object);
    }

    @Override
    public void remove(String key, CacheTime cacheTime) {
        c.delete(key);
    }

    @Override
    public void clearAll(CacheTime cacheTime) {
        c.flush();
      
    }

    @Override
    public void shutdown() {
        if (c != null) {
            c.shutdown();
            c = null;
        }
    }

    @Override
    public void replace(String key, Serializable object, CacheTime cacheTime) {
        int expriteTimeSecond = cacheTime.getMin() * 60;
        c.replace(key, expriteTimeSecond, object);
    }
}
