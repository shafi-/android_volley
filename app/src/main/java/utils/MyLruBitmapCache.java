package utils;

/**
 * Created by mash on 5/12/16.
 */
public class MyLruBitmapCache {

    private static MyLruBitmapCache ourInstance = new MyLruBitmapCache();

    public static MyLruBitmapCache getInstance() {
        return ourInstance;
    }

    private MyLruBitmapCache() {
    }
}
