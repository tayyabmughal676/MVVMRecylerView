package com.gaalbaat.mvvmrecylerview

import com.google.gson.Gson
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MoviesApi {

   /*
   * Http Get method
   *
   * Coroutines library suspend
   * suspend fun name
   *  return type Response  List <Model Class or Data Class>
   * */

    @GET("movies")
    suspend fun getMovies() : Response<List<Movies>>


    // https://api.simplifiedcoding.in/course-apis/recyclerview/movies
    companion object{
        // simple call MoviesApi then run Invoke fun return type MoviesApi
       operator fun invoke() : MoviesApi{
              /*
          return Retrofit . Builder()
            . AddConverterFactory (GsonConverterFactor.create())
            .baseUrl()
            .build()
            .create(Class name )
             */
         return Retrofit.Builder()
               .addConverterFactory(GsonConverterFactory.create())
               .baseUrl("https://api.simplifiedcoding.in/course-apis/recyclerview/")
               .build()
               .create(MoviesApi::class.java)
       }
    }
}