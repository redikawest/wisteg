package com.example.wisteg.Rest;

import com.example.wisteg.ModelData.Wisata;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("wisata")
    Call<ArrayList<Wisata>> getAllWisata();

}
