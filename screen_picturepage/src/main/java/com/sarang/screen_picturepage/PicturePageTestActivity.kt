package com.sarang.screen_picturepage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.torang_core.navigation.PicturePageNavigation
import com.example.torang_core.util.Logger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject

@AndroidEntryPoint
class PicturePageTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_page_test)

        Logger.d("review id is ${intent.getIntExtra("review_id", 0)}")

        val fragment = PicturePageFragment().apply {
            arguments = Bundle().apply {
                putInt(
                    "review_id",
                    this@PicturePageTestActivity.intent.getIntExtra("review_id", 0)
                )
                putInt("position", this@PicturePageTestActivity.intent.getIntExtra("position", 0))
            }
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitAllowingStateLoss()
    }
}

@Module
@InstallIn(ActivityComponent::class)
abstract class PicturePageNavigationModule {
    @Binds
    abstract fun providePicturePageNavigation(picturePageNavigationimpl: PicturePageNavigationImpl): PicturePageNavigation

}

class PicturePageNavigationImpl @Inject constructor() : PicturePageNavigation {
    override fun go(context: Context, reviewId: Int, position: Int) {
        context.startActivity(Intent(context, PicturePageTestActivity::class.java).apply {
            putExtra("review_id", reviewId)
        })
    }
}