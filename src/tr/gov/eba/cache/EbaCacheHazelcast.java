/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.eba.cache;

import com.hazelcast.config.FileSystemXmlConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.IMap;
import java.io.File;
import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author murat
 */
public class EbaCacheHazelcast implements EbaCache {

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

        try {

            IMap iMap = Hazelcast.getMap(cacheTime.name());

            // Future<String> future = iMap.getAsync(key);
            //return (String)iMap.get(key) ;
            return iMap.get(key);



        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void putValue(String key, Serializable object, CacheTime cacheTime) {
        try {

            IMap iMap = Hazelcast.getMap(cacheTime.name());
            iMap.putAsync(key, object);

        } catch (Exception e) {
        }
    }

    @Override
    public void remove(String key, CacheTime cacheTime) {
        try {

            Map map = Hazelcast.getMap(cacheTime.name());
            map.remove(key);

        } catch (Exception e) {
        }
    }

    @Override
    public void clearAll(CacheTime cacheTime) {

        try {

            Map map = Hazelcast.getMap(cacheTime.name());
            map.clear();

        } catch (Exception e) {
        }
    }

    @Override
    public void shutdown() {
        Hazelcast.shutdownAll();
    }

    @Override
    public void replace(String key, Serializable object, CacheTime cacheTime) {
        try {
            IMap iMap = Hazelcast.getMap(cacheTime.name());
            iMap.replace(key, object);

        } catch (Exception e) {
        }
    }
}
