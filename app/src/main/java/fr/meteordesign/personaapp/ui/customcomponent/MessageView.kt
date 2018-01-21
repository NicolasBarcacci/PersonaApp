package fr.meteordesign.personaapp.ui.customcomponent

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.TextView
import fr.meteordesign.personaapp.dpToPx
import fr.meteordesign.personaapp.messageParamsType1

class MessageView : TextView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val triangleBitmap1 = TriangleBitmap()
    private val triangleBitmap2 = TriangleBitmap()
    private val backgroundPaint = Paint()

    private lateinit var backgroundBitmap: Bitmap
    private lateinit var backgroundCanvas: Canvas

    private val porterDuffPaint = Paint()
    private val porterDuffMode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

    private val params = messageParamsType1

    init {
        backgroundPaint.isAntiAlias = true
        backgroundPaint.color = Color.rgb(0, 0, 0)
        triangleBitmap1.paint = backgroundPaint
        triangleBitmap2.paint = backgroundPaint

        triangleBitmap1.params = params.triangleParams1
        triangleBitmap2.params = params.triangleParams2

        setPadding(dpToPx(resources, params.paddingLeft).toInt(),
                dpToPx(resources, params.paddingTop).toInt(),
                dpToPx(resources, params.paddingRight).toInt(),
                dpToPx(resources, params.paddingBottom).toInt())
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        triangleBitmap1.onSizeChanged(w, h)
        triangleBitmap2.onSizeChanged(w, h)

        backgroundBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        backgroundCanvas = Canvas(backgroundBitmap)
    }

    override fun onDraw(canvas: Canvas?) {
        if (canvas != null) {
            backgroundCanvas.drawBitmap(triangleBitmap1.onDraw(), 0F, 0F, porterDuffPaint)
            porterDuffPaint.xfermode = porterDuffMode
            backgroundCanvas.drawBitmap(triangleBitmap2.onDraw(), 0F, 0F, porterDuffPaint)

            canvas.drawBitmap(backgroundBitmap, 0F, 0F, Paint())
        }
        super.onDraw(canvas)
    }

    data class Params(
            val paddingLeft: Float,
            val paddingTop: Float,
            val paddingRight: Float,
            val paddingBottom: Float,
            val triangleParams1: TriangleBitmap.Params,
            val triangleParams2: TriangleBitmap.Params)
}