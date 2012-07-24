/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.eba.cache;

import java.io.Serializable;

/**
 *
 * @author murat
 */
public class EbaCacheUtil {

    static {
        _ebaCache = EbaCacheFactory.getInstance().createCache();
    }
    private static EbaCache _ebaCache;

    public static Object getValue(String key, CacheTime cacheTime) {
        return _ebaCache.getValue(key, cacheTime);
    }

    public static void putValue(String key, Serializable object, CacheTime cacheTime) {
        _ebaCache.putValue(key, object, cacheTime);
    }

    public static void remove(String key, CacheTime cacheTime) {
        _ebaCache.remove(key, cacheTime);
    }
    
    public static void replace(String key, Serializable object, CacheTime cacheTime) {
        _ebaCache.replace(key, object, cacheTime);
    }
    
     public static void shutdown() {
        _ebaCache.shutdown();
     }
     
     public static void clearAll(CacheTime cacheTime){
         _ebaCache.clearAll(cacheTime);
     }
}
