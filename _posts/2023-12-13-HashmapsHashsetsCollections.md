---
layout: post
title: HashMaps, HashSets, Collections, SQL Student Lessons
description: by Tirth T, Haseeb B, Sreeja G, Ekam K, Drew R, Adan R
courses: {'compsci': {'week': 13}}
type: hacks
---

## Collections

### What are collections?
Collections are any group of individual objects that are represented as a single unit is known as a Java Collection of Objects. In Java, a separate framework named the “Collection Framework” has been defined in JDK 1.2 which holds all the Java Collection Classes and Interface in it. It works as an interface that defines the highest-level of shared collection behavior, and extends Iterable which allows usage of ForEach loop.

### Types of Collections

- **List:**  
    - Ordered collection
    - Allows duplicate elements
    - Example: **ArrayList** and **LinkedList**

- **Set:**  
    - Unordered collection 
    - No duplicates
    - Example: **HashSet** and **TreeSet**

- **Map:**  
    - Key-pair values
    - Each key must be unique
    - Example: **HashMap** and **TreeMap**

- **Queue:**  
    - Follows First-In-First-Out order
    - Example: **LinkedList** and **PriorityQueue**

- **Deque:**  
    - Double ended queue
    - Insertion and removal at both ends
    - Example: **ArrayDeque**

### Popcorn Hack!
Come up with a real world example in which collections are used! Write your answer below:

Using a bookshelf organizer, you categorize books by genre, creating a system that efficiently organizes and retrieves books based on their specific attributes. This categorization simplifies the process of managing and locating books on the bookshelf.

## HashMaps 

#### What are they? 

Hash Maps are a **data structure** with keys and values; very similar to a Python dictionary. The keys in Hash Maps have a single value assigned to them, which can be accessed by calling the key: 


```java
import java.util.HashMap;  //Hashmaps are part of the java.util package

public class PlanetDistances {
    public static void main(String[] args) {

        HashMap<String, Double> hashMap = new HashMap<>();

        // key-value pairs, where the key is the planet (a string) and the value is the double assigned to each key
        hashMap.put("Mercury", 0.39);
        hashMap.put("Venus", 0.72); //adding an element
        hashMap.put("Earth", 1.00);
        hashMap.remove("Earth", 1.00); //removing an element

        // the value 0.39 can be accessed by calling the key "Mercury"
        double value = hashMap.get("Mercury");
        boolean exists = hashMap.containsKey("Mercury"); //you can also check if a key exists
        System.out.println("Mercury is " + value + " astronomical units away from the Sun");
    }
}

PlanetDistances.main(null);
```

    Mercury is 0.39 astronomical units away from the Sun


As shown above, the data type of the keys and values must be defined when creating the Hashmap. You cannot use data types for keys or values that are different from the ones assigned to it. Also, keys must be non-null objects. However, values can be null!

<br>

Keys in a Hashmap must be unique. Otherwise the previous values of the key get overwritten.


```java
import java.util.HashMap;  

public class ShoePrices {
    public static void main(String[] args) {

        HashMap<String, Double> hashMap = new HashMap<>();

        hashMap.put("Nike", 41.97);
        hashMap.put("Nike", 80.97); //this value replaces the previous value 
        hashMap.put("Adidas", 69.99);
        hashMap.put("Vans", 55.00);

        double value = hashMap.get("Nike");
        System.out.println("A Nike shoe would cost " + value);
    }
}

ShoePrices.main(null);
```

    A Nike shoe would cost 80.97


#### Popcorn hack: what can we do if we want to assign multiple values to a single key? Do it below!: 

In Java, you can use a Map where the key is associated with a collection, such as a List or Set, to store multiple values. 



