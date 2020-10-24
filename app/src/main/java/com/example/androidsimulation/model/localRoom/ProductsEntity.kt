package com.example.androidsimulation.model.localRoom

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Products_table")
data class ProductsEntity(@PrimaryKey @NonNull val id: Int,
                                 val image: String,
                                 val name: String,
                                 val price: Int
)
