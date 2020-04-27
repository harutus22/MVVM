package com.example.mvvm.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvvm.R
import com.example.mvvm.models.NicePlace
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerAdapter(private val mContext: Context, private val mNicePlaces: ArrayList<NicePlace>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_listitem, parent, false)
        val vh = ViewHolder(view)
        return vh
    }

    override fun getItemCount() = mNicePlaces.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mName.text = mNicePlaces[position].title

        val requestOptions = RequestOptions().error(R.drawable.ic_launcher_background)
        Glide.with(mContext).setDefaultRequestOptions(requestOptions)
            .load(mNicePlaces[position].imageUrl)
            .into(holder.mImage)
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val mImage: CircleImageView = view.findViewById(R.id.image)
        val mName: TextView = view.findViewById(R.id.image_name)
    }
}