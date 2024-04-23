---
title: Unit 2 Study
description: Review the Generic Concepts of Unit 2 of AP CSA Exam
layout: post
courses: {'csa': {'week': 25}}
categories: ['C4.0']
type: tangibles
comments: True
---

# Java Classes and Objects:
In OOP (Object Oriented Programming), objects have...
- States (fields in Java)
- Behaviors (methods in Java)

### Example: Lightbulb Object
- States:
    - color
    - wattage

- Behaviors:
    - turnOn
    - turnOff
    - flash

### What is a class?
A class is a blueprint (or template) for a object

### Lightbulb Example (Again)
```cs
    Lightbulb x = new Lightbulb();
    Lightbulb y;
    y = new Lightbulb();
    Lightbulb z = new Lightbulb("green");
    y.turnOff(); //example, doesn't run because some methods aren't defined
```

- Methods that don't need an object are called static methods
- Methods where you need to create an object first are called nonstatic methods

### Different Ways to Create Objects
```cs
    Lightbulb w = new Lightbulb(); //typical
    String x = "hello"; //string
    int[] y = new int[5]; //array
    int[] z = {3, 4, 1} // array
```

# Methods:
- Methods are blocks of code that can be called from another program
- May be returned to the part of the prgoram that called them
- They pass **parameters** that allows us to pass them data
- Void return type means return statement is optional
    - Method with any other return type means data of the correct type **MUST** be returned back
- Methods end as soon as there is a return type, regardless even if there is more code


```Java
public class Method {
    public static int addTwoNums(int num1, int num2){ //must return a type int, given 2 parameters
        int total = num1 + num2;
        return total;
    }

    public static int averageOfTwo(int numA, int numB){
        return addTwoNums(numA, numB) / 2;
    }

    public static void printAverage(int num3){
        System.out.println("Average is " + num3);
    }

    public static void main(String[] args){
       int sum = addTwoNums(5,3); //parameters have to match
       int avg = averageOfTwo(7,5);
       printAverage(avg);
    }
}

Method.main(null);
```

    Average is 6


### Extra Notes:
- A method can have multiple return statements, but only one is activated every time the method is run
- You must have the same number, type, and order of the argument(s) as parameter(s)

# Escape Sequence
Definition: A way to represent certain special characters inside a String

## Example: 

```cs
System.out.println("This is a test message.");
```
This prints out "This is a test message."

### Incorrect Way:
```cs
System.out.println("This is a "test" message.");
```
Will lead to error, test is not printed out as a string.

### Correct Way:
```cs
System.out.println("This is a \"test\" message.");
```
This will print out "This is a "test" message."

### Chart with all Escape Sequences:
![image.png](attachment:image.png)

**For the AP Test, you only need to know first 3.**


```Java
public class IntDoubleDivision {
    public static void main(String[] args){
        System.out.println("abc \\ \' def \n \" ghi");
    }
}

IntDoubleDivision.main(null);
```

    abc \ ' def 
     " ghi


# String Class:
- Strings are a data type that hold text
- Internally Strings are an array of the pirimitve type char
- String class has a variety of methods to compare and modify Strings


```Java
public class StringClass {
    public static void main(String[] args){
        String a = "hello";
        String b = "hello"; //in a heap, both object `b` and `a` are directed to the string "hello" to save memory

        String c = new String("hello"); //will create a second object in heap
        String d = new String("hello");

        System.out.println(a == b); //both 'a' and 'b' are pointed to the same memory location
        System.out.println(c == d); //two different memory locations where the data is stored

        System.out.println(a.equals(b)); //true
        System.out.println(c.equals(d)); //false, two different memoring locations

        System.out.println(c.equals("hello")); //true

        a = "hola"; //strings are immutable, we can't change the data on the heap
        // will create a as a brand new object under "hola" instead of "hello"

        String e = "hi";
        String f = e;
        String g = "howdy";
        String h = "HI";

        System.out.println(e.equals(f)); //true
        System.out.println(e.equals(h)); //false, capitalizatoin is accounted for

        System.out.println(e.equalsIgnoreCase(h)); //true, ignoring capital case
        System.out.println(g.length()); //5
        System.out.println(g.substring(2)); //returns "wdy", starting at index 2
        System.out.println(g.substring(1,4)); //(inclusive, exclusive), includes index 1 but not 4!! Returns "owd"
        System.out.println(h.compareTo(e)); //-32

        int i = h.length();

        if (e.equals("hi")){
            System.out.println("e equals hi");
        }
    }
}

StringClass.main(null);
```

    true
    false
    true
    true
    true
    true
    false
    true
    5
    wdy
    owd
    -32
    e equals hi


