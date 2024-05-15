---
title: Algorythmic Prep
description: All sorts
layout: post
courses: {'csa': {'week': 25}}
categories: ['C4.0']
type: tangibles
comments: True
---

### Bubble Sort:

![Image](https://miro.medium.com/v2/resize:fit:776/1*7QsZkfrRGhAu5yxxeDdzsA.png)

- It repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.
- The pass through the list is repeated until the list is sorted.
- In each iteration, the largest unsorted element "bubbles up" to its correct position.

### Selection Sort:

![image](https://he-s3.s3.amazonaws.com/media/uploads/2888f5b.png)
- It divides the input list into two parts: the sorted and the unsorted sublists.
- Initially, the sorted sublist is empty, and the unsorted sublist contains all the elements.
- It repeatedly finds the smallest element from the unsorted sublist and moves it to the end of the sorted sublist.
- The algorithm continues this process until the unsorted sublist becomes empty.

### Insertion Sort:
![image2](https://miro.medium.com/v2/resize:fit:818/1*_NOe6jL9veyR4yAyf85dzA.png)
- It builds the final sorted list one element at a time.
- It takes one element from the input data and places it in its correct position within the sorted list.
- It iterates through the remaining elements, shifting them to the right if they are larger than the current element being sorted.


### Merge Sort:
![image3](https://media.geeksforgeeks.org/wp-content/uploads/20230706153706/Merge-Sort-Algorithm-(1).png)
- It is a divide-and-conquer algorithm that divides the input list into two halves, recursively sorts each half, and then merges them.
- It divides the list until it cannot be further divided (i.e., it has one or zero elements).
- It then merges the smaller sorted lists into larger sorted lists until the entire list is sorted.

### Quick Sort:
![image4](https://miro.medium.com/v2/resize:fit:750/format:webp/1*DtH6fEdBhoUGnjBWudJ8pA.png)
- It is also a divide-and-conquer algorithm that partitions the input list into two parts around a pivot element.
- It selects a pivot element from the list and partitions the other elements into two sublists: one with elements less than the pivot and one with elements greater than the pivot.
- It then recursively applies the same process to the sublists until the entire list is sorted.
- It's worth noting that the choice of pivot can greatly affect the performance of the algorithm; the implementation here uses the last element as the pivot for simplicity.

# Code in Demostration with Generic T Lists (Collectables):


```Java
public class TList<T extends Comparable<T>> { // Defining a generic class TList with a type parameter T that extends Comparable<T>
    private List<T> list; // List to store elements of type T
    
    public TList() { //Constructor to initialize the list as an ArrayList
        list = new ArrayList<>();
    }

    public void add(T item) { //Simple method to add an element to the list
        list.add(item);
    }

    public void bubbleSort() {//Bubble sort algorithm to sort the list
        int n = list.size();
        // Traverse through the list
        for (int i = 0; i < n - 1; i++) { //iterates through everything but last index to prevent out of bounds exception
            for (int j = 0; j < n - i - 1; j++) { //sorts the list the amount of times the list is needed to sorted
                if (list.get(j).compareTo(list.get(j + 1)) > 0) { //compare adjacent elements and swap if necessary
                    T temp = list.get(j); //setting up temporary variable
                    list.set(j, list.get(j + 1)); //swapping variables
                    list.set(j + 1, temp);
                }
            }
        }
    }

    public void selectionSort() {// Selection sort algorithm to sort the list
        int n = list.size();
        // Traverse through the list
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // Find the index of the minimum element in the unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swap the minimum element with the first element of the unsorted portion
            if (minIndex != i) {
                T temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }

    // Insertion sort algorithm to sort the list
    public void insertionSort() {
        int n = list.size();
        // Traverse through the list
        for (int i = 1; i < n; ++i) {
            T key = list.get(i);
            int j = i - 1;
            // Move elements of list[0..i-1], that are greater than key, to one position ahead of their current position
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
    }

    // Merge sort algorithm to sort the list
    public void mergeSort() {
        // Create a temporary list to perform merge sort
        List<T> temp = new ArrayList<>(list);
        mergeSortHelper(temp, 0, list.size() - 1);
    }

    // Helper method for merge sort algorithm
    private void mergeSortHelper(List<T> arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            // Recursively sort the left and right halves
            mergeSortHelper(arr, left, middle);
            mergeSortHelper(arr, middle + 1, right);
            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }

    // Method to merge two sorted sublists
    private void merge(List<T> arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary lists to hold the elements of the two sublists
        List<T> L = new ArrayList<>();
        List<T> R = new ArrayList<>();

        // Copy data to temporary lists L[] and R[]
        for (int i = 0; i < n1; ++i)
            L.add(arr.get(left + i));
        for (int j = 0; j < n2; ++j)
            R.add(arr.get(middle + 1 + j));

        // Merge the temporary lists back into arr[left..right]
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L.get(i).compareTo(R.get(j)) <= 0) {
                arr.set(k, L.get(i));
                i++;
            } else {
                arr.set(k, R.get(j));
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr.set(k, L.get(i));
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr.set(k, R.get(j));
            j++;
            k++;
        }
    }

    // Quick sort algorithm to sort the list
    public void quickSort() {
        // Create a temporary list to perform quick sort
        List<T> temp = new ArrayList<>(list);
        quickSortHelper(temp, 0, list.size() - 1);
    }

    // Helper method for quick sort algorithm
    private void quickSortHelper(List<T> arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after the pivot
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }

    // Method to partition the array for quick sort
    private int partition(List<T> arr, int low, int high) {
        // Choose the pivot element
        T pivot = arr.get(high);
        int i = (low - 1);
        // Traverse through the array
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr.get(j).compareTo(pivot) < 0) {
                i++;

                // Swap arr[i] and arr[j]
                T temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        T temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }

    // Method to print the elements of the list
    public void print() {
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Main method to test the TList class
    public static void main(String[] args) {
        TList<Integer> list = new TList<>();
        list.add(64);
        list.add(34);
        list.add(25);
        list.add(12);
        list.add(22);
        list.add(11);
        list.add(90);

        System.out.println("Original List:");
        list.print();

        System.out.println("\nBubble Sort:");
        list.bubbleSort();
        list.print();

        System.out.println("\nSelection Sort:");
        list.selectionSort();
        list.print();

        System.out.println("\nInsertion Sort:");
        list.insertionSort();
        list.print();

        System.out.println("\nMerge Sort:");
        list.mergeSort();
        list.print();

        System.out.println("\nQuick Sort:");
        list.quickSort();
        list.print();
    }
}

TList.main(null)
```

    Original List:
    64 34 25 12 22 11 90 
    
    Bubble Sort:
    11 12 22 25 34 64 90 
    
    Selection Sort:
    11 12 22 25 34 64 90 
    
    Insertion Sort:
    11 12 22 25 34 64 90 
    
    Merge Sort:
    11 12 22 25 34 64 90 
    
    Quick Sort:
    11 12 22 25 34 64 90 



```Java
import java.util.Iterator;
import java.util.NoSuchElementException;

class Node<T extends Comparable<T>> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void sort() {
        if (size <= 1) return;
        boolean swapped;
        do {
            swapped = false;
            Node<T> current = head;
            while (current.next != null) {
                if (current.data.compareTo(current.next.data) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    @Override
    public String toString() {
        StringBuilder json = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            json.append("{\"data\": \"").append(current.data).append("\"},");
            current = current.next;
        }
        if (json.length() > 1) {
            json.setLength(json.length() - 1);
        }
        json.append("]");
        return json.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(1);
        
        System.out.println("Original List: " + list);
        
        list.sort();
        System.out.println("Sorted List: " + list);
    }
}

Main.main(null)
```

    Original List: [{"data": "5"},{"data": "3"},{"data": "8"},{"data": "1"}]
    Sorted List: [{"data": "1"},{"data": "3"},{"data": "5"},{"data": "8"}]



```Java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> extends ArrayList<T> {

    // Constructor
    public CustomList() {
        super();
    }

    // Performance sort method
    public void performanceSort() {
        Collections.sort(this);
    }

    // Override toString method to return JSON representation
    @Override
    public String toString() {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            json.append("{")
                .append("\"index\": ").append(i).append(", ")
                .append("\"value\": \"").append(get(i)).append("\"")
                .append("}");
            if (i < size() - 1) {
                json.append(", ");
            }
        }
        json.append("]");
        return json.toString();
    }
}

public class Tester {
    public static void main(String[] args) {
        CustomList<String> list = new CustomList<>();
        list.add("banana");
        list.add("apple");
        list.add("cherry");

        System.out.println("Original List:");
        System.out.println(list);

        // Sort by default (alphabetical order)
        list.performanceSort();
        System.out.println("\nSorted List (default):");
        System.out.println(list);

        // Sort by length
        list.sort((s1, s2) -> s1.length() - s2.length());
        System.out.println("\nSorted List (by length):");
        System.out.println(list);
    }
}

Tester.main(null)
```

    Original List:
    [{"index": 0, "value": "banana"}, {"index": 1, "value": "apple"}, {"index": 2, "value": "cherry"}]
    
    Sorted List (default):
    [{"index": 0, "value": "apple"}, {"index": 1, "value": "banana"}, {"index": 2, "value": "cherry"}]
    
    Sorted List (by length):
    [{"index": 0, "value": "apple"}, {"index": 1, "value": "banana"}, {"index": 2, "value": "cherry"}]

