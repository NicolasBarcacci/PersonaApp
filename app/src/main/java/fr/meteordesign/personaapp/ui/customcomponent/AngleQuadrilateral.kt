package fr.meteordesign.personaapp.ui.customcomponent

import android.graphics.Path
import android.graphics.PointF

class AngleQuadrilateral {

    var leftTopPoint = PointF(0F, 0F)
    var leftBottomPoint = PointF(0F, 0F)
    var rightTopPoint = PointF(0F, 0F)
    var rightBottomPoint = PointF(0F, 0F)

    fun setLeftSideFropTopPoint(point: PointF, sideParams: SideParams) {
        leftTopPoint = point

        val parsedAngle = parseToTopAngle(sideParams.angle)
        leftBottomPoint.x = calculateX1(leftTopPoint.x, parsedAngle, sideParams.length)
        leftBottomPoint.y = calculateY1(leftTopPoint.y, parsedAngle, sideParams.length)
    }

    fun setLeftSideFromBottomPoint(point: PointF, sideParams: SideParams) {
        leftBottomPoint = point

        val parsedAngle = parseToBottomAngle(sideParams.angle)
        leftTopPoint.x = calculateX1(leftBottomPoint.x, parsedAngle, sideParams.length)
        leftTopPoint.y = calculateY1(leftBottomPoint.y, parsedAngle, sideParams.length)
    }

    fun setRightSideFromTopPoint(point: PointF, sideParams: SideParams) {
        rightTopPoint = point

        val parsedAngle = parseToTopAngle(sideParams.angle)
        rightBottomPoint.x = calculateX1(rightTopPoint.x, parsedAngle, sideParams.length)
        rightBottomPoint.y = calculateY1(rightTopPoint.y, parsedAngle, sideParams.length)
    }

    fun setRightSideFromBottomPoint(point: PointF, sideParams: SideParams) {
        rightBottomPoint = point

        val parsedAngle = parseToBottomAngle(sideParams.angle)
        rightTopPoint.x = calculateX1(rightBottomPoint.x, parsedAngle, sideParams.length)
        rightTopPoint.y = calculateY1(rightBottomPoint.y, parsedAngle, sideParams.length)
    }

    private fun parseToTopAngle(angle: Float): Float = 90 - angle

    private fun parseToBottomAngle(angle: Float): Float = 270 + angle

    private fun calculateX1(x0: Float, angle: Float, distance: Float): Float =
            (distance * Math.cos(Math.toRadians(angle.toDouble())) + x0).toFloat()

    private fun calculateY1(y0: Float, angle: Float, distance: Float): Float =
            (distance * Math.sin(Math.toRadians(angle.toDouble())) + y0).toFloat()

    fun generatePath(): Path {
        val path = Path()
        path.moveTo(leftTopPoint.x, leftTopPoint.y)
        path.lineTo(rightTopPoint.x, rightTopPoint.y)
        path.lineTo(rightBottomPoint.x, rightBottomPoint.y)
        path.lineTo(leftBottomPoint.x, leftBottomPoint.y)
        path.close()

        return path
    }

    data class SideParams(val angle: Float, val length: Float)
}