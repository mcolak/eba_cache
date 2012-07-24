package tr.gov.eba.util;

import tr.gov.eba.util.StringUtil;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author murat
 */
public class ConfigReader {

    public static String readExternal(String key) {
        String prob = null;
        ClassLoader parentLoader = Thread.currentThread().getContextClassLoader();
        // 
        Properties properties = new Properties();
        try {

            String globalLibDir = getParentPath(ConfigReader.class.getClassLoader(), ConfigReader.class.getName());

            int pos = globalLibDir.lastIndexOf(".jar!");

            if (pos == -1) {
                pos = globalLibDir.lastIndexOf(".jar/");
            }

            pos = globalLibDir.lastIndexOf(CharPool.SLASH, pos);

            globalLibDir = globalLibDir.substring(0, pos + 1);

            URL url = new URL("file://" + globalLibDir + "ebaconfig-ext.properties");

            if (url != null) {
                InputStream inputStream = url.openStream();
                properties.load(inputStream);
                inputStream.close();
                prob = properties.getProperty(key);
            } else {
            }
            //*/
        } catch (Exception re) {
            
        }
        return prob;
    }

    public static String getParentPath(
            ClassLoader classLoader, String className) {


        if (!className.endsWith(_CLASS_EXTENSION)) {
            className += _CLASS_EXTENSION;
        }

        className = StringUtil.replace(
                className, CharPool.PERIOD, CharPool.SLASH);

        className = StringUtil.replace(className, "/class", _CLASS_EXTENSION);

        URL url = classLoader.getResource(className);

        String path = null;

        try {
            path = url.getPath();

            URI uri = new URI(path);

            String scheme = uri.getScheme();

            if (path.contains(EXCLAMATION)
                    && ((scheme == null) || (scheme.length() <= 1))) {

                if (!path.startsWith(SLASH)) {
                    path = SLASH + path;
                }
            } else {
                path = uri.getPath();

                if (path == null) {
                    path = url.getFile();
                }
            }
        } catch (URISyntaxException urise) {
            path = url.getFile();
        }





        int pos = path.indexOf(className);

        String parentPath = path.substring(0, pos);

        if (parentPath.startsWith("jar:")) {
            parentPath = parentPath.substring(4, parentPath.length());
        }

        if (parentPath.startsWith("file:/")) {
            parentPath = parentPath.substring(6, parentPath.length());
        }



        return parentPath;
    }
    public static final String SLASH = "/";
    public static final String EXCLAMATION = "!";
    private static final String _CLASS_EXTENSION = ".class";
}
