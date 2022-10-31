package com.example.mobicomposeapp.utils

import android.content.Context
import android.widget.Toast


enum class ToastDuration(val value: Int) {
    SHORT(0),
    LONG(1)
}

fun Context.toast(
    message: String,
    duration: ToastDuration = ToastDuration.LONG
) = Toast.makeText(this, message, duration.value).show()
