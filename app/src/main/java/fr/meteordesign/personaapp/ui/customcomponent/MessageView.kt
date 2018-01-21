package fr.meteordesign.personaapp.ui.customcomponent

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.TextView
import fr.meteordesign.personaapp.messageParamsType1
import fr.meteordesign.personaapp.messageParamsType2

class MessageView : TextView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private lateinit var exteriorShape: PersonaShapeDrawer
    private var exteriorPaint = Paint()

    private lateinit var interiorShape: PersonaShapeDrawer
    private var interiorPaint = Paint()

    init {
        exteriorPaint.isAntiAlias = true
        exteriorPaint.color = Color.rgb(255, 255, 255)

        interiorPaint.isAntiAlias = true
        interiorPaint.color = Color.rgb(0, 0, 0)

        setPadding(messageParamsType1.paddingLeft,
                messageParamsType1.paddingTop,
                messageParamsType1.paddingRight,
                messageParamsType1.paddingBottom)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        exteriorShape = PersonaShapeDrawer(w, h, messageParamsType1.triangleParams1, messageParamsType1.triangleParams2)
        interiorShape = PersonaShapeDrawer(w, h, messageParamsType2.triangleParams1, messageParamsType2.triangleParams2)
    }

    override fun onDraw(canvas: Canvas?) {
        if (canvas != null) {
            exteriorShape.onDraw(canvas, exteriorPaint)
            interiorShape.onDraw(canvas, interiorPaint)
        }
        super.onDraw(canvas)
    }

    data class Params(
            val paddingLeft: Int,
            val paddingTop: Int,
            val paddingRight: Int,
            val paddingBottom: Int,
            val triangleParams1: TriangleDrawer.Params,
            val triangleParams2: TriangleDrawer.Params)
}