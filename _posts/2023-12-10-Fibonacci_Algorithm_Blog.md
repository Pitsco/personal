---
toc: True
comments: True
layout: post
title: Fibonacci Blog
description: Explanation on our Fibonacci code
courses: {'compsci': {'week': 13}}
type: hacks
---

# Frontend

# Backend

# FibonacciBase Abstract Class:


```python
package com.nighthawk.spring_portfolio.mvc.fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract class FibonacciBase {//abstract class providing common functionality for Fibonacci implementations
    public List<Long> calculateFibonacci(int num) {//method to calculate Fibonacci numbers and measure time
        long startTime = System.nanoTime();
        List<Long> fibonacciNumbers = performFibonacciCalculation(num);
        long endTime = System.nanoTime();
        displayResults(getMethodName(), endTime - startTime, fibonacciNumbers);
        return fibonacciNumbers;
    }
    
    protected abstract List<Long> performFibonacciCalculation(int num); //abstract method to be implemented by subclasses
    protected abstract String getMethodName(); //abstract method to get the method name

    private static void displayResults(String method, double timeTaken, List<Long> fibonacciNumbers) {//displaying results method
        System.out.println("Method: " + method);
        System.out.println("Time taken: " + timeTaken / 1e6 + " milliseconds"); //convert to milliseconds
        System.out.println("Fibonacci numbers: " + fibonacciNumbers);
        System.out.println();
    }
}

```

- FibonacciBase is an abstract class providing common functionality for Fibonacci implementations
- calculateFibonacci method calculates Fibonacci numbers and measures the time taken
- performFibonacciCalculation is an abstract method to be implemented by subclasses
- getMethodName is an abstract method to get the method name
- displayResults is a private static method displaying the results, including method name, time taken, and Fibonacci numbers

# FibonacciFor Class


```python
class FibonacciFor extends FibonacciBase {//implementation of FibonacciBase using a for loop
    @Override
    protected List<Long> performFibonacciCalculation(int num) {
        List<Long> result = new ArrayList<>();
        long a = 0, b = 1;
        for (int i = 0; i < num; i++) {
            result.add(a);
            long temp = a;
            a = b;
            b = temp + b;
        }
        return result;
    }

    @Override
    protected String getMethodName() {
        return "For Loop";
    }
}
```

- FibonacciFor is a concrete class that extends FibonacciBase and implements the Fibonacci calculation using a for loop
- performFibonacciCalculation method calculates Fibonacci numbers using a for loop
- getMethodName method returns the method name, which is "For Loop"

# FibonacciWhile Class


```python
class FibonacciWhile extends FibonacciBase {//implementation of FibonacciBase class using a while loop
    @Override
    protected List<Long> performFibonacciCalculation(int num) {
        List<Long> result = new ArrayList<>();
        long a = 0, b = 1;
        int count = 0;
        while (count < num) {
            result.add(a);
            long temp = a;
            a = b;
            b = temp + b;
            count++;
        }
        return result;
    }

    @Override
    protected String getMethodName() {
        return "While Loop";
    }
}

```

- FibonacciWhile is a concrete class that extends FibonacciBase and implements the Fibonacci calculation using a while loop
- performFibonacciCalculation method calculates Fibonacci numbers using a while loop
- getMethodName method returns the method name, which is "While Loop"

# FibonacciRecursion Class


```python
class FibonacciRecursion extends FibonacciBase {//implementation of FibonacciBase using recursion
    @Override
    protected List<Long> performFibonacciCalculation(int num) {
        List<Long> result = new ArrayList<>();
        fibonacciRecursionStructure(num, 0, 1, result);
        return result;
    }

    private static void fibonacciRecursionStructure(int num, long a, long b, List<Long> result) {//helper method for recursive calculation
        if (num > 0) {
            result.add(a);
            fibonacciRecursionStructure(num - 1, b, a + b, result);
        }
    }

    @Override
    protected String getMethodName() {
        return "Recursion Loop";
    }
}

```

- FibonacciRecursion is a concrete class that extends FibonacciBase and implements the Fibonacci calculation using recursion
- performFibonacciCalculation method calculates Fibonacci numbers using recursion
- fibonacciRecursionStructure is a helper method for the recursive calculation
- getMethodName method returns the method name, which is "Recursion Loop"

# FibonacciStream Class


```python
class FibonacciStream extends FibonacciBase {//implementation of FibonacciBase using Java Streams
    @Override
    protected List<Long> performFibonacciCalculation(int num) {
        return Stream.iterate(new long[]{0, 1}, f -> new long[]{f[1], f[0] + f[1]})
                .limit(num)
                .mapToLong(f -> f[0])
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    protected String getMethodName() {
        return "Stream Loop";
    }
}

```

