package uz.abbosbek.retrofitcustomrequestheaders.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap
import uz.abbosbek.retrofitcustomrequestheaders.models.Post

interface SimpleApi {

    @GET("/posts")
    suspend fun getPost(): Response<List<Post>>

//    @GET("post/{postNumber}")
//    suspend fun getPost2(
//        @Path("postNumber") number: Int
//    ): Response<Post>
//
//    @GET("posts")
//    suspend fun getCustomPosts(
//        @Query("userId") userId: Int,
//        @Query("_sort") sort: String,
//        @Query("_order") order: String,
//    ): Response<List<Post>>
//
//    @GET("posts")
//    suspend fun getCustomPosts2(
//        @Query("userId") userId: Int,
//        @QueryMap option: Map<String, String>
//    ): Response<List<Post>>
//
//    @POST("posts")
//    suspend fun pushPost(
//        @Body post: Post
//    ): Response<Post>
//
//    @FormUrlEncoded
//    @POST("posts")
//    suspend fun pushPost2(
//        @Field("userId") userId: Int,
//        @Field("id") id: Int,
//        @Field("title") title: String,
//        @Field("body") body: String
//    ): Response<Post>
}