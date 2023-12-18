---
layout: post
title: Sorting Blog
description: Explanation on our Sorting code
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

The code above is our frontend and it features a chart at the top, created using the JSCharting library, similar to our fibonacci sorting program. It displays the execution time of various sorting algorithms. The chart is initialized with default settings and an empty dataset. Below the chart, there is an interactive data table with headers such as "Sort Type," "Iterations," "Comparisons," and more. This table is initially empty and will be populated dynamically.

The JavaScript functions handle the fetching of sorting algorithm data from a specified API endpoint (base_url). The read_pull() function triggers the data fetching for different sorting algorithms, such as merge, insertion, selection, and bubble sorts. The fetched data is then used to populate a table row for each algorithm, updating both the HTML table and the chart simultaneously.

The chart is designed to represent the execution time of each sorting algorithm on the horizontal axis, with each algorithm depicted as a separate column on the vertical axis. The updateChart() function is responsible for updating the chart with new data, and it is called after each new row is added to the data table.

# Backend

# Sorting Algorithms Class


```python
class SortingAlgorithm {
    protected int iterations;
    protected int comparisons;
    protected int mergesOrSwaps;
    protected long executionTime;

    public SortingAlgorithm() {
        iterations = 0;
        comparisons = 0;
        mergesOrSwaps = 0;
        executionTime = 0;
    }

    public void resetStatistics() {
        iterations = 0;
        comparisons = 0;
        mergesOrSwaps = 0;
        executionTime = 0;
    }

    public void displayStatistics() {
        System.out.println("Iterations: " + iterations);
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Merges/Swaps: " + mergesOrSwaps);
        System.out.println("Execution Time: " + executionTime + " milliseconds");
    }

    public void sort(DogBreed[] array) {
        // This method should be overridden by each sorting algorithm class
    }
}
```

- This is an abstract class representing a template for sorting algorithms
- It contains fields (iterations, comparisons, mergesOrSwaps, executionTime) to track algorithm statistics
- The constructor initializes these fields, and resetStatistics method resets them
- displayStatistics prints the statistics to the console
- The sort method is marked abstract, indicating that it should be implemented by subclasses

# DogBreed Class


```python
class DogBreed {
    private int id;
    private String breed;
    private String origin;
    private String url;
    private String img;

    public DogBreed(int id, String breed, String origin, String url, String img) {
        this.id = id;
        this.breed = breed;
        this.origin = origin;
        this.url = url;
        this.img = img;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return "DogBreed{" +
                "id:" + id +
                ", breed:'" + breed + '\'' +
                ", origin:'" + origin + '\'' +
                ", url:'" + url + '\'' +
                ", img:'" + img + '\'' +
                '}';
    }
}
```

- This class represents a DogBreed object with fields for id, breed, origin, URL, and image.
- The toString method is overridden to provide a formatted string representation of the object.

# BubbleSort Class


```python

class BubbleSort extends SortingAlgorithm {
    @Override
    public void sort(DogBreed[] array) {
        iterations = 0;
        comparisons = 0;
        mergesOrSwaps = 0;
        executionTime = 0;

        executionTime = System.currentTimeMillis();

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (array[j].getBreed().compareTo(array[j + 1].getBreed()) > 0) {
                    // Swap array[j] and array[j+1]
                    DogBreed temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    mergesOrSwaps++;
                }
                iterations++;
            }
        }

        executionTime = System.currentTimeMillis() - executionTime;
    }
}
```

- BubbleSort extends SortingAlgorithm, inheriting its fields and methods
- The sort method is overridden to implement the bubble sort algorithm
- It counts iterations, comparisons, swaps, and measures execution time

# Selction Sort Class


```python
class SelectionSort extends SortingAlgorithm {
    @Override
    public void sort(DogBreed[] array) {
        iterations = 0;
        comparisons = 0;
        mergesOrSwaps = 0;
        executionTime = 0;

        executionTime = System.currentTimeMillis();

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (array[j].getBreed().compareTo(array[minIndex].getBreed()) < 0) {
                    minIndex = j;
                }
                iterations++;
            }

            // Swap array[i] and array[minIndex]
            DogBreed temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;

            mergesOrSwaps++;
        }

        executionTime = System.currentTimeMillis() - executionTime;
    }
}
```

