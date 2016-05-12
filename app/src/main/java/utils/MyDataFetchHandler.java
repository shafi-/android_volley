package utils;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by mash on 5/12/16.
 */
public class MyDataFetchHandler extends Application{

    final static String TAG = MyDataFetchHandler.class.getName();
    private static MyDataFetchHandler ourInstance = new MyDataFetchHandler();
    RequestQueue requestQueue;

    public MyDataFetchHandler() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance = this;
        requestQueue = Volley.newRequestQueue(this);
    }

    public synchronized static MyDataFetchHandler getInstance() {
        return ourInstance;
    }

    public RequestQueue getRequestQueue()
    {
        return  requestQueue;
    }

    public <T> void add(Request<T> request)
    {
        getRequestQueue().add(request);
    }

    public void cancel()
    {
        getRequestQueue().cancelAll(TAG);
    }
}
