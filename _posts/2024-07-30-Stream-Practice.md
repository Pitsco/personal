---
title: Stream Practice
description: Fourth CSA FRQ and explanations
layout: post
courses: {'csa': {'week': 25}}
categories: ['C4.0']
type: tangibles
comments: True
---

# Question 1
Stream a list of int primitives between the range of 0 (inclusive) and 5 (exclusive).  Calculate and output the average.


```Java
public class AverageCalculator {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4);
        
        // Convert the list to a stream and calculate the average
        OptionalDouble average = numbers.stream()
                                        .mapToInt(Integer::intValue)
                                        .average();
        
        // Check if the average is present and print it
        if (average.isPresent()) {
            System.out.println("Average: " + average.getAsDouble());
        } else {
            System.out.println("The stream is empty.");
        }
    }
}

AverageCalculator.main(null)
```

    Average: 2.0


# Question 2:
Given the Item class (in the zip file), declare a List typed for Item with the following Item’s: 

a. id=1 name=”Screw” 

b. id=2 name=”Nail” 

c. id=3 name=”Bolt” 

Stream the list and sort it so that it outputs “BoltNailScrew” i.e. alphabetic name order. Use Stream’s forEach method to output the names (use the method reference version for the required Consumer lambda).   


```Java
public class Item {
    private int id;
    private String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class ItemSorter {
    public static void main(String[] args) {
        // Create a list of Item objects
        List<Item> items = Arrays.asList(
            new Item(1, "Screw"),
            new Item(2, "Nail"),
            new Item(3, "Bolt")
        );
        
        // Stream the list, sort it by the name, and print the names in sorted order
        items.stream()
             .sorted((item1, item2) -> item1.getName().compareTo(item2.getName()))
             .map(Item::getName)
             .forEach(System.out::print);
    }
}

ItemSorter.main(null)
```

    BoltNailScrew

# Question 3
Generate a Stream<List<String>> using the Stream.of(Arrays.asList(“a”, “b”), Arrays.asList(“a”, “c”)) method call. Filter the stream so that only list’s that contain “c” make it through the filter. Flatten the Stream<List<String>> to a Stream<String> using the flatMap() operation. Note that flapMap() states in the API “Each mapped stream is closed after its contents have been placed into this [new] stream.”. Use forEach() to output the new stream.      


```Java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<List<String>> listOfLists = Stream.of(
                Arrays.asList("a", "b"),
                Arrays.asList("a", "c")
        );

        listOfLists
                .filter(list -> list.contains("c")) // Filter lists containing "c"
                .flatMap(list -> list.stream()) // Flatten the Stream<List<String>> to Stream<String>
                .forEach(System.out::println); // Output each element
    }
}
Main.main(null)
```

    a
    c


# Question 4:
There are several parts to this:      
a. Using 1, 2 and 3 create a List of Integers.  
(QID 2.1738) 
i. Stream the list and calculate the sum, using the sum() method from IntStream.  
ii. Stream the list again and calculate the maximum value, using the max() method from 
IntStream.  
b. Given the Person class (in the zip file), declare a List typed for Person with the following 
Person’s: 
i. “Alan”, “Burke”, 22 
ii. “Zoe”, “Peters”, 20 
iii. “Peter”, “Castle”, 29 
Using the max(Comparator) from Stream, calculate the oldest person in the list. 
c. Using 10, 47, 33 and 23 create a List of Integers. Stream the list and using the following 
versions of reduce(), calculate the maximum value: 
i. Optional<T> reduce(BinaryOperator<T> accumulator) 
ii. T reduce(T identity, BinaryOperator<T> accumulator)


