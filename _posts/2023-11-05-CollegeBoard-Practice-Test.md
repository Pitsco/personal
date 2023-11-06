---
title: College Board Questions
description: College Board Questions that I missed/need to be reviewed on
layout: post
courses: {'csa': {'week': 11}}
categories: ['C4.0']
type: hacks
---

# Overall Score:
![img](https://media.discordapp.net/attachments/818210913923629066/1170928637512519780/image.png?ex=655ad345&is=65485e45&hm=7e0a42d538b7a00a29401efdc0099d56e9b2cb5bb37a440178ac5889ab726a9a&=&width=900&height=123)

# Questions I missed: 

### Question 5:
![img](https://media.discordapp.net/attachments/934591169885790290/1170856140238753853/image.png?ex=655a8fc1&is=65481ac1&hm=6f24b89449db94002413cc0d7a4b92d31f41d4d4ce1a0494d7b4eab1c0f20037&=&width=733&height=425)

Very dumb error. Did not account that index 0 was not included.

### Question 21:
![img](https://media.discordapp.net/attachments/934591169885790290/1170850914521841775/image.png?ex=655a8ae3&is=654815e3&hm=5263c03cda4ac28ca0471140647ec90d9673f71f7b91d22c18b379bcc4d68f74&=&width=608&height=425)

Image that helped me understand 2D arrays more:

![img](https://media.discordapp.net/attachments/888137565021016144/1170852107163803698/IMG_4923.jpg?ex=655a8bff&is=654816ff&hm=504f466060b2442c130e98e27bfa40c0866e3c5787f01559f70411a317bc581a&=&width=757&height=425)

To be honest, I initially guessed on this problem because I did not remember how 2D arrays worked. I worked out an image and I understood that in this problem, it is checking each row and each element within the row for the smallest difference.



### Question 23: 
![img](https://media.discordapp.net/attachments/934591169885790290/1170917442277621770/image.png?ex=655ac8d8&is=654853d8&hm=7f7d301b398661a0f03dd6701a084fcf70cc0414233d8082ba582bc763a397c5&=&width=675&height=425)

Collegeboard's Notes:
List is an interface, which an ArrayList implements.

 The manipulate method contains a for loop with a loop control variable k that starts at the right most index of animals, decrements by 1 each time, until k is equal to 0. In the first iteration, when k is 5, if the element of animals at 5 (“baboon”) starts with a “b”, which it does, then this value is removed from the list and inserted at index 1. The list would then be {“bear”, “baboon”, “zebra”, “bass”, “cat”, “koala”}. 
 
 In the second iteration, when k is 4, the element of animals at 4 (“cat”) does not start with a “b” and no changes are made to the list. 
 
 In the third iteration, when k is 3, the element of animals at 3 (“bass”) starts with a “b”. This value is removed from the list and inserted at index 3. Since it was already at index 3, the list would not change. 
 
 In the fourth iteration, when k is 2, the element of animals at 2 (“zebra”) does not start with a “b” and no changes are made to the list.  
 
 In the fifth iteration, when k is 1, the element of animals at 1 (“baboon”) starts with a “b”. It is removed from the list and inserted at index 5. 
 
The list would then be {“bear”, “zebra”, “bass”, “cat”, “koala”, “baboon”}.  Finally, k decrements to 0 which is not greater than 0 so the loop terminates.

### Overall:
Overall, I found this question very tough because I didn't really understand it that well when I first looked at it.


### Question 24:
![img](https://media.discordapp.net/attachments/818210913923629066/1170924687065358356/image.png?ex=655acf98&is=65485a98&hm=2b8d56fd7da7d249821b86b263b046ae6bcca02f58470b31d4f8e6e01b2804e7&=&width=699&height=425)

This question is actually very basic. It is asking for the position (Index) value at column 0 and row 2, which would be the value of 7. After reviweing question 21, I understand more of 2D arrays, which helped me easily solve this problem.

### Question 26:
![img](https://media.discordapp.net/attachments/818210913923629066/1170926537806200982/image.png?ex=655ad151&is=65485c51&hm=ac6139847bdb0a45e657daefeff1d3c478f185d5ba7a149166d35d4c0bff653e&=&width=900&height=362)

In enhanced for loops, I have to make sure that I understand "int x" represents the value, not the index value (compared to int x = 1 in a regular for loop). Therefore, I chose arr[x] because I thought it represented the value of that specific "x" index. 

### Question 29:

![img](https://media.discordapp.net/attachments/888137565021016144/1170854333257109715/image.png?ex=655a8e12&is=65481912&hm=f0cf285254b2b400d82dbded96a993855edda73fbb8c30b91cbcc68ba71470aa&=&width=864&height=425)

This was a very dumb mistake. I did not account that the for loop will print out every value instead of JUST the values that are divisible by 4 and leave no reminder. E perfectly makes sense because it starts at index 4, which should be the first value divisible by 4, and then moves by factors of 4 from then on.

### Question 33:
![img](https://media.discordapp.net/attachments/934591169885790290/1170855217873563678/image.png?ex=655a8ee5&is=654819e5&hm=865f389018e303a6befcc1b46938bb495903ed9a6b4e558406c2d3e4b02215e4&=&width=757&height=425)

I did not account for the "||" mark and looked at it as a "&&". Since k < 4 would always be true (as the value k is never being affected), the while loop will always be true and it will run indefinently. 

### Question 40:
![img](https://media.discordapp.net/attachments/934591169885790290/1170856857066295446/image.png?ex=655a906c&is=65481b6c&hm=d584ab4d7605913ec39b3b4d220c4a87fbd8ae172ca106c5b2d5599d5938983f&=&width=618&height=425)

In this question, I did not realize that the function kept calling itself until it reached the letter "W". Then, it starts printing out all the recursive values until it reaches back to "WATC". I thought it did the opposite as each time it is done removing a letter, it prints out that specific string

# Questions that required help

## Question 14

![image](https://media.discordapp.net/attachments/1146844775815843851/1170811679890751599/image.png?ex=655a6659&is=6547f159&hm=0f19b66877db090758ebe772570af170e40fccb1aef57244e1be7b9b0ab90d6c&=&width=472&height=425)

Interface class. Interface class has a get method getMileage that has no implementation in it but is called for each vehicle because there maybe different types of vehicles in the array. 

Answer: E. v.getMileage()

Each element in the array (v), regardless of the Vehicle type, is called and then the double value (mileage) is the recieved with the get method. It will eventually add up all the sums of the vehicles in the array.


### Question 39

![img](https://media.discordapp.net/attachments/818210913923629066/1170922023355174972/image.png?ex=655acd1d&is=6548581d&hm=d2f722bcc3106150ca00f697672559714551c6e45ad1ad9b61c2a59808f984b5&=&width=900&height=416)

When I first did this problem, I got 18 as the answer because I did not check the recursion twice. I reevaluated my work and realized that rigth after.

## Overall feedback from first CollegeBoard MC:

### Goods:
- Good understanding of majority of units
    - Constructors, methods
        - getters and setters
    - Iteration
    - Public vs Private Class

### Needs Improvement:
- Need to read questions more carefully
    - Worried about pacing at first
        - Will gradually get better after more practice
- Integerate what I've learned in lessons into code (OOP!)

- Units:
    - U7 with 2D arrays
        - Understand more about 2D arrays: functionality and implementation
    - U10 with recursion
        - Understand how the function calls itself
        - Question 39 is a great example


