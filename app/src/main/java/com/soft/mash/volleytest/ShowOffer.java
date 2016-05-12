package com.soft.mash.volleytest;

/**
 * Created by mash on 5/12/16.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import utils.MyDataFetchHandler;
import utils.MyJSONRequest;



public class ShowOffer extends AppCompatActivity{

    TextView name, shortDescription, start, end;
    Button details;
    ImageView image;
    final static String url = "http://marsweather.ingenology.com/v1/latest/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.offer);
        name = (TextView) findViewById(R.id.offerName);
        shortDescription = (TextView) findViewById(R.id.offer_description);
        start = (TextView) findViewById(R.id.offer_start_date);
        end = (TextView) findViewById(R.id.offer_expire_date);
        details = (Button) findViewById(R.id.offerDetails);
        image = (ImageView) findViewById(R.id.offerImage);
        MyDataFetchHandler handler = MyDataFetchHandler.getInstance();

        MyJSONRequest request = new MyJSONRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(ShowOffer.this, "Request Responsed", Toast.LENGTH_SHORT).show();
                name.setText("Volley Request worked");
               /* Offer offer = (new OfferJSONParser()).getOffer(response);
                name.setText(offer.name); */
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                details.setText("VolleyError");
                error.printStackTrace();
            }
        }
        );

        request.setPriority();
        handler.add(request);
    }
}
