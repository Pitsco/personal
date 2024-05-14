---
title: All 10 Units Combined
description: Review all concepts for the AP CSA Exam
layout: post
courses: {'csa': {'week': 25}}
categories: ['C4.0']
type: tangibles
comments: True
---

# References:
### [Initial Series, 11 videos. Talks about how code works in stack and heaps](https://www.youtube.com/watch?v=BjRvQbWsTfM&list=PLmpmyPywZ440vPqpAPeUkE-TeKifbS45W)

### [In-Depth Series, 40 videos. Very useful to success in the AP CSA exam!](https://www.youtube.com/watch?v=JYLJbVECJxs&list=PLfpeXtDSa8rUl8S9NtbPKlg0ikc-rw-LC)

### [Computer Scientist takes the CSA Exam...?](https://www.youtube.com/watch?v=XGxaOYcQFHk&t=6013s&pp=ygUGYXAgY3Nh)


# Unit 1, Primitive Types:

# Declaring and Initializing Variables:
![image.png](attachment:image.png)

Variables defined in a method are called "local varibales" since they are local to the method that was created.

## 8 Primitive Data Types:
### These 4 all hold **integer** values but having different ranges:

Byte: -128 to 127 (inclusive)

Int: -32768 to 327687 (inclusive)

Short: -2^31 to 2^31-1

Long: -2^63 to 2^63-1

### The next two hold decimals, but double is more precise:

Float

Decimal

### Rest are self-explantory:
Boolean: True or False

Char: Holds a character

**For the AP Test, you need to know: int, double, and boolean**


```Java
public class PrimitiveDataTypes {
    public static void main(String[] args){
        int a = 3;
        double b = 3.0;
        b = 3;
        //a = 3.0; doesn't convert because double can't convert to int.
        a = (int)3.999;
        System.out.println(a);

        boolean c = true;
        c = false;
        System.out.println(c);
    }
}

PrimitiveDataTypes.main(null);
```

    3
    false


# Arithmetic and Uninary Operators:


```Java
public class Operators{
    public static void main(String[] args){
        int x = 3;
        System.out.println(x);
        System.out.println(3 + 3);

        x = 3 * 3;
        x = 3 * x;
        System.out.println(x);
        System.out.println(4 % 3); //output is remainder

        //x++; is x = x + 1;
        //x--; is x = x - 1;
        //x =* 3;  is x = x * 3;
        
        boolean z = true;
        System.out.println(!z);

    }
}

Operators.main(null)
```

    3
    6
    27
    1
    false



```Java
public class IntDoubleDivision {
    public static void main(String[] args){
        System.out.println(5/3); //int division, will return 1
        
        System.out.println(5.0/3.0); //double division, will return 1.6667

        //System.out.println(5/0) will return error

        System.out.println(5/0.0); //Infinity

        System.out.println(-5/0.0); //Negative Infinity

        System.out.println(0.0/0.0); //Returns Nan (Not a Number)
    
    }
}

IntDoubleDivision.main(null)
```

    1
    1.6666666666666667
    Infinity
    -Infinity
    NaN


## Operation Precdence:
- Some operators will be processed first, depending on their precedence (PEMDAS)
- Precedence is same? Code goes left to right
- Best used with parenthesis to clarify the order of execution

![image.png](attachment:image.png)


```Java
public class PEMDAS {
    public static void main(String[] args){
        int x = 9;
        int y = 6;
        System.out.println((double)x++/(3-1*2) > ((5-2) * 3));
        System.out.println(x);
        System.out.println((double)x);
        // ((double)x++/1 > 9)
        // ((double)9.0 > 9)
        // returns false
        // if we returned x after, it would return 10

    }
}

PEMDAS.main(null)
```

    false
    10
    10.0


# Casting a Primitive and Overflow:
- Casting primitive data type allows us to convert a peice of data from one type to another type
- Widening means converting a data type to a data type with more precise/more space
- Narrowing means converting a data type to a data type with less precision/less space
- **For AP Exam, you only need to know about int, double, boolean**


```Java
public class Casting{
    public static void Example1() {
        double a = 3.0;
        System.out.println(a);
 
        double b = 4; //in this case, the system automatically **widens** 4 to 4.0 
        System.out.println(b);
 
        double c = (double)5; //manually widens 5 to 5.0
        System.out.println(c);
 
        // int d = c; will cause error, c needs to narrow down from a double to int
 
        //narrowing must be done manually
        int d = (int)c;
        System.out.println(d);
 
        int e = (int)3.95;
        System.out.println(e); //truncate 3.95 --> 3
    }

    public static void Example2() {
        int x = 10;
        byte y; //value from -128 to 127

        // y = x; will cause error because of "lossy conversion", meaning system doesn't want to loose data
        y = (byte)x;

        System.out.println(y);

    }

    public static void main(String[] args){
        System.out.println("Example 1:");
        Example1();

        System.out.println(" ");
        System.out.println("Example 2:");
        Example2();
    }
}

Casting.main(null);
```

    Example 1:
    3.0
    4.0
    5.0
    5
    3
     
    Example 2:
    10


