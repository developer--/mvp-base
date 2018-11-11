package app.awesomethings.com.injection.module

import app.awesomethings.com.network.RequestApi
import app.awesomethings.com.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    fun provideRequestApi(retrofit: Retrofit): RequestApi {
        return retrofit.create(RequestApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }


}