package org.gsm.software.highthon.view.activity

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.activity.viewModels
import org.gsm.software.highthon.R
import org.gsm.software.highthon.databinding.ActivitySearchBinding
import org.gsm.software.highthon.viewmodel.activity.SearchViewModel
import android.view.MotionEvent

import android.view.View.OnTouchListener
import org.gsm.software.highthon.adapter.SearchAdapter


class SearchActivity : AppCompatActivity() {

    private val viewModel: SearchViewModel by viewModels()
    private val binding by lazy { ActivitySearchBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.activity = this
        binding.vm = viewModel
        binding.lifecycleOwner = this
        setRecyclerView()
        searchSchool()

    }

    private fun setRecyclerView() {
        val adapter = SearchAdapter()
        binding.resultRecycler.adapter = adapter
        binding.resultRecycler.setHasFixedSize(true)
    }

    private fun searchSchool() {

        binding.searchSchool.setOnKeyListener { _, keyCode, event ->
            if ((event.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                if (binding.searchSchool.text.toString().isEmpty()) {
                    Toast.makeText(this, "학교를 입력 해주세요.", Toast.LENGTH_SHORT).show()
                    false
                } else {
                    viewModel.getSchoolInfo(binding.searchSchool.text.toString())
                    true
                }
            } else {
                false
            }
        }
    }

}