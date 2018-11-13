package app.awesomethings.com.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<P: BasePresenter<BaseView>> : AppCompatActivity(), BaseView {

    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = instantiatePresenter()
    }

    protected abstract fun instantiatePresenter(): P

    override fun getContext() = this
}