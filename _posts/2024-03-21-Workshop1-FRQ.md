---
title: Workshop 1 FRQ
description: 2 FRQs
layout: post
courses: {'csa': {'week': 25}}
categories: ['C4.0']
type: tangibles
comments: True
---

## Question 4: Math Class (Unit 2)
Situation: You are developing a scientific calculator application where users need to perform various mathematical operations.

### (a) Discuss the purpose and utility of the Math class in Java programming. Provide examples of at least three methods provided by the Math class and explain their usage.

In Java programming, the Math class is a part of the Java API and is included in the `java.lang` package by default. It provides a set of methods for performing common mathematical operations. 

`Math.abs(double a)`:
```cs
double number = -10.5;
double absValue = Math.abs(number); // absValue will be 10.5
```
This method returns the absolute value of a given number. The absolute value of a number is its distance from zero on the number line, disregarding its sign.

`Math.sqrt(double a)`:
``` cs
double number = 25;
double sqrtValue = Math.sqrt(number); // sqrtValue will be 5.0
```
This method returns the square root of a given non-negative number. It calculates the non-negative square root of the argument.

`Math.pow(double base, double exponent)`:
``` cs
double base = 2;
double exponent = 3;
double result = Math.pow(base, exponent); // result will be 8.0 (2^3)
```
This method returns the value of the first argument raised to the power of the second argument. It's useful for performing exponentiation.

These are just a few examples of methods provided by the Math class. There are many more methods available in the class, including trigonometric functions like sin, cos, tan, logarithmic functions like log, log10, rounding functions like ceil, floor, and more. The Math class simplifies mathematical operations in Java programs by providing these ready-to-use methods, thereby saving developers from having to implement them from scratch.

### (b) You need to implement a method calculateSquareRoot that takes a double number as input and returns its square root using the Math class. Write the method signature and the method implementation. Include comments to explain your code.

### Code:



```java
public class SquareRootCalculator {
    public static double calculateSquareRoot(double number) {//method to calculate square root using Math class
        double squareRoot = Math.sqrt(number);//using Math.sqrt() method to calculate square root
        return squareRoot;
    }

    public static void main(String[] args) {
        double number = 16.0; //example with 16.0 as a double number
        double result = calculateSquareRoot(number); //putting the number through the method of "calculateSquareRoot"
        System.out.println("Square root of " + number + " is " + result);
    }
}

SquareRootCalculator.main(null);
```

    Square root of 16.0 is 4.0


## Question 5: If, While, Else (Unit 3-4)
Situation: You are developing a simple grading system where you need to determine if a given score is passing or failing.

### (a) Explain the roles and usage of the if statement, while loop, and else statement in Java programming. Provide examples illustrating each.

**If Statement:**
The if statement in Java is used to make decisions based on certain conditions. It allows you to execute a block of code only if a specified condition is true. Down below is the basic skeleton of an if statement.
```cs
if (condition) {
    // code to be executed if condition is true
}
```

This is a basic example of how a if statement should work.
```cs
int x = 10;
if (x > 5) {
    System.out.println("x is greater than 5");
}
```
The if statement should print "x is greater than 5".

**While loop:**
The while loop is used to repeatedly execute a block of code as long as a specified condition is true. It's typically used when you don't know in advance how many times the code should be executed.

```cs
while (condition) {
    // code to be executed
}
```

```cs
int i = 0;
while (i < 5) {
    System.out.println("Value of i: " + i);
    i++;
}
```
The while loop should print "Value of i:" 5 times (0-4 index, which is 5 numbers) with numbers 0-4 following it, respectively. 

**Else Statement**:
The else statement follows an if statement and executes a block of code if the if condition is false. It's used to handle cases where the condition specified in the if statement evaluates to false.

Skeleton:
```cs
if (condition) {
    // code to be executed if condition is true
} 
    else {
        // code to be executed if condition is false
    }
```

Example:
```cs
int y = 5;
if (y > 10) {
    System.out.println("y is greater than 10");
} 
    else {
        System.out.println("y is not greater than 10");
    }
```
Else statement should print out "y is not greater than 10" because the if statement is false. Therefore, the code runs through the else statement and it's true (therefore the statement is printed out).

### (b) You need to implement a method printGradeStatus that takes an integer score as input and prints “Pass” if the score is greater than or equal to 60, and “Fail” otherwise. Write the method signature and the method implementation. Include comments to explain your code.

### Code:


```java
public class GradeChecker {
    // Method to print "Pass" if score is >= 60, otherwise "Fail"
    public static void printGradeStatus(int score) {
        // Check if the score is greater than or equal to 60
        if (score >= 60) {
            //if score is greater/equal to 60, it should print "Pass"
            System.out.println("Pass");
        } 
            else {
                // If score is less than 60, it should print "Fail"
                System.out.println("Fail");
            }
    }

    public static void main(String[] args) {
        printGradeStatus(75);  // Should print "Pass"
        printGradeStatus(45);  // Should print "Fail"
    }
}

GradeChecker.main(null);
```

    Pass
    Fail