# Swapping Variable Values:
- Switch values of two variables


```Java
public class SwitchVariables {
    public static void WrongWay() {
        int x = 3;
        int y = 6;

        //wrong way, you are essentially declaring all variables equal to 6
        x = y;
        System.out.println(x); //x = 6 (y is 6);
        y = x;
        System.out.println(y); //y = 6;
    }

    public static void RightWay() {
        int x = 3;
        int y = 6;

        //correct way, declare a temporary variable that holds a value
        int temp = y;
        y = x;
        x = temp;
        System.out.println("x-value (or temp): " + temp);
        System.out.println("y-value: " + y);
    }

    public static void main(String[] args){
        System.out.println("Wrong Way:");
        WrongWay();

        System.out.println(" ");
        System.out.println("Right Way:");
        RightWay();
    }
}

SwitchVariables.main(null)
```

    Wrong Way:
    6
    6
     
    Right Way:
    x-value (or temp): 6
    y-value: 3


# Unit 2, Java Classes and Objects:
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

## Methods:
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

## Escape Sequence
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

IntDoubleDivision.main(null)
```

    abc \ ' def 
     " ghi


## String Class:
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

StringClass.main(null)
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


## Math Class:
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

## Random Numbers with Math.random()
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

    Random Number between 0 and 10: 10
    Random Number between 1 and 10: 10
     
    Random Name chosen from array "name": Toto
    Heads


## Scanner:


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
    160.0 
    What is your age? 
    17
    Are you female? 
    false


## Practice FRQ:


```Java
public class Car{
    private String make;
    private String model;
    private boolean isConvertible;
    private int numPassengers;

    public Car(String newMake, String newModel, Boolean newIsConvertible, int newNumPassengers){
        make = newMake;
        model = newModel;
        isConvertible = newIsConvertible;
        numPassengers = newNumPassengers;
    }

    public int addNumPassengers(int newPassengersToAdd){
        return numPassengers += newPassengersToAdd;
    }

    public void printMakeModel(){
        System.out.println(make + " "+ model);
    }

    public static void main(String[] args){
        String hello1 = "wtfismake";
        String hello2 = "Honda";
        boolean hello3 = true;
        int hello4 = 10;
        Car newClass = new Car(hello1, hello2, hello3, hello4);
        int lolz = newClass.addNumPassengers(2);

        System.out.println(lolz);
        newClass.printMakeModel();
    }
}

Car.main(null);
```

    12
    wtfismake Honda


# Unit 3, Boolean Expressions:


```Java
public class EqualityRelationalCondition {
    static int x = 5;

    public static void greaterStatement(){
        if (x <= 2){
            System.out.println("ABC"); //doesn't print abc because 5 is not less or equal to 2
        }
    }

    public static void andStatement() {
        if (x >= 8 && 5/0 > 3){
            System.out.println("DEF"); //doesn't print def because 5 is not greater than 8
        }

        /* if (x >= 8 && 5/0 > 3){
            System.out.println("DEF"); //doesn't print because error of dividing by 0. Since "x >=8" is true, 
        } */
    }

    public static void orStatement() {
        if (x > 3 || x == 10){ //since first is true, it won't check the second value
            System.out.println("GHI");
        }

        if (x < 3 || x == 5){ //since first is true, it won't check the second value
            System.out.println("JKL");
        }
    }
    
    public static void main(String[] args){
        greaterStatement();
        andStatement();
        orStatement();
    }
}

EqualityRelationalCondition.main(null)
```

    GHI
    JKL


## if, else if, and else:
- if and else if require a boolean expression while else doesn't
- an else if statement must have another else if to "latch on to"
- an else must have a if or else if to latch on to


```Java
public class Statements {
    public static void ifStatementOnly(){
        int x = 5;
        if (x < 10){
            System.out.println("A");
        }
        if (x < 4){
            System.out.println("B");
        }
        if(x < 7){
            System.out.println("C");
        }
    }

    public static void ifElseStatementOnly(){
        int y = 5;
        if (y > 10){
            System.out.println("D");
        }
        else{
            System.out.println("E");
        }
    }

