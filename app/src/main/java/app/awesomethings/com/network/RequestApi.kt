package app.awesomethings.com.network

import app.awesomethings.com.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface RequestApi {

    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}