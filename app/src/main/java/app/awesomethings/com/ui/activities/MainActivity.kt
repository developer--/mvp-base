package app.awesomethings.com.ui.activities

import android.os.Bundle
import android.util.Log
import app.awesomethings.com.R
import app.awesomethings.com.base.BaseActivity
import app.awesomethings.com.model.Post
import app.awesomethings.com.ui.PostView
import app.awesomethings.com.ui.presenter.PostPresenter

class MainActivity : BaseActivity<PostPresenter>(), PostView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun updatePosts(posts: List<Post>) {
        Log.e("LIFECYCLE ", "updatePosts development")
        posts.forEach {
            Log.e("POST_ITEMS ", it.toString())
        }
    }

    override fun showError(error: String) {
        Log.e("LIFECYCLE ", "showError $error")
    }

    override fun showLoading() {
        Log.e("LIFECYCLE ", "showLoading")
    }

    override fun hideLoading() {
        Log.e("LIFECYCLE ", "hideLoading")
    }

    override fun instantiatePresenter(): PostPresenter {
        return PostPresenter(this)
    }

}
