package com.ethadien.disney

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ethadien.disney.databinding.RecyclerContentHolderBinding
import com.makeramen.roundedimageview.RoundedImageView

class RecyclerAdapter(var mContext : Context, var imageList : List<Int>) : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    inner class RecyclerViewHolder(binding: RecyclerContentHolderBinding) : RecyclerView.ViewHolder(binding.root)
    {

        var roundedImage : RoundedImageView = binding.RoundedItem

        fun setImage(image : Int){
            roundedImage.setImageResource(image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder
    {
        val binding = RecyclerContentHolderBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int)
    {
        val components = holder.setImage(imageList[position])

        holder.roundedImage.setImageResource(imageList.get(position))

    }

    override fun getItemCount(): Int
    {
        return imageList.size
    }
}