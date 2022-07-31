package com.sarang.screen_picturepage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.example.torang_core.data.model.ReviewImage
import com.example.torang_core.util.Logger
import com.sarang.screen_picturepage.databinding.PictureFragmentBinding

class PicturePagerRvAdt() : RecyclerView.Adapter<PicturePagerViewHolder>() {
    private var pictures = emptyList<ReviewImage>()
    fun setPictures(pictures: List<ReviewImage>) {
        this.pictures = pictures
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return pictures.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicturePagerViewHolder {
        return PicturePagerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.picture_fragment, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PicturePagerViewHolder, position: Int) {
        holder.pictureBody(pictures[position])
    }
}

class PicturePagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var binding: PictureFragmentBinding = PictureFragmentBinding.bind(itemView)

    fun pictureBody(reviewImage: ReviewImage) {
        Logger.d(reviewImage)
        binding.picture = reviewImage
    }


}