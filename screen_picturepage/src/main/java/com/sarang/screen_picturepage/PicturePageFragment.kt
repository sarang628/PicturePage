package com.sarang.screen_picturepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.torang_core.util.Logger
import com.sarang.screen_picturepage.databinding.PicturePageFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PicturePageFragment : Fragment() {
    private val mViewModel: PicturePageViewModel by viewModels()
    lateinit var mBinding: PicturePageFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        mBinding = PicturePageFragmentBinding.inflate(layoutInflater, container, false)
        val adapter = PicturePagerRvAdt()
        mBinding.vpPicture.adapter = adapter

        Logger.d("review id is ${getRestaurantId()}")
        mViewModel.loadPicture(
            getRestaurantId()
        )

        mViewModel.setCurrentPosition(
            getPosition()
        )

        mViewModel.pictures.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.setPictures(it)
            }
        })

        return mBinding.root
    }

    private fun getRestaurantId(): Int {
        arguments?.let {
            return it.getInt("review_id")
        }
        return 0
    }

    fun getPosition(): Int {
        arguments?.let {
            return it.getInt("position")
        }
        return 0
    }

    override fun onDetach() {
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        super.onDetach()
    }

    companion object {
        fun go(fragmentManager: FragmentManager, layoutId: Int) {
            fragmentManager.beginTransaction()
                .add(layoutId, PicturePageFragment(), PicturePageFragment::class.java.simpleName)
                .addToBackStack(PicturePageFragment::class.java.simpleName)
                .commit()
        }
    }
}