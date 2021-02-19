package com.udacoding.kotlinintermediate2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.udacoding.kotlinintermediate2.R
import com.udacoding.kotlinintermediate2.model.crud.DataItem
import kotlinx.android.synthetic.main.list_item.view.*

class ListViewAdapter(val list: List<DataItem>?,) : RecyclerView.Adapter<ListViewAdapter.ViewHolder>() {

    private var itemClick: OnItemClickCallback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list?.get(position)

        holder.nama.text = item?.nama
        holder.deskripsi.text = item?.deskripsi

        holder.itemView.setOnClickListener{
           itemClick?.onItemClicked(item)
        }
    }

    override fun getItemCount(): Int = list?.size ?: 0

    fun setOnItemCallback(onItemClickCallback: OnItemClickCallback){
        this.itemClick = onItemClickCallback
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v)  {
        val nama = v.tv_produk_name
        val deskripsi = v.tv_produk_deskripsion
    }

    interface OnItemClickCallback{
        fun onItemClicked(item: DataItem?)
    }
}