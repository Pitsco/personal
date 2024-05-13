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


### Example for Practice:

!(A > B || B != A)

(A <= B && B == A)

### Another Example:

!(A == B || (B >= C || B < A))

(A != B && !(B >=C || B < A))

(A != B && (B < C && B >= A))

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



