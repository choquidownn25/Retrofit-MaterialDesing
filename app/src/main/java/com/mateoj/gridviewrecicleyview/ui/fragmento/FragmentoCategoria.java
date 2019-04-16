package com.mateoj.gridviewrecicleyview.ui.fragmento;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mateoj.gridviewrecicleyview.R;
import com.mateoj.gridviewrecicleyview.configuracion.ApiInterface;
import com.mateoj.gridviewrecicleyview.configuracion.RetrofitInstancia;
import com.mateoj.gridviewrecicleyview.ui.adaptador.AdaptadorCategorias;
import com.mateoj.gridviewrecicleyview.ui.adaptador.AdaptadorCategoriass;
import com.mateoj.gridviewrecicleyview.ui.adaptador.AdaptadorInicio;
import com.mateoj.gridviewrecicleyview.ui.modelo.Comida;
import com.mateoj.gridviewrecicleyview.ui.modelo.ListaDato;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Fragmento que representa el contenido de cada pestaña dentro de la sección "Categorías"
 */
public class FragmentoCategoria extends Fragment {

    private static final String INDICE_SECCION
            = "com.restaurantericoparico.FragmentoCategoriasTab.extra.INDICE_SECCION";

    private RecyclerView reciclador;
    private GridLayoutManager layoutManager;
    private AdaptadorCategorias adaptador;
    private List<Comida> listData;
    private ApiInterface apiInterface;
    private AdaptadorCategoriass adaptadorCategoriass;
    private AdaptadorInicio adaptadorInicio;
    private RecyclerView recyclerView;

    public static FragmentoCategoria nuevaInstancia(int indiceSeccion) {
        FragmentoCategoria fragment = new FragmentoCategoria();
        Bundle args = new Bundle();
        args.putInt(INDICE_SECCION, indiceSeccion);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_grupo_items, container, false);

        reciclador = (RecyclerView) view.findViewById(R.id.reciclador);
        layoutManager = new GridLayoutManager(getActivity(), 2);
        reciclador.setLayoutManager(layoutManager);

        int indiceSeccion = getArguments().getInt(INDICE_SECCION);

        switch (indiceSeccion) {
            case 0:

                apiInterface= RetrofitInstancia.getRetrofitInstance().create(ApiInterface.class);
                Call<List<Comida>> call=apiInterface.getImgDato();
                call.enqueue(new  Callback<List<Comida>>() {

                    @Override
                    public void onResponse(Call<List<Comida>> call, Response<List<Comida>> response) {
                        listData=response.body();

//                        adaptadorCategoriass = new AdaptadorCategoriass(getContext(), R.layout.list_data, listData);
                        adaptador = new AdaptadorCategorias(Comida.BEBIDAS);
                        reciclador.setAdapter(adaptador);
                    }

                    @Override
                    public void onFailure(Call<List<Comida>> call, Throwable t) {
                        Toast.makeText(getContext(), getString(R.string.errordatos) + t.getMessage() ,Toast.LENGTH_LONG).show();

                    }
                });

                break;
            case 1:
                adaptador = new AdaptadorCategorias(Comida.BEBIDAS);
                reciclador.setAdapter(adaptador);
                break;
            case 2:
                adaptador = new AdaptadorCategorias(Comida.POSTRES);
                reciclador.setAdapter(adaptador);
                break;
        }



        return view;
    }

}
