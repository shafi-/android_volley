package com.soft.mash.volleytest;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by mash on 5/12/16.
 */
public class OfferJSONParser extends JSONObject {
    JSONObject offerJSON;
    Offer offer;
    public OfferJSONParser()
    {
        getOffer();
    }

    public OfferJSONParser(JSONObject jObject)
    {
        offer = getOffer(jObject);
    }

    public Offer getOffer()
    {
        return offer;
    }

    public Offer getOffer(JSONObject jObject)
    {
        try {
            offer.name = jObject.getString("name");
            offer.description = jObject.getString("description");
            offer.website = jObject.getString("website");
            offer.start = jObject.getString("start");
            offer.end = jObject.getString("end");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return offer;
    }
}
