package com.example.pocs

import android.graphics.BlurMaskFilter
import android.graphics.MaskFilter
import android.text.SpannableString
import android.text.Spanned
import android.text.style.MaskFilterSpan

fun String.maskText(maskText : Boolean): SpannableString {
    val string = SpannableString(this)
    if (maskText) {
        val blurMask: MaskFilter = BlurMaskFilter(20f, BlurMaskFilter.Blur.NORMAL)
        string.setSpan(
            MaskFilterSpan(blurMask),
            0,
            string.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }
    return string
}