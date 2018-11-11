package app.awesomethings.com.ui

import android.support.annotation.StringRes
import app.awesomethings.com.base.BaseView
import app.awesomethings.com.model.Post

interface PostView : BaseView {

    fun updatePosts(posts: List<Post>)

    fun showError(error: String)

    fun showError(@StringRes errorResId: Int){
        this.showError(getContext().getString(errorResId))
    }

    fun showLoading()

    fun hideLoading()
}