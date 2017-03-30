package com.vjam.demo.data.network;

import com.vjam.demo.data.db.item_model.Item;
import com.vjam.demo.util.AppConstants;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by anand.chandaliya on 30-03-2017.
 */

public interface ItemServices {



    @GET("58da40e30f0000b700d66adc")
    Observable<List<Item>> getItems();

    /******** Helper class that sets up a new services *******/
    class Creator {

        public static ItemServices newRibotsService() {
            /*Gson gson = new GsonBuilder()
                    .registerTypeAdapterFactory(MyGsonTypeAdapterFactory.create())
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();*/
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(AppConstants.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            return retrofit.create(ItemServices.class);
        }
    }
}