```Java
import java.util.*;
import java.util.stream.*;

class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", Age: " + age;
    }
}

public class Main {
    public static void main(String[] args) {
        // Part a: Create a list of integers and perform calculations
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        int max = numbers.stream().mapToInt(Integer::intValue).max().orElse(0);
        System.out.println("Sum: " + sum);
        System.out.println("Maximum value: " + max);

        // Part b: Find the oldest person using max(Comparator)
        List<Person> people = Stream.of(
                new Person("Alan", "Burke", 22),
                new Person("Zoe", "Peters", 20),
                new Person("Peter", "Castle", 29)
        ).collect(Collectors.toList());
        Person oldestPerson = people.stream()
                                    .max(Comparator.comparingInt(Person::getAge))
                                    .orElse(null);
        System.out.println("Oldest person: " + oldestPerson);

        // Part c: Use reduce() to find the maximum value
        List<Integer> numbers2 = Arrays.asList(10, 47, 33, 23);
        Optional<Integer> max1 = numbers2.stream().reduce(Integer::max);
        Integer max2 = numbers2.stream().reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("Maximum value using reduce(BinaryOperator<T> accumulator): " + max1.orElse(null));
        System.out.println("Maximum value using reduce(T identity, BinaryOperator<T> accumulator): " + max2);
    }
}

Main.main(null)
```

    Sum: 6
    Maximum value: 3
    Oldest person: Peter Castle, Age: 29
    Maximum value using reduce(BinaryOperator<T> accumulator): 47
    Maximum value using reduce(T identity, BinaryOperator<T> accumulator): 47


# Question 5:
Code a method public static Optional<String> getGrade(int marks)         
a. in the method getGrade: 
i. declare an empty optional, typed for String called grade 
ii. insert the following code: 
if (marks > 50) {grade = Optional.of(“PASS”);} else {grade.of(“FAIL”);} 
b.  in main(): 
i. declare an Optional, typed for String named grade1 which is initialised to the return 
value of calling getGrade(50) 
ii. declare an Optional, typed for String named grade2 which is initialised to the return 
value of calling getGrade(55) 
iii. using orElse() on grade1, output the value of grade1 or “UNKNOWN” 
iv. if(grade2.isPresent()) is true: use ifPresent(Consumer) to output the contents of 
grade2; if false, use orElse() to output the contents of grade2 or “Empty” 
v. Notes:  
1. Optional’s are immutable. 
2. Optional.of(null); // NullPointerException 
3. Optional.ofNullable(null); // Optional.empty returned 


```Java
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> grade1 = getGrade(50);
        Optional<String> grade2 = getGrade(55);

        // Output value of grade1 or "UNKNOWN" if empty
        System.out.println(grade1.orElse("UNKNOWN"));

        // Output contents of grade2 if present, otherwise output "Empty"
        if (grade2.isPresent()) {
            grade2.ifPresent(System.out::println);
        } else {
            System.out.println(grade2.orElse("Empty"));
        }
    }

    public static Optional<String> getGrade(int marks) {
        Optional<String> grade = Optional.empty(); // Declare an empty optional

        // Set the value of grade based on marks
        if (marks > 50) {
            grade = Optional.of("PASS");
        } else {
            grade = Optional.of("FAIL");
        }

        return grade;
    }
}

Main.main(null)
```

    FAIL
    PASS


# Question 6:
 Given the Book class (in the zip file),  declare a List typed for Book with the following Book’s: 
a. title=”Thinking in Java”, price=30.0 
b. title=”Java in 24 hrs”, price=20.0 
c. title=”Java Recipes”, price=10.0 
Stream the books and calculate the average price of the books whose price is > 10.      
Change the filter to books whose price is > 90. Ensure you do not get an exception.


```Java
import java.util.*;
import java.util.stream.*;

class Book {
    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Thinking in Java", 30.0),
                new Book("Java in 24 hrs", 20.0),
                new Book("Java Recipes", 10.0)
        );

        double averagePrice = books.stream()
                .filter(book -> book.getPrice() > 10) // Filter books whose price is greater than 10
                .mapToDouble(Book::getPrice) // Map to double prices
                .average() // Calculate average
                .orElse(0.0); // Default value if no elements or average is NaN

        System.out.println("Average price of books whose price is greater than 10: " + averagePrice);
    }
}

Main.main(null)
```

    Average price of books whose price is greater than 10: 25.0


# Question 7:
Given the Book class (in the zip file),  declare a List typed for Book with the following Book’s: 
a. title=”Atlas Shrugged”, price=10.0 
b. title=”Freedom at Midnight”, price=5.0 
c. title=”Gone with the wind”, price=5.0 
Stream the books and instantiate a Map named ‘bookMap’ that maps the book title to its price. To do 
this use the collect(Collectors.toMap(Function fnToGetKey, Function fnToGetValue)). Iterate 
through ‘bookMap’ (using the Map forEach(BiConsumer) method).  The BiConsumer only outputs 
prices where the title begins with “A”.           


