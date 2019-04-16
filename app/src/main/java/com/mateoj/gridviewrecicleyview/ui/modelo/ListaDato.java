package com.mateoj.gridviewrecicleyview.ui.modelo;
import com.google.gson.annotations.SerializedName;
import com.mateoj.gridviewrecicleyview.R;

import java.util.ArrayList;
import java.util.List;

public class ListaDato {

    @SerializedName("imageurl")
    private String imageurl;



    public ListaDato(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getImageurl() {
        return imageurl;
    }
}
