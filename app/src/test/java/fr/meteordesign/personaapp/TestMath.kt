package fr.meteordesign.personaapp

import org.junit.Assert.assertEquals
import org.junit.Test

private const val PRECISION = 0.001

class TestMath {

    @Test(expected = IllegalArgumentException::class)
    fun testCalculateLinearEquation_0_0__0_0() {
        val p0 = PointD(0.0, 0.0)
        val p1 = PointD(0.0, 0.0)

        calculateLinearEquation(p0, p1)
    }

    @Test
    fun testCalculateLinearEquation_m1_0__0_0() {
        val p0 = PointD(-1.0, 0.0)
        val p1 = PointD(0.0, 0.0)
        val equation = calculateLinearEquation(p0, p1)

        assertEquals(0.0, equation.gradient, PRECISION)
        assertEquals(0.0, equation.yIntersect, PRECISION)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testCalculateLinearEquation_0_m1__0_0() {
        val p0 = PointD(0.0, -1.0)
        val p1 = PointD(0.0, 0.0)

        calculateLinearEquation(p0, p1)
    }

    @Test
    fun testCalculateLinearEquation_m1_m1__0_0() {
        val p0 = PointD(-1.0, -1.0)
        val p1 = PointD(0.0, 0.0)
        val equation = calculateLinearEquation(p0, p1)

        assertEquals(1.0, equation.gradient, PRECISION)
        assertEquals(0.0, equation.yIntersect, PRECISION)
    }

    @Test
    fun testCalculateLinearEquation_0_0__m1_m1() {
        val p0 = PointD(0.0, 0.0)
        val p1 = PointD(-1.0, -1.0)
        val equation = calculateLinearEquation(p0, p1)

        assertEquals(1.0, equation.gradient, PRECISION)
        assertEquals(0.0, equation.yIntersect, PRECISION)
    }

    @Test
    fun testCalculateLinearEquation_test1() {
        val p0 = PointD(-30.0, 70.0)
        val p1 = PointD(40.0, 208.0)
        val equation = calculateLinearEquation(p0, p1)

        assertEquals(69.0 / 35.0, equation.gradient, PRECISION)
        assertEquals(904.0 / 7.0, equation.yIntersect, PRECISION)
    }

    @Test
    fun testCalculateLinearEquation_test2() {
        val p0 = PointD(-25.0, 40.0)
        val p1 = PointD(501.0, -56.0)
        val equation = calculateLinearEquation(p0, p1)

        assertEquals(-48.0 / 263.0, equation.gradient, PRECISION)
        assertEquals(9320.0 / 263.0, equation.yIntersect, PRECISION)
    }

    @Test
    fun testCalculateLinearEquation_test3() {
        val p0 = PointD(206.0, 99.0)
        val p1 = PointD(-3.0, 1066.0)
        val equation = calculateLinearEquation(p0, p1)

        assertEquals(-967.0 / 209.0, equation.gradient, PRECISION)
        assertEquals(219893.0 / 209.0, equation.yIntersect, PRECISION)
    }

    @Test
    fun testCalculatePolarCoordinate_0_0_D0_A0() {
        val p0 = PointD(0.0, 0.0)
        val distance = 0.0
        val angle = 0.0
        val p1 = calculatePolarCoordinate(p0, distance, angle)

        val pExpected = PointD(0.0, 0.0)
        assertEquals(pExpected.x, p1.x, PRECISION)
        assertEquals(pExpected.y, p1.y, PRECISION)
    }

    @Test
    fun testCalculatePolarCoordinate_0_0_D0_A90() {
        val p0 = PointD(0.0, 0.0)
        val distance = 0.0
        val angle = 90.0
        val p1 = calculatePolarCoordinate(p0, distance, angle)

        val pExpected = PointD(0.0, 0.0)
        assertEquals(pExpected.x, p1.x, PRECISION)
        assertEquals(pExpected.y, p1.y, PRECISION)
    }

    @Test
    fun testCalculatePolarCoordinate_0_0_D0_A180() {
        val p0 = PointD(0.0, 0.0)
        val distance = 0.0
        val angle = 180.0
        val p1 = calculatePolarCoordinate(p0, distance, angle)

        val pExpected = PointD(0.0, 0.0)
        assertEquals(pExpected.x, p1.x, PRECISION)
        assertEquals(pExpected.y, p1.y, PRECISION)
    }

    @Test
    fun testCalculatePolarCoordinate_0_0_D0_A270() {
        val p0 = PointD(0.0, 0.0)
        val distance = 0.0
        val angle = 270.0
        val p1 = calculatePolarCoordinate(p0, distance, angle)

        val pExpected = PointD(0.0, 0.0)
        assertEquals(pExpected.x, p1.x, PRECISION)
        assertEquals(pExpected.y, p1.y, PRECISION)
    }

    @Test
    fun testCalculatePolarCoordinate_0_0_D0_A360() {
        val p0 = PointD(0.0, 0.0)
        val distance = 0.0
        val angle = 360.0
        val p1 = calculatePolarCoordinate(p0, distance, angle)

        val pExpected = PointD(0.0, 0.0)
        assertEquals(pExpected.x, p1.x, PRECISION)
        assertEquals(pExpected.y, p1.y, PRECISION)
    }

    @Test
    fun testCalculatePolarCoordinate_0_0_D1_A0() {
        val p0 = PointD(0.0, 0.0)
        val distance = 1.0
        val angle = 0.0
        val p1 = calculatePolarCoordinate(p0, distance, angle)

        val pExpected = PointD(1.0, 0.0)
        assertEquals(pExpected.x, p1.x, PRECISION)
        assertEquals(pExpected.y, p1.y, PRECISION)
    }

    @Test
    fun testCalculatePolarCoordinate_0_0_D1_A90() {
        val p0 = PointD(0.0, 0.0)
        val distance = 1.0
        val angle = 90.0
        val p1 = calculatePolarCoordinate(p0, distance, angle)

        val pExpected = PointD(0.0, 1.0)
        assertEquals(pExpected.x, p1.x, PRECISION)
        assertEquals(pExpected.y, p1.y, PRECISION)
    }

    @Test
    fun testCalculatePolarCoordinate_0_0_D1_A180() {
        val p0 = PointD(0.0, 0.0)
        val distance = 1.0
        val angle = 180.0
        val p1 = calculatePolarCoordinate(p0, distance, angle)

        val pExpected = PointD(-1.0, 0.0)
        assertEquals(pExpected.x, p1.x, PRECISION)
        assertEquals(pExpected.y, p1.y, PRECISION)
    }

    @Test
    fun testCalculatePolarCoordinate_0_0_D1_A270() {
        val p0 = PointD(0.0, 0.0)
        val distance = 1.0
        val angle = 270.0
        val p1 = calculatePolarCoordinate(p0, distance, angle)

        val pExpected = PointD(0.0, -1.0)
        assertEquals(pExpected.x, p1.x, PRECISION)
        assertEquals(pExpected.y, p1.y, PRECISION)
    }

    @Test
    fun testCalculatePolarCoordinate_0_0_D1_A3600() {
        val p0 = PointD(0.0, 0.0)
        val distance = 1.0
        val angle = 360.0
        val p1 = calculatePolarCoordinate(p0, distance, angle)

        val pExpected = PointD(1.0, 0.0)
        assertEquals(pExpected.x, p1.x, PRECISION)
        assertEquals(pExpected.y, p1.y, PRECISION)
    }

    @Test
    fun testCalculatePolarCoordinate_0_0_D1_A45() {
        val p0 = PointD(0.0, 0.0)
        val distance = 1.0
        val angle = 45.0
        val p1 = calculatePolarCoordinate(p0, distance, angle)

        val pExpected = PointD(0.70710678118655, 0.70710678118655)
        assertEquals(pExpected.x, p1.x, PRECISION)
        assertEquals(pExpected.y, p1.y, PRECISION)
    }

    @Test
    fun testCalculatePolarCoordinate_10_10_D1_A45() {
        val p0 = PointD(10.0, 10.0)
        val distance = 1.0
        val angle = 45.0
        val p1 = calculatePolarCoordinate(p0, distance, angle)

        val pExpected = PointD(10.70710678118655, 10.70710678118655)
        assertEquals(pExpected.x, p1.x, PRECISION)
        assertEquals(pExpected.y, p1.y, PRECISION)
    }

    @Test
    fun testCalculatePolarCoordinate_10_10_D100_A45() {
        val p0 = PointD(10.0, 10.0)
        val distance = 100.0
        val angle = 45.0
        val p1 = calculatePolarCoordinate(p0, distance, angle)

        val pExpected = PointD(80.710678118655, 80.710678118655)
        assertEquals(pExpected.x, p1.x, PRECISION)
        assertEquals(pExpected.y, p1.y, PRECISION)
    }
}