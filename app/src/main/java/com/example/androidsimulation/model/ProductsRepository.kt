package com.example.androidsimulation.model

import android.util.Log
import com.example.androidsimulation.model.localRoom.ProductsDAO
import com.example.androidsimulation.model.localRoom.ProductEntity
import com.example.androidsimulation.model.network.RetrofitClient
import com.example.androidsimulation.model.pojos.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class ProductsRepository(private val productsDAO: ProductsDAO) {

    // Union de la API con el cliente Retrofit
    private val retroService = RetrofitClient.getRetrofitClient()
    // Traer tabla de peliculas Entity
    val allProductsLiveData = productsDAO.showAllProducts()

    fun getAllProductsFromServer(){
        val call = retroService.allProducts()
        call.enqueue(object : retrofit2.Callback<List<Product>>{
            override fun onResponse(
                call: Call<List<Product>>,
                response: Response<List<Product>>
            ) {
                when(response.code()) {
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        Log.d("RESPONSEOK", response.body().toString())
                        response.body()?.let {
                            productsDAO.insertAllProducts(convert(it))
                        }
                    }
                    in 300..399 -> Log.d("Response", response.errorBody().toString())
                    else -> Log.d("Error300!", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.e("ERROR!", t.message.toString())
            }
        })
    }

    fun convert(listFromNetwork:List<Product>): List<ProductEntity> {
        val listMutable = mutableListOf<ProductEntity>()

        listFromNetwork.map {
            listMutable.add(ProductEntity(it.id,
            it.image,
            it.name,
            it.price))
        }
        return listMutable
        }


    }
