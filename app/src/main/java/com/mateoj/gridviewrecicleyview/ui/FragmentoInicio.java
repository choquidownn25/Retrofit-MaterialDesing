package com.mateoj.gridviewrecicleyview.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mateoj.gridviewrecicleyview.R;
import com.mateoj.gridviewrecicleyview.configuracion.ApiInterface;
import com.mateoj.gridviewrecicleyview.configuracion.RetrofitInstancia;
import com.mateoj.gridviewrecicleyview.ui.adaptador.AdaptadorInicio;
import com.mateoj.gridviewrecicleyview.ui.modelo.Comida;
import com.mateoj.gridviewrecicleyview.ui.modelo.ListaDato;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Fragmento para la sección de "Inicio"
 */
public class FragmentoInicio extends Fragment {

    //<editor-fold desc="Atributos">
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private AdaptadorInicio adaptadorInicio;
    private Context context;
    private List<Comida> listData;
    private ApiInterface apiInterface;
    //</editor-fold>

//    Constructor
    public FragmentoInicio(){

    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup,
                             Bundle savedInstanceState){
        View view = layoutInflater.inflate(R.layout.fragmento_inicio, viewGroup, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.reciclador);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        context= getContext();



        apiInterface= RetrofitInstancia.getRetrofitInstance().create(ApiInterface.class);
        Call<List<Comida>> call=apiInterface.getImgDato();
        call.enqueue(new  Callback<List<Comida>>() {

            @Override
            public void onResponse(Call<List<Comida>> call, Response<List<Comida>> response) {
                listData=response.body();
                adaptadorInicio = new AdaptadorInicio( listData);

            }

            @Override
            public void onFailure(Call<List<Comida>> call, Throwable t) {
                Toast.makeText(getContext(), getString(R.string.errordatos) + t.getMessage() ,Toast.LENGTH_LONG).show();

            }
        });

        recyclerView.setAdapter(adaptadorInicio);
        return  view;
    }
}
