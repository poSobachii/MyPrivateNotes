# Java  <hr>

0. Introduction:
    + Basics of programming and Java's role
    + Installation and setup


1. Basics:
    + 1.1 Variables
        + Declaration
        + Variable types
            + local/static/instance(field)
            + variable/field/attribute/property
        + Data types primitive vs non-primitive
        + char, String , int , long, float , double, boolean, array[]
        + Integer, Long, Boolean etc. Objects to primitive diff 'Integer.parseInt()'. Object uses 'new' keyword.
        + Implicit casting / Explicit casting
        + Autoboxing
    + 1.2 Methods
    + 1.3 String manipulations
        + String conversion '.parseInt()'
        + String formatting
    + 1.4 Operators
        + arithmetical / unary
        + relational / comparison
        + logical / conditional
        + assignment
        + increment/decrement operators
    + 1.5 Statements
        + if-then
        + if-then-else
        + switch
        + ternary operator
    + 1.6 Loop controls
        + FOR foreach, fori
        + while
        + do while
        + continue/break
    + 1.7 Comments
        + single line
        + comment block
    + 1.8 Clean code policy, conventions


2. Classes & Objects:
    + 2.1 Classes initialization (blueprint), Object creation (blueprints representation)
    + 2.2 Constructors. default constructor == without parameters.
    + 2.3 Access level modifiers public/protected/no-modifier/private
        + private classes can be declared as Inner or Nested
    + 2.4 Modifiers static/final
        + final class prevents extending of class
        + synchronized - only one thread at a time
        + volatile - prevents reordering in cache memory in runtime
        + transient - marks not to serialize this field.
    + 2.5 Nested Classes/ Inner classes
    + 2.6 Enums
    + 2.7 Interface


3. OOP:
    + 3.1 OOP principles abstraction/encapsulation/polymorphism/inheritance
        + association - connectivity between objects one-to-one , one-to-many etc.
        + composition - Member is tied to his Owner. Building and room example
        + aggregation - They are not tied. Player and a Team example
    + 3.2 Encapsulation
        + getters, - Read Only class
        + setters, - Write Only class
        + private modifiers
    + 3.3 Inheritance
        + interface
        + overriding
        + super keyword
    + 3.4 Polymorphism
        + overriding
        + overloading
    + 3.5 Abstraction
        + abstract class
        + abstract method
    + 3.6 .equals() & .hashCode() difference


4. Array, Collections
    + 4.1 Collections array vs collection
    + 4.2 Arrays
        + single [ ]
        + multidimensional [ ][ ]
    + 4.3 Lists
        + ArrayList
        + LinkedList
    + 4.4 Set
        + HashSet
        + TreeSet
        + LinkedHashSet
    + 4.5 Queue / Dequeue
        + priorityQueue
        + ArrayDeque
    + 4.6 Stack
    + 4.7 Maps
        + size/ order / manipulations
        + hashMap
        + treeMap
        + LinkedHashMap
        + Iterator/iterable


5. Exceptions
    + 5.1 Types checked/unchecked
    + 5.2 Try catch block
    + 5.3 Finally block
        + always executes after try
        + bypass continue, break, return
    + 5.4 Try-with-resources
        + buffer reader etc. .close();)
        + custom exception have to implement AutoCloseable
    + 5.5 Throwing exceptions inside method, outside method
    + 5.6 Custom exceptions


6. IO package Input/Output source
    + 6.1 Input types
        + Scanner for primitives input
        + BufferedReader for bigger data input ( file etc.)
    + 6.2 Output types
        + console/log - println(), printf()
    + 6.3 Object streams
    + 6.4 Data serialization/deserialization , transient keyword
    + 6.5 Files reader/writer
    + 6.7 Input validation
        + regular expression
        + exception handling for valid inputs


7. Testing & Debugging
    + 7.1 Type of tests
        + Unit tests
        + Integration tests
        + Selenium tests
    + 7.2 JUnit testing
    + 7.3 Debugging tools
    