```java
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class ShoePrices {
    public static void main(String[] args) {
        HashMap<String, List<Double>> hashMap = new HashMap<>();
        hashMap.computeIfAbsent("Nike", k -> new ArrayList<>()).add(41.97);//adding prices to the "Nike" key
        hashMap.computeIfAbsent("Nike", k -> new ArrayList<>()).add(80.97);
        hashMap.computeIfAbsent("Adidas", k -> new ArrayList<>()).add(69.99); //adding prices for other brands
        hashMap.computeIfAbsent("Vans", k -> new ArrayList<>()).add(55.00);
        List<Double> nikePrices = hashMap.get("Nike");//retrieving prices for "Nike" key
        if (nikePrices != null) {
            System.out.println("Nike shoe prices: " + nikePrices);
        } else {
            System.out.println("No prices found for Nike.");
        }
    }
}

ShoePrices.main(null);
```

    Nike shoe prices: [41.97, 80.97]


Note that collisions can still occur when two keys produce the same hash code. Hash codes are assigned to each key through a hash function (this is called hashing). They are used to determine what the key-value pair's index should be iwthin the Hashmaps. A bad hash function may cause collisions to occur, in which case the function would need to be adjusted. 

HashMaps do not store the input order of the key-value pairs, and there is no guarantee the pairs will always be stored in the same order. Therefore if something needs to be found within a HashMap, iteration must be used. This can be done through `keySet()`, `values()`, or `entrySet()`


<br>

**keySet()** -- provides access to the set of keys. Useful for if you only need to access keys w/out values 


```java
import java.util.HashMap;
import java.util.Set;

public class OscarWinners {
    public static void main(String[] args) {

        HashMap<String, Integer> oscarWinnersYear = new HashMap<>();

        oscarWinnersYear.put("Nomadland", 2020);
        oscarWinnersYear.put("Parasite", 2019);
        oscarWinnersYear.put("Green Book", 2018);
        oscarWinnersYear.put("The Shape of Water", 2017);

        Set<String> oscarWinners = oscarWinnersYear.keySet(); //using keySet to get keys 

        System.out.println("List of Oscar winners " + oscarWinners);
    }
}

OscarWinners.main(null);
```

    List of Oscar winners [Nomadland, Parasite, Green Book, The Shape of Water]


**values()** -- returns set of values, without any keys 


```java
import java.util.HashMap;
import java.util.Set;

public class OscarWinners {
    public static void main(String[] args) {

        HashMap<String, Integer> oscarWinnersYear = new HashMap<>();

        oscarWinnersYear.put("Nomadland", 2020);
        oscarWinnersYear.put("Parasite", 2019);
        oscarWinnersYear.put("Green Book", 2018);
        oscarWinnersYear.put("The Shape of Water", 2017);

        Collection<Integer> oscarWinnerYears = oscarWinnersYear.values(); //using values to get values 

        System.out.println("Years movies won Oscars " + oscarWinnerYears);
    }
}

OscarWinners.main(null);
```

    Years movies won Oscars [2020, 2019, 2018, 2017]


**entryset()** -- returns keys and values in the form of objects. Useful for when working with key-value pair relationships


```java
import java.util.HashMap;
import java.util.Set;

public class OscarWinners {
    public static void main(String[] args) {

        HashMap<String, Integer> oscarWinnersYear = new HashMap<>();

        oscarWinnersYear.put("Nomadland", 2020);
        oscarWinnersYear.put("Parasite", 2019);
        oscarWinnersYear.put("Green Book", 2018);
        oscarWinnersYear.put("The Shape of Water", 2017);

        Set<Map.Entry<String, Integer>> oscarWinnersAndYears = oscarWinnersYear.entrySet(); //using values to get values 

        System.out.println("Oscars and their years " + oscarWinnersAndYears);
    }
}

OscarWinners.main(null);
```

    Oscars and their years [Nomadland=2020, Parasite=2019, Green Book=2018, The Shape of Water=2017]


HashMaps have a time complexity of O(1) on average!

## HashSet

### What is a hashset?
- A hashset is a data structure that stores only unique values and does not allow duplicates. You can also think of it as a set of keys with no values.  


```java
import java.util.HashSet;
import java.util.Set;

public class Colors{
    static Set<String> colors = new HashSet<>();

    public static void main(String[] args) {
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        System.out.println(colors);
    }
}

Colors.main(null);
```

    [Red, Blue, Green]


