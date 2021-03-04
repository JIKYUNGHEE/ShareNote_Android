package com.snc.sharenote.utils

import android.os.Build
import android.text.Html
import android.text.Spanned

fun String?.notEmptyString(callback: (String) -> Unit) {
    if (!this.isNullOrEmpty()) {
        callback(this!!)
    }
}

fun String?.htmlToSpanned(): Spanned {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
        return Html.fromHtml(this)
    }
    return Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
}