8. Network TCP/UDP
    + 8.1 Network fundamentals, client-server architecture communication protocols
    + 8.2 TCP (Transmission Control Protocol)
        + TCP Overview and communication
        + Socket Programming
    + 8.3 UDP (User Datagram Protocol)
        + UDP Overview and communication
        + Datagram Programming
        + MulticastSocket
    + 8.4 URL and URLConnection
    + 8.5 HTTP and HTTPS
      + HTTP, HTTPS overview
      + HTTPUrlConnection vs URLConnection
      + List of other URLConnection subclasses
    + 8.6 Popular network frameworks
    + 8.7 Network security concepts & secure communication


9. JDBC (MySQL preferred + docker / H2 with Spring Boot)
    + 9.1 DB connection
    + 9.2 Create query/statement
        + insert
        + update
        + select
        + delete


10. Concurrency
    + 10.1 Processes/Threads
    + 10.2 Runnable interface
    + 10.3 Pausing execution
    + 10.4 interrupts/join
    + 10.5 Synchronized / volatile keywords
    + 10.6 High level concurrency/ lock / cyclicBarrier
    + 10.7 Thread safety
        + synchronization
        + locks
        + atomic variables
        + concurrent collections
    + 10.8 Multithreading
        + Thread synchronization
        + Thread communication/coordination
    + 10.9 Concurrent collections and utilities
    + 10.10 Executors and thread pools


11. Generics
    + 11.1 Introduction to Generics
    + 11.2 Generics with Collections
    + 11.3 Wildcard Generics
    + 11.4 Bounded Types
    + 11.5 Generic Methods
    + 11.6 Generic Classes
        + Pair<K, V>
        + U extends Number
    + 11.7 In-depth Generics
    + 11.8 Using Generics for Type Safety
    + 11.9 Best Practices and Limitations
    + 11.10 Generics in Java Standard Library


12. Java Standard Library & Advanced language features
    + 12.1 Date and time manipulation
    + 12.2 Math and number formatting
    + 12.3 Localization and internationalization
    + 12.4 Optionals (Handling potentially nullable values)
    + 12.5 VARARGS Arbitrary number of arguments in methods parameters method(String... inputString)
    + 12.6 Lambda
    + 12.7 Streams and parallel processing
    + 12.8 Static imports.
    + 12.9 Reflections & Annotations
        + Java Reflection: Introducing reflection and its capabilities, including dynamically inspecting and modifying classes,
          accessing methods and fields at runtime, and understanding its use cases.
    + 12.10 Design patterns in Java
    + 12.11 Immutability in Java
    + 12.12 Garbage collector
    + 12.13 Stack/heap memory


13. GUI basics
    + 13.1 Audio
    + 13.2 Swing
        + Frame, Labels, Panels, Buttons
        + Border layout, FLow layout, Grid layout
        + Layered Pane
        + New GUI window
        + JOption Pane
        + checkbox, radio buttons, combobox
        + slider, progress bar
        + menu bar
        + select a file
        + color chooser
        + Key & Mouse listeners
        + drag and drop
        + key bindings
        + 2g graphics, 2d animations
    + 13.3 JavaFX


14. Spring Framework (maven/ gradle)
    + 14.1 Introduction to Spring Framework
    + 14.2 Spring Core Concepts:
        + Dependency Injection (DI) and Inversion of Control (IoC)
        + Beans and their lifecycle management
        + Application Context and Bean Factory
    + 14.3 Spring Configuration
        + XML-based configuration
        + Annotation-based configuration
        + Java-based configuration
    + 14.4 Spring MVC (Model-View-Controller):
        + Overview of the MVC design pattern
        + Controllers, views, and request handling
        + Mapping URLs and handling forms
    + 14.5 Spring Data Access:
        + JDBC template and data access objects (DAOs)
        + Object-relational mapping (ORM) with Spring and Hibernate
        + Spring Data JPA for simplified database access
    + 14.6 Spring AOP (Aspect-Oriented Programming):
        + Understanding AOP concepts
        + Aspect-oriented programming with Spring
        + Using aspect annotations and pointcuts
    + 14.7 Spring Security
        + Authentication and authorization concepts
        + Securing web applications with Spring Security
        + Role-based access control and custom authentication providers
    + 14.8 Spring Integration
        + Overview of enterprise integration patterns
        + Integration with messaging systems and external APIs
        + Building message-driven applications with Spring Integration
    + 14.9 Spring Boot
        + Introduction to Spring Boot and its features
        + Auto-configuration and starters
        + Building standalone, production-ready applications with Spring Boot