```Java
import java.util.*;
import java.util.stream.*;

class Book {
    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Atlas Shrugged", 10.0),
                new Book("Freedom at Midnight", 5.0),
                new Book("Gone with the wind", 5.0)
        );

        Map<String, Double> bookMap = books.stream()
                .collect(Collectors.toMap(Book::getTitle, Book::getPrice));

        bookMap.forEach((title, price) -> {
            if (title.startsWith("A")) {
                System.out.println("Title: " + title + ", Price: " + price);
            }
        });
    }
}

Main.main(null)
```

    Title: Atlas Shrugged, Price: 10.0


# Question 8:
Given the Book class (in the zip file),  declare a List typed for Book with the following Book’s: 
a. title=”Gone with the wind”, price=5.0 
b. title=”Gone with the wind”, price=10.0 
c. title=”Atlas shrugged”, price=15.0 
In a pipeline which has no return type:       
 stream the books 
(QID 2.1847) 
 using the collect() method, generate a Map that maps the book title to its price 
 using forEach(), output the title and price of each entry in the map 
What happened and why? Fix this by using the Collectors.toMap(Function, Function, 
BinaryOperator) method.  


```Java
import java.util.*;
import java.util.stream.*;

class Book {
    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Gone with the wind", 5.0),
                new Book("Gone with the wind", 10.0),
                new Book("Atlas shrugged", 15.0)
        );

        Map<String, Double> bookMap = books.stream()
                .collect(Collectors.toMap(Book::getTitle, Book::getPrice, (oldValue, newValue) -> oldValue));

        bookMap.forEach((title, price) -> System.out.println("Title: " + title + ", Price: " + price));
    }
}

Main.main(null)

```

    Title: Atlas shrugged, Price: 15.0
    Title: Gone with the wind, Price: 5.0


# Question 9:
Given the Person class (in the zip file),  declare a List typed for Person with the following Person’s: 
a. name=”Bob”, age=31 
b. name=”Paul”, age=32 
c. name=”John”, age=33 
Pipeline the following where the return type is double:     
 stream the people 
 filter the stream for Person’s whose age is < 30  
 map to int primitives 
 calculate the average age.  
(QID 2.1810) 
This should generate a NoSuchElementException. Using orElse(), fix the pipeline (not the filter) so 
that 0.0 is returned instead of an exception being generated.  


```Java
import java.util.*;
import java.util.stream.*;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Bob", 31),
                new Person("Paul", 32),
                new Person("John", 33)
        );

        double averageAge = people.stream()
                .filter(person -> person.getAge() < 30)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);

        System.out.println("Average age: " + averageAge);
    }
}

Main.main(null)
```

    Average age: 0.0


# Question 10:
A question about Optional. Let us look at this in parts: 

a. Declare an Optional, typed for Double, named ‘price’ using the Optional.ofNullable(20.0). 
Output the Optional value for ‘price’ 3 times: using ifPresent(Consumer), orElse(T) and 
orElseGet(Supplier).          

b. declare a new Optional, typed for Double, named ‘price2’ (or comment out (a) and re-use 
‘price’). Use Optional.ofNullable again but this time, pass in null.  

    i. Output ‘price2’ in a normal System.out.println(). 

    ii. check to see if price2 isEmpty() and if so output “empty”. 

    iii. do (ii) again except this time use the more functional “ifPresent(Consumer)” method. 

    iv. initialise a Double x to the return of “price2.orElse(44.0)”. Output and observe the 
        value of x. 

