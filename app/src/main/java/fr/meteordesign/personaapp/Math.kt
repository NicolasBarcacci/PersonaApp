package fr.meteordesign.personaapp

data class PointD(var x: Double, var y: Double)

data class LinearEquation(val gradient: Double, val yIntersect: Double)

private const val PROJECTION = 100.0

fun calculateLinearEquation(p0: PointD, angle: Double): LinearEquation {
    val p1 = calculatePolarCoordinate(p0, PROJECTION, angle)
    return calculateLinearEquation(p0, p1)
}

fun calculateLinearEquation(p0: PointD, p1: PointD): LinearEquation {
    if (p0.x == p1.x) {
        throw IllegalArgumentException("The two points can't have the same x value")
    }

    val gradient = (p1.y - p0.y) / (p1.x - p0.x)
    val yIntersect = p0.y - gradient * p0.x

    return LinearEquation(gradient, yIntersect)
}

fun calculatePolarCoordinate(p0: PointD, distance: Double, angle: Double): PointD
        = PointD(calculatePolarCoordinateX(p0.x, distance, angle),
        calculatePolarCoordinateY(p0.y, distance, angle))

fun calculatePolarCoordinateX(x0: Double, distance: Double, angle: Double): Double
        = x0 + distance * Math.cos(radian(angle))

fun calculatePolarCoordinateY(y0: Double, distance: Double, angle: Double): Double
        = y0 + distance * Math.sin(radian(angle))

fun calculateEquationIntersection(e0: LinearEquation, e1: LinearEquation): PointD {
    val x = (e1.yIntersect - e0.yIntersect) / (e0.gradient - e1.gradient)
    val y = e0.gradient * x + e0.yIntersect

    return PointD(x, y)
}

fun radian(angle: Double): Double = Math.toRadians(angle)