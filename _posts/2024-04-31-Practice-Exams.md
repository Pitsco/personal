---
title: Practice FRQ Exams!
description: Number 1 of 2019 CSA practice frq exam
layout: post
courses: {'csa': {'week': 25}}
categories: ['C4.0']
type: tangibles
comments: True
---

# 2019 #1 Practice AP Exam:


```java
public static boolean isLeapYear(int year){
    if (year % 4 == 0){
        return true;
    }
    return false;
}

public static int numberOfLeapYears(int year1, int year2){
    int totalYears = year2 - year1;
    int numberOfLeapYear = 0;
    for (int i = 0; i < totalYears; i++){
        if (isLeapYear(i) == true){
        numberOfLeapYear++;
        }
    }
    return numberOfLeapYear;
}

System.out.println(numberOfLeapYears(2000, 2050))
```

    13



```java
public static int dayOfWeek(int month, int day, int year){
    int dayOfTheWeek = 0;
    int firstDayOfTheYear = firstDayOfYear(year);
    int dayOfTheYear = dayOfYear(month, day, year);

    int setDate = (firstDayOfTheYear + dayOfTheYear - 1) % 7;

    return setDate;
}
```

# 2019 FRQ #3:


```java
String openDel = "<q>";
String closeDel = "</q>";

public ArrayList<String> getDelimitersList(String[] tokens){
    ArrayList<String> delimeters = new ArrayList<>();
    for (int i = 0; i < tokens.length; i++){
        if (tokens[i] == openDel || tokens[i] == closeDel){
        delimeters.add(tokens[i]);
        }
    }
    return delimeters;
}

String[] hello = new String[]{"<q>", "yy", "</q>", "zz", "</q>"};
System.out.println(getDelimitersList(hello));
```

    [<q>, </q>, </q>]



```java
String openDel = "<sup>";
String closeDel = "</sup>";

public boolean isBalanced(ArrayList<String> delimiters){
    int numOpenDel = 0;
    int numCloseDel = 0;
    for (int i = 0; i < delimiters.size(); i++){
        if (delimiters.get(i) == openDel){
            numOpenDel++;
        }
        else if (delimiters.get(i) == closeDel) {
            numCloseDel++;
        }
    }

    if (numCloseDel == numOpenDel){
        return true;
    }
    return false;
}

ArrayList<String> hello = new ArrayList<>(Arrays.asList("<sup>", "</sup>", "</sup>", "<sup>, </sup>"));
System.out.println(isBalanced(hello));
```

    false


# 2018 #3 Practice FRQ


```java
public ArrayList<String> WordPairList(String[] words) {
    ArrayList<String> allPairs = new ArrayList<String>();
        for (int i = 0; i < words.length - 1; i++){
            for (int j = i + 1; j < words.length; j++){
                WordPair newPair = new WordPair(words[i], words[j]);
                allPairs.add(newPair);
            }
        }
        return allPairs;
    }
```


```java
public int numMatches(){
    int matches = 0;
    for (int i = 0; i < allPairs.size(); i++){
        WordPair pair = allPairs.get(i);
        if (pairs.getFirst().equals(pairs.getSecond())){
            matches++;
        }
    }
    return matches;
}
```

# 2018 #1 Practice FRQ


```java
public boolean stimulate(){
    boolean success = false;
    int total = 0;
    int position = 0;
    for (int i = 0; i <= maxHops; i++){
        position += hopDistance();
        if (position > goalDistance){
            success = true;
        }
        if (total < 0){
            return sucess;
        }
        if (i = maxHops){
            return success;
        }
    }
    return success;
}
```


```java
public double runStimulations(int num){
    double simulationUntilTrue = 0.0;
    if (stimulate() == true){
        position += num;
    }

    return stimulateUntilTrue;
}
```

# 2023 AP CSA Exam:


```java
public int findFreeBlock(int period, int duration){
    boolean isAvailible = false;
    if (isMinuteFree(period, duration) == true){
        return startMinute;
    }
    return -1;
}

//score 3/5
```


