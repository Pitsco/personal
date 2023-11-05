---

---

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
![img](https://media.discordapp.net/attachments/934591169885790290/1170860460162162708/image.png?ex=655a93c7&is=65481ec7&hm=7934782e8a195977e0bcf974f82aaa54a58b6767c1faa6de8be774a69b3dd96a&=&width=686&height=425)

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


## 2D Arrays

