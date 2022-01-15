package org.gsm.software.highthon.retrofit

import android.provider.Contacts.SettingsColumns.KEY
import org.gsm.software.highthon.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query
import javax.security.auth.callback.Callback

interface Api {
    @GET("hub/mealServiceDietInfo")
    fun getMeal(
        @Query("MLSV_YMD") day: String, // 급식 날짜
        @Query("MMEAL_SC_CODE") sc: Int, // 조식,점식,석식 코드
        @Query("KEY") key: String = "${BuildConfig.Key}",//자신의 api 인증키
        @Query("ATPT_OFCDC_SC_CODE") region: String,// 시교육청 코드
        @Query("SD_SCHUL_CODE") school: Int, //학교 코드
        @Query("Type") type: String = "json", //api를 json 형식으로 읽어오기
        @Query("pIndex") index: Int = 1,
        @Query("pSize") size: Int = 100
    ):retrofit2.Callback<Any>


    @GET("hub/schoolInfo")
    fun getSchoolInfo(
        @Query("Key") key: String = "${BuildConfig.Key}",
        @Query("Type") type: String = "json",
        @Query("SCHUL_NM") school_name: String,
        @Query("pIndex") index: Int = 1,
        @Query("pSize") size: Int = 100,
    ):retrofit2.Callback<Any>

}