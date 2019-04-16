package com.mateoj.gridviewrecicleyview.ui.adaptador;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mateoj.gridviewrecicleyview.R;
import com.mateoj.gridviewrecicleyview.ui.modelo.Comida;
import com.mateoj.gridviewrecicleyview.ui.modelo.ListaDato;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdaptadorCategoriass extends ArrayAdapter <ListaDato >{

//    public class AdaptadorInicio extends RecyclerView.Adapter<AdaptadorInicio.ViewHolder>
    private List<ListaDato> listData;
    private Context context;
    int resource;


    public AdaptadorCategoriass(@NonNull Context context, int resource, @NonNull List<ListaDato> listData) {
        super(context, resource, listData);
        this.context=context;
        this.resource=resource;
        this.listData=listData;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView==null){
            LayoutInflater layoutInflater=(LayoutInflater)getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.list_data,null,true);
        }
        ListaDato listdata=getItem(position);
        ImageView img=(ImageView)convertView.findViewById(R.id.image_view);
        Picasso.get()
                .load(listdata.getImageurl())
                .into(img);


        return convertView;
    }
}
