package com.example.androidsimulation.model.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidsimulation.R
import com.example.androidsimulation.model.localRoom.ProductEntity
import com.example.androidsimulation.model.viewModel.ProductsViewModel
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), ProductsAdapter.IPassTheData {

    lateinit var mViewModel : ProductsViewModel
    lateinit var mAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)
        mAdapter = ProductsAdapter(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = mRecycler
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        mViewModel.liveDataFromLocal.observe(viewLifecycleOwner, Observer {
            Log.d("FromDataBase", it.toString())
            mAdapter.updateAdapter(it)
        })
    }

    override fun passTheProducts(product: ProductEntity) {
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }
}