    public static void elseIfStatements(){
        int z = 5;
        if (z > 10){
            System.out.println("F");
        }
        else if (z >= 4){
            System.out.println("G");
        }
        else if (z < 1){
            System.out.println("H");
        }
        else {
            System.out.println("I");
        }
    }

    public static void main(String[] args){
        ifStatementOnly();
        ifElseStatementOnly();
        elseIfStatements();
    }
}

Statements.main(null)
```

    A
    C
    E
    G


### Nested if, else if, and else
- An if, else if, and else can be "nested" inside a block of code attached to another if, else if, and else
- Other control strucutres like while, do while, for, etc. can be nested



```Java
public class Nested {
    public static void nestedIfElseStatements() {
        int x = 5;
        int y = 3;

        if (x < 10){
            if (y != 3){ //if statement nested in a if statement
                System.out.println("A");
            }
            else if (y <= 5) {//else if statement nested in a if statement
                System.out.println("B");
            }
            else {//else statement nested in a if statement
                System.out.println("C");
            }
        }
        else {
            if (y != 3){//if statement nested in a else statement
                System.out.println("D");
            }
            else if (y <= 5){//else if statement nested in a else statement
                System.out.println("E");
            }
        }
    }

    public static void main(String[] args){
        nestedIfElseStatements();
    }
}

Nested.main(null)
```

    B


# De Morgan's Laws

1. not (A or B) = not A and not B
2. not (A and B) = not A or not B

![image.png](attachment:image.png)

We can see that everywhere outside the two circles are highlighted. not (A or B) means that it can't be either A or B, so both A and B should be avoided. 

![image-2.png](attachment:image-2.png)

This diagram was tricky for me to understand at first. Basically, it means that the circle with isolated "not A" means that everything outside the two circles AND circle B is "not" A. Therefore, eliminating everything but "A" and "A and B" is what will happen. This also does the same thing with "not B", as everything but "B" and "A and B" is eliminated. 

![image-3.png](attachment:image-3.png)


## Checking Equality in Java:
- Primitive data types are compared using (a == b)
- Using == to compare two reference (object) type variables will only check if they are poitning at the same object
- Using equals() (ex. a.equals(b)). Some classes will check if they are the same object, but some will check if they are equivalent objects


```Java
public class CheckingEquality   {
    public static void main(String[] args){
        int a = 3;
        int b = 3;
        double c = 3.0;
        double d = 3.0;
        boolean e = false;

        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(a != b);
        // System.out.println(c == e); boolean can't be comapred with double value

        
    }
}

CheckingEquality.main(null);
```

## Comparing Objects
- Compare two objects with ==, but it will only tell us if it is pointing in the same direction
- We can compare two objects with equals() method
    - "shallow" comparison, only checks whether they are the pointing to the same object (similar to ==)
    - "deep" comparison, only checks whether the data in the two objects are the same 


```Java
public class ComparingObjects {
    public static void main(String[] args){
        String a = "coffee";
        String b = "coffee"; //in a heap, both object `b` and `a` are directed to the string "coffee" to save memory

        String c = new String("coffee"); //will create a second object in heap
        String d = new String("coffee");

        System.out.println(a == b); //both 'a' and 'b' are pointed to the same memory location
        System.out.println(c == d); //two different memory locations where the data is stored

        System.out.println(a.equals(b)); //true
        System.out.println(a.equals(c)); //false, two different memoring locations
   }
}

ComparingObjects.main(null)
```

    true
    false
    true
    true


# Unit 4, Iteration and Loops:
- For loops let us repeat a command or commands
- each loop declares a varible that acts as a counter
- counter variable will be progressed in the loop and can be used for various purposes


```Java
public class ForLoop {    
    public static void main(String[] args){
        for (int i = 0; i < 4; i ++){
            System.out.println(i);
        }
    }
}

ForLoop.main(null);
```

    0
    1
    2
    3


## while loops do while loops
- while loops repeat commands while a boolean expression remains true
- Do While loops check boolean expressions at the end of the loop and at least will run once


```Java
public class WhileLoop { 
    public static void main(String[] args){
        int i = 4;
        while (i > 0){
            System.out.println(i);
            i--;
        }
    }
}

WhileLoop.main(null);
```

## Reverse String


```Java
public class Reversestring{
    public static void main(String[] args){
        String original = "pupils";
        String reverse = "";

        for(int i = original.length() - 1; i >= 0; i--){
            reverse = reverse + original.substring(i, i + 1);
            System.out.println(reverse);
        }
        
        System.out.println("Final reversed word: " + reverse);
    }
}

