/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.eba.cache;

/**
 *
 * @author Murat Colak
 */
public enum CacheTime {

    DEFAULT(0), MIN15(15), MIN30(30), ONEHOUR(60), SIXHOUR(60 * 6), DAY(60 * 60);

    private CacheTime(int min) {
        this.min = min;
    }
    private int min;

    public int getMin() {
        return min;
    }
    /*
     public static CacheTime getType(int i) {
     if (i > CacheTime.values().length || i < 0) {
     return CacheTime.DEFAULT;
     }
     return CacheTime.values()[i];
     }
     */
}
