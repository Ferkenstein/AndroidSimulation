package com.example.androidsimulation.model.network

import com.example.androidsimulation.model.pojos.AndroidDetails
import com.example.androidsimulation.model.pojos.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductAPI {

    // Mostrar listado de productos
    @GET("/Himuravidal/FakeAPIdata/products")
    fun allProducts(): Call<List<Product>>

    // Mostrar detalle de productos por id
    @GET("/Himuravidal/FakeAPIdata/details/{id}")
    fun idDetails(@Path("id") idDetailsProducts: Int ): Call<AndroidDetails>

}