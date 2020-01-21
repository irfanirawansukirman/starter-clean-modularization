package com.irfanirawansukirman.auth

import com.irfanirawansukirman.abstraction.base.BaseActivity
import com.irfanirawansukirman.abstraction.common.ext.showToast

class AuthActivity : BaseActivity() {

    override fun bindLayoutId() = R.layout.activity_auth

    override fun setupViewListener() {

    }

    override fun onLoadObserver() {

    }

    override fun setupComponents() {
        val data = intent.data?.lastPathSegment ?: ""
        showToast(this, data)
    }

}
