package com.ethadien.disney

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.ethadien.disney.databinding.SlideItemContainerBinding
import com.makeramen.roundedimageview.RoundedImageView

class SliderAdapter(var mContext : Context, var imageList : List<Int>) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    inner class SliderViewHolder(binding:SlideItemContainerBinding) : RecyclerView.ViewHolder(binding.root) {

        var roundedImage : RoundedImageView = binding.imageSlideRounded

        fun setImage(image : Int){
            roundedImage.setImageResource(image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val binding = SlideItemContainerBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return SliderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        val components = holder.setImage(imageList[position])

    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}