# Math Class:
- Math class contains a variety of methods
- All methods are static
- Can't extend or create an instance of the methods
- Can pass a int, double, float, or long
- Will return the same data type (usually)

### Examples:
```cs
Math.abs(-3.2) //taking absolute value, returns 3.2
```
```cs
Math.pow(3,2.0) //this method will always return double. (base, exponent), in this cause it returns 9.0
```
```cs
Math.sqrt(9) //returns a double like Math.pow, this one returns 3.0
```
```cs
Math.PI //is a public variable, a double type approximately equal to pi
double circumference = 2 * Math.PI * radius //ex
```

### Other Useful Methods:
![image.png](attachment:image.png)

# Random Numbers with Math.random()
- Several ways to genearte random numbers in Java, one of which is Math.random()
- Includes many mathematical methods including random()
- It's a static method, you can call it without an instance of Math class

For example:
```cs
0.0 <= Math.random() < 1.0 //number between 0.0 and 0.99999...
```


```Java
int randNum = (int)(Math.random()*11); //number between 0 and 10
System.out.println("Random Number between 0 and 10: " + randNum);

int randNum2 = (int)(Math.random()*10 + 1); //number between 1 and 10
System.out.println("Random Number between 1 and 10: " + randNum2);

System.out.println(" ");

String[] name = {"Dorothy", "Glenda", "Toto"};
int randNum3 = (int)(Math.random() * 3);
String chosenName = name[randNum3];
System.out.println("Random Name chosen from array \"name\": " + chosenName);

int coinFlip = (int)(Math.random() * 2);
if (coinFlip == 0) {
    System.out.println("Heads");
}
else {
    System.out.println("Tails");
}
```

    Random Number between 0 and 10: 8
    Random Number between 1 and 10: 4
     
    Random Name chosen from array "name": Dorothy
    Tails


# Scanner:


```Java
public class UserInput {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Type in your height: ");
        double x = keyboard.nextDouble();
        System.out.print(x);

        System.out.println(" \nWhat is your age? ");
        int y = keyboard.nextInt();
        System.out.println(y);

        System.out.println("Are you female? "); //can only respond with true or false
        boolean isFemale = keyboard.nextBoolean();
        System.out.println(isFemale);
    }
}

UserInput.main(null);
```

    Type in your height: 
    12.3 
    What is your age? 
    2
    Are you female? 
    true


## Special case with keyboard.next() and keyboard.nextLine()


```Java
public class NextvsNextline {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Using next()
        System.out.print("Enter your first name: ");
        String firstName = keyboard.next(); // Reads the first word, ex. Derrick Huang will only read Derrick
        System.out.println("First Name: " + firstName);

        // Using nextLine()
        System.out.print("Enter your full name: ");
        keyboard.nextLine(); // Consume the newline character left by next()
        String fullName = keyboard.nextLine(); // Reads the entire line, ex. Derrick Huang will read Derrick Huang
        System.out.println("Full Name: " + fullName);

        keyboard.close();
    }
}

NextvsNextline.main(null);
```

    Enter your first name: First Name: Derrick
    Enter your full name: Full Name: Derrick Huang

