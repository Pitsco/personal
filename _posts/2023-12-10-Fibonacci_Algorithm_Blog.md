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


```python
<script src="https://code.jscharting.com/latest/jscharting.js"></script>

<div style="height: 650px;">
    <div id="chartDiv" style="max-width: 640px; height: 650px; margin: 0 auto;">
    </div>
    <div class="container">
        <label for="numberInput">Enter a number:</label>
        <input type="number" id="numberInput" placeholder="Enter a number">
        <button id="calculateButton" onclick="read_pull()">Calculate Fibonacci</button>
        <title>Fibonacci - Live Updating Table</title>
        <style>
          table {
            border-collapse: collapse;
            width: 50%;
            margin: 20px;
          }
      
          table, th, td {
            border: 1px solid black;
          }
      
          th, td {
            padding: 10px;
            text-align: left;
          }
      
          th {
            background-color: #f2f2f2;
          }
        </style>
      </head>
      <body>
      
      <table id="loopTable">
        <thead>
          <tr>
            <th>Name of Loop</th>
            <th>Time Taken</th>
            <th>Steps Taken</th>
            <th>Final Result</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>For Loop</td>
            <td id="forLoopTime">-</td>
            <td id="forLoopSteps">-</td>
            <td id="forLoopResult">-</td>
          </tr>
          <tr>
            <td>While Loop</td>
            <td id="whileLoopTime">-</td>
            <td id="whileLoopSteps">-</td>
            <td id="whileLoopResult">-</td>
          </tr>
          <tr>
            <td>Recursion Loop</td>
            <td id="recursionLoopTime">-</td>
            <td id="recursionLoopSteps">-</td>
            <td id="recursionLoopResult">-</td>
          </tr>
          <tr>
            <td>Stream Loop</td>
            <td id="streamLoopTime">-</td>
            <td id="streamLoopSteps">-</td>
            <td id="streamLoopResult">-</td>
          </tr>
        </tbody>
      </table>
    </div>
</div>

<script>
    var chart = JSC.chart('chartDiv', { 
        debug: true, 
        type: 'horizontal column solid', 
        title_label: { 
            text: 'Time took to Run each Fibonacci Method',
            style_fontWeight: 'bold',
            position: 'top middle',
            style_fontSize: 16 
        }, 
        legend_visible: true, 
        legend_template: "%icon %name",
        yAxis: { 
            scale_range: { padding: 0.1, min: 0 }, 
            orientation: 'opposite',
            label_text: "Method",
            label_style_fontWeight: 'bold'
        }, 
        xAxis: { 
            defaultTick_label_width: 100, 
            label_text: "Time",
            label_style_fontWeight: 'bold',
            crosshair: { 
                enabled: true, 
                gridLine_visible: false, 
                outline_width: 0, 
                label_style_fontWeight: 'bold'
            } 
        }, 
        defaultSeries_palette: 'default', 
        defaultPoint: { 
            outline_width: 0, 
            tooltip: '<b>%yValue</b>', 
        }, 
        defaultTooltip_label_text: '%points', 
        series: makeSeries(getData()) 
    }); 
  
    var chartData = getData();

function makeSeries(data) {
  return [
    {
      points: data.map(function (item) {
        return {
          name: item.type,
          y: item.value,
          method: item.name
        };
      })
    }
  ];
}

function updateChart(newData) {
  // Update existing data with new data
  chartData = chartData.concat(newData);

  // Update chart series with the new data
  chart.options({ series: makeSeries(chartData) });

  // Redraw the chart
  chart.update('modify', 'refresh');
}

function getData() {
  return [

  ];
}
</script>

<script>
const base_url = "http://localhost:8799/api/fibonacci/";

function read_pull() {
    const userFiboInput = document.getElementById("numberInput").value;
    console.log(userFiboInput);

    // set options for cross-origin header request
    const authOptions = {
        method: 'GET', // GET request 
        mode: 'cors', // no-cors, cors, same-origin
        cache: 'default', // default, no-cache, reload, force-cache, only-if-cached
        // credentials: 'include',
        headers: {
            'Content-Type': 'application/json',
        },
    };

    // Fetch data for the "for" loop
    fetch(base_url + "for/" + userFiboInput, authOptions)
      .then(response => response.json())
      .then(data => updateTableRow("forLoop", data));

    // Fetch data for the "while" loop
    fetch(base_url + "while/" + userFiboInput, authOptions)
      .then(response => response.json())
      .then(data => updateTableRow("whileLoop", data));

    // Fetch data for the "recursion" loop
    fetch(base_url + "recursion/" + userFiboInput, authOptions)
      .then(response => response.json())
      .then(data => updateTableRow("recursionLoop", data));

    // Fetch data for the "stream" loop
    fetch(base_url + "stream/" + userFiboInput, authOptions)
      .then(response => response.json())
      .then(data => updateTableRow("streamLoop", data));
  }

  function updateTableRow(loopName, data) {
    document.getElementById(loopName + "Time").textContent = data.timeTaken;
    document.getElementById(loopName + "Steps").textContent = data.intermediateSteps;
    document.getElementById(loopName + "Result").textContent = data.fibonacciNumbers;
  
    updateChart([
      {
        type: 'Fibonacci (' + loopName + ')',
        name: loopName,
        value: data.timeTaken,
      }
      ]);
  }
</script>
```

We integrated the JSCharting library to create a dynamic chart visualizing the time taken to run various Fibonacci calculation methods. The page includes an HTML table to display the results of different loop types (for, while, recursion, and stream) alongside their respective execution times, step counts, and final results. Users can input a number and click a button to trigger the calculation of Fibonacci numbers using different loop methods. The JavaScript code interacts with a Fibonacci API, fetching data for each loop type asynchronously and updating both the table and the chart with the obtained results. The chart displays the execution times for each method, providing a visual comparison. The integration of dynamic data fetching, charting, and table updating makes this code a comprehensive example of combining interactive visualization and API interaction in a web application.

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
