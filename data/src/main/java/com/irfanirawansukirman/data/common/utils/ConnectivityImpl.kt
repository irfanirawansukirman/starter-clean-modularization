package com.irfanirawansukirman.data.common.utils

import android.content.Context
import com.irfanirawansukirman.data.common.checkNetworkStatus

class ConnectivityImpl(private val context: Context) : Connectivity {

    override fun isNetworkAvailable() = checkNetworkStatus(context)

}