package com.mateoj.gridviewrecicleyview.ui.fragmento;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mateoj.gridviewrecicleyview.R;
import com.mateoj.gridviewrecicleyview.ui.adaptador.AdaptadorInicio;
import com.mateoj.gridviewrecicleyview.ui.modelo.Comida;
import com.mateoj.gridviewrecicleyview.ui.modelo.ListaDato;

import java.util.List;

/**
 * Fragmento para la sección de "Inicio"
 */
public class FragmentoInicio extends Fragment {
    private RecyclerView reciclador;
    private LinearLayoutManager layoutManager;
    private AdaptadorInicio adaptador;
    private List<Comida> listData;
    public FragmentoInicio() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_inicio, container, false);

        reciclador = (RecyclerView) view.findViewById(R.id.reciclador);
        layoutManager = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(layoutManager);

        adaptador = new AdaptadorInicio( listData);
        reciclador.setAdapter(adaptador);
        return view;
    }
}
