### XML File Operations

#### 1. XML Read SAXParser

Program - [XMLRead.java](./src/main/java/xml_io/XMLRead.java)

Output - from [read.xml](./xml/read.xml)

```
Start Element :class
Start Element :student
Start Element :birthdate
End Element:birthdate
Start Element :gender
End Element:gender
Start Element :school
End Element:school
Start Element :marks
Marks : 86.10358
End Element:marks
End Element:student
Start Element :student
Start Element :birthdate
End Element:birthdate
Start Element :gender
End Element:gender
Start Element :school
End Element:school
Start Element :marks
Marks : 74.26056
End Element:marks
End Element:student
Start Element :student
Start Element :birthdate
End Element:birthdate
Start Element :gender
End Element:gender
Start Element :school
End Element:school
Start Element :marks
Marks : 85.69205
End Element:marks
End Element:student
Start Element :student
Start Element :birthdate
End Element:birthdate
Start Element :gender
End Element:gender
Start Element :school
End Element:school
Start Element :marks
Marks : 92.922195
End Element:marks
End Element:student
Start Element :student
Start Element :birthdate
End Element:birthdate
Start Element :gender
End Element:gender
Start Element :school
End Element:school
Start Element :marks
Marks : 58.017418
End Element:marks
End Element:student
End Element:class
```

#### 2. XML Read DOMParser

Program - [XMLReaderDOM.java](./src/main/java/xml_io/XMLReaderDOM.java)

Output - from [read.xml](./xml/read.xml)

```
Root element: class

Node Name: <class>
Node Content: 
    
        2015-11-13
        Male
        Summers Institute
        82.431595
    
    
        2018-12-16
        Female
        Bear River Elementary
        64.232254
    
    
        2014-01-14
        Female
        Waterfalls Middle School
        48.76246
    
    
        2010-02-25
        Male
        Mountainview School
        48.534008
    
    
        2012-11-09
        Male
        Westside School
        95.129105
    


Node Name: <student>
Node Content: 
        2015-11-13
        Male
        Summers Institute
        82.431595
    
Attribute name: rollno
Attribute value: 100

Node Name: <birthdate>
Node Content: 2015-11-13
Node Name: </birthdate>

Node Name: <gender>
Node Content: Male
Node Name: </gender>

Node Name: <school>
Node Content: Summers Institute
Node Name: </school>

Node Name: <marks>
Node Content: 82.431595
Node Name: </marks>
Node Name: </student>

Node Name: <student>
Node Content: 
        2018-12-16
        Female
        Bear River Elementary
        64.232254
    
Attribute name: rollno
Attribute value: 101

Node Name: <birthdate>
Node Content: 2018-12-16
Node Name: </birthdate>

Node Name: <gender>
Node Content: Female
Node Name: </gender>

Node Name: <school>
Node Content: Bear River Elementary
Node Name: </school>

Node Name: <marks>
Node Content: 64.232254
Node Name: </marks>
Node Name: </student>

Node Name: <student>
Node Content: 
        2014-01-14
        Female
        Waterfalls Middle School
        48.76246
    
Attribute name: rollno
Attribute value: 102

Node Name: <birthdate>
Node Content: 2014-01-14
Node Name: </birthdate>

Node Name: <gender>
Node Content: Female
Node Name: </gender>

Node Name: <school>
Node Content: Waterfalls Middle School
Node Name: </school>

Node Name: <marks>
Node Content: 48.76246
Node Name: </marks>
Node Name: </student>

Node Name: <student>
Node Content: 
        2010-02-25
        Male
        Mountainview School
        48.534008
    
Attribute name: rollno
Attribute value: 103

Node Name: <birthdate>
Node Content: 2010-02-25
Node Name: </birthdate>

Node Name: <gender>
Node Content: Male
Node Name: </gender>

Node Name: <school>
Node Content: Mountainview School
Node Name: </school>

Node Name: <marks>
Node Content: 48.534008
Node Name: </marks>
Node Name: </student>

Node Name: <student>
Node Content: 
        2012-11-09
        Male
        Westside School
        95.129105
    
Attribute name: rollno
Attribute value: 104

Node Name: <birthdate>
Node Content: 2012-11-09
Node Name: </birthdate>

Node Name: <gender>
Node Content: Male
Node Name: </gender>

Node Name: <school>
Node Content: Westside School
Node Name: </school>

Node Name: <marks>
Node Content: 95.129105
Node Name: </marks>
Node Name: </student>
Node Name: </class>
```

### 3. Write XML DOMParser

Program - [XMLWriterDOM.java](./src/main/java/xml_io/XMLWriterDOM.java)

Output - from [write.xml](./xml/write.xml)

```
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<class>
    <student rollno="100">
        <birthdate>2015-11-13</birthdate>
        <gender>Male</gender>
        <school>Summers Institute</school>
        <marks>94.621506</marks>
    </student>
    <student rollno="101">
        <birthdate>2018-12-16</birthdate>
        <gender>Female</gender>
        <school>Bear River Elementary</school>
        <marks>81.75483</marks>
    </student>
    <student rollno="102">
        <birthdate>2014-01-14</birthdate>
        <gender>Female</gender>
        <school>Waterfalls Middle School</school>
        <marks>85.96851</marks>
    </student>
    <student rollno="103">
        <birthdate>2010-02-25</birthdate>
        <gender>Male</gender>
        <school>Mountainview School</school>
        <marks>80.97072</marks>
    </student>
    <student rollno="104">
        <birthdate>2012-11-09</birthdate>
        <gender>Male</gender>
        <school>Westside School</school>
        <marks>94.31802</marks>
    </student>
</class>
```