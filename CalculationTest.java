package com.CalculationTest; // Replace "com.example" with your desired package name

import java.util.ArrayList;
import java.util.List;

public class CalculationTest {
    private static float finalResult;

    private static void Calculate1(List<Float> numbers, List<String> operations) {
        // The implementation of the Calculate1 method as provided in the question
        // ...
        if (numbers.size() == 1) {
            finalResult = numbers.get(0);
            return;
        }

        float result = 0;

        int indexMultiply = operations.indexOf("*");
        int indexDivide = operations.indexOf("/");

        if (indexMultiply != -1 && indexDivide != -1) {
            if (indexMultiply < indexDivide) {
                result += numbers.get(indexMultiply) * numbers.get(indexMultiply + 1);

                numbers.set(indexMultiply, result);
                numbers.remove(indexMultiply + 1);

                operations.remove(indexMultiply);

                Calculate1(numbers, operations);
                return;
            } else {
                result += numbers.get(indexDivide) / numbers.get(indexDivide + 1);

                numbers.set(indexDivide, result);
                numbers.remove(indexDivide + 1);

                operations.remove(indexDivide);

                Calculate1(numbers, operations);
                return;
            }
        }

        if (indexMultiply != -1) {
            result += numbers.get(indexMultiply) * numbers.get(indexMultiply + 1);

            numbers.set(indexMultiply, result);
            numbers.remove(indexMultiply + 1);

            operations.remove(indexMultiply);

            Calculate1(numbers, operations);
            return;
        }

        if (indexDivide != -1) {
            result += numbers.get(indexDivide) / numbers.get(indexDivide + 1);

            numbers.set(indexDivide, result);
            numbers.remove(indexDivide + 1);

            operations.remove(indexDivide);

            Calculate1(numbers, operations);
            return;
        }

        int indexPlus = operations.indexOf("+");
        int indexMinus = operations.indexOf("-");

        if (indexMinus != -1 && indexPlus != -1) {
            if (indexPlus < indexMinus) {
                result += numbers.get(indexPlus) + numbers.get(indexPlus + 1);

                numbers.set(indexPlus, result);
                numbers.remove(indexPlus + 1);

                operations.remove(indexPlus);

                Calculate1(numbers, operations);
                return;
            } else {
                result += numbers.get(indexMinus) - numbers.get(indexMinus + 1);

                numbers.set(indexMinus, result);
                numbers.remove(indexMinus + 1);

                operations.remove(indexMinus);

                Calculate1(numbers, operations);
                return;
            }

        }

        if (indexPlus != -1) {
            result += numbers.get(indexPlus) + numbers.get(indexPlus + 1);

            numbers.set(indexPlus, result);
            numbers.remove(indexPlus + 1);

            operations.remove(indexPlus);

            Calculate1(numbers, operations);
            return;
        }

        if (indexMinus != -1) {
            result += numbers.get(indexMinus) - numbers.get(indexMinus + 1);

            numbers.set(indexMinus, result);
            numbers.remove(indexMinus + 1);

            operations.remove(indexMinus);

            Calculate1(numbers, operations);
            return;
        }


        // Store the final result in the class-level variable finalResult
        finalResult = numbers.get(0);
    }

    public static void main(String[] args) {
        List<Float> numbers = new ArrayList<>();
        List<String> operations = new ArrayList<>();
        float expected_result = 12.0f;

        // Set up the numbers and operations for the calculation
        numbers.add(3.0f);
        numbers.add(4.0f);
        operations.add("*");

        // Perform the calculation
        Calculate1(numbers, operations);

        // Compare the expected result with the finalResult
        if (expected_result == finalResult) {
            System.out.println("Test succeeded");
        } else {
            System.out.println("Test failed for values " + numbers + " " + operations);
        }
    }
}


   
