package org.gsm.software.highthon.viewmodel.activity

import android.content.ContentValues.TAG
import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.gsm.software.highthon.model.schoolinfo.Row
import org.gsm.software.highthon.model.schoolinfo.SchoolInfo
import org.gsm.software.highthon.retrofit.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class SearchViewModel : ViewModel() {

    private val _items = MutableLiveData<List<Row>>()
    val items: LiveData<List<Row>> get() = _items

    private val _schoolCode = MutableLiveData<String>()
    private val _schoolDistrict = MutableLiveData<String>()
    private val _searchVisible = MutableLiveData<Boolean>()
    private val _searchTextVisible = MutableLiveData<Boolean>()

    val schoolCode: LiveData<String>
        get() = _schoolCode
    val schoolDistrict: LiveData<String>
        get() = _schoolDistrict
    val searchVisible: LiveData<Boolean>
        get() = _searchVisible
    val searchTextVisible: LiveData<Boolean>
        get() = _searchTextVisible

    init {
        _searchVisible.value = false
        _searchTextVisible.value = false
    }


    fun getSchoolInfo(school: String) {
        RetrofitBuilder.api.getSchoolInfo(school_name = school)
            .enqueue(object : Callback<SchoolInfo> {
                override fun onResponse(call: Call<SchoolInfo>, response: Response<SchoolInfo>) {
                    try {
                        if (response.isSuccessful) {
                            val res = response.body()!!.schoolInfo[1].row
                            Log.d(TAG, "onResponse: ${res.size}")
                            _items.value = res!!
                            _schoolCode.value = res[0].SD_SCHUL_CODE
                            _schoolDistrict.value = res[0].ATPT_OFCDC_SC_CODE
                            _searchVisible.value = true
                            _searchTextVisible.value = false

                        }
                    } catch (e: Exception) {
                        _searchTextVisible.value = true
                        _searchVisible.value = false

                        Log.d(TAG, "실패: $e")
                    }
                }

                override fun onFailure(call: Call<SchoolInfo>, t: Throwable) {
                    Log.d(TAG, "onFailure: $t")
                }

            })
    }

}