- SelectionSort extends SortingAlgorithm
- The sort method is overridden to implement the selection sort algorithm
- It counts iterations, comparisons, swaps, and measures execution time

# Merge Sort Class


```python
class MergeSort extends SortingAlgorithm {
    @Override
    public void sort(DogBreed[] array) {
        iterations = 0;
        comparisons = 0;
        mergesOrSwaps = 0;
        executionTime = 0;

        executionTime = System.currentTimeMillis();

        mergeSort(array, 0, array.length - 1);

        executionTime = System.currentTimeMillis() - executionTime;
    }

    private void merge(DogBreed[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        DogBreed[] leftArray = new DogBreed[n1];
        DogBreed[] rightArray = new DogBreed[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            comparisons++;
            if (leftArray[i].getBreed().compareTo(rightArray[j].getBreed()) <= 0) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
            iterations++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
            mergesOrSwaps++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
            mergesOrSwaps++;
        }
    }

    private void mergeSort(DogBreed[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }
}
```

- MergeSort extends SortingAlgorithm
- The sort method is overridden to implement the merge sort algorithm
- It uses helper methods merge and mergeSort

# Insertion Sort Class


```python
class InsertionSort extends SortingAlgorithm {
    @Override
    public void sort(DogBreed[] array) {
        iterations = 0;
        comparisons = 0;
        mergesOrSwaps = 0;
        executionTime = 0;

        executionTime = System.currentTimeMillis();

        int n = array.length;
        for (int i = 1; i < n; ++i) {
            DogBreed key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].getBreed().compareTo(key.getBreed()) > 0) {
                comparisons++;
                array[j + 1] = array[j];
                j = j - 1;
                mergesOrSwaps++;
                iterations++;
            }
            array[j + 1] = key;
            iterations++;
        }

        executionTime = System.currentTimeMillis() - executionTime;
    }
}
```

- InsertionSort extends SortingAlgorithm
- The sort method is overridden to implement the insertion sort algorithm
- It counts iterations, comparisons, swaps, and measures execution time

# SortingAlgs Main Class


```python
public class SortingAlgs {
    public static void main(String[] args) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://covid-193.p.rapidapi.com/statistics"))
                    .header("X-RapidAPI-Key", "1748ee8916mshe4a05c6edb7af0ap1399f4jsn23f82b0ddfa3")
                    .header("X-RapidAPI-Host", "covid-193.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            // System.out.println(response.body());
            // Parse the response body into an array of Covid objects
            Covid[] unsortedcovids = parseResponse(response.body());
            
            for (Covid covid : unsortedcovids) {
                System.out.println(covid);
            }
            // Create an instance of the sorting algorithm
            SortingAlgorithm bubbleSortingAlgorithm = new BubbleSort();

            // Sort the array of dog breeds
            Covid[] bubbleCovids = bubbleSortingAlgorithm.sort(unsortedcovids);

            // Display sorting statistics
            System.out.println("Bubble");
            bubbleSortingAlgorithm.displayStatistics();

            SortingAlgorithm selectionSortingAlgorithm = new SelectionSort();

            // Sort the array of dog breeds
            Covid[] selectionCovids = selectionSortingAlgorithm.sort(unsortedcovids);

            // Display sorting statistics
            System.out.println("Selection");
            selectionSortingAlgorithm.displayStatistics();

            SortingAlgorithm mergSortingAlgorithm = new MergeSort();

            // Sort the array of dog breeds
            Covid[] mergeCovids = mergSortingAlgorithm.sort(unsortedcovids);

            // Display sorting statistics
            System.out.println("Merge");
            mergSortingAlgorithm.displayStatistics();
            

            SortingAlgorithm insertionSortingAlgorithm = new InsertionSort();

            // Sort the array of dog breeds
            Covid[] insertionCovids = insertionSortingAlgorithm.sort(unsortedcovids);

            // Display sorting statistics
            System.out.println("Insertion");
            insertionSortingAlgorithm.displayStatistics();
            
            // Print the sorted dog breeds
            for (Covid deaths : insertionCovids) {
                System.out.println(deaths);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

This Java code fetches COVID-19 statistics from a RapidAPI endpoint, parses the response into an array of Covid objects, and then applies four different sorting algorithms (Bubble Sort, Selection Sort, Merge Sort, and Insertion Sort) to sort the array based on some criteria. The code uses a common interface called SortingAlgorithm, implemented by classes such as BubbleSort, SelectionSort, MergeSort, and InsertionSort. Each sorting algorithm has a sort method that takes an array of Covid objects and returns the sorted array. After sorting, the code prints the sorted array and displays statistics for each sorting algorithm, such as the number of comparisons and swaps performed during the sorting process. Additionally, it includes error handling using a try-catch block to handle any exceptions that might occur during the HTTP request or sorting process, printing the stack trace if an exception occurs. The code also contains commented-out lines that can be uncommented to print the raw response body received from the COVID-19 statistics API.

# parseResponse Method:


```python

