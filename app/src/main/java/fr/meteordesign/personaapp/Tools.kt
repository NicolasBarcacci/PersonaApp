package fr.meteordesign.personaapp

import android.content.res.Resources
import android.util.TypedValue

fun dpToPx(resources: Resources, dp: Float): Float =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)