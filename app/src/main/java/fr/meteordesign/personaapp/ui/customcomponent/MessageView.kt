package fr.meteordesign.personaapp.ui.customcomponent

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.TextView
import fr.meteordesign.personaapp.messageStyle1

class MessageView : TextView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    var style = messageStyle1
        set(value) {
            field = value
            setPadding(field.paddingLeft, field.paddingTop, field.paddingRight, field.paddingBottom)
            requestLayout()
            invalidate()
        }

    private lateinit var exteriorShapeDrawer: PersonaShapeDrawer
    private var exteriorPaint = Paint()

    private lateinit var interiorShapeDrawer: PersonaShapeDrawer
    private var interiorPaint = Paint()

    init {
        setPadding(style.paddingLeft, style.paddingTop, style.paddingRight, style.paddingBottom)

        exteriorPaint.isAntiAlias = true
        exteriorPaint.color = Color.rgb(255, 255, 255)

        interiorPaint.isAntiAlias = true
        interiorPaint.color = Color.rgb(0, 0, 0)
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeight)
        exteriorShapeDrawer = PersonaShapeDrawer(width, height, style.exteriorShapeDrawer)
        interiorShapeDrawer = PersonaShapeDrawer(width, height, style.interiorShapeDrawer)
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.let {
            it.drawPath(exteriorShapeDrawer.path, exteriorPaint)
            it.drawPath(interiorShapeDrawer.path, interiorPaint)
        }
        super.onDraw(canvas)
    }

    data class Style(
            val paddingLeft: Int,
            val paddingTop: Int,
            val paddingRight: Int,
            val paddingBottom: Int,
            val exteriorShapeDrawer: PersonaShapeDrawer.Params,
            val interiorShapeDrawer: PersonaShapeDrawer.Params)
}