---
title: Algorythmic Prep
description: All sorts,
layout: post
courses: {'csa': {'week': 25}}
categories: ['C4.0']
type: tangibles
comments: True
---

```java
import java.util.Arrays;

public class TList<T extends Comparable<T>> {
    private T[] array;

    public TList(T[] array) {
        this.array = array;
    }

    public void bubbleSort() {
        SortingAlgorithms.bubbleSort(array);
    }

    public void selectionSort() {
        SortingAlgorithms.selectionSort(array);
    }

    public void insertionSort() {
        SortingAlgorithms.insertionSort(array);
    }

    public void mergeSort() {
        SortingAlgorithms.mergeSort(array);
    }

    public void quickSort() {
        SortingAlgorithms.quickSort(array);
    }

    public void print() {
        SortingAlgorithms.printArray(array);
    }
}

public class SortingAlgorithms {
    // Bubble Sort
    public static <T extends Comparable<T>> long bubbleSort(T[] arr) {
        long startTime = System.nanoTime();

        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Selection Sort
    public static <T extends Comparable<T>> long selectionSort(T[] arr) {
        long startTime = System.nanoTime();

        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Insertion Sort
    public static <T extends Comparable<T>> long insertionSort(T[] arr) {
        long startTime = System.nanoTime();

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Merge Sort
    public static <T extends Comparable<T>> long mergeSort(T[] arr) {
        long startTime = System.nanoTime();

        mergeSort(arr, 0, arr.length - 1);

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static <T extends Comparable<T>> void mergeSort(T[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        T[] L = Arrays.copyOfRange(arr, left, mid + 1);
        T[] R = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    // Quick Sort
    public static <T extends Comparable<T>> long quickSort(T[] arr) {
        long startTime = System.nanoTime();

        quickSort(arr, 0, arr.length - 1);

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Utility method to print array
    public static <T> void printArray(T[] arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[] intArray = {64, 34, 25, 12, 22, 11, 90};
        TList<Integer> intList = new TList<>(intArray);

        System.out.println("Original Integer array:");
        intList.print();
        System.out.println("");

        intList.bubbleSort();
        System.out.println("After Bubble Sort:");
        intList.print();
        long bubbleSortTime = SortingAlgorithms.bubbleSort(intArray);
        System.out.println("Bubble Sort Time: " + bubbleSortTime + " ns");
        System.out.println("");

        intList.selectionSort();
        System.out.println("After Selection Sort:");
        intList.print();
        long selectionSortTime = SortingAlgorithms.selectionSort(intArray);
        System.out.println("Selection Sort Time: " + selectionSortTime + " ns");
        System.out.println("");

        intList.insertionSort();
        System.out.println("After Insertion Sort:");
        intList.print();
        long insertionSortTime = SortingAlgorithms.insertionSort(intArray);
        System.out.println("Insertion Sort Time: " + insertionSortTime + " ns");
        System.out.println("");

        intList.mergeSort();
        System.out.println("After Merge Sort:");
        intList.print();
        long mergeSortTime = SortingAlgorithms.mergeSort(intArray);
        System.out.println("Merge Sort Time: " + mergeSortTime + " ns");
        System.out.println("");

        intList.quickSort();
        System.out.println("After Quick Sort:");
        intList.print();
        long quickSortTime = SortingAlgorithms.quickSort(intArray);
        System.out.println("Quick Sort Time: " + quickSortTime + " ns");     
    }
}

Main.main(null);
```

    Original Integer array:
    64 34 25 12 22 11 90 
    
    After Bubble Sort:
    11 12 22 25 34 64 90 
    Bubble Sort Time: 4200 ns
    
    After Selection Sort:
    11 12 22 25 34 64 90 
    Selection Sort Time: 4200 ns
    
    After Insertion Sort:
    11 12 22 25 34 64 90 
    Insertion Sort Time: 3000 ns
    
    After Merge Sort:
    11 12 22 25 34 64 90 
    Merge Sort Time: 14600 ns
    
    After Quick Sort:
    11 12 22 25 34 64 90 
    Quick Sort Time: 6300 ns



```java
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

Main.main(null);

```

    Original List: [{"data": "5"},{"data": "3"},{"data": "8"},{"data": "1"}]
    Sorted List: [{"data": "1"},{"data": "3"},{"data": "5"},{"data": "8"}]

