package com.mateoj.gridviewrecicleyview.configuracion;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*Archivo de configuracion del movil al servidor*/
public class RetrofitInstancia {

    private static Retrofit retrofit=null;
    private static final String BASE_URL = "http://uniqueandrocode.000webhostapp.com/hiren/androidtutorial/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