Reversestring.main(null);
```

    s
    sl
    sli
    slip
    slipu
    slipup
    Final reversed word: slipup


## Nested Loop
- loop inside a loop
- outer loop runs once, inner loop will go through entire cycle
- Nested loops is helpful when it comes to 2D arrays


```Java
public class NestedLoop{
    public static void main(String[] args){
        for (int i = 0; i < 2; i++){ //loops 2 times
            for (int j = 0; j< 3; j++){// loops 3 times
                System.out.print("# "); 
            }
        }
    }
}

NestedLoop.main(null);
```

    # # # # # # 

# Unit 5, Classes and Objects:
- In Object Oriengted Programming (OOP), Objects have both States and Behaviors

### Example Dog Object:
    - States:
    1. color
    2. isAwake
    3. age

    - Behaviors:
    1. bark
    2. run
    3. eat

### Class vs Object:
- A class is a blue print (or template) for an object

Static Methods:
- Certain behaviors we can access without creating an object (instance)
    - These are called static methods
- Examples: public static void rotateWheel()
    - public static void openHood()

Non-Static Methods:
- behaviors we can only access from an object 
    - non-static methods
    - public void turnOnEngine()
    - public void drive()

Class Variables (Static Fields):
- States that bleong to the class are called class variables
- Changing a class variable anywhere will change it everywhere
- private static int wheelSize;
- private static String vehicleType;

Instance Variables (Non-static fields):
- certain states that belong to the object
- isntance variables
- only an object mayu have a value for instance variables
- don't have the word "static"
- only change one place means it will only change in that instance

- static method can only access variables
- non-static method can access variables or instance variables
- private means that it cant be directly access by other classes

# Getter and Setter Methods (accessor and Mutator Methods):


```Java
public class Student {
    private int studentID; //instance variable
    private static String mascot; //class variable
    //fields will automatically set their own values, for example studentID will default to 0
    //private means that we can only access these variables in this class, not outside...

    public int getStudentID(){
        return studentID;
    }

    public void setStudentID(int newStudentID){
        studentID = newStudentID;
    }

    public static String getMascot(){
        return mascot;
    }

    public static void setMascot(String newMascot){
        mascot = newMascot;
    }
}

public class Highschool{
    public static void main(String[] args){
        Student derrick = new Student();
        Student jonathan = new Student();
        derrick.setMascot("Duke");
        derrick.setStudentID(12345);
        int derrickID = derrick.getStudentID();
        int jonathanID = jonathan.getStudentID();
        
        System.out.println(derrick.getMascot());
        System.out.println(Student.getMascot());
        System.out.println(derrickID);

    }
}

Highschool.main(null);
```

    Duke
    Duke
    12345


# Method Overloading:
- Must have the exact same name
- Must have different numbers and/or types of parameters
- Constructors can be overloaded

Overloaded methods CAN'T have different...
1. method names

Overloaded methods CAN have different...
1. return types
2. visibility (i.e. public, private, etc..)
3. static or non-static
4. parameter names

Overloaded methods MUST have different...
1. numbers of parameters
2. type of parameters
3. Order OF the type of parameters(i.e. String & int vs int & String)



# Java Constructor:
- only activated when you create an instance of a class
- behaves like a non-static method
- Can set up a new object after the object is created


```Java
public class Robot {
    private static String fuelSource;
    private String name;

    public Robot(){
        fuelSource = "electricity";
        randomName();
    }

    public void randomName(){
        int randomNumber = (int)(Math.random()*3 + 1);

        if (randomNumber == 1){
            name = "Bender";
        }

        else if (randomNumber == 2){
            name = "Hal 9000";
        }

        else {
            name = "Gort";
        }
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName(){
        return name;
    }

    public static String getFuelSource(){
        return fuelSource;
    }

    public static void setFuelSource(String newFuelSource){
        fuelSource = newFuelSource;
    }
}

public class Main {
    public static void main(String[] args) {
        Robot one = new Robot();
        Robot two = new Robot();
        Robot three = new Robot();
        three.setFuelSource("derrick");
        three.setName("lolz");
        String poo = three.getName();
        
        System.out.println(poo);
        System.out.println(three.getFuelSource());
    }
}

Main.main(null);

```

    lolz
    derrick


# "this" keyword:
- contains a pointer to whatever object it is currently in
- does not need to be declared
- can only be used for nonstatic methods or constructors

## Specific uses for "this"
- to specify a field over another variable of the same name
- to call another constructor in the same class
- to pass a copy of a pointer back to the current class


```Java
public class ThisKeyword {
    private int x = 10;
    private static int y = 0;

