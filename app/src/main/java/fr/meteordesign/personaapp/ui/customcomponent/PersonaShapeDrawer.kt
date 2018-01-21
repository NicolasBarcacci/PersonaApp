package fr.meteordesign.personaapp.ui.customcomponent

import android.graphics.*

class PersonaShapeDrawer(width: Int, height: Int, triangle1Params: TriangleDrawer.Params,
                         triangle2Params: TriangleDrawer.Params) {

    private val triangle1Drawer = TriangleDrawer(width, height, triangle1Params)
    private val triangle1Bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    private val triangle1Canvas = Canvas(triangle1Bitmap)
    private val triangle2Drawer = TriangleDrawer(width, height, triangle2Params)
    private val triangle2Bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    private val triangle2Canvas = Canvas(triangle2Bitmap)
    private val resultBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    private val resultCanvas = Canvas(resultBitmap)
    private val porterDuffPaint = Paint()
    private val porterDuffMode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

    fun onDraw(canvas: Canvas, paint: Paint) {
        triangle1Drawer.onDraw(triangle1Canvas, paint)
        triangle2Drawer.onDraw(triangle2Canvas, paint)

        resultCanvas.drawBitmap(triangle1Bitmap, 0F, 0F, porterDuffPaint)
        porterDuffPaint.xfermode = porterDuffMode
        resultCanvas.drawBitmap(triangle2Bitmap, 0F, 0F, porterDuffPaint)

        canvas.drawBitmap(resultBitmap, 0F, 0F, Paint())
    }
}