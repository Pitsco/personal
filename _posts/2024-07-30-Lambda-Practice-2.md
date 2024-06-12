---
title: Lambda Practice 2
description: Fourth CSA FRQ and explanations
layout: post
courses: {'csa': {'week': 25}}
categories: ['C4.0']
type: tangibles
comments: True
---

# Question 1
Static method references:

a. in staticMR(), declare a List of integers with 1, 2, 7, 4, and 5 as values.

b. using a Consumer typed for List<Integer> and the Collections.sort static method, code a lambda that sorts the list passed  in.

c. invoke the lambda.

d. prove that the sort worked.

e. re-initialise the list (so it is unsorted again).

f. code the method reference version.

    i. sort() is overloaded : sort(List) and sort(List, Comparator)

    ii. how does Java know which version to call?

g. invoke the method reference version.

h. prove that the sort worked.


```java
public class StaticMethodReferenceExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 7, 4, 5);
        System.out.println("Initial List: " + numbers);
        
        Consumer<List<Integer>> sortLambda = list -> Collections.sort(list);
        sortLambda.accept(numbers);
        System.out.println("Sorted List (using lambda): " + numbers);
        
        numbers = Arrays.asList(1, 2, 7, 4, 5);
        System.out.println("Re-initialized List: " + numbers);
        
        Consumer<List<Integer>> sortMethodRef = Collections::sort;
        
        // g. Invoke the method reference version.
        sortMethodRef.accept(numbers);
        System.out.println("Sorted List (using method reference): " + numbers);
    }
}

StaticMethodReferenceExample.main(null)
```

    Initial List: [1, 2, 7, 4, 5]
    Sorted List (using lambda): [1, 2, 4, 5, 7]
    Re-initialized List: [1, 2, 7, 4, 5]
    Sorted List (using method reference): [1, 2, 4, 5, 7]


# Question 2:
Bound method references (calling instance methods on a particular object):

a. in boundMR(), declare a String variable called name and initialise it to “Mr. Joe Bloggs”.

b. using a Predicate typed for String, code a lambda that checks to see if name starts with the prefix passed in.

c. invoke the lambda passing in “Mr.” which should return true.

d. invoke the lambda passing in “Ms.” which should return false.

e. code the method reference version.

f. repeat c and d above except using the method reference version.


```java
public class BoundMethodReferenceExample {
    public static void main(String[] args) {
        String name = "Mr. Joe Bloggs";
        System.out.println("Initial List: " + name);
        
        Predicate<String> sortLambda = n -> n.startsWith("Mr.");
        Predicate<String> sortLambda2 = j -> j.startsWith("Ms.");
        boolean result = sortLambda.test(name);
        boolean result2 = sortLambda2.test(name);
        System.out.println("Does the name have 'Mr.'? " + result);
        System.out.println("Does the name have 'Ms.'? " + result2);

        Predicate<String> testMethodRef = name::startsWith;
        
        // g. Invoke the method reference version.
        boolean result3 = testMethodRef.test("Mr.");
        boolean result4 = testMethodRef.test("Ms.");
        System.out.println("Contain 'Mr.' (using method reference): " + result3);
        System.out.println("Contain 'Ms.' (using method reference): " + result4);
    }
}

BoundMethodReferenceExample.main(null)
```

    Initial List: Mr. Joe Bloggs
    Does the name have 'Mr.'? true
    Does the name have 'Ms.'? false
    Contain 'Mr.' (using method reference): true
    Contain 'Ms.' (using method reference): false


# Question 3:
Unbound method references (calling instance methods on a parameter):

a. in unboundMR(), code a Predicate lambda typed for String that checks to see if the string passed in is empty.

b. invoke the lambda passing in “” (returns true).

c. invoke the lambda passing in “xyz” (returns false).

d. code the method reference version of the lambda from (a).

e. repeat b and c above except using the method reference version.

f. code a BiPredicate lambda typed for String and String:

    i. the lambda takes in two parameters (hence “Bi”)

    ii. check if the first parameter starts with the second parameter

    iii. invoke the lambda twice:

        1. passing in “Mr. Joe Bloggs” and “Mr.” (returns true)

        2. passing in “Mr. Joe Bloggs” and “Ms.” (returns false)

g. code the method reference version of the lambda from (f).

h. test it as per above in (f.iii)


