package org.gsm.software.highthon.retrofit

import retrofit2.http.GET
import javax.security.auth.callback.Callback

interface Api {
    @GET("")
    fun getApi(

    ):retrofit2.Callback<Any>
}