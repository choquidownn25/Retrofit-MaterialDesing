package com.mateoj.gridviewrecicleyview.configuracion;

import com.mateoj.gridviewrecicleyview.ui.modelo.Comida;
import com.mateoj.gridviewrecicleyview.ui.modelo.ListaDato;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/*Conecion al servidor web*/
public interface ApiInterface {

//    Call<List<ListaDato>>getImgDato();
    @GET("androidweb.php")
    Call<List<Comida>>getImgDato();
}
