package com.irfanirawansukirman.abstraction.base

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindLayoutId())
        onLoadObserver()
        setupViewListener()
        setupComponents()
    }

    @LayoutRes
    abstract fun bindLayoutId(): Int

    abstract fun setupViewListener()
    abstract fun onLoadObserver()
    abstract fun setupComponents()

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> false
    }

}