```java
String[][] letters = {
    {"A", "B", "C", "D"},
    {"E", "F", "G", "H"},
    {"I", "J", "K", "L"}
};

for (int col = 1; col < letters[0].length; col++) {
    for (int row = 1; row < letters.length; row++) {
        System.out.print(letters[row][col] + " ");
    }
    System.out.println();
}

```

    F J 
    G K 
    H L 



```java
public class Example {
    // A void method that prints a message
    public static void printMessage() {
        System.out.println("This is a void method.");
    }

    public static void main(String[] args) {
        // Calling the void method
        printMessage();
    }
}
Example.main(null)

```

    This is a void method.



```java
class A {
    public String message(int i) {
        return "A" + i;
    }
}

class B extends A {
    public String message(int i) {
        return "B" + i;
    }
}

public class Main {
    public static void main(String[] args) {
        // With message method in class A
        System.out.println("With message method in class A:");
        A obj1 = new B(); // Line 1
        B obj2 = new B(); // Line 2
        System.out.println(obj1.message(3));   // Line 3
        System.out.println(obj2.message(2));   // Line 4

        // Without message method in class A
        System.out.println("\nWithout message method in class A:");
        AWithoutMessage obj3 = new BWithoutMessage(); // Line 1
        BWithoutMessage obj4 = new BWithoutMessage(); // Line 2
        System.out.println(obj3.message(3));   // Line 3
        System.out.println(obj4.message(2));   // Line 4
    }
}

// Class definitions without message method in class A
class AWithoutMessage {}
class BWithoutMessage extends AWithoutMessage {
    public String message(int i) {
        return "B" + i;
    }

}

Main.main(null)

```


    |   

    |   

    |   public class Main {

    |       public static void main(String[] args) {

    |           // With message method in class A

    |           System.out.println("With message method in class A:");

    |           A obj1 = new B(); // Line 1

    |           B obj2 = new B(); // Line 2

    |           System.out.println(obj1.message(3));   // Line 3

    |           System.out.println(obj2.message(2));   // Line 4

    |   

    |           // Without message method in class A

    |           System.out.println("\nWithout message method in class A:");

    |           AWithoutMessage obj3 = new BWithoutMessage(); // Line 1

    |           BWithoutMessage obj4 = new BWithoutMessage(); // Line 2

    |           System.out.println(obj3.message(3));   // Line 3

    |           System.out.println(obj4.message(2));   // Line 4

    |       }

    |   }

    Unresolved dependencies:

       - method message(int)



