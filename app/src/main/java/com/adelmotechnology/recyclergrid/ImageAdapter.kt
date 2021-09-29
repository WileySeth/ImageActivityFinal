package com.adelmotechnology.recyclergrid

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(var context: Context) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    var dataList = emptyList<DataModel>()

    internal fun setDataList(dataList: List<DataModel>) {
        this.dataList = dataList
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var title: TextView
        var desc: TextView

        init {
            image = itemView.findViewById(R.id.image)
            title = itemView.findViewById(R.id.title)
            desc = itemView.findViewById(R.id.desc)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.photo_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageAdapter.ViewHolder, position: Int) {
        var images = dataList[position]

        holder.title.text = images.title
        holder.desc.text = images.desc

        holder.image.setImageResource(images.image)

        holder.image.setOnClickListener(){
            (context as Activity).findViewById<ImageView>(R.id.myImageView).setImageResource(images.image)
            (context as Activity).findViewById<TextView>(R.id.title).text = images.title }
    }


    override fun getItemCount() = dataList.size
}