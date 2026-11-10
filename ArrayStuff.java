import java.util.Random;
import java.util.Scanner;

public class ArrayStuff
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        // Step 1: Declare an int array named dataPoints that holds 100 values
        int[] dataPoints = new int[100];

        // Step 2: Initialize each element to a random value from 1 to 100
        for (int i = 0; i < dataPoints.length; i++)
        {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        // Step 3: Display the values on one line separated by " | "
        System.out.println("The values in dataPoints are:");
        for (int i = 0; i < dataPoints.length; i++)
        {
            System.out.print(dataPoints[i] + " | ");
        }
        System.out.println();

        // Step 4: Calculate and display the sum and the average
        int sum = 0;
        double average = 0;
        for (int i = 0; i < dataPoints.length; i++)
        {
            sum = sum + dataPoints[i];
        }
        average = (double) sum / dataPoints.length;
        System.out.println("\nThe sum of the random array dataPoints is: " + sum);
        System.out.printf("The average of the random array dataPoints is: %.2f%n", average);

        // Step 5: Get a value from 1 to 100 from the user with SafeInput
        int userValue = SafeInput.getRangedInt(in, "Enter a value to count in dataPoints", 1, 100);

        // Step 6: Count how many times the user's value is in the array
        int count = 0;
        for (int i = 0; i < dataPoints.length; i++)
        {
            if (dataPoints[i] == userValue)
            {
                count++;
            }
        }
        System.out.println("The value " + userValue + " was found " + count + " time(s) in dataPoints.");

        // Step 7: Find the first position of a second value, stopping (break) when it is found
        userValue = SafeInput.getRangedInt(in, "Enter a value to find in dataPoints", 1, 100);
        int position = -1;
        boolean found = false;
        for (int i = 0; i < dataPoints.length; i++)
        {
            if (dataPoints[i] == userValue)
            {
                position = i;
                found = true;
                break; // short circuit: stop at the first match
            }
        }
        if (found)
        {
            System.out.println("The value " + userValue + " was found at array index " + position + ".");
        }
        else
        {
            System.out.println("The value " + userValue + " was not found in dataPoints.");
        }

        // Step 8: Scan for the minimum and maximum values
        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int i = 1; i < dataPoints.length; i++)
        {
            if (dataPoints[i] < min)
            {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max)
            {
                max = dataPoints[i];
            }
        }
        System.out.println("\nThe minimum value in dataPoints is " + min + ".");
        System.out.println("The maximum value in dataPoints is " + max + ".");

        // Step 9: Use the static getAverage method
        System.out.println("\nAverage of dataPoints is: " + getAverage(dataPoints));
    }

    /**
     * Returns the average of an array of double values.
     *
     * @param values the array of values
     * @return the average of the values
     */
    public static double getAverage(double values[])
    {
        double sum = 0;
        for (int i = 0; i < values.length; i++)
        {
            sum = sum + values[i];
        }
        return sum / values.length;
    }

    /**
     * dataPoints is an int array, so this version copies the ints into a double array
     * and calls getAverage(double values[]). That lets getAverage(dataPoints) work as written.
     *
     * @param values the array of int values
     * @return the average of the values
     */
    public static double getAverage(int values[])
    {
        double[] asDoubles = new double[values.length];
        for (int i = 0; i < values.length; i++)
        {
            asDoubles[i] = values[i];
        }
        return getAverage(asDoubles);
    }
}