```java
public static String[] strArrMethod(String[] arr)

{

String[] result = new String[arr.length];

for (int j = 0; j < arr.length; j++)

{

String sm = arr[j];

for (int k = j + 1; k < arr.length; k++)

{

if (arr[k].length() < sm.length())

{

sm = arr[k]; // Line 12

}

}

result[j] = sm;

}

return result;

}

String[] testOne = {"first", "day", "of", "spring"};

String[] resultOne = strArrMethod(testOne);
for (int i = 0; i < resultOne.length; i++){
    System.out.println(resultOne[i]);
}
System.out.println(resultOne);
```

    of
    of
    of
    spring
    [Ljava.lang.String;@571c126d



```java

for (int i = 0; i < 6; i++)
{
   System.out.print("A");
}

for (int j = 1; j <= 3; j++)
{
   for (int k = 1; k < 2; k++)
   {
      System.out.print("B");
   }
}
```

    AAAAAABBB

# 2017 AP CSA FRQ #1


```java
import java.util.ArrayList;

public class Digits {
    private ArrayList<Integer> digitList;

    public Digits(int num) {
        digitList = new ArrayList<>();
        while (num > 0) {
            int digit = num % 10; // Extract the last digit
            digitList.add(0, digit); // Add the digit to the beginning of digitList
            num /= 10;
            System.out.println(num);
        }
    }

    public boolean isStrictlyIncreasing() {
        boolean isIncreasing = true;
        for (int i = 0; i < digitList.size() - 1; i++) {
            if (digitList.get(i) >= digitList.get(i + 1)) {
                isIncreasing = false;
                break; // Once we find a non-increasing pair, we can stop checking
            }
        }
        return isIncreasing;
    }

    public static void main(String[] args) {
        Digits newInstance = new Digits(12345);
        System.out.println(newInstance.digitList);
        System.out.println(newInstance.isStrictlyIncreasing());
    }
}


Digits.main(null)
```

    1234
    123
    12
    1
    0
    [1, 2, 3, 4, 5]
    true


# 2022 FRQ #1


```java
public int getScore(){
    int totalScore = 0;
    if (levelOne.goalReached() == true){
        totalScore += getPoints();

        if (levelTwo.goalReached() == true){
            totalScore += getPoints();
        }
        if (levelThree.goalReached() == true){
            totalScore += getPoints();
        }
    }

    if(isBonus() == true){
        totalScore *= 3;
    }

    return totalScore;
}
```


```java
/* public int playManyTimes(int num){
    int highestScore = 0;
    for (int i = 0; i < num; i++){
        if (i > highestScore){
            highestScore = play().getScore(); // can't chain method, especially if there is a void type
        }
    }
}
*/

public int playManyTimes(int num){
    int highestScore = 0;
    for (int i = 0; i < num; i++){
        play();
        int tempScore = getScore();
        if (tempScore > highestScore){
            highestScore = tempScore; // can't chain method
        }
    }
}
```


    |               highestScore = play().getScore(); // can't chain method

    cannot find symbol

      symbol:   method play()

    

    |   public int playManyTimes(int num){

    |       int highestScore = 0;

    |       for (int i = 0; i < num; i++){

    |           if (i > highestScore){

    |               highestScore = play().getScore(); // can't chain method

    |           }

    |       }

    |   }

    missing return statement

    


# 2022 FRQ #2:


```java
public class Book {
    /** The title of the book */
    private String title;

    /** The price of the book */
    private double price;

    /** Creates a new Book with given title and price */
    public Book(String bookTitle, double bookPrice) {
        this.title = bookTitle;
        this.price = bookPrice;
    }

    /** Returns the title of the book */
    public String getTitle() {
        return title;
    }

    /** Returns the price of the book */
    public double getPrice() {
        return price;
    }

    /** Returns a string containing the title and price of the Book */
    public String getBookInfo() {
        return title + "-" + price;
    }

}


public class Textbook extends Book {
    private int edition;

    public Textbook(String bookTitle, double bookPrice, int edition){
        super(bookTitle, bookPrice);
        this.edition = edition;
    }

    public boolean canSubstituteFor(Textbook other){
        boolean canSubstitute = false;
        if (other.getTitle().equals(getTitle()) && other.edition > edition){
            canSubstitute = true;
        }

        return canSubstitute;
    }

    public String getBookInfo() {
        return getTitle() + "-" + getPrice() + "-" + edition;
    }
}

public class main{
    public static void main(String[] args){
        Textbook bio2015 = new Textbook("Biology", 49.75, 3);
        Textbook bio2017 = new Textbook("Biology", 20.2, 3);
        Textbook bio2019 = new Textbook("Biology", 49.75, 4);
        Textbook math2019 = new Textbook("Math", 49.75, 4);
        System.out.println(bio2015.getBookInfo());
        System.out.println(bio2015.canSubstituteFor(bio2017));
        System.out.println(bio2015.canSubstituteFor(bio2019));
        System.out.println(bio2015.canSubstituteFor(math2019));

    }
}

main.main(null)
```

    Biology-49.75-3
    false
    true
    false


# 2022 Question 3


```java
import java.util.ArrayList;

public class Review { 
    private int rating; 
    private String comment;

    public Review(int r, String c) { 
        rating = r; 
        comment = c; 
    } 

    public int getRating() { 
        return rating; 
    } 

    public String getComment() {
        return comment; 
    } 
}

public class ReviewAnalysis {
    private Review[] allReviews;

    public ReviewAnalysis(Review[] reviews) {
        allReviews = reviews;
    }

    public double getAverageRating() { //part b
        double totalRating = 0;
        for (int i = 0; i < allReviews.length; i++) {
            totalRating += allReviews[i].getRating();
        }
        return totalRating / allReviews.length;
    }

    public ArrayList<String> collectComments() { //part b
        ArrayList<String> allComments = new ArrayList<>();
    
        for (int i = 0; i < allReviews.length; i++) {
            if (allReviews[i].getComment().contains("!")) {
                allComments.add(allReviews[i].getComment());
            }
        }
    
        for (int j = 0; j < allComments.size(); j++) {
            String comment = allComments.get(j);
            if (!comment.endsWith("!") && !comment.endsWith(".")) {
                comment += ".";
                allComments.set(j, comment);
            }
        }
    
        return allComments;
    }
}

public class Main {
    public static void main(String[] args) {
        Review[] reviews = {
            new Review(4, "Good! Thx"),
            new Review(3, "OK Site"),
            new Review(5, "Great!"),
            new Review(2, "Poor! Bad."),
            new Review(3, "")
        };

        ReviewAnalysis analysis = new ReviewAnalysis(reviews);
        System.out.println("Average Rating: " + analysis.getAverageRating());
        System.out.println("Average Rating: " + analysis.collectComments());
    }
}

Main.main(null);
```

    Average Rating: 3.4
    Average Rating: [Good! Thx., Great!, Poor! Bad.]


# 2022 Question 4


```java
public class Data {
    public static final int MAX = 100;
    private int[][] grid;

    public void repopulate(){
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                grid[i][j] = (int)(Math.random()* MAX);
                while (grid[i][j] % 10 != 0){
                    grid[i][j] = (int)(Math.random()* MAX);
                    if (grid[i][j] % 10 == 0){
                        grid[i][j] = grid[i][j];
                    }
                }
            }
        }
    }
    
    public int countIncreasingcols(){
    int counter = 0;
    boolean ifIncreasing = true;
    for (int i = 0; i < grid.length; i++) { // Iterate over rows
        
        for (int j = 0; j < grid[i].length - 1; j++) {
            if (grid[i][j] >= grid[i][j + 1]) { // Check if current element is not less than the next element in the row
                ifIncreasing = false;
                break;
            }
        }
        }
        if (ifIncreasing){
            counter++;
    }
    return counter;
}

    
    public void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] grid = {
            {1, 2, 3, 4},
            {2, 2, 3, 4},
            {3, 2, 4, 2}
        };
        Data newInstance = new Data();
        newInstance.grid = grid;
        newInstance.repopulate();
        
        // Print the populated grid
        newInstance.printGrid();
        System.out.println(newInstance.countIncreasingcols());
    }
}

Data.main(null)

```

    50 60 90 20 
    10 10 10 80 
    30 0 0 70 
    0


# 2021 AP FRQ


```java
public class WordMatch {
    private String secret;

    public WordMatch(String word) {
        secret = word;
    }

    public int scoreGuess(String guess) {
        int counter = 0;
        int guessLength = guess.length();
        for (int i = 0; i < secret.length() - guess.length(); i++) {
            if (secret.substring(i, i+ guess.length()).equals(guess)) {
                counter++;
            }
        }

        counter *= Math.pow(guess.length(), 2);

        return counter;
    }
    
    public static void main(String[] args) {
        WordMatch newGuess = new WordMatch("mississippi");
        System.out.println(newGuess.scoreGuess("iss"));
    }
}


WordMatch.main(null)

```

    18



```java
int a = 11;
double b = 4.3;

System.out.println(b/a);
```

    0.3909090909090909