```java
import java.util.function.BiPredicate;

public class BoundMethodReferenceExample {
    public static void main(String[] args) {
        String name = "";
        System.out.println("Name: " + name);
        
        Predicate<String> unboundLambda = n -> n.contains("");
        Predicate<String> unboundLambda2 = j -> j.contains("xyz");
        boolean result = unboundLambda.test(name);
        boolean result2 = unboundLambda2.test(name);
        System.out.println("Does the name nothing? " + result);
        System.out.println("Does the name contain xyz? " + result2);
        
        //numbers = Arrays.asList(1, 2, 7, 4, 5);
       // System.out.println("Re-initialized List: " + numbers);
        
        Predicate<String> testMethodRef = name::contains;
        
        // g. Invoke the method reference version.
        boolean result3 = testMethodRef.test("");
        boolean result4 = testMethodRef.test("xyz");
        System.out.println("Contain nothing (using method reference): " + result3);
        System.out.println("Contain 'xyz (using method reference): " + result4);
        
        BiPredicate<String, String> test = (n, m) -> n.contains(m);
        boolean result5 = test.test("Mr. Joe Bloggs", "Mr.");
        boolean result6 = test.test("Mr. Joe Bloggs", "Ms.");
        System.out.println("Does the name contain 'Mr.'? " + result5);
        System.out.println("Does the name contain 'Ms.'? " + result6);

        BiPredicate<String, String> testMR = String::contains;
        boolean result7 = test.test("Mr. Joe Bloggs", "Mr.");
        boolean result8 = test.test("Mr. Joe Bloggs", "Ms.");
        System.out.println("Does the name contain 'Mr.'? " + result7);
        System.out.println("Does the name contain 'Ms.'? " + result8);

    }
}

BoundMethodReferenceExample.main(null)
```

    Name: 
    Does the name nothing? true
    Does the name contain xyz? false
    Contain nothing (using method reference): true
    Contain 'xyz (using method reference): false
    Does the name contain 'Mr.'? true
    Does the name contain 'Ms.'? false
    Does the name contain 'Mr.'? true
    Does the name contain 'Ms.'? false


# Question 4:
Constructor method references:

a. in constructorMR(), code a Supplier typed for List<String> that returns a new ArrayList.

b. invoke the lambda to create a new List<String> named list.

c. add “Lambda” to the list.

d. output the list to show it worked.

e. code the method reference version of the lambda:

    i. re-initialise list by invoking the method reference version.

    ii. add “Method Reference” to the list.

    iii. output the list to show it worked.

f. next, we want to use the overloaded ArrayList constructor passing in 10 as the initial capacity (note: the default
    constructor assumes a capacity of 10).

    i. thus, we need to pass IN something and get back OUT something:

        1. IN: 10 OUT: ArrayList

    ii. we need a Function typed for Integer and List<String> for this.

    iii. code the lambda.

    iv. re-initialise the list by invoking the lambda passing in 10 as the capacity.

    v. add “Lambda” to the list.

    vi. output the list to show it worked.

g. code the method reference version.

    i. note that the method reference version is the exact same as above in e!!

    ii. this is where context is all important:

        1. the first method reference was for a Supplier and Supplier’s functional method is T get() and thus, Java knew
        to look for the ArrayList constructor that takes in NO argument

        2. the first method reference was for a Function and Function’s functional method is R apply(T t) and thus, Java knew
        to look for the ArrayList constructor that takes in ONE argument.


```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorMethodReferenceExample {
    public static void constructorMR() {
        // a. Code a Supplier typed for List<String> that returns a new ArrayList.
        Supplier<List<String>> listSupplier = () -> new ArrayList<>();
        
        // b. Invoke the lambda to create a new List<String> named list.
        List<String> list = listSupplier.get();
        
        // c. Add “Lambda” to the list.
        list.add("Lambda");
        
        // d. Output the list to show it worked.
        System.out.println("List after adding 'Lambda': " + list);
        
        // e. Code the method reference version of the lambda.
        // i. Re-initialize list by invoking the method reference version.
        Supplier<List<String>> listSupplierMR = ArrayList::new;
        list = listSupplierMR.get();
        
        // ii. Add “Method Reference” to the list.
        list.add("Method Reference");
        
        // iii. Output the list to show it worked.
        System.out.println("List after adding 'Method Reference': " + list);
        
        // f. Use the overloaded ArrayList constructor passing in 10 as the initial capacity.
        // ii. We need a Function typed for Integer and List<String> for this.
        Function<Integer, List<String>> listFunction = (capacity) -> new ArrayList<>(capacity);
        
        // iv. Re-initialize the list by invoking the lambda passing in 10 as the capacity.
        list = listFunction.apply(10);
        
        // v. Add “Lambda” to the list.
        list.add("Lambda");
        
        // vi. Output the list to show it worked.
        System.out.println("List after adding 'Lambda' with initial capacity 10: " + list);
        
        // g. Code the method reference version.
        // i. Note that the method reference version is the exact same as above in e!!
        Function<Integer, List<String>> listFunctionMR = ArrayList::new;
        
        // iv. Re-initialize the list by invoking the method reference version passing in 10 as the capacity.
        list = listFunctionMR.apply(10);
        
        // v. Add “Method Reference” to the list.
        list.add("Method Reference");
        
        // vi. Output the list to show it worked.
        System.out.println("List after adding 'Method Reference' with initial capacity 10: " + list);
    }

    public static void main(String[] args) {
        constructorMR();
    }
}

ConstructorMethodReferenceExample.main(null)
```

    List after adding 'Lambda': [Lambda]
    List after adding 'Method Reference': [Method Reference]
    List after adding 'Lambda' with initial capacity 10: [Lambda]
    List after adding 'Method Reference' with initial capacity 10: [Method Reference]