c. declare a new Optional, typed for Double, named ‘price3’ (or comment out (b) and re-use 
‘price’). Use Optional.ofNullable passing in null.  
    i. initialise a Double z to the return of “price3.orElseThrow(() -> new 
    
RuntimeException(“Bad Code”). Output and observe the value of z.


```Java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Part a
        Optional<Double> price = Optional.ofNullable(20.0);
        price.ifPresent(val -> System.out.println("ifPresent: " + val));
        System.out.println("orElse: " + price.orElse(0.0));
        System.out.println("orElseGet: " + price.orElseGet(() -> 0.0));

        // Part b
        Optional<Double> price2 = Optional.ofNullable(null);
        System.out.println("Value of price2: " + price2);
        System.out.println("isEmpty check: " + price2.isEmpty());
        price2.ifPresent(val -> System.out.println("ifPresent: " + val));
        Double x = price2.orElse(44.0);
        System.out.println("Value of x: " + x);

        // Part c
        Optional<Double> price3 = Optional.ofNullable(null);
        Double z = price3.orElseThrow(() -> new RuntimeException("Bad Code"));
        System.out.println("Value of z: " + z);        
    }
}

Main.main(null)
```

    ifPresent: 20.0
    orElse: 20.0
    orElseGet: 20.0
    Value of price2: Optional.empty
    isEmpty check: true
    Value of x: 44.0
    Value of z: 0.0


# Question 11:
 Given the AnotherBook class (in the zip file),  declare a List typed for AnotherBook namely ‘books’  
with the following AnotherBook’s: 
a. title=”Gone with the wind”, genre=”Fiction”    
b. title=”Bourne Ultimatum”, genre=”Thriller” 
c. title=”The Client”, genre=”Thriller” 
Declare the following: List<String> genreList = new ArrayList<>();  
(QID 2.1858) 
Stream books so that genreList refers to a List containing the genres of the books in the books List.


```Java
import java.util.*;
import java.util.stream.*;

class AnotherBook {
    private String title;
    private String genre;

    public AnotherBook(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}

public class Main {
    public static void main(String[] args) {
        List<AnotherBook> books = Arrays.asList(
                new AnotherBook("Gone with the wind", "Fiction"),
                new AnotherBook("Bourne Ultimatum", "Thriller"),
                new AnotherBook("The Client", "Thriller")
        );

        List<String> genreList = books.stream()
                                     .map(AnotherBook::getGenre)
                                     .collect(Collectors.toList());

        System.out.println(genreList);
    }
}


Main.main(null)
```

    [Fiction, Thriller, Thriller]


# Question 12:
There are two parts:          
a. Generate a DoubleStream using the of() method consisting of the numbers 0, 2 and 4. Note 
that this stream is a stream of primitives and not a stream of types. Filter in odd numbers only 
and sum the remaining stream. You should get 0.    
(QID 2.2024) 
b. Using 1.0 and 3.0, generate a stream of Double’s. Map them to primitive double’s. Filter in 
even numbers only and calculate the average. Output the result without running the risk of 
generating an exception. 


```Java
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // Part a
        DoubleStream stream1 = DoubleStream.of(0, 2, 4);
        double sum1 = stream1.filter(num -> num % 2 != 0).sum();
        System.out.println("Sum: " + sum1);

        // Part b
        Stream<Double> stream2 = Stream.of(1.0, 3.0);
        double average = stream2.mapToDouble(Double::doubleValue)
                                .filter(num -> num % 2 == 0)
                                .average()
                                .orElse(Double.NaN);
        System.out.println("Average: " + average);
    }
}

Main.main(null)
```

    Sum: 0.0
    Average: NaN


# Question 13:
This question demonstrates lazy evaluation. Declare the following List<Integer> ls = 
Arrays.asList(11, 11, 22, 33, 33, 55, 66); 
a. stream the List (note that this is possible because List is a Collection and Collection defines a 
stream() method); ensure only distinct (unique) numbers are streamed; check if “any match” 
11. You should get true for this. 
b. stream the List again (this is necessary because once a stream is closed by a previous terminal 
operation, you must re-create the stream); check to see if “none match” the expression 
x%11>0. Note that the terminal operation noneMatch(Predicate) needs to return false for 
every element in the stream for noneMatch() to return true. In other words, “none of them 
match this….that’s correct, none of them do; return true”. You should get true here as well. 


```Java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(11, 11, 22, 33, 33, 55, 66);

        // Part a
        boolean anyMatch = ls.stream()
                             .distinct()
                             .anyMatch(num -> num == 11);
        System.out.println("Any match 11: " + anyMatch);

        // Part b
        boolean noneMatch = ls.stream()
                              .distinct()
                              .noneMatch(num -> num % 11 > 0);
        System.out.println("None match x%11>0: " + noneMatch);
    }
}

Main.main(null)
```

    Any match 11: true
    None match x%11>0: true

