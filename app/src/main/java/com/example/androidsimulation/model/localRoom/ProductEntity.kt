package com.example.androidsimulation.model.localRoom

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_table")
data class ProductEntity(@PrimaryKey @NonNull val id: Int,
                         val image: String,
                         val name: String,
                         val price: Int
)
