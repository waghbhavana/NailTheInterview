package com.bhavanawagh.nailtheinterview.api

import com.bhavanawagh.nailtheinterview.models.QuestionListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface QuestionsApi {

    @GET("/v3/b/65f9de6e266cfc3fde9ac9c9?meta=false")
  suspend fun getQuestions(@Header("X-JSON-Path") category: String) : Response<List<QuestionListItem>>


  @GET("/v3/b/65f9de6e266cfc3fde9ac9c9?meta=false")
  @Headers("X-JSON-path:questions..category")
  suspend fun getCategory() : Response<List<String>>

}