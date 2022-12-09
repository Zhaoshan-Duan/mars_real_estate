/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android.marsrealestate.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

// Hold Network Layer

// Root web address of the Mars server endpoint
private const val BASE_URL = "https://mars.udacity.com/"

// Create Retrofit object using builder with ScalarConverterFactory and BASE_URL
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

// An interface explains how retrofit talks to web services using HTTP requests
interface MarsApiService{

    // request the JSON response string
    @GET("realestate") // "realstate" end point is appended to the URL when this method is called
    fun getProperties():
            Call<String> // Call object is used to create request

}

// Create MarsApi object using Retrofit to implement the MarsApiService
object MarsApi{
    val retrofitService: MarsApiService by lazy {
        // initialize using MarsApiService interface
        retrofit.create(MarsApiService::class.java)
    }
}
