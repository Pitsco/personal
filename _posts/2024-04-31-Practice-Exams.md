---
title: Unit 8 Study
description: Review the Generic Concepts of Unit 8 of AP CSA Exam
layout: post
courses: {'csa': {'week': 25}}
categories: ['C4.0']
type: tangibles
comments: True
---

# 2D Arrays:
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

