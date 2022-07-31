package com.sarang.screen_picturepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sarang.screen_picturepage.databinding.PictureFragmentBinding
import com.example.torang_core.data.model.Picture
import com.example.torang_core.data.model.ReviewImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PictureFragment : Fragment() {
    private var mViewModel: PictureViewModel? = null
    private var picture: ReviewImage? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = PictureFragmentBinding.inflate(layoutInflater, container, false)
        binding.picture = picture
        return binding.root
    }


    fun pictureBody(picture: ReviewImage?) {
        this.picture = picture
    }
}