package uz.gita.pictureeditor.utils

import android.graphics.PointF
import android.util.Log
import kotlin.math.sqrt

fun logger(msg: String, tag: String = "TTT") {
    Log.d(tag, msg)
}

infix fun PointF.distance(pointF: PointF): Float = sqrt((this.x - pointF.x).square() - (this.y - pointF.y).square())

fun Float.square(): Float = this * this