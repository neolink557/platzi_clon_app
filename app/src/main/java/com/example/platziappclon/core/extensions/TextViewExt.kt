package com.example.platziappclon.core.extensions

import android.R.id
import android.text.SpannableStringBuilder
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.text.color
import com.example.platziappclon.R
import android.R.id.text2
import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan


fun TextView.changePartTextBold(textToChange : String)
{
    val spannableString = SpannableString(this.text)

    val startText = this.text.toString().indexOf(textToChange)
    spannableString.setSpan(
        StyleSpan(Typeface.BOLD), startText, startText + textToChange.length,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

    this.setText(spannableString, TextView.BufferType.SPANNABLE)
}

fun TextView.textToBold()
{
    val spannableString = SpannableString(this.text)

    spannableString.setSpan(StyleSpan(Typeface.BOLD), 0, this.text.toString().length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

    this.setText(spannableString, TextView.BufferType.SPANNABLE)
}

fun TextView.changePartTextColor(textToChange : String, colorHexadecimal : Int) {
    val spannableString = SpannableString(this.text)
    val startText = this.text.toString().indexOf(textToChange)
    spannableString.setSpan(
        ForegroundColorSpan(colorHexadecimal), startText, startText + textToChange.length,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

    this.setText(spannableString, TextView.BufferType.SPANNABLE)
}

fun TextView.changePartTextColorBoldSize(textToChange : String, colorHexadecimal : Int) {
    val spannableString = SpannableString(this.text)
    val startText = this.text.toString().indexOf(textToChange)
    spannableString.setSpan(
        ForegroundColorSpan(colorHexadecimal), startText, startText + textToChange.length,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

    spannableString.setSpan(
        StyleSpan(Typeface.BOLD), startText, startText + textToChange.length,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

    spannableString.setSpan(
        RelativeSizeSpan(1.5f), startText, startText + textToChange.length,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

    this.setText(spannableString, TextView.BufferType.SPANNABLE)

}

fun TextView.getTrimmedText() = this.text.toString().trim()