package fr.meteordesign.personaapp

import android.graphics.PointF
import fr.meteordesign.personaapp.ui.customcomponent.MessageView
import fr.meteordesign.personaapp.ui.customcomponent.TriangleDrawer

// blanc
val messageParamsType1 = MessageView.Params(
        40,
        50,
        70,
        50,
        TriangleDrawer.Params(
                TriangleDrawer.Params.LEFT,
                TriangleDrawer.Params.TOP,
                PointF(20F, 30F),
                96F,
                46F),
        TriangleDrawer.Params(
                TriangleDrawer.Params.RIGHT,
                TriangleDrawer.Params.BOTTOM,
                PointF(50F, 10F),
                100F,
                232F))

// noir
val messageParamsType2 = MessageView.Params(
        0,
        0,
        0,
        0,
        TriangleDrawer.Params(
                TriangleDrawer.Params.LEFT,
                TriangleDrawer.Params.TOP,
                PointF(30F, 40F),
                95F,
                46.5F),
        TriangleDrawer.Params(
                TriangleDrawer.Params.RIGHT,
                TriangleDrawer.Params.BOTTOM,
                PointF(60F, 20F),
                94F,
                229F))
