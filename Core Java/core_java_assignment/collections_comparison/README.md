### Collections

#### 1. Basic Collections

Program - [./BasicCollections.java](./BasicCollections.java)

Output -

```
ArrayList:
[{Isaac J. McDonald, 76, Male}, {Carolyn D. Cannon, 44, Female}]

LinkedList
[{Nicholas S. Brennan, 55, Male}, {Eugene C. Guerin, 36, Male}, {Isaac J. McDonald, 76, Male}, {Carolyn D. Cannon, 44, Female}, {Betty M. Obrien, 40, Female}]

Vector:
[{Nicholas S. Brennan, 55, Male}, {Eugene C. Guerin, 36, Male}, {Betty M. Obrien, 40, Female}]

Stack:
[{Betty M. Obrien, 40, Female}, {Nicholas S. Brennan, 55, Male}, {Carolyn D. Cannon, 44, Female}]

HashSet:
[{Eugene C. Guerin, 36, Male}, {Betty M. Obrien, 40, Female}, {Isaac J. McDonald, 76, Male}, {Nicholas S. Brennan, 55, Male}, {Carolyn D. Cannon, 44, Female}]

LinkedHashSet:
[{Isaac J. McDonald, 76, Male}, {Betty M. Obrien, 40, Female}, {Carolyn D. Cannon, 44, Female}, {Eugene C. Guerin, 36, Male}, {Nicholas S. Brennan, 55, Male}]

TreeSet:
[{Shawn N. Sparks, Mountainview School, 13, 105}, {David A. Booher, Westside School, 11, 104}, {Velma W. Lope, Waterfalls Middle School, 9, 101}, {Stephen D. Salvato, Summers Institute, 8, 103}, {Diana R. Schimmel, Bear River Elementary, 5, 102}]

HashMap:

Roll No: 101, Value: {Velma W. Lope, Waterfalls Middle School, 9, 101}
Roll No: 102, Value: {Diana R. Schimmel, Bear River Elementary, 5, 102}
Roll No: 103, Value: {Stephen D. Salvato, Summers Institute, 8, 103}
Roll No: 104, Value: {David A. Booher, Westside School, 11, 104}
Roll No: 105, Value: {Shawn N. Sparks, Mountainview School, 13, 105}

TreeMap:

Roll No: 101, Value: {Velma W. Lope, Waterfalls Middle School, 9, 101}
Roll No: 102, Value: {Diana R. Schimmel, Bear River Elementary, 5, 102}
Roll No: 103, Value: {Stephen D. Salvato, Summers Institute, 8, 103}
Roll No: 104, Value: {David A. Booher, Westside School, 11, 104}
Roll No: 105, Value: {Shawn N. Sparks, Mountainview School, 13, 105}

LinkedHashMap:

Roll No: 103, Value: {Stephen D. Salvato, Summers Institute, 8, 103}
Roll No: 101, Value: {Velma W. Lope, Waterfalls Middle School, 9, 101}
Roll No: 104, Value: {David A. Booher, Westside School, 11, 104}
Roll No: 105, Value: {Shawn N. Sparks, Mountainview School, 13, 105}
Roll No: 102, Value: {Diana R. Schimmel, Bear River Elementary, 5, 102}
```

#### 2. Sorting Collection using Comparable and Comparator 

Program - [./SortCollections.java](./SortCollections.java)

Output -

```
Original Student List:
[{Stephen D. Salvato, Summers Institute, 8, 84.99017}, {Diana R. Schimmel, Bear River Elementary, 5, 90.58251}, {Velma W. Lope, Waterfalls Middle School, 9, 94.94352}, {Shawn N. Sparks, Mountainview School, 13, 90.02305}, {David A. Booher, Westside School, 11, 83.91052}]

Student List sorted based on age:
[{Shawn N. Sparks, Mountainview School, 13, 90.02305}, {David A. Booher, Westside School, 11, 83.91052}, {Velma W. Lope, Waterfalls Middle School, 9, 94.94352}, {Stephen D. Salvato, Summers Institute, 8, 84.99017}, {Diana R. Schimmel, Bear River Elementary, 5, 90.58251}]

Student List sorted based on marks:
[{David A. Booher, Westside School, 11, 83.91052}, {Stephen D. Salvato, Summers Institute, 8, 84.99017}, {Shawn N. Sparks, Mountainview School, 13, 90.02305}, {Diana R. Schimmel, Bear River Elementary, 5, 90.58251}, {Velma W. Lope, Waterfalls Middle School, 9, 94.94352}]

Original Employee List:
[{Stephen D. Salvato, Summers Institute, 44473.664}, {Diana R. Schimmel, Bear River Elementary, 55273.617}, {Velma W. Lope, Waterfalls Middle School, 55988.785}, {Shawn N. Sparks, Mountainview School, 50867.11}, {David A. Booher, Westside School, 75623.125}]

Employee List sorted based on age:
[{Diana R. Schimmel, Bear River Elementary, 55273.617}, {Stephen D. Salvato, Summers Institute, 44473.664}, {Velma W. Lope, Waterfalls Middle School, 55988.785}, {David A. Booher, Westside School, 75623.125}, {Shawn N. Sparks, Mountainview School, 50867.11}]

Employee List sorted based on salary:
[{Stephen D. Salvato, Summers Institute, 44473.664}, {Shawn N. Sparks, Mountainview School, 50867.11}, {Diana R. Schimmel, Bear River Elementary, 55273.617}, {Velma W. Lope, Waterfalls Middle School, 55988.785}, {David A. Booher, Westside School, 75623.125}]
```