package com.sarang.screen_picturepage

import androidx.lifecycle.*
import com.example.torang_core.data.model.Picture
import com.example.torang_core.data.model.ReviewImage
import com.example.torang_core.repository.PicturesRepository
import com.example.torang_core.util.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@HiltViewModel
class PicturePageViewModel @Inject constructor(
    private val picturesRepository: PicturesRepository
) :
    ViewModel() {
    private val reviewId = MutableLiveData<Int>()
    val pictures: LiveData<List<ReviewImage>> = reviewId.switchMap {
        picturesRepository.getFeedPicture(it)
    }
    val currentPosition = MutableLiveData<Int>()


    fun setCurrentPosition(currentPosition: Int) {
        this.currentPosition.value = currentPosition
    }

    fun loadPicture(reviewId: Int) {
        this.reviewId.postValue(reviewId)
    }
}