    public void printX(){
        int x = 5;
        System.out.println(x);
    }

    public void setX(int x){
        this.x = x;
    }

    public int getX(){
        return x;
    }

    public void resetY(){
        int y = 0;
        this.y = y;
    }

    public static void main(String[] args){
        ThisKeyword lolz = new ThisKeyword();
        lolz.setX(3);
        
        lolz.printX();
        int q = lolz.getX();
        System.out.println(q);
    }
}

ThisKeyword.main(null)
```

    5
    3


# Good Example found from java hello file:


```Java
// Define Class
public class HelloDynamic { // name the first letter of class as capitalized, note camel case
    // instance variable have access modifier (private is most common), data type, and name
    private String hello;
    // constructor signature 1, public and zero arguments, constructors do not have return type
    public HelloDynamic() {  // 0 argument constructor
        this.setHello("Hello, World!");  // using setter with static string
    }
    // constructor signature, public and one argument
    public HelloDynamic(String hello) { // 1 argument constructor
        this.setHello(hello);   // using setter with local variable passed into constructor
    }
    // setter/mutator, setter have void return type and a parameter
    public void setHello(String hello) { // setter
        this.hello = hello;     // instance variable on the left, local variable on the right
    }
    // getter/accessor, getter used to return private instance variable (encapsulated), return type is String
    public String getHello() {  // getter
        return this.hello;
    }
    
    // public static void main(String[] args) is signature for main/drivers/tester method
    // a driver/tester method is singular or called a class method, it is never part of an object
    public static void main(String[] args) {  
        HelloDynamic hd1 = new HelloDynamic(); // no argument constructor
        HelloDynamic hd2 = new HelloDynamic("Hello, Nighthawk Coding Society!"); // one argument constructor
        
        System.out.println(hd1.getHello()); // accessing getter
        System.out.println(hd2.getHello()); 
    }
}
// IJava activation
HelloDynamic.main(null);
```

    Hello, World!
    Hello, Nighthawk Coding Society!


# Scope and Lifetime:
- Scope determines where in a program that a variable can be accessed
- Lifetime determines when a object is created or destroyed in the memory
- scope and lifetime is determiend when it is declared, not intialized


```Java
public class ScopeAndLifetime{
    public static void main(String[] args){
        int a = 3; //int a is declared and its scope is within the entire main method

        if(true){
            int b = 4; //int b is declared in the if statement so it's scope is within the if statement
                       //it is destroyed when the if statement is dne executing
        }

        for (int c = 5; c < 8; c++){ //int c is only destroyed after the for loop is complete
            int d = 6; //created everytime it runs through a cycle in for loop and destroyed right after
        }
    }
}
```

## Example of in and out of scope:


```Java
public class ScopeAndLifetime {
    public static void anotherMethod(){
        System.out.println("a is out of scope!");
    }
    public static void main(String[] args){
        int a = 3; //in scope
        anotherMethod(); //when method is called, a is out of scope because it is not avaliable in another method
        System.out.println(a); //now accessible since it is back in scope!
    } //main method ends, a is destroyed
}

ScopeAndLifetime.main(null);
```

    a is out of scope!
    3


![image.png](attachment:image.png)


```Java
public class Train {
    private String name;
    private boolean isDiesel;
    private int numPassengers;
    
    public Train(String newName, boolean newIsDiesel){
        name = newName;
        isDiesel = newIsDiesel;
    }

    public int addPassengers(int newPassengersToAdd){
       return numPassengers += newPassengersToAdd;
    }

    public void unloadPassengers(){
        System.out.println(numPassengers -= numPassengers);
        
    }

    public static void main(String[] args){
        Train newClass = new Train("Thomas", false);
        int numberpoop = newClass.addPassengers(3);
        System.out.println(numberpoop);
        newClass.unloadPassengers();

    }
}

Train.main(null);
```

    3
    0


# Unit 6, Using Arrays:
- Arrays can hold 
multiple values of the same data type
- They are objects, but they hold either primitive types or reference types
- Arrays in Java start at index 0


```Java
    int [] x = new int [4];
    int [] y = {3, 5, 7, 2};

    x[2] = 12;

    //y[4] = 21; out of bounds error

    System.out.println(y[3]);
    
