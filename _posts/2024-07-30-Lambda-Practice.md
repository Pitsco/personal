---
title: Lambda Practice
description: Fourth CSA FRQ and explanations
layout: post
courses: {'csa': {'week': 25}}
categories: ['C4.0']
type: tangibles
comments: True
---

# Question 1
In main() invoke the consumer() method; in consumer() do the following:

a) Using a lambda expression, implement the Printable interface (typed for String). The relevant method just prints out the String argument it receives. Invoke the relevant method, passing in "Printable lambda".

b) Using both a lambda expression and a method reference, implement 1a using a Consumer.


```java
import java.util.function.Consumer;

interface Printable {
    void print(String message);
}

public class Main {
    public static void consumer() {
        Printable example = message -> System.out.println(message);
        example.print("example");

        Consumer<String> consumerLambda = (message) -> System.out.println(message);
        consumerLambda.accept("Consumer lambda");

        Consumer<String> consumerMR = System.out::println;
        consumerMR.accept("ConsumerMR");
    }


    public static void main(String[] args) {
        consumer();
    }
}

Main.main(null)
```

    example
    Consumer lambda
    ConsumerMR


# Question 2
In main() invoke the supplier() method; in supplier() do the following:

a) Using a lambda expression, implement the Retrievable interface (typed for Integer). The relevant method just returns 77. Invoke the relevant method.

b) Using a lambda expression, implement 2a using a Supplier.


```java
import java.util.function.Supplier;

interface Retrievable<T> {
    T retrieve(); //part a
} 
public class Main {
    public static void Supplier() {
        Retrievable<Integer> example0 = () -> 77;
        System.out.println(example0.retrieve());

        Supplier<Integer> example1 = () -> 77; //part b
        System.out.println(example1.get());   
    }

    public static void main(String[] args) {
        Supplier();
    }
}

Main.main(null)
```

    77
    77


# Question 3
In main() invoke the predicate() method; in predicate() do the following:

a) Using a lambda expression, implement the Evaluate interface (typed for Integer). The relevant method returns true if the argument passed is < 0, otherwise it returns false. Invoke the relevant method twice – the first time pass in -1 and the second time pass in +1

b) Using a lambda expression, implement 3a using a Predicate.

c) Declare a generically-typed check() method (not in UML). The first parameter is generic and the second parameter is a Predicate, also generically typed. The check() method returns true/false. Invoke the check() method with the following Predicate lambda expressions:

- we want to know if a number is even (true) – invoke check() with 4 and 7 (true and false).

- we want to know if a String begins with “Mr.” – invoke check() with “Mr. Joe Bloggs” and “Ms. Ann Bloggs”

- we want to know if a person is an adult (age >= 18) – invoke check() with “Mike” who is 33 and 1.8 (metres assumed) in height; and “Ann” who is 13 and 1.4 (metres) in height.


```java
import java.util.function.Predicate;

interface Evaluate<T> {
    boolean evaluate(T t); // part a
} 

public class Main {
    public static <T> boolean check(T value, Predicate<T> predicate) {
        return predicate.test(value);
    }
    
    public static void Predicate() {
        Evaluate<Integer> example0 = (Integer t) -> t < 0;
        System.out.println(example0.evaluate(-1));
        System.out.println(example0.evaluate(1));

        Predicate<Integer> checking = num -> num % 2 == 0;
        System.out.println("Is 4 an even number? " + check(4, checking));
        System.out.println("Is 7 an even number? " + check(7, checking));

        Predicate<String> startsWithMr = str -> str.startsWith("Mr.");

        // Test with Strings
        System.out.println("Starts with \"Mr.\"? " + check("Mr. Joe Bloggs", startsWithMr)); // Should print true
        System.out.println("Starts with \"Mr.\"? " + check("Ms. Ann Bloggs", startsWithMr)); // Should print false

        // Predicate to check if a person is an adult (age >= 18)
        Predicate<Person> isAdult = person -> person.getAge() >= 18;

        // Test with persons
        Person mike = new Person("Mike", 33, 1.8);
        Person ann = new Person("Ann", 13, 1.4);
        System.out.println("Is Mike an adult? " + check(mike, isAdult)); // Should print true
        System.out.println("Is Ann an adult? " + check(ann, isAdult)); // Should print false
    }

    public static class Person {
        private String name;
        private int age;
        private double height; // assumed in meters
    
        public Person(String name, int age, double height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }
    
        public String getName() {
            return name;
        }
    
        public int getAge() {
            return age;
        }
    
        public double getHeight() {
            return height;
        }
    }

    public static void main(String[] args) {
        Predicate();
    }
}

Main.main(null);
```

    true
    false
    Is 4 an even number? true
    Is 7 an even number? false
    Starts with "Mr."? true
    Starts with "Mr."? false
    Is Mike an adult? true
    Is Ann an adult? false


# Question 4
In main() invoke the function() method; in function() do the following:

a) Using a lambda expression, implement the Functionable interface - the input type is Integer and the return type is String. The relevant method returns the number passed in appended to the String “Number is: ”. Invoke the relevant method passing in 25.

b) Using a lambda expression, implement 4a using a Function.


