### Basics of Java 

#### 1. Concept of Class, Objects, State and Methods

Program - [./Persons.java](./Person.java)

Output - 

```
A Person Class which stores a person's name, age, gender, dob, phone number, email and nationality

Default Person Object: {Person, 21, Male}

Enter name of the person: Rohit
Enter date of birth of Rohit separated by '-' in D-M-Y format: 28-12-2000
Enter gender of Rohit: Male
Enter phone number of Rohit: 9876543210
Enter email of Rohit: rohit@email.com
Enter nationality of Rohit: Indian

Custom Input Person Object: {Rohit, 23, Male}

Rohit
23
Male
2000-12-28
9876543210
rohit@email.com
Indian
```

#### 2. Basic Datatypes

Program - [./DataTypes.java](./DataTypes.java)

Output - 

```
Byte Value: 127
Short Value: 32767
Int Value: 2147483647
Long Value: 9223372036854775807
Float Value: 32.767
Double Value: 327.67
Bool Value: true
Char Value: A
```

#### 3. Variable Types 

Program - [./VariablesTypes.java](./VariablesTypes.java)

Output - 

```
Operation + result: 25.0
```

#### 4. Modifier Types

Program - [./AccessModifiers.java](./AccessModifiers.java)

Output - 

* Accessing private variable

```
Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
	The field DifferentAccessModifiers.privateVariable is not visible
	The field DifferentAccessModifiers.privateVariable is not visible

	at basics_of_java.AccessModifiers.main(AccessModifiers.java:40)
```

* Accesing other modifier variables

```
Private Variable Value from getter method: 10
Accessing private variable outside class:
Accessing public static operation variable from package basicsOfJava.Operations: /
Accessing protected result variable from package basicsOfJava.Operations: 5
Accessing default access modifier name variable from package basicsOfJava.Person: Person
```

#### 5. Final Keyword

Program - [./FinalKeyword.java](./FinalKeyword.java)

Output - 

* Accessing Final Variable

```
Final variable declared and initialized: 10
```

* Changing Final Variable

```
Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	The final local variable finalVariable cannot be assigned. It must be blank and not using a compound assignment

	at basics_of_java.FinalKeyword.main(FinalKeyword.java:44)
```

* Overriding Final Method

```
Exception in thread "main" java.lang.IncompatibleClassChangeError: class basics_of_java.SubClass2 overrides final method basics_of_java.FinalMethodClass.finalMethod()V
	at java.base/java.lang.ClassLoader.defineClass1(Native Method)
	at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:1027)
	at java.base/java.security.SecureClassLoader.defineClass(SecureClassLoader.java:150)
	at java.base/jdk.internal.loader.BuiltinClassLoader.defineClass(BuiltinClassLoader.java:862)
	at java.base/jdk.internal.loader.BuiltinClassLoader.findClassOnClassPathOrNull(BuiltinClassLoader.java:760)
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClassOrNull(BuiltinClassLoader.java:681)
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:639)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526)
	at basics_of_java.FinalKeyword.main(FinalKeyword.java:46)
```

* Inheriting Final Class

```
Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	The type SubClass cannot subclass the final class FinalClass

	at basics_of_java.SubClass.<init>(FinalKeyword.java:15)
	at basics_of_java.FinalKeyword.main(FinalKeyword.java:46)
```

#### 6. Loop Control and Decision Control Statements 

Program - [./LoopsAndDecisionMaking.java](./LoopsAndDecisionMaking.java)

Output - 

```
Star pattern with 3 lines:
   *   
  ***  
 ***** 


Star pattern with 4 lines:
    *    
   ***   
  *****  
 ******* 


Star pattern with 5 lines:
     *     
    ***    
   *****   
  *******  
 ********* 

5 * 1 = 5
5 * 2 = 10
5 * 3 = 15
5 * 4 = 20
5 * 5 = 25
5 * 6 = 30
5 * 7 = 35
5 * 8 = 40
5 * 9 = 45
5 * 10 = 50

10 is greater than 5

10 is greater than 5

15 is the greatest.

15 is the greatest.

Random number generated is 2
```

#### 7. Strings and Arrays

Program - [./StringsAndArrays.java](./StringsAndArrays.java)

Output - 

```
A String Variable
0 1 4 9 16 
0 1 2 3 4 
0 1 4 9 16 
```
