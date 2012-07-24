/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.eba.util;

import java.util.ResourceBundle;

/**
 *
 * @author murat
 */
public class PropsUtil {
    static {
        System.out.println("Reading configuration file");
    }

    //TODO
    public static String getStringValue(String key) {

        String prob = ConfigReader.readExternal(key);
        if (prob == null) {
            ResourceBundle rb = ResourceBundle.getBundle("ebaconfig");
            prob = rb.getString(key);
        }
        return prob;
    }

    public static Double getDouble(String key) {
        try {
            return Double.parseDouble(getStringValue(key));
        } catch (Exception e) {
            return 0d;
        }
    }

    public static Integer getInteger(String key) {
        try {
            return Integer.parseInt(getStringValue(key));
        } catch (Exception e) {
            return 0;
        }
    }
}
