---
layout: post
title: Sorting Blog
description: Explanation on our Sorting code
courses: {'compsci': {'week': 13}}
type: hacks
---

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
                    .uri(URI.create("https://dog-breeds2.p.rapidapi.com/dog_breeds"))
                    .header("X-RapidAPI-Key", "48e23c6bf3msh9a6baf3e68d9a4ep14546ajsn1a39e98c4ad5")
                    .header("X-RapidAPI-Host", "dog-breeds2.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            DogBreed[] dogBreeds = parseResponse(response.body()); //parse the response body into an array of DogBreed objects

            SortingAlgorithm sortingAlgorithm = new BubbleSort(); //create an instance of the sorting algorithm

            sortingAlgorithm.sort(dogBreeds);//sort the array of dog breeds

            sortingAlgorithm.displayStatistics();//display sorting statistics

            for (DogBreed breed : dogBreeds) {//print the sorted dog breeds
                System.out.println(breed);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```

- This is the main class containing the main method for testing sorting algorithms
- It makes an HTTP request to fetch dog breeds, parses the response using parseResponse, and then tests the sorting algorithms with the fetched data

# parseResponse Method:


```python
private static DogBreed[] parseResponse(String responseBody) {//parse the response body into an array of DogBreed objects
    String[] lines = responseBody.split("\n");
    DogBreed[] dogBreeds = new DogBreed[lines.length];
    for (int i = 0; i < lines.length; i++) {
        String[] parts = lines[i].split(":");
        int id = Integer.parseInt(parts[1]);
        String breed = parts[3].replace("\"", "");
        String origin = parts[5].replace("\"", "");
        String url = parts[7].replace("\"", "");
        String img = parts[9].replace("\"", "");
        dogBreeds[i] = new DogBreed(id, breed, origin, url, img);
    }
    return dogBreeds;
}
```

- parseResponse is a helper method to parse the response body (assumed to be in a specific format) into an array of DogBreed objects

represents a framework for various sorting algorithms applied to a list of dog breeds obtained from an API. The sorting algorithms are implemented in separate classes, and their statistics are tracked for analysis. The main method serves as a testing ground for these sorting algorithms. The parseResponse method is responsible for converting the API response into an array of DogBreed objects.