    for (int i = 0; i < x.length; i++){
    System.out.println(x[i]);
        }

```

    2
    0
    0
    12
    0



```Java
public class Array2 {
    public static void main(String[] args){
        int a = 3;
        int b = a;
        b = 100;
        
        int [] c = {1, 2, 3, 4}; //pointed is located in stack, but the data of the array is located in the heap!!
        int [] d = c; //same objects on the heap because d is set equal to c

        d[1] = 99; //affects both objects
        d = new int[5];

        int [] e = {5, 6, 7, 8};
        int [] f = {5, 6, 7, 8}; //separate objects on the heap!!
        f[1] = 99;
    }
}

Array2.main(null)
```

# Traversing an Array:
- Arrays in Java start at 0
- .length will return the number of indexes in an array
- traverse an array with a For Loop or a For-Each Loop


```Java
int[] x = {2, 1, 5, 8};

for (int i = 0; i < x.length; i += 2){
    System.out.print(x[i] + " ");
}

// enhanced for loop, for each loop
//can't skip indexes
//can't modify data within array
for (int t : x){
    System.out.print(t + " ");
}


int sum = 0;
for (int i = 0; i < x.length; i++){
    x[i] *= 2;
    sum += x[i];
}

System.out.println(sum);
```

    2 5 2 1 5 8 32


# Reversing an array:
- can be reversed by swapping values of the first half and the second half
- values can also be swapped by copying values to the opposite index in a temporary array


```Java
public class Array {
    public static void main(String[] args) {
        int[] x = {4, 2, 6, 1, 7};

        // Reverse the array
        for (int i = 0; i < x.length / 2; i++) {
            int temp = x[i]; //temp is set = 4
            x[i] = x[x.length - i - 1]; // 4 is set equal to (5-0-1 = 4), which is 7
            x[x.length - i - 1] = temp; //index 4 is set = 4
        }

        // Print the reversed array
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }
}

Array.main(null);
```

    7
    1
    6
    2
    4


# Find the Largest Number in an Array:


```Java
public class FindLargest {
    public static void main(String[] args) {
        int[] anArray = {-2, 1, 6, -3, 10, 8};

        int largest = anArray[0];

        for (int i = 0; i < anArray.length; i++){
            if (largest < anArray[i]){
                largest = anArray[i];
            }
        }
        System.out.println(largest);
    }
}

FindLargest.main(null);
```

    10


![image.png](attachment:image.png)


```Java
public class Example {

    public int highestNumber(int[] numbers){//part a
        int highestNumber = 0;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] > highestNumber){
                highestNumber = numbers[i];
            }
        }
        return highestNumber;
    }

    public double averageNumber(double[] numbers){//part b
        double sum = 0;
        double totalNumbers = 0;
        for (int i = 0; i < numbers.length; i++){
            sum += numbers[i];
            totalNumbers += 1;
        }
        return sum/totalNumbers;
    }

    public static void main(String[] args){
        int[] numbers = {1, 3, 4, 7, 2};
        double[] numbers2 = {1, 3, 4, 7, 2};
        Example newClass = new Example();
        System.out.println(newClass.highestNumber(numbers));
        System.out.println(newClass.averageNumber(numbers2));

    }
}

Example.main(null);

```

    7
    3.4


# Unit 7, Arraylists:


```Java
public class ArrayandArrayList {
    public static void main(String[] args){
        String[] fishArr = new String[4];
        fishArr[0] = "trout";
        fishArr[2] = "salmon";
        fishArr[1] = "tuna";
        fishArr[1] = "bass"; //overriding index 1

        ArrayList<String> fishArrList = new ArrayList<>();
        fishArrList.add("salmon");
        fishArrList.add("trout");
        fishArrList.add(1, "tuna");
        fishArrList.set(1, "bass"); //overriding index 1
        //fish.ArrayList.remove(1); remove index 1, everything slides down
        String removedFish = fishArrList.remove(1); //setting the removed index equal to a new string; essentially storing the removed variable
        String aFish = fishArrList.get(0); //setting a String at index 0 equal to a variable

        for (int i = 0; i < fishArrList.size(); i++){
            System.out.println(fishArrList.get(i));
        }

        System.out.println(fishArrList);
    }
}

ArrayandArrayList.main(null)
```

    salmon
    trout
    [salmon, trout]



```Java
public class ArrayandArrayList {
    public static void main(String[] args){
        ArrayList<Integer> myNumbers = new ArrayList<>();
        myNumbers.add(4);
        myNumbers.get(0);
    }
}

ArrayandArrayList.main(null)
```

## Traversing an ArrayList:
- Arrays in Java start at 0
- .length will return the number of indexes in an array
- traverse an array with a For Loop or a For-Each Loop


```Java
ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(3, 1, 8));

