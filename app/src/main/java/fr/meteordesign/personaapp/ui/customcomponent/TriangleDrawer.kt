package fr.meteordesign.personaapp.ui.customcomponent

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PointF
import android.support.annotation.IntDef

private const val projection = 1000F

class TriangleDrawer(width: Int, height: Int, private var params: Params) {

    private val path: Path

    init {
        val triangle = calculateTriangle(width, height)
        path = generatePath(triangle)
    }

    private fun calculateTriangle(width: Int, height: Int): Triangle {
        val vertex0 = findOrigin(width, height)

        val halfAngle = params.angle / 2
        val vertex1 = calculatePolarPoint(vertex0, params.orientation - halfAngle, projection)
        val vertex2 = calculatePolarPoint(vertex0, params.orientation + halfAngle, projection)

        return Triangle(vertex0, vertex1, vertex2)
    }

    private fun findOrigin(width: Int, height: Int): PointF {
        val p0 = PointF()
        p0.x = if (params.posHorizontal == Params.LEFT) params.shift.x else width - params.shift.x
        p0.y = if (params.posVertical == Params.TOP) params.shift.y else height - params.shift.y

        return p0
    }

    private fun calculatePolarPoint(p0: PointF, angle: Float, length: Float): PointF {
        val p1 = PointF()
        p1.x = calculateX1(p0.x, angle, length)
        p1.y = calculateY1(p0.y, angle, length)

        return p1
    }

    private fun calculateX1(x0: Float, angle: Float, distance: Float): Float =
            (distance * Math.cos(Math.toRadians(angle.toDouble())) + x0).toFloat()

    private fun calculateY1(y0: Float, angle: Float, distance: Float): Float =
            (distance * Math.sin(Math.toRadians(angle.toDouble())) + y0).toFloat()

    private fun generatePath(triangle: Triangle): Path {
        val path = Path()
        path.moveTo(triangle.vertex0.x, triangle.vertex0.y)
        path.lineTo(triangle.vertex1.x, triangle.vertex1.y)
        path.lineTo(triangle.vertex2.x, triangle.vertex2.y)
        path.close()

        return path
    }

    fun onDraw(canvas: Canvas, paint: Paint) {
        canvas.drawPath(path, paint)
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