package com.example.androidsimulation.model.localRoom

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface ProductsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllProducts(mList: List<ProductsEntity>)

    @Query("SELECT * FROM products_table")
    fun showAllProducts(): LiveData<ProductsEntity>

    @Query("SELECT * FROM androidDetails_table")
    fun showOnProductsByID(mID: Int): LiveData<AndroidDetailsEntity>

}