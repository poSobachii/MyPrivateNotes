# Java  <hr>

0. Introduction:
    + Basics of programming and Java's role
    + Installation of JAVA & IDE and setup


1. Basics:
    + 1.1 Variables
        + Declaration
        + Variable types
            + local/static/instance(field)
            + variable/field/attribute/property
            + variable shadowing
        + Data types primitive vs non-primitive
        + Integer, Long, Boolean etc. Objects to primitive diff 'Integer.parseInt()'. Object uses 'new' keyword.
        + Implicit casting / Explicit casting
        + Autoboxing
    + 1.2 Methods
    + 1.3 String manipulations
        + String conversion '.parseInt()'
        + String formatting StringBuilder, String.format()
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
        + recursion
    + 1.7 Comments
        + single line
        + comment block
    + 1.8 Clean code policy, conventions


2. Classes & Objects:
    + 2.1 Objects overview
        + Classes initialization (blueprint),
        + Object creation (blueprints representation),
        + Singletons
        + Object lifecycle
    + 2.2 Constructors. default constructor == without parameters.
    + 2.3 Access level modifiers public/protected/no-modifier/private
        + private classes can be declared as Inner or Nested
    + 2.4 Modifiers static/final
        + static
        + final
    + 2.5 Nested / Inner / Anonymous classes
    + 2.6 Enums - the best Singleton
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
        + `this` keyword
    + 3.3 Inheritance
        + interface
        + overriding
        + `super` keyword
        + multiple interface usage
    + 3.4 Polymorphism
        + overriding
        + overloading
    + 3.5 Abstraction
        + abstract class
        + abstract method
        + default method
    + 3.6 Difference between abstract and interface
    + 3.6 .equals() & .hashCode() difference
    + 3.7 InstanceOf overview
    + 3.8 Comparable interface & Custom Comparators


4. Array, Collections
    + 4.1 Collections array vs collection
    + 4.2 Arrays
        + single [ ]
        + multidimensional [ ][ ]
        + ragged array
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


5. Exceptions & Logging
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
    + 5.7 Error handling and Logging
        + popular framework Log4j / SLF4J


6. IO package Input/Output and File Handling
    + 6.1 Input types
        + InputStream,
        + Reader
        + Scanner for primitives input
        + BufferedReader for bigger data input ( file etc.)
        + ByteArrayInputStream
    + 6.2 Output types
        + OutputStream
        + console/log - println(), printf()
        + Writer
        + BufferedWriter
        + ByteArrayOutputStream
    + 6.3 Object streams
    + 6.4 Data serialization/deserialization
        + `transient` keyword
        + xml, json, yml, properties formats
        + jackson ObjectMapper overview
    + 6.5 Files reader/writer
        + io vs nio
        + File vs File vs FileChannel
        + Selector
        + Path vs Paths
    + 6.7 Input validation
        + regular expression
        + exception handling for valid inputs


7. Testing & Debugging
    + 7.1 Type of tests
        + Unit tests
        + Integration tests
        + Selenium tests
    + 7.2 JUnit testing
        + Mocking
        + Asserting
    + 7.3 Debugging tools
    + 7.4 TDD - Test Driven Development
    

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
    + 9.2 CRUD operations
    + 9.3 Prepared statements
    + 9.4 connection pooling


10. Concurrency
    + 10.1 Processes/Threads/Pools
    + 10.2 Related interfaces
        + Runnable
        + Callble
        + Future
    + 10.4 Executors and thread pools
        + ExecutorService and stoping it
        + FixedThreadPool
        + CachedThreadPool
        + ScheduledExecutorService
    + 10.5 Execution manipulation
        + Pause
        + start
        + sleep
        + interrupt
        + join
        + wait
        + notify
    + 10.6 Thread safety
        + ThreadLocal & ThreadLocalRandom
        + `synchronized` keyword - only one thread at a time
        + `volatile` keyword - prevents reordering in cache memory in runtime
        + locks and Deadlock
    + 10.7 High level concurrency & Multithreading
        + cyclicBarrier
        + Thread synchronization
        + Thread communication/coordination
        + atomic variables
    + 10.8 Concurrent collections and utilities


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
        + Date, DateFormat, Calendar,
        + LocalDate, LocalTime, LocalDateTime
        + Instant, ZonedDateTime
        + DateTimeFormatter
    + 12.2 Math and number formatting:
      + new Short((short) 10)	Less efficient	May create unnecessary objects
      + Short.valueOf((short) 10) More efficient	Reuses objects for common values
    + 12.3 Localization and internationalization
    + 12.4 Optionals (Handling potentially nullable values)
    + 12.5 VARARGS Arbitrary number of arguments in methods parameters method(String... inputString)
    + 12.6 Lambda
        + method reference
    + 12.7 Functional interfaces
    + 12.8 Streams and parallel processing
    + 12.9 Static imports.
    + 12.10 Reflections & Annotations
        + Java Reflection: Introducing reflection and its capabilities, including dynamically inspecting and modifying classes,
          accessing methods and fields at runtime, and understanding its use cases.
        + Create your own Annotation
        + Popular annotations @Deprecated, @Override, @Nullable etc.
    + 12.11 Design patterns in Java
        + Singleton Pattern
        + Factory Method Pattern
        + Observer Pattern
        + Strategy Pattern
        + Decorator Pattern
        + Adapter Pattern
        + Command Pattern
        + Template Method Pattern
        + Iterator Pattern
        + Proxy Pattern
    + 12.12 Mutability in Java
    + 12.13 Garbage collector
    + 12.14 Stack/heap memory
    + 12.16 MapReduce technique
    + 12.17 SOLID principle


13. Graphical User Interface (GUI) Development
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
    + 14.3 Spring Boot
        + Introduction to Spring Boot and its features
        + Auto-configuration and starters
        + Building standalone, production-ready applications with Spring Boot
    + 14.4 Spring Configuration
        + XML-based configuration
        + Annotation-based configuration
        + Java-based configuration
    + 14.5 Spring MVC (Model-View-Controller):
        + Overview of the MVC design pattern
        + Controllers, views, and request handling
        + Mapping URLs and handling forms
    + 14.6 Spring Data Access:
        + JDBC template and data access objects (DAOs)
        + Object-relational mapping (ORM) with Spring and Hibernate
        + Spring Data JPA for simplified database access
    + 14.7 Spring AOP (Aspect-Oriented Programming):
        + Understanding AOP concepts
        + Aspect-oriented programming with Spring
        + Using aspect annotations and pointcuts
    + 14.8 Spring Security
        + Authentication and authorization concepts
        + Securing web applications with Spring Security
        + Role-based access control and custom authentication providers
    + 14.9 Spring Integration
        + Overview of enterprise integration patterns
        + Integration with messaging systems and external APIs
        + Building message-driven applications with Spring Integration
    + 14.10 Spring testing & monitoring:
        + Spring Test 
        + Spring Boot Actuator: production-ready monitor
        + Rest Assured
        + Web Driver

