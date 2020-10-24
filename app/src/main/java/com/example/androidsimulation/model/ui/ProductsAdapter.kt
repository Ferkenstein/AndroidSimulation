package com.example.androidsimulation.model.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidsimulation.R
import com.example.androidsimulation.model.localRoom.ProductEntity
import com.example.androidsimulation.model.pojos.Product
import kotlinx.android.synthetic.main.product_list.view.*

class ProductsAdapter :RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {
    //Lista Vacia
    private var productsList = emptyList<ProductEntity>()
    // Actualización de datos
    fun updateAdapter(mList : List<ProductEntity>) {
        productsList = mList
        notifyDataSetChanged()
    }

    inner class ProductsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image = itemView.imageProduct
        val name = itemView.nameProduct
        val price = itemView.priceProduct
        val clickListener = itemView.setOnClickListener{
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list,parent,false)
        return ProductsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val product = productsList[position]
        Glide.with(holder.itemView.context).load(product.image).into(holder.image)
        holder.name.text = product.name
        holder.price.text = product.price.toString()
    }

    override fun getItemCount() = productsList.size

    interface passTheData {
        fun passTheProducts(product : ProductEntity)
    }
}
