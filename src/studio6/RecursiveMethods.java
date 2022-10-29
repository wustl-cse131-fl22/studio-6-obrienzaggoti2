package studio6;

import java.awt.Color;
import java.lang.reflect.Array;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		if (n == 0)
		{
			return 0;
		}
		else
		{
			return geometricSum(n-1) + Math.pow(0.5, n);
		}
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		if (q == 0)
		{
			return p;
		}
		else 
		{
			return gcd(q, p % q);
		}
	}

	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		int [] reversed = new int[array.length];
		toReversedHelper(array, reversed, 0);
		return reversed;
	}
	public static void toReversedHelper(int[] array, int[] reversed,  int index)
	{
		int lastIndex = array.length - index - 1;
		if(index <= lastIndex)
		{
			int temp = array[index];
			int temp2 = array[lastIndex];
			reversed[index] = temp2;
			reversed[lastIndex] = temp;
			toReversedHelper(array, reversed, index + 1);
		}
		else
		{
			return;
		}
	}

	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) 
	{
		if (radius < radiusMinimumDrawingThreshold)
		{
			return;
		}
		else 
		{
			StdDraw.setPenColor(Color.BLACK);
			StdDraw.circle(xCenter, yCenter, radius);
			circlesUponCircles (xCenter + radius, yCenter, radius / 3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles (xCenter - radius, yCenter, radius / 3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles (xCenter, yCenter + radius, radius / 3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles (xCenter, yCenter - radius, radius / 3.0, radiusMinimumDrawingThreshold);
		}
		
	}

}
