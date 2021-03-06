package one.hundred.core.extend

import java.text.NumberFormat
import java.util.*

fun String?.toLongOr(def: Long): Long {
    return try {
        this?.toLong() ?: def
    } catch (e: NumberFormatException) {
        def
    }
}

fun String?.toIntOr(def: Int): Int {
    return try {
        this?.toInt() ?: def
    } catch (e: NumberFormatException) {
        def
    }
}

fun String?.toDoubleOr(def: Double): Double {
    return try {
        this?.toDouble() ?: def
    } catch (e: NumberFormatException) {
        def
    }
}

fun Int.coerceInOr(range: ClosedRange<Int>, def: Int): Int {
    if (range.isEmpty()) return def
    return coerceIn(range)
}

operator fun Int.contains(i: Int): Boolean = (this and i) == i

operator fun Long.contains(i: Long): Boolean = (this and i) == i

fun Number.toLocalizedString(locale: Locale = Locale.getDefault()): String {
    val nf = NumberFormat.getInstance(locale)
    return nf.format(this)
}