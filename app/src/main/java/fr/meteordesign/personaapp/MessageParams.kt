package fr.meteordesign.personaapp

import android.graphics.PointF
import fr.meteordesign.personaapp.ui.customcomponent.MessageView
import fr.meteordesign.personaapp.ui.customcomponent.TriangleBitmap

val messageParamsType1 = MessageView.Params(
        30F,
        50F,
        70F,
        50F,
        TriangleBitmap.Params(
                TriangleBitmap.Params.LEFT,
                TriangleBitmap.Params.TOP,
                PointF(20F, 40F),
                100F,
                47F),
        TriangleBitmap.Params(
                TriangleBitmap.Params.RIGHT,
                TriangleBitmap.Params.BOTTOM,
                PointF(60F, 30F),
                96F,
                229F))
