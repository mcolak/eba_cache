/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.eba.util;

/**
 *
 * @author murat
 */
public class ProbsValues {

    public final static String CACHE_FACTOR_NAME = PropsUtil.getStringValue(ProbsKeys.CACHE_FACTOR_NAME);
    public final static String CACHE_FACTOR_NAME_HAZELCAST = "tr.gov.eba.cache.hazelcast";
    public final static String CACHE_FACTOR_NAME_MEMCACHE = "tr.gov.eba.cache.memcache";
    public final static String CACHE_FACTOR_NAME_EHCACHE = "tr.gov.eba.cache.ehcache";
    public final static String NONE = "none";
    public final static String CACHE_FACTOR_NAME_HAZELCASTCLIENT = "tr.gov.eba.cache.hazelcastcilent";
  
    public final static String MEMCACHE_SERVER_ADRESSES=PropsUtil.getStringValue(ProbsKeys.MEMCACHE_SERVER_ADRESSES);
}
