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
public class EbaCacheNone implements EbaCache {

    @Override
    public Object getValue(String key, CacheTime cacheTime) {
        return null;
    }

    @Override
    public void putValue(String key, Serializable object, CacheTime cacheTime) {
    }

    @Override
    public void replace(String key, Serializable object, CacheTime cacheTime) {
    }

    @Override
    public void remove(String key, CacheTime cacheTime) {
    }

    @Override
    public void clearAll(CacheTime cacheTime) {
    }

    @Override
    public void shutdown() {
    }
}