### What if we add duplicates?
- If we try add duplicates, the hashset will simply not add the duplicate value and return false as seen bellow. 


```java
public class ColorsButDifferent{
    static Set<String> colors = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(colors.add("Blue"));
        System.out.println(colors.add("Green"));
        System.out.println(colors.add("Green"));
        System.out.println(colors);
    }
}

ColorsButDifferent.main(null);
```

    true
    true
    false
    [Blue, Green]


### Order?
- Hashsets are not ordered and do not store the order in which the values were added that means that if values are removed their order will not be preserved. 


```java
public class Fruits{
    static Set<String> fruits = new HashSet<>();

    public static void main(String[] args) {
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        System.out.println(fruits);

        fruits.remove("Banana");

        System.out.println(fruits);
    }
}

Fruits.main(null);
```

    [Apple, Orange, Banana]
    [Apple, Orange]


### How do you know if a value is in a hashset?
- You can use the contains method to check if a value is in a hashset.


```java
public class Fruits{
    static Set<String> fruits = new HashSet<>();

    public static void main(String[] args) {
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        System.out.println(fruits.contains("Apple"));
    }
}

Fruits.main(null);
```

    true


### Other methods
- clear() - removes all values from the hashset
- isEmpty() - returns true if the hashset is empty
- size() - returns the number of values in the hashset
- toArray() - returns an array of the values in the hashset



