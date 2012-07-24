/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.eba.cache;

import com.hazelcast.client.ClientConfig;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.config.FileSystemXmlConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import java.io.File;
import java.io.Serializable;

/**
 *
 * @author murat
 */
public class EbaCacheHazelcastCilent implements EbaCache {

 

    static {
        try {
            File file = new File("hazelcast.xml");
            FileSystemXmlConfig fileSystemXmlConfig = new FileSystemXmlConfig(file);
            fileSystemXmlConfig.setLiteMember(true);
            Hazelcast.init(fileSystemXmlConfig);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getValue(String key, CacheTime cacheTime) {

        IMap iMap = Hazelcast.getMap(cacheTime.name());

        // Future<String> future = iMap.getAsync(key);
        //return (String)iMap.get(key) ;
        return iMap.get(key);


    }

    @Override
    public void putValue(String key, Serializable object, CacheTime cacheTime) {
        IMap iMap = Hazelcast.getMap(cacheTime.name());
        iMap.putAsync(key, object);
    }

    @Override
    public void replace(String key, Serializable object, CacheTime cacheTime) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(String key, CacheTime cacheTime) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clearAll(CacheTime cacheTime) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
