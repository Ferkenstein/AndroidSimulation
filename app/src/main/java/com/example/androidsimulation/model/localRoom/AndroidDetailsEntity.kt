package com.example.androidsimulation.model.localRoom

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "androidDetails_table")
data class AndroidDetailsEntity (@PrimaryKey @NonNull val id: Int,
                                 val image: String,
                                 val name: String,
                                 val description: String,
                                 val price: Int,
                                 val lastPrice: Int,
                                 val credit: Boolean
)
