package fr.meteordesign.personaapp.ui.customcomponent

import android.graphics.*
import android.support.annotation.IntDef

private const val projection = 1000F

class TriangleBitmap {

    var params = Params(Params.LEFT, Params.TOP, PointF(0F, 0F), 90F, 45F)

    private lateinit var bitmap: Bitmap
    private lateinit var canvas: Canvas
    private val path = Path()
    var paint = Paint()

    fun onDraw(): Bitmap {
        canvas.drawPath(path, paint)
        return bitmap
    }

    fun onSizeChanged(width: Int, height: Int) {
        val triangle = calculateTriangle(width, height)

        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        canvas = Canvas(bitmap)
        refreshPath(triangle)
    }

    private fun calculateTriangle(width: Int, height: Int): Triangle {
        val vertex0 = calculateP0(width, height)

        val halfAngle = params.angle / 2
        val vertex1 = calculateP1(vertex0, params.orientation - halfAngle)
        val vertex2 = calculateP1(vertex0, params.orientation + halfAngle)

        return Triangle(vertex0, vertex1, vertex2)
    }

    private fun calculateP0(width: Int, height: Int): PointF {
        val p0 = PointF()
        p0.x = if (params.posHorizontal == Params.LEFT) params.shift.x else width - params.shift.x
        p0.y = if (params.posVertical == Params.TOP) params.shift.y else height - params.shift.y

        return p0
    }

    private fun calculateP1(p0: PointF, angle: Float): PointF {
        val p1 = PointF()
        p1.x = calculateX1(p0.x, angle, projection)
        p1.y = calculateY1(p0.y, angle, projection)

        return p1
    }

    private fun calculateX1(x0: Float, angle: Float, distance: Float): Float =
            (distance * Math.cos(Math.toRadians(angle.toDouble())) + x0).toFloat()

    private fun calculateY1(y0: Float, angle: Float, distance: Float): Float =
            (distance * Math.sin(Math.toRadians(angle.toDouble())) + y0).toFloat()

    private fun refreshPath(triangle: Triangle) {
        path.reset()
        path.moveTo(triangle.vertex0.x, triangle.vertex0.y)
        path.lineTo(triangle.vertex1.x, triangle.vertex1.y)
        path.lineTo(triangle.vertex2.x, triangle.vertex2.y)
        path.close()
    }

    data class Params(
            @PositionHorizontal
            val posHorizontal: Long,
            @PositionVertical
            val posVertical: Long,
            val shift: PointF,
            val angle: Float,
            val orientation: Float) {

        companion object {
            const val TOP = 0L
            const val BOTTOM = 1L

            @IntDef(TOP, BOTTOM)
            @Retention(AnnotationRetention.SOURCE)
            annotation class PositionHorizontal

            const val LEFT = 0L
            const val RIGHT = 1L

            @IntDef(LEFT, RIGHT)
            @Retention(AnnotationRetention.SOURCE)
            annotation class PositionVertical
        }
    }

    private data class Triangle(
            val vertex0: PointF,
            val vertex1: PointF,
            val vertex2: PointF)
}