- FibonacciRecursion is a concrete class that extends FibonacciBase and implements the Fibonacci calculation using recursion
- performFibonacciCalculation method calculates Fibonacci numbers using recursion
- fibonacciRecursionStructure is a helper method for the recursive calculation
- getMethodName method returns the method name, which is "Recursion Loop"

# Fibonacci Class


```python
public class Fibonacci {//fibonacci class to demonstrate and compare different Fibonacci implementations
    public static void main(String[] args) {
        int num = getUserInput();

        FibonacciBase fibonacciFor = new FibonacciFor();//instantiate and calculate Fibonacci using For Loop
        fibonacciFor.calculateFibonacci(num);

        FibonacciBase fibonacciWhile = new FibonacciWhile();//same for while loop
        fibonacciWhile.calculateFibonacci(num);

        FibonacciBase fibonacciRecursion = new FibonacciRecursion();//same for recursion loop
        fibonacciRecursion.calculateFibonacci(num);

        FibonacciBase fibonacciStream = new FibonacciStream();//same for stream loop
        fibonacciStream.calculateFibonacci(num);
    }

    private static int getUserInput() {
        Scanner scanner = new Scanner(System.in); //scanner for number fo Fibonacci numbers user wants to input
        System.out.print("Enter the number of Fibonacci numbers to generate: ");
        int num;
        while (true) {
            try {
                num = scanner.nextInt();
                if (num > 0) {
                    break;
                } else {
                    System.out.print("Please enter a positive integer: "); //asking only for positive integer
                }
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a positive integer: "); //will catch invalid input such as negative number or letter
                scanner.next(); // consume invalid input
                scanner.next(); //consume invalid input
            }
        }
        scanner.close();
        return num;
    }
}
```

- Fibonacci is the main class that demonstrates and compares different Fibonacci implementations
- main method initializes instances of Fibonacci implementations and calculates Fibonacci numbers using user input
- getUserInput method retrieves the number of Fibonacci numbers the user wants to generate using a Scanner

# Inheritance

## Example: Utilization in the Fibonacci Class


```python
FibonacciBase fibonacciFor = new FibonacciFor();
fibonacciFor.calculateFibonacci(num);

FibonacciBase fibonacciWhile = new FibonacciWhile();
fibonacciWhile.calculateFibonacci(num);

FibonacciBase fibonacciRecursion = new FibonacciRecursion();
fibonacciRecursion.calculateFibonacci(num);

FibonacciBase fibonacciStream = new FibonacciStream();
fibonacciStream.calculateFibonacci(num);
```

In the Fibonacci class, instances of the concrete subclasses (FibonacciFor, FibonacciWhile, FibonacciRecursion, FibonacciStream) are created and assigned to variables of type FibonacciBase. This is possible because of the inheritance relationship; a subclass instance can be treated as an instance of its superclass.

The calculateFibonacci method is then called on each instance, demonstrating polymorphism. The specific implementation of calculateFibonacci in each subclass is invoked based on the type of the object, allowing for flexibility and code reuse.

# UserInput method


```python
private static int getUserInput() {
    Scanner scanner = new Scanner(System.in); //scanner for number fo Fibonacci numbers user wants to input
    System.out.print("Enter the number of Fibonacci numbers to generate: ");
    int num;
    while (true) {
        try {
            num = scanner.nextInt();
            if (num > 0) {
                break;
            } else {
                System.out.print("Please enter a positive integer: "); //asking only for positive integer
            }
        } catch (Exception e) {
            System.out.print("Invalid input. Please enter a positive integer: "); //will catch invalid input such as negative number or letter
            scanner.next(); //consume invalid input
        }
    }
    scanner.close();
    return num;
}
```

This Java code defines a method named getUserInput that prompts the user to enter the number of Fibonacci numbers they want to generate. Here's the steps of the code:

1. It creates a Scanner object to read input from the user.
2. The user is prompted to enter the number of Fibonacci numbers to generate.
3. The code uses a while loop to continuously prompt the user until a valid input is provided.

### Within the loop:
4. It attempts to read an integer from the user using scanner.nextInt().
5. If the input is a positive integer (num > 0), the loop breaks.
6. If the input is not a positive integer, an error message is displayed, and the user is prompted again.
7. If an exception is caught (e.g., input is not an integer), an error message is displayed, and the invalid input is consumed using scanner.next() to prevent an infinite loop.
8. After a valid input is obtained, the Scanner is closed, and the entered number is returned.
