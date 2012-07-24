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
public interface EbaCache {

    public Object getValue(String key, CacheTime cacheTime);

    public void putValue(String key, Serializable object, CacheTime cacheTime);

    public void replace(String key, Serializable object, CacheTime cacheTime);

    public void remove(String key, CacheTime cacheTime);

    public void clearAll(CacheTime cacheTime);

    public void shutdown();
}
