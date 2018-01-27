package fr.meteordesign.personaapp.ui.customcomponent

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.ImageView

class AvatarView: ImageView {

    private var exteriorPaint = Paint()
    private var interiorPaint = Paint()

    init {
        exteriorPaint.isAntiAlias = true
        exteriorPaint.color = Color.rgb(0, 0, 0)

        interiorPaint.isAntiAlias = true
        interiorPaint.color = Color.rgb(0, 255, 0)
    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeight)
        updatePersonaShapeDrawers(width, height)
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.let {
            getExteriorPersonaShapeDrawer()?.let {
                canvas.drawPath(it.path, exteriorPaint)
            }
            getInteriorPersonaShapeDrawer()?.let {
                canvas.drawPath(it.path, interiorPaint)
            }
        }
        super.onDraw(canvas)
    }
}