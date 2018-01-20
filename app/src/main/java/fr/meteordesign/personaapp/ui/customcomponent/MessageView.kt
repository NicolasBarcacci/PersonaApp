package fr.meteordesign.personaapp.ui.customcomponent

import android.content.Context
import android.graphics.*
import android.support.annotation.FloatRange
import android.util.AttributeSet
import android.widget.TextView
import fr.meteordesign.personaapp.messageParamsType1

private const val MIN_ANGLE: Double = -45.0
private const val MAX_ANGLE: Double = 45.0

class MessageView : TextView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private var exteriorPath = Path()
    private val exteriorPaint = Paint()

    private val interiorPath = Path()
    private val interiorPaint = Paint()

    private var params = messageParamsType1
    private val exteriorQuadrilateral = AngleQuadrilateral()

    init {
        exteriorPaint.isAntiAlias = true
        exteriorPaint.color = Color.argb(255, 255, 255, 255)

        interiorPaint.isAntiAlias = true
        interiorPaint.color = Color.argb(255, 0, 0, 0)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        recalculateExteriorPath(w, h)
        recalculateInteriorPath()
    }

    private fun recalculateExteriorPath(width: Int, height: Int) {
        val leftBottomPoint = PointF(
                params.exteriorLeftSideShift.x,
                height - params.exteriorLeftSideShift.y)
        val leftSideParams = AngleQuadrilateral.SideParams(
                params.exteriorLeftSideAngle,
                height * params.exteriorLeftSideRatio)
        exteriorQuadrilateral.setLeftSideFromBottomPoint(leftBottomPoint, leftSideParams)

        val topRightPoint = PointF(
                width - params.exteriorRightSideShift.x,
                params.exteriorRightSideShift.y)
        val rightSideParams = AngleQuadrilateral.SideParams(
                params.exteriorRightSideAngle,
                height * params.exteriorRightSideRatio)
        exteriorQuadrilateral.setRightSideFromTopPoint(topRightPoint, rightSideParams)

        exteriorPath = exteriorQuadrilateral.generatePath()
    }

    private fun recalculateInteriorPath() {
        interiorPath.reset()
        interiorPath.moveTo(
                exteriorQuadrilateral.leftTopPoint.x + params.interiorLeftTopShit.x,
                exteriorQuadrilateral.leftTopPoint.y + params.interiorLeftTopShit.y)
        interiorPath.lineTo(
                exteriorQuadrilateral.rightTopPoint.x - params.interiorRightTopShift.x,
                exteriorQuadrilateral.rightTopPoint.y + params.interiorRightTopShift.y)
        interiorPath.lineTo(
                exteriorQuadrilateral.rightBottomPoint.x - params.interiorRightBottomShift.x,
                exteriorQuadrilateral.rightBottomPoint.y - params.interiorRightBottomShift.y)
        interiorPath.lineTo(
                exteriorQuadrilateral.leftBottomPoint.x + params.interiorLeftBottomShift.x,
                exteriorQuadrilateral.leftBottomPoint.y - params.interiorLeftBottomShift.y)
        interiorPath.close()
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawPath(exteriorPath, exteriorPaint)
        canvas?.drawPath(interiorPath, interiorPaint)
        super.onDraw(canvas)
    }

    data class Params(
            @FloatRange(from = MIN_ANGLE, to = MAX_ANGLE, fromInclusive = true)
            val exteriorLeftSideAngle: Float,
            @FloatRange(from = 0.0, to = 1.0, fromInclusive = true)
            val exteriorLeftSideRatio: Float,
            val exteriorLeftSideShift: PointF,
            @FloatRange(from = MIN_ANGLE, to = MAX_ANGLE, fromInclusive = true)
            val exteriorRightSideAngle: Float,
            @FloatRange(from = 0.0, to = 1.0, fromInclusive = true)
            val exteriorRightSideRatio: Float,
            val exteriorRightSideShift: PointF,
            val interiorLeftTopShit: PointF,
            val interiorLeftBottomShift: PointF,
            val interiorRightTopShift: PointF,
            val interiorRightBottomShift: PointF)
}