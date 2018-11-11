package app.awesomethings.com.ui.presenter

import app.awesomethings.com.base.BasePresenter
import app.awesomethings.com.network.RequestApi
import app.awesomethings.com.ui.PostView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostPresenter(postView: PostView) : BasePresenter<PostView>(postView) {

    @Inject
    lateinit var requestApi: RequestApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadPosts()
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }

    fun loadPosts(){
        view.showLoading()
        subscription = requestApi.getPosts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { items -> view.updatePosts(items)},
                        { err -> view.showError(err.message ?: err.toString())}
                )
    }

}