```java
import java.util.function.Function;

interface Functionable {
    String operate(Integer number);
}

public class Main {
    public static void function() {
        // Part a: Using a lambda expression to implement the Functionable interface
        Functionable func = (Integer number) -> "Number is: " + number;
        System.out.println(func.operate(25));

        // Part b: Using a lambda expression and Function to implement 4a
        Function<Integer, String> funcWithFunction = (Integer number) -> "Number is: " + number;
        System.out.println(funcWithFunction.apply(25));
    }

    public static void main(String[] args) {
        function();
    }
}


Main.main(null)
```

    Number is: 25
    Number is: 25


# Question 5:
Given the following implementation of the getPeople() method:

private static List<Person> getPeople() {

List<Person> result = new ArrayList<>();

result.add(new Person("Mike", 33, 1.8));

result.add(new Person("Mary", 25, 1.4));

result.add(new Person("Alan", 34, 1.7));

result.add(new Person("Zoe", 30, 1.5));

return result;

}

In main(), invoke the getPeople() – store the result in a variable named listPeople.


```java
public class Person {
    private String name;
    private int age;
    private double height;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Person> listPeople = getPeople();
        
        // Now you can use listPeople as needed
        // For example, printing the details of each person in the list:
        for (Person person : listPeople) {
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge() + ", Height: " + person.getHeight());
        }
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();

        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));

        return result;
    }
}

Main.main(null)
```

    Name: Mike, Age: 33, Height: 1.8
    Name: Mary, Age: 25, Height: 1.4
    Name: Alan, Age: 34, Height: 1.7
    Name: Zoe, Age: 30, Height: 1.5


# Question 6
In main(), invoke the sortAge() method passing down listPeople; in sortAge() do the following:

a) Using the Iterable sort() method (note: List extends Iterable), and the Comparator.comparing() method, sort the Person objects in ascending age order. Note that the argument to Comparator.comparing() requires a Function (In, Out) that returns a Comparable (a class that implements Comparable). From that, the comparing() method generates a Comparator that it passes to the sort() method.

- Note that as of Java 8, the List interface supports the sort() method directly so there is no need to use the Collections.sort(): i.e. instead of Collections.sort(list, comparatorRef); we now have list.sort(comparatorRef);

b) Output the sorted list using the Iterable forEach() method passing in a lambda expression.



```java
public class Person {
    private String name;
    private int age;
    private double height;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Person> listPeople = getPeople();

        // Sort the list by age in ascending order
        listPeople.sort((person1, person2) -> Integer.compare(person1.getAge(), person2.getAge()));
        listPeople.sort(Comparator.comparing(Person::getAge));

        // Output the sorted list using lambda expression
        listPeople.forEach(person -> System.out.println("Name: " + person.getName() + ", Age: " + person.getAge() + ", Height: " + person.getHeight()));
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();

        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));

        return result;
    }
}

Main.main(null)
```

    Name: Mary, Age: 25, Height: 1.4
    Name: Zoe, Age: 30, Height: 1.5
    Name: Mike, Age: 33, Height: 1.8
    Name: Alan, Age: 34, Height: 1.7


# Question 7:
In main(), invoke the sortName() method passing down listPeople; in sortName() do the following:

a) As in 6a except sort the Person objects in ascending name order.

b) Output the sorted list using the Iterable forEach() method passing in a lambda expression.


```java
public class Main {
    public static void sortName(List<Person> listPeople) {
        // Part a: Sort the list by name in ascending order
        listPeople.sort((person1, person2) -> person1.getName().compareTo(person2.getName())); //lambda
        listPeople.sort(Comparator.comparing(Person::getName)); //method reference

        // Part b: Output the sorted list
        listPeople.forEach(person -> System.out.println("Name: " + person.getName() + ", Age: " + person.getAge() + ", Height: " + person.getHeight()));
    }

    public static void main(String[] args) {
        List<Person> listPeople = getPeople();
        
        // Invoke the sortName() method passing the list of Person objects
        sortName(listPeople);
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();

        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));

        return result;
    }
}

Main.main(null)
```

    Name: Alan, Age: 34, Height: 1.7
    Name: Mary, Age: 25, Height: 1.4
    Name: Mike, Age: 33, Height: 1.8
    Name: Zoe, Age: 30, Height: 1.5


# Question 8:
In main(), invoke the sortHeight() method passing down listPeople; in sortHeight() do the following:

a) As in 6a except sort the Person objects in ascending height order.

b) Output the sorted list using the Iterable forEach() method passing in a lambda expression.


```java
public class Main {
    public static void sortHeight(List<Person> listPeople) {
        // Part a: Sort the list by name in ascending order
        listPeople.sort((person1, person2) -> Double.compare(person1.getHeight(), person2.getHeight()));
        listPeople.sort(Comparator.comparing(Person::getHeight));

        // Part b: Output the sorted list
        listPeople.forEach(person -> System.out.println("Name: " + person.getName() + ", Age: " + person.getAge() + ", Height: " + person.getHeight()));
    }

    public static void main(String[] args) {
        List<Person> listPeople = getPeople();
        
        // Invoke the sortHeight() method passing the list of Person objects
        sortHeight(listPeople);
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();

        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));

        return result;
    }
}

Main.main(null)
```

    Name: Mary, Age: 25, Height: 1.4
    Name: Zoe, Age: 30, Height: 1.5
    Name: Alan, Age: 34, Height: 1.7
    Name: Mike, Age: 33, Height: 1.8

