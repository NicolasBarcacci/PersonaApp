package fr.meteordesign.personaapp.ui.customcomponent

import android.graphics.Path
import fr.meteordesign.personaapp.PointD
import fr.meteordesign.personaapp.calculateEquationIntersection
import fr.meteordesign.personaapp.calculateLinearEquation

class PersonaShapeDrawer(width: Int, height: Int, params: Params) {

    val path: Path

    init {
        val a = PointD(params.topLeftCorner.x, params.topLeftCorner.y)
        val c = PointD(width - params.bottomRightCorner.x, height - params.bottomRightCorner.y)

        val leftSideEquation = calculateLinearEquation(a, params.leftAngle)
        val topSideEquation = calculateLinearEquation(a, params.topAngle)
        val rightSideEquation = calculateLinearEquation(c, params.rightAngle)
        val bottomSideEquation = calculateLinearEquation(c, params.bottomAngle)

        val b = calculateEquationIntersection(topSideEquation, rightSideEquation)
        val d = calculateEquationIntersection(leftSideEquation, bottomSideEquation)

        path = Path()
        path.moveTo(a.x.toFloat(), a.y.toFloat())
        path.lineTo(b.x.toFloat(), b.y.toFloat())
        path.lineTo(c.x.toFloat(), c.y.toFloat())
        path.lineTo(d.x.toFloat(), d.y.toFloat())
        path.close()
    }

    data class Params(
            val topLeftCorner: PointD,
            val bottomRightCorner: PointD,
            val leftAngle: Double,
            val topAngle: Double,
            val rightAngle: Double,
            val bottomAngle: Double)
}