private static Covid[] parseResponse(String responseBody) {
    // Parse the response body into an array of Covid objects
    // Example parsing logic: (You may need to adapt this based on the actual response format)
    String[] lines = responseBody.split("continent");

    // for (int i = 0; i < lines.length; i++) {
    //     System.out.println("AAAAAAAAA"+lines[i]);
    // }
    Covid[] covids = new Covid[lines.length];
    for (int i = 1; i < lines.length; i++) {
        // System.out.println("AAAAAAAAA"+lines[i]);
        String[] parts = lines[i].split(",");
        // System.out.println(parts[1]);
        // System.out.println(parts[2]);
        // System.out.println(parts[8]);
        // System.out.println(parts[11]);
        // System.out.println(parts[13]);
        String country = parts[1].replace("\"country\":", "");
        // System.out.println(country);
        String poptemp = parts[2].replace("\"population\":", "");
        // System.out.println(poptemp);
        if(poptemp.equals("null")){
            poptemp = "0";
        }
        Integer population = Integer.parseInt(poptemp);
        String casesTemp = parts[8].replace("\"total\":", "");
        // System.out.println(casesTemp);
        String casesm = casesTemp.substring(0, casesTemp.length()-1);
        if(casesm.equals("null")){
            casesm = "0";
        }
        Integer cases = Integer.parseInt(casesm);
        // System.out.println(cases);
        String deathsTemp = parts[11].replace("\"total\":", "");
        // System.out.println(deathsTemp);
        String deathsm = deathsTemp.substring(0, deathsTemp.length()-1);
        if(deathsm.equals("null")){
            deathsm = "0";
        }
        Integer deaths = Integer.parseInt(deathsm);
        // System.out.println(deaths);
        String testsTemp = parts[13].replace("\"total\":", "");
        // System.out.println(testsTemp);
        String testsm = testsTemp.substring(0, testsTemp.length()-1);
        if(testsm.equals("null")){
            testsm = "0";
        }
        Integer tests = Integer.parseInt(testsm);
        // System.out.println(tests);
        covids[i] = new Covid(country, population, cases, deaths, tests);
    }
    covids = Arrays.copyOfRange(covids, 1, covids.length);
    return covids;
}
//test
```

This Java code defines a method named parseResponse that takes a String responseBody as input, representing the response received from a COVID-19 statistics API. The method parses this response into an array of Covid objects. The parsing logic is based on splitting the response into lines and then further splitting each line into parts to extract relevant information such as country, population, total cases, total deaths, and total tests. The parsed information is used to create new instances of the Covid class.

1. The response body is split into an array of lines using the "continent" as the delimiter.
2. For each line (starting from index 1 to skip the first line), it is further split into parts using a comma as the delimiter.
3. The necessary information (country, population, cases, deaths, tests) is extracted from specific parts of each line, removing unnecessary characters.
4. Special handling is done for cases where certain fields may be "null" in the response, setting them to 0.
5. The extracted information is converted to the appropriate data types (Integer) and used to create new instances of the Covid class.
6. The resulting array of Covid objects is then trimmed to exclude the first element (initialized as null) and returned.
