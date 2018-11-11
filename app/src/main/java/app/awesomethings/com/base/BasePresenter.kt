package app.awesomethings.com.base

import app.awesomethings.com.injection.component.DaggerPresenterInjector
import app.awesomethings.com.injection.component.PresenterInjector
import app.awesomethings.com.injection.module.ContextModule
import app.awesomethings.com.injection.module.NetworkModule
import app.awesomethings.com.ui.presenter.PostPresenter

abstract class BasePresenter<out V: BaseView>(protected val view: V) {

    private val injector: PresenterInjector = DaggerPresenterInjector.builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    open fun onViewCreated(){}

    open fun onViewDestroyed(){}

    private fun inject(){
        when(this){
            is PostPresenter -> injector.inject(this)
        }
    }
}