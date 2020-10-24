package com.example.androidsimulation.network

import com.example.androidsimulation.pojos.AndroidDetails
import com.example.androidsimulation.pojos.Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsAPI {

    // Mostrar listado de productos
    @GET("/Himuravidal/FakeAPIdata/products")
    fun allProducts(): Call<Products>

    // Mostrar detalle de productos por id
    @GET("/Himuravidal/FakeAPIdata/details/{id}")
    fun idDetails(@Path("id") idDetailsProducts: Int ): Call<AndroidDetails>

}