package com.example.androidsimulation.model.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.androidsimulation.model.ProductsRepository
import com.example.androidsimulation.model.localRoom.ProductEntity
import com.example.androidsimulation.model.localRoom.ProductsDataBase

class ProductsViewModel(application: Application) : AndroidViewModel(application){
    private val mRepository: ProductsRepository
    val liveDataFromLocal : LiveData<List<ProductEntity>>

    init {
        val productsDAO = ProductsDataBase.getDataBase(application).productsDAO()
        mRepository = ProductsRepository(productsDAO)
        mRepository.getAllProductsFromServer()
        liveDataFromLocal = mRepository.allProductsLiveData
    }
}