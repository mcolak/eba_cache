/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.eba.cache;

import java.io.Serializable;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 *
 * @author murat
 */
public class EbaCacheEhcache implements EbaCache {

    private static final CacheManager cacheManager = new CacheManager();

    private Cache getCache(String name) {
        return cacheManager.getCache(name);
    }

    @Override
    public Object getValue(String key, CacheTime cacheTime) {
        Element element = getCache(cacheTime.name()).get(key);
        if (element != null) {
            return element.getValue();
        }
        return null;

    }

    @Override
    public void putValue(String key, Serializable object, CacheTime cacheTime) {
        Element element = new Element(key, object);
        getCache(cacheTime.name()).put(element);
    }

    @Override
    public void remove(String key, CacheTime cacheTime) {
        getCache(cacheTime.name()).remove(key);
    }

    @Override
    public void clearAll(CacheTime cacheTime) {
        getCache(cacheTime.name()).removeAll();
    }

    @Override
    public void shutdown() {
        cacheManager.shutdown();
    }

    @Override
    public void replace(String key, Serializable object, CacheTime cacheTime) {
        Element element = new Element(key, object);
        getCache(cacheTime.name()).replace(element);
    }
}