```java
public class Fruits{
    static Set<String> fruits = new HashSet<>();

    public static void main(String[] args) {
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        System.out.println(fruits);

        System.out.println();
        System.out.println("Length of Hashmap: " + fruits.size());
        
        System.out.println();
        System.out.println("Array Version of Hashmap: " + fruits.toArray());

        System.out.println();
        fruits.clear();
        System.out.println("Hashmap After Clearing " + fruits);

    }
}

Fruits.main(null);
```

    [Apple, Orange, Banana]
    
    Length of Hashmap: 3
    
    Array Version of Hashmap: [Ljava.lang.Object;@665e264a
    
    Hashmap After Clearing []


### Iterations
- You can iterate through a hashset using a for each loop or an iterator. The order of the values is not guaranteed and can change as values are removed or added.
- These two methods are can be called using the `iterator()` and `forEach()` methods. For the `forEach()` method you can pass in a lambda expression (a lambda expression is an anonymous function) or a method reference.


```java
// foreach loop to iterate through a set

public class Fruits{
    static Set<String> fruits = new HashSet<>();

    public static void main(String[] args) {
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        System.out.println(fruits);

        // Using foreach loop to iterate through the set and print each fruit as it goes
        fruits.forEach(fruit -> System.out.println(fruit));
    }
}

Fruits.main(null);

```

    [Apple, Orange, Banana]
    Apple
    Orange
    Banana



```java
// Different version of foreach loop to iterate through a set

public class Cheeses{
    static Set<String> cheeses = new HashSet<>();

    public static void main(String[] args) {
        cheeses.add("Cheddar");
        cheeses.add("Brie");
        cheeses.add("Gouda");
        System.out.println(cheeses);

        cheeses.forEach(cheese -> {
            if(cheese.equals("Brie")) {
                System.out.println("I love " + cheese);
            } else {
                System.out.println("I like " + cheese);
            }
        });
    }
}

Cheeses.main(null);
```

    [Brie, Cheddar, Gouda]
    I love Brie
    I like Cheddar
    I like Gouda



```java
// using iterator to iterate through a set

import java.util.Iterator;

public class Games{
    static Set<String> games = new HashSet<>();

    public static void main(String[] args) {
        games.add("Monopoly");
        games.add("Scrabble");
        games.add("Sorry");
        System.out.println(games);
        System.out.println();

        Iterator<String> iterator = games.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

Games.main(null);
```

    [Sorry, Monopoly, Scrabble]
    
    Sorry
    Monopoly
    Scrabble


### How to check for equality?
- You can check if two hashsets are equal by using the `equals()` method. This method will return true if the hashsets contain the same values and false if they do not.


```java
public class Pokemon {
    public static void main(String[] args) {
        Set<String> pokemonSet1 = new HashSet<>();
        Set<String> pokemonSet2 = new HashSet<>();

        // Populate the sets
        pokemonSet1.add("Pikachu");
        pokemonSet1.add("Charmander");
        pokemonSet1.add("Pikaman");

        pokemonSet2.add("Pikachu");
        pokemonSet2.add("Charmander");
        pokemonSet2.add("Pikaman");

        // Check equality
        boolean areEqual = pokemonSet1.equals(pokemonSet2);
        System.out.println("Are the sets equal? " + areEqual);
    }
}

Pokemon.main(null);

```

    Are the sets equal? true


### Other kinds of hashsets
- There are other kinds of hashsets that are similar to the hashset but have some differences. These include the linkedhashset and the treeset. 
- The linkedhashset is similar to the hashset but it maintains the order in which the values were added. 
- The treeset is similar to the hashset but it sorts the values in ascending order.


```java
// LinkedHashSet

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        Set<String> linkedHashSet = new LinkedHashSet<>();

        // Add elements
        linkedHashSet.add("Pikachu");
        linkedHashSet.add("Charmander");
        linkedHashSet.add("Pikaman");

        // Iterate through the LinkedHashSet
        System.out.println("LinkedHashSet: ");
        linkedHashSet.forEach(pokemon -> System.out.println(pokemon));
        System.out.println();

        linkedHashSet.remove("Pikachu");
        System.out.println("New hashset: " + linkedHashSet);
    }
}

LinkedHashSetExample.main(null);
```

    LinkedHashSet: 
    Pikachu
    Charmander
    Pikaman
    
    New hashset: [Charmander, Pikaman]



```java
// TreeSet
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        Set<String> treeSet = new TreeSet<>();

        // Add elements
        treeSet.add("Alberquerque, New Mexico");
        treeSet.add("Pikachu");
        treeSet.add("Charmander");
        treeSet.add("Pikaman");

        // Iterate through the TreeSet
        treeSet.forEach(pokemon -> System.out.println(pokemon));
        // The values for the TreeSet are sorted alphabetically
    }
}

TreeSetExample.main(null);
```

    Alberquerque, New Mexico
    Charmander
    Pikachu
    Pikaman


## SQL

SQL is a programming language focused on managing and manipulating relational (table-based) databases. It acts as the backbone for many of this class's project backends, allowing users to create, read, update and delete data efficiently. To get a better idea of how data is formatted with JPA to be stored in an SQL database, we'll be looking at the `Person` object in the [lesson backend](https://github.com/Tirth-Thakkar/LessonBackend). Follow along in this notebook.

### Person Object Setup

(see .../mvc/person/Person.java)

After the first three tags, which specify to Lombok that `@AllArgsConstructor` and `@NoArgsConstructor` methods should be created

The `@Entity` tag indicates that Person objects will be stored as entities in a database. Generally, entities' attributes are represented by values in columns in the SQLite table.


```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Convert(attributeName ="person", converter = JsonType.class)
public class Person //...
```

The `@Id` tag specifies to that this value will be used as the unique identifier for each object in the database, and `@GeneratedValue(strategy = GenerationType.AUTO)` allows these ID's to be automatically generated when a new Person is created. In order for data to be most easily differentiated and manipulated in a database, IDs are deeply important to use.


```java
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
```

### Person JPA Repository Setup

(see .../mvc/person/PersonJpaRepository.java)

JPA is a great asset when creating an SQL database because it can provide methods that help you modify its contents. If a specific object has a `JpaRepository` interface made that extends the base JPA repository, it allows you to access many useful JPA methods.


```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// ...

public interface PersonJpaRepository extends JpaRepository<Person, Long> // ...
```

#### Popcorn Hack!

List all of the JPA methods that you see in the PersonJpaRepository.java file and what their purpose is.

Person findByEmail(String email)

Purpose: Finds a person by their email address.
List Person findAllByOrderByNameAsc()

Purpose: Retrieves all persons and orders them by name in ascending order.
List Person findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email)

Purpose: Finds persons whose name contains the specified substring (case-insensitive) or whose email contains the specified substring (case-insensitive).
Person findByEmailAndPassword(String email, String password)

Purpose: Finds a person by their email and password. This can be useful for authentication.
List Person findByLikeTermNative(String term)

Purpose: Executes a custom native SQL query to find persons whose name or email is similar to the provided term.

#### Custom JPA Queries

You can create custom JPA queries that utilize SQL to serve a specific purpose outside of the existing JPA methods. See the example below from PersonJpaRepository.java:


```java
@Query(
        value = "SELECT * FROM Person p WHERE p.name LIKE ?1 or p.email LIKE ?1",
        nativeQuery = true)
List<Person> findByLikeTermNative(String term);
```

Going step-by-step:
- The `@Query` indicates a custom query is being created
- `value` is a String containing an SQL query that will be run with the method `findByLikeTermNative`
    - `?1` is a placeholder for a parameter (in this case the String `term` from the method declaration)
- `nativeQuery` is set to true, indicating that the value uses native SQL rather than JPQL (Java Persistence Query Language)

Using a custom SQL query like this would be a great way to show understanding on the homework.

### Many-to-Many Relationship

(see .../mvc/person/Person.java)

A "Many-to-Many" relationship (shown in the @ManyToMany tag) indicates that entities on both sides of a relationship can have multiple connections with each other.

This condition allows for one object to be related to multiple different objects, and those different objects on the other side of the relationship can have their own relationship to other objects.


```java
@ManyToMany(fetch = EAGER)
private Collection<PersonRole> roles = new ArrayList<>();
```

(fetch = EAGER) specifies that, whenever a `Person` object is loaded, its corresponding `PersonRole` objects should be loaded simultaneously.

Objects in a "many-to-many" relationship often use "join tables" to represent the connections between these objects.

```text
| person_id | role_id |
|-----------|---------|
| 1         | 1       |
| 1         | 2       |
| 2         | 2       |
| 3         | 1       |
| 3         | 3       |
```

This is what a "join table" may look like with multiple interconnected people and roles. There is a table in the backend repository's SQLite.db called `person_roles` that acts as a join table for the two roles, but you'll notice that it's empty. If you can show it filled up, that sounds like a good reason to give extra points.

#### Popcorn Hack!

Explain in your own words what the relationship between `Person` objects and `PersonRole` objects is. Why is this relevant to collections? (Hint: In the code above, multiple `PersonRole` objects are stored within a `Person` object's roles attribute.)

The relationship between `Person` and `PersonRole` objects involves a `Person` having multiple roles, stored in its `roles` attribute. This connection is important to collections as it enables the organized management of diverse roles associated with an individual within a single `Person` object.

### Many-to-One Relationship

On the other hand, there is also a "Many-to-One" relationship that can exist between two objects. It means that multiple instances of one entity (the "many" side) are associated with a single instance of another entity (the "one" side). This can be seen applied to the `Note` object in relation to the `Person` object.


```java
@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "tutorial_id", nullable = false) // notice this!
@OnDelete(action = OnDeleteAction.CASCADE)
@JsonIgnore
private Person person;
```

Notice the `@JoinColumn(name = "tutorial_id", nullable = false)` tag. Then, check the `note` table in the sqlite.db file.

#### Popcorn Hack!

Where do you see "tutorial_id" on the table? What does it represent in relation to the leftmost "id" column?


The "tutorial_id" column, specified by the `@JoinColumn(name = "tutorial_id")`, represents a foreign key in the database table of the entity containing this code, establishing a many-to-one relationship with the "id" column of the "Person" entity. It signifies that each entry in the table is associated with a specific "Person" through the "tutorial_id" foreign key.

### Storing HashMaps with jsonb

JSONB is a binary representation of JSON data. It is a data type used in some relational databases (such as SQL databases) to store JSON documents in a more efficient and flexible way compared to traditional JSON. Within SQL databases, this data from the JSON can often be filtered, searched and/or extracted using provided functions.


```java
@JdbcTypeCode(SqlTypes.JSON)
@Column(columnDefinition = "jsonb")
private Map<String,Map<String, Object>> stats = new HashMap<>(); 
```

JSONB allows for the storage of nested and dynamic data structures. In the context of `Person` object stats, it means that each person can store activity data with the formatted date as the key, and the structure of this JSON data can be modified or extended without altering the database schema.

You can view the way this data is structured in the `person` sqlite.db table.

## Homework

- Complete all popcorn hacks throughout this lesson
- Using the [Person](https://github.com/Tirth-Thakkar/LessonBackend/tree/master/src/main/java/com/nighthawk/spring_portfolio/mvc/person) object as inspiration, create your own UNIQUE SQL database with at least 3 object entries that incorporates either a "many-to-many" relationship with another object (hint: Person and PersonRole) OR uses the JSONB column definition to store more complex data (such as a HashMap) as an attribute (hint: stats in Person object).
    - Show a clear screenshot of your SQLite table (using SQLite viewer) on your blog for credit.
    - Using past group project materials is valid for this homework as long as the expectations are met.

### Ideas for 1.0/1.0

- Incorporating both a "many-to-many" relationship and a JSONB column with information would be great.
- Implementing JPA repository methods (think CRUD methods, custom queries, etc.) would show interest in modifying SQL database data.
- Take extra notes on this lesson that show deeper research into Collections and SQL.

## Hacks
This is what happens when I run the Person.java in terminal, replacing human with book (first five books of the harry potter series) and the email with the author (JK Rowling's email)
![hi](https://raw.githubusercontent.com/Pitsco/personal/main/images/hashmaphack1.png)

### SQLite Table:
![image-2.png](https://raw.githubusercontent.com/Pitsco/personal/main/images/hashmaphack2.png)

I made a new one that contained the books with different book titles and emails. I had an issue with `@Column(unique=true)` as I didn't realize that if you had the same email, the table will not show information of other books with the same email. Therefore, I had to change the emails

# Person.java code in person folder


```java
package com.nighthawk.spring_portfolio.mvc.person;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Convert;
import static jakarta.persistence.FetchType.EAGER;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.format.annotation.DateTimeFormat;

import com.vladmihalcea.hibernate.type.json.JsonType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/*
Person is a POJO, Plain Old Java Object.
First set of annotations add functionality to POJO
--- @Setter @Getter @ToString @NoArgsConstructor @RequiredArgsConstructor
The last annotation connect to database
--- @Entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Convert(attributeName ="person", converter = JsonType.class)
public class Person {

    // automatic unique identifier for Person record
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // email, password, roles are key attributes to login and authentication
    @NotEmpty
    @Size(min=5)
    @Column(unique=true)
    @Email
    private String email;

    @NotEmpty
    private String password;

    // @NonNull, etc placed in params of constructor: "@NonNull @Size(min = 2, max = 30, message = "Name (2 to 30 chars)") String name"
    @NonNull
    @Size(min = 2, max = 100, message = "Book Name (2 to 30 chars)")
    private String book;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datepublished;

    // To be implemented
    @ManyToMany(fetch = EAGER)
    private Collection<PersonRole> roles = new ArrayList<>();

    /* HashMap is used to store JSON for daily "stats"
    "stats": {
        "2022-11-13": {
            "calories": 2200,
            "steps": 8000
        }
    }
    */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String,Map<String, Object>> stats = new HashMap<>(); 
    

    // Constructor used when building object from an API
    public Person(String email, String password, String book, Date datepublished) {
        this.email = email;
        this.password= password;
        this.book = book;
        this.datepublished = datepublished;
    }

    // A custom getter to return age from dob attribute
    public int getAge() {
        if (this.datepublished != null) {
            LocalDate birthDay = this.datepublished.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return Period.between(birthDay, LocalDate.now()).getYears(); }
        return -1;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getbook() {
        return book;
    }

    public void setbook(String book) {
        this.book = book;
    }

    public Date getdatepublished() {
        return datepublished;
    }

    public void setdatepublished(Date datepublished) {
        this.datepublished = datepublished;
    }
    // Initialize static test data 
    public static Person[] init() {

        // Basics of class construction
        Person p1 = new Person();
        p1.setbook("Harry Potter and the Philosopher's Stone");
        p1.setEmail("jkrowling@gmail.com");
        p1.setPassword("123Toby!");
        // Adding Note to notes collection
        try {  
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("06-26-1997"); // Publish date of the first Harry Potter book
            p1.setdatepublished(d);
        } catch (Exception e) {
            // No actions as default date of birth is good enough
        }
    
        Person p2 = new Person();
        p2.setbook("Harry Potter and the Chamber of Secrets");
        p2.setEmail("jkrowling@gmail.com");
        p2.setPassword("123LexB!");
        try {
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("07-02-1998"); // Publish date of the second Harry Potter book
            p2.setdatepublished(d);
        } catch (Exception e) {
        }
    
        Person p3 = new Person();
        p3.setbook("Harry Potter and the Prisoner of Azkaban");
        p3.setEmail("jkrowling@gmail.com");
        p3.setPassword("123Niko!");
        try {
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("07-08-1999"); // Publish date of the third Harry Potter book
            p3.setdatepublished(d);
        } catch (Exception e) {
        }
    
        Person p4 = new Person();
        p4.setbook("Harry Potter and the Goblet of Fire");
        p4.setEmail("jkrowling@gmail.com");
        p4.setPassword("123Madam!");
        try {
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("07-08-2000"); // Publish date of the fourth Harry Potter book
            p4.setdatepublished(d);
        } catch (Exception e) {
        }
    
        Person p5 = new Person();
        p5.setbook("Harry Potter and the Order of the Phoenix");
        p5.setEmail("jkrowling@gmail.com");
        p5.setPassword("123Qwerty!");
        try {
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("06-21-2003"); // Publish date of the fifth Harry Potter book
            p5.setdatepublished(d);
        } catch (Exception e) {
        }
    
        // Array definition and data initialization
        Person persons[] = {p1, p2, p3, p4, p5};
        for (Person person : persons) {
            Map<String, Object> statsMap = new HashMap<>();
            statsMap.put("complexity out of 10", 7);
            person.getStats().put("2022-12-17", statsMap);
        }
        return persons;
    }    

    public static void main(String[] args) {
        // obtain Person from initializer
        Person persons[] = init();

        // iterate using "enhanced for loop"
        for( Person person : persons) {
            System.out.println(person);  // print object
        }
    }

}
```

# Person.java file in the classDataStruc Folder


```java
package com.nighthawk.hacks.classDataStruct;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;


/*
Adapted from Person POJO, Plain Old Java Object.
 */
public class Person extends Generics{
    // Class data
    private static String classType = "Person";
    public static KeyTypes key = KeyType.title;  // static initializer
	public static void setOrder(KeyTypes key) {Person.key = key;}
	public enum KeyType implements KeyTypes {title, uid, name, dob, age}

    // Instance data
    private String uid;  // user / person id
    private String password;
    private String name;
    private Date dob;
    

    // Constructor with zero arguments
    public Person() {
        super.setType(classType);
    }

    // Constructor used when building object from an API
    public Person(String uid, String password, String name, Date dob) {
        this();  // runs zero argument constructor
        this.uid = uid;
        this.password = password;
        this.name = name;
        this.dob = dob;
    }

    /* 'Generics' requires getKey to help enforce KeyTypes usage */
	@Override
	protected KeyTypes getKey() { return Person.key; }

    public String getUserID() {
        return uid;
    }

    /* 'Generics' requires toString override
	 * toString provides data based off of Static Key setting
	 */
	@Override
	public String toString() {		
		String output="";
		if (KeyType.uid.equals(this.getKey())) {
			output += this.uid;
		} else if (KeyType.name.equals(this.getKey())) {
			output += this.name;
		} else if (KeyType.age.equals(this.getKey())) {
			output += "0000" + this.getAge();  // pads integer 1,100,11,2 to 0001,0100,0011,0002
			output = output.substring(output.length() - 4);
		} else {
			output = super.getType() + ": " + this.uid + ", " + this.name + ", " + this.getAge();
		}
		return output;
	}

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    // A custom getter to return age from dob attribute
    public int getAge() {
        if (this.dob != null) {
            LocalDate birthDay = this.dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return Period.between(birthDay, LocalDate.now()).getYears(); }
        return -1;
    }

    // Initialize static test data 
    public static Person[] init() {

        // basics of class construction
        Person p1 = new Person();
        p1.setName("Harry Potter and the Sorcerer's Stone");
        p1.setUid("jkrowling1@gmail.com");
        p1.setPassword("123J.K.R.!");
        try {
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("06-26-1997"); //publish date of the first book
            p1.setDob(d);
        } catch (Exception e) {
            // no actions as dob default is good enough
        }
    
        Person p2 = new Person();
        p2.setName("Harry Potter and the Chamber of Secrets");
        p2.setUid("jkrowling2@gmail.com");
        p2.setPassword("123J.K.R.!");
        try {
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("07-02-1998"); //publish date of the second book
            p2.setDob(d);
        } catch (Exception e) {
        }
    
        Person p3 = new Person();
        p3.setName("Harry Potter and the Prisoner of Azkaban");
        p3.setUid("jkrowling3@gmail.com");
        p3.setPassword("123J.K.R.!");
        try {
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("07-08-1999"); //publish date of the third book
            p3.setDob(d);
        } catch (Exception e) {
        }
    
        Person p4 = null;
        Person p5 = null;
        try {
            p4 = new Person(
                "jkrowling4@gmail.com",
                "123J.K.R.!",
                "Harry Potter and the Goblet of Fire",
                new SimpleDateFormat("MM-dd-yyyy").parse("07-08-2000")
            );
    
            p5 = new Person(
                "jkrowling5@gmail.com",
                "123J.K.R!",
                "Harry Potter and the Order of the Phoenix",
                new SimpleDateFormat("MM-dd-yyyy").parse("06-21-2003")
            );
        } catch (Exception e) {
        }    

        // Array definition and data initialization
        Person persons[] = {p1, p2, p3, p4, p5};
        return(persons);
    }

    public static void main(String[] args) {
        // obtain Person from initializer
        Person persons[] = init();
        Person.setOrder(Person.KeyType.title);

        // iterate using "enhanced for loop"
        for( Person person : persons ) {
            System.out.println(person);  // print object
        }
    }

}
```

### What it would show in terminal after running:
![image.png](attachment:image.png)

## Extra notes:

The lesson itself covered good notes, but I dived deeper with into Person.java as I thought it was very useful. Like with the error of duplicate emails above, learning this code more in depth is very useful to me when it comes to learning these relationships.

```
This Java code defines a Person class intended for use in a Spring MVC application with Hibernate and validation annotations. The class is annotated with JPA annotations (@Entity, @Id, @GeneratedValue, etc.) to map it to a relational database, and it includes Lombok annotations (@Data, @AllArgsConstructor, @NoArgsConstructor, @NonNull) for boilerplate code generation.

The Person class encapsulates attributes such as id, email, password, name, dob (date of birth), and a collection of PersonRole entities stored in a roles attribute. Additionally, it incorporates a stats attribute, represented as a JSONB column in the database, to store daily statistics.

The code employs Hibernate's JsonType converter for the stats attribute, allowing the storage of JSON data in the database. There's also a custom method getAge() to calculate and retrieve a person's age based on the date of birth.

The class includes a static init() method to create and initialize an array of Person objects with test data. Each person is associated with a set of statistics stored in the stats attribute. The main method demonstrates the initialization and prints the created Person objects.

Overall, to me, the code has clear and meaningful variable names, uses appropriate annotations for validation and database mapping, and follows conventions for Java persistence and Lombok. However, there are a few areas for improvement, such as handling exceptions more effectively and potentially using Java 8's LocalDate instead of Date for the dob attribute. Additionally, some comments could be enhanced for better clarity, and the password handling might need to be revisited for security considerations.
```
