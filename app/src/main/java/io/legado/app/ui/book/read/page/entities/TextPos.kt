package io.legado.app.ui.book.read.page.entities

import androidx.annotation.Keep

/**
 * 每一个文字的位置信息
 */
@Keep
@Suppress("unused")
data class TextPos(
    var relativePagePos: Int,//所在的page
    var lineIndex: Int,//所在函数
    var columnIndex: Int,//所在列数
    var isTouch: Boolean = true,
    var isLast: Boolean = false
) {

    fun upData(
        relativePos: Int,
        lineIndex: Int,
        charIndex: Int,
        isTouch: Boolean,
        isLast: Boolean
    ) {
        this.relativePagePos = relativePos
        this.lineIndex = lineIndex
        this.columnIndex = charIndex
        this.isTouch = isTouch
        this.isLast = isLast
    }

    fun upData(pos: TextPos) {
        relativePagePos = pos.relativePagePos
        lineIndex = pos.lineIndex
        columnIndex = pos.columnIndex
        isTouch = pos.isTouch
        isLast = pos.isLast
    }

    fun compare(pos: TextPos): Int {
        return when {
            relativePagePos < pos.relativePagePos -> -3
            relativePagePos > pos.relativePagePos -> 3
            lineIndex < pos.lineIndex -> -2
            lineIndex > pos.lineIndex -> 2
            columnIndex < pos.columnIndex -> -1
            columnIndex > pos.columnIndex -> 1
            else -> 0
        }
    }

    fun compare(relativePos: Int, lineIndex: Int, charIndex: Int): Int {
        return when {
            this.relativePagePos < relativePos -> -3
            this.relativePagePos > relativePos -> 3
            this.lineIndex < lineIndex -> -2
            this.lineIndex > lineIndex -> 2
            this.columnIndex < charIndex -> -1
            this.columnIndex > charIndex -> 1
            else -> 0
        }
    }
}