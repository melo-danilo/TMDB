package com.draccoapp.movieapp.api.request

import com.draccoapp.movieapp.api.retrofit.RetrofitConfiguration

class ApiRequest {

    fun <S> getService(service: Class<S>): S {
        return RetrofitConfiguration.createService(service)
    }

}