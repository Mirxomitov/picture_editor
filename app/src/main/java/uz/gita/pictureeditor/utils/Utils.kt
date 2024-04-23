package uz.gita.pictureeditor.utils

import android.content.Context
import android.graphics.PointF
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlin.math.sqrt

fun logger(msg: String, tag: String = "TTT") {
    Log.d(tag, msg)
}

infix fun PointF.distance(pointF: PointF): Float = sqrt((this.x - pointF.x).square() - (this.y - pointF.y).square())

fun View.showSoftKeyboard() {
    post {
        if (this.requestFocus()) {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
        }
    }
}

fun Float.square(): Float = this * this