for (int temp : nums) {
    System.out.print(temp);
}

for (int i = 0; i < nums.size(); i++){
    System.out.println(nums.get(i));
    nums.remove(i);
    i--;
}


System.out.println(nums);

```

    3183
    1
    8
    []



```Java
public class ShoppingList {
    private ArrayList<String> items;

    public ShoppingList(ArrayList<String> newItemList) {
        items = newItemList;
    }

    public ArrayList<String> removeAnItem(String itemToRemove) {
        int count = 0;
        ArrayList<String> removedItems = new ArrayList<String>();
        for (int i = items.size() - 1; i >= 0; i--) {
            if (items.get(i).equals(itemToRemove)) {
                items.remove(i);
                removedItems.add(itemToRemove);
                count++;
            }
        }
        return removedItems;
    }

    public static void main(String[] args){
        ArrayList<String> newList = new ArrayList<>(Arrays.asList("Hello", "Hi"));
        ShoppingList list = new ShoppingList(newList);
        ArrayList<String> removed2Items = list.removeAnItem("Hello");
        System.out.println(removed2Items);

    }
}

ShoppingList.main(null)
```

    [Hello]


# Converting Array to Arraylist:


```Java
public class ArrayToArrayList {
    public static void main(String[] args){
        int[] Array = {3, 6, 1, 7, 3, 1};
        ArrayList<Integer> aNewList = new ArrayList<>();

        for (int temp : Array){
            aNewList.add(temp);
        }
        System.out.println(aNewList);
    }
}

ArrayToArrayList.main(null)

```

    [3, 6, 1, 7, 3, 1]


![image.png](attachment:image.png)
![image-2.png](attachment:image-2.png)


```Java
import java.util.ArrayList;
import java.util.Arrays;

public class Assignment {
    private String name;
    private String course;
    private int daysUntilDue;
    private String description;

    public Assignment(String name, String course, int daysUntilDue, String desc){
        this.name = name;
        this.course = course;
        this.daysUntilDue = daysUntilDue;
        description = desc;
    }

    public String getName(){
        return name;
    }

    public String getCourse(){
        return course;
    }

    public int getDaysUntilDue(){
        return daysUntilDue;
    }

    public String getDescription(){
        return description;
    }
}

public class Agenda {
    private ArrayList<Assignment> assignments;

    public Agenda(){
        assignments = new ArrayList<>();
    }

    public void addToAgenda(Assignment assignment){
        int currentDaysUntilDue = assignment.getDaysUntilDue();
        int indexToInsert = 0;
    
        // Find the correct index to insert the assignment based on daysUntilDue
        for (int i = 0; i < assignments.size(); i++){
            Assignment currentAssignment = assignments.get(i);
            if (currentDaysUntilDue < currentAssignment.getDaysUntilDue()){
                indexToInsert = i;
                break; // Found the correct index, exit the loop
            }
        }
    
        // Insert the assignment at the correct index
        assignments.add(indexToInsert, assignment);
    }
    

    public static void main(String[] args){
        Assignment newAssignment = new Assignment("SampleName1", "APCS", 6, "");

        Agenda newClass = new Agenda();
        newClass.addToAgenda(newAssignment);
    }
}

Agenda.main(null)
```

# Unit 8, 2D Arrays:
- declaring a 2d array:
``` cs
int[][] varName = new int[3][4]
```

- first bracket = rows;
- second bracket = column;
- columns are stored in rows


```Java
int[][] varName = new int[3][4];
int[][] varName2 = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

System.out.println(varName2[0][2]);

//array.length = # of rows
//array[0].length = # of colums

for (int i = 0; i < varName2.length; i++){
    for (int j = 0; j < varName2[i].length; j++){//traverses array from top left to bottom right
        System.out.println(varName2[i][j]);
    }
}

System.out.println("Traversing:");
for (int i = varName2.length - 1; i >= 0; i--){
    for (int j = varName2[i].length - 1; j >= 0; j--){
        System.out.println(varName2[i][j]);
    }
}
```

    3
    1
    2
    3
    4
    5
    6
    7
    8
    9
    Traversing:
    9
    8
    7
    6
    5
    4
    3
    2
    1



```Java
int[][] varName2 = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};


System.out.println("Traversing with enhanced for loop: ");
for (int[] row: varName2){
    for (int val: row) {
        System.out.println(val);
    }
}
```

    Traversing with enhanced for loop: 
    1
    2
    3
    4
    5
    6
    7
    8
    9


![image.png](attachment:image.png)


```Java
public class BattleField {
    private boolean[][] battlefieldGrid;

