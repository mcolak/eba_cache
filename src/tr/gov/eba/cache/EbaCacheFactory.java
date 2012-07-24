/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.eba.cache;

import tr.gov.eba.util.ProbsValues;

/**
 *
 * @author murat
 */
public class EbaCacheFactory {

    private static EbaCacheFactory _ebaCacheFactory;

    private EbaCacheFactory() {
    }

    public EbaCache createCache() {
        if (ProbsValues.CACHE_FACTOR_NAME.equals(ProbsValues.CACHE_FACTOR_NAME_HAZELCAST)) {
            System.out.println("hazelcast used");
            return new EbaCacheHazelcast();
        } else if (ProbsValues.CACHE_FACTOR_NAME.equals(ProbsValues.CACHE_FACTOR_NAME_MEMCACHE)) {
            System.out.println("memcache used");
            return new EbaCacheMemcache();
        } else if (ProbsValues.CACHE_FACTOR_NAME.equals(ProbsValues.CACHE_FACTOR_NAME_EHCACHE)) {
            System.out.println("ehcache used");
            return new EbaCacheEhcache();
        } else if (ProbsValues.CACHE_FACTOR_NAME.equals(ProbsValues.NONE)) {
            System.out.println("no cache used");
            return new EbaCacheNone();
        }else {
            throw new RuntimeException("Configurable cache not found");
        }
    }

    public static EbaCacheFactory getInstance() {
        if (_ebaCacheFactory == null) {
            _ebaCacheFactory = new EbaCacheFactory();
        }
        return _ebaCacheFactory;

    }
}
