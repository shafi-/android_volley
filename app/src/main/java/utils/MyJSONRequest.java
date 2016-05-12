package utils;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * Created by mash on 5/12/16.
 */
public class MyJSONRequest extends JsonObjectRequest {

    private Priority priority;
    public MyJSONRequest(int method, String url, JSONObject jsonRequest, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    public void setPriority() {
        priority = (priority == null ) ? Priority.NORMAL : priority;
    }

}
