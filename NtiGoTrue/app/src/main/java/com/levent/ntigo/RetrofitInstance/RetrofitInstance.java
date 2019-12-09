package com.levent.ntigo.RetrofitInstance;

import com.levent.ntigo.Interfaces.PostAppInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit=null;
    private static String BASE_URL="http://147.0.27.208";
    //private static String BASE_URL;


    public static PostAppInterface getService()
    {

        if(retrofit==null)
        {
            retrofit=new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(PostAppInterface.class);
    }
}