    public BattleField(boolean[][] battlefieldnew) {
        battlefieldGrid = battlefieldnew;
    }

    public boolean hasMine(int row, int col){
        for (int i = 0; i < battlefieldGrid.length; i++){
            for (int j = 0; j < battlefieldGrid[i].length; j++){
                if (battlefieldGrid[row][col] == true){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canSafetlyCross(int rowToCross){
        for (int i = 0; i < battlefieldGrid.length; i++){
            if (hasMine(rowToCross, i) == true){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        boolean[][] hello = {
            {true, true, false, false, false},
            {false, true, false, false, false},
            {false, false, false, false, false},
            {true, false, false, true, false},
            {true, true, false, false, false}

        };

        BattleField newClass = new BattleField(hello);
        boolean hellonew = newClass.hasMine(3,4);
        boolean helloold = newClass.canSafetlyCross(2);
        System.out.println(hellonew);
        System.out.println(helloold);
    }
}

BattleField.main(null)

```

    false
    true


# Unit 9, Inheritance:
- idea of a class "inheriting" properties from another class

### Ex:
- Vehicle Class
- A car is a type of vehicle
    - more of a "specialized vehicle"
- Bus
    - color could be a unique factor
- Train
    - Steam Engine Train
    - Diesel Engine Train

- you have a basic model that basic features such as engine, or color that all vehicles can inherit
- **Constructors are not inherited!**
    - Remember, constructors must be the name of the class, so if a constructor is "inherited", its class and the constructor name will not be the same!

- they may have special features

Hiearchy is created in this example.

- Superclass will give everytrhing below in the hiearchy is refered to the subclass

### Continued Example:
**Class Vehicle:**
- Name (String)
- make (String)
- model (String)
- Constructor: Vehicle (...)
- Method: moveForward()

**Class Vehicle is the superclass of class Train**

**class Train:**
- Name (String)
- make (String)
- model (String)
- Constructor: Train (...) //we would change this to Train instead of vehicle!
- Method: moveForward()

*new addition:*
- Conductor (String) //doesn't carry to the vehicle class, conductor is a **SUBCLASS** of vehicle class
- moveFoward() method is still called the same thing, but we want to change the code inside it
    - this is called overwriting!
    - Overwriting: Changing the subclass body of a method that is inherited from a superclass

**Class Train is the superclass of class DieselEngineTrain**

**class DieselEngineTrain:**
- Name (String)
- make (String)
- model (String)
- Constructor: DiselEngineTrain: (...) //we would change this to DieselEngineTrain instead of Train!
- Method: moveForward() //inherit the overwritten method!
- Conductor (String)


*new addition:*
- oilLevel (double) //additional field added


```Java
//structure of example above

class Vehicle {
    public String name;
    public String make;
    public String model;

    public Vehicle(...) {
        //implentation not shown
    }
}

class Train extends Vehicle {
    public String conductor;

    public Train(...){
        //implenatation not shown
    }

    public void moveFoward(){
        //do something else
    }
}

class DieselEngineTrain extends Train {
    public double oilLevel;

    public DieselEngineTrain(...){
        //implementation not shown
    }
}

//super(params) --> accesses the superclass's constructor
```


    |       public Vehicle(...) {


    illegal start of type


    


    |       public Vehicle(...) {


    <identifier> expected



![image.png](attachment:image.png)

1. C
2. C
3. A
4. A
5. C
6. D
7. F
8. D
9. H //should be F

8/9


# Unit 10, Recursion:
- The idea of a method running itself inside of itself.



```Java
int n = 5;
public static int product(int n){
    if (n <= 1){
        return 1;
    }
    else {
        return n * product(n-2);
    }
}
//iteration 1: product(int 5) = 5 * product(3) = 15;
//iteration 2: product(int 3) = 3 * product(1) = 3;
//iteration 3: product(int 1) = 1;

System.out.println(product(5));
```

    15



```Java
public static int f(int n){
    if (n == 0){
        return 0;
    }

    else if (n == 1){
        return 1;
    }

    else {
        return f(n-1) + f(n-2);
    }

    //iteration 1: f(5) = f(4) + f(3);
    //iteration 2: f(4) = f(3) + f(2);
    //f(3) = f(2) + f(1) or f(3) = f(2) + 1;
    //f(2) = f(1) + f(0);
    //f(2) = 1 + 0 = 1;


    //reversing back...
    //f(3) = 1 + 1 = 2;
    //f(4) = 2 + 1 = 3;
    //f(5) = 3 + 2 = 5;
}

System.out.println(f(5));
```

    5

