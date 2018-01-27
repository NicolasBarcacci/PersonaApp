package fr.meteordesign.personaapp.ui.customcomponent

import android.view.View
import fr.meteordesign.personaapp.R

fun View.getPersonaStyle(): PersonaStyle? {
    getTag(R.id.persona_style).let {
        if (it is PersonaStyle) return it
    }

    return null
}

fun View.setPersonaStyle(personaStyle: PersonaStyle) {
    setTag(R.id.persona_style, personaStyle)
    setPadding(personaStyle.paddingLeft,
            personaStyle.paddingTop,
            personaStyle.paddingRight,
            personaStyle.paddingBottom)
    requestLayout()
    invalidate()
}

fun View.getExteriorPersonaShapeDrawer(): PersonaShapeDrawer? {
    getTag(R.id.persona_shape_drawer_exterior).let {
        if (it is PersonaShapeDrawer) return it
    }

    return null
}

fun View.getInteriorPersonaShapeDrawer(): PersonaShapeDrawer? {
    getTag(R.id.persona_shape_drawer_interior).let {
        if (it is PersonaShapeDrawer) return it
    }

    return null
}

fun View.updatePersonaShapeDrawers(width: Int, height: Int) {
    getPersonaStyle()?.let {
        setTag(R.id.persona_shape_drawer_exterior,
                PersonaShapeDrawer(width, height, it.exteriorShapeDrawerParams))
        setTag(R.id.persona_shape_drawer_interior,
                PersonaShapeDrawer(width, height, it.interiorShapeDrawerParams))
    }
}

data class PersonaStyle(
        val paddingLeft: Int,
        val paddingTop: Int,
        val paddingRight: Int,
        val paddingBottom: Int,
        val exteriorShapeDrawerParams: PersonaShapeDrawer.Params,
        val interiorShapeDrawerParams: PersonaShapeDrawer.Params)