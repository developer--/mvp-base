package app.awesomethings.com.injection.component

import app.awesomethings.com.base.BaseView
import app.awesomethings.com.injection.module.ContextModule
import app.awesomethings.com.injection.module.NetworkModule
import app.awesomethings.com.ui.presenter.PostPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, NetworkModule::class])
interface PresenterInjector {

    fun inject(postPresenter: PostPresenter)


    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder

        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}