# Note App

This is a practical project for intermediate android developers that covers clean Architecture basics using the following: skills: Real-like coding with Kotlin, MVVM Design pattern, Kotlin Coroutines, Room database, Recyclerview , Navigation Controller,Jetpack compose , Use cases, and Dependancy injection using Dagger-Hilt.

# MVVM Design pattern, Kotlin Coroutines, Room database.

for more information https://github.com/agelmahdi/News-APP

# Clean Architecture

1. Why Architecture Is Important?
   - to manage the complexity of your application. You may not need to worry about it on a smaller project, but it becomes a lifesaver on larger ones.
 
 
 ![image](https://user-images.githubusercontent.com/26491505/138539745-1be43639-a348-44da-8df6-4ac1d322591e.png)


2. Principles of Clean Architecture:
   - Abstraction Principle: The Abstraction Principle specifies that inner circles should contain business logic, and outer circles should contain implementation details.
   - Dependency Rule: This rule specifies that each level can depend only on the nearest inward level — this is what makes the architecture work.

3. SOLID Principles: Five design principles make software design more understandable, flexible and maintainable. 
    
    Those principles are:
    - Single Responsibility: Each software component should have only one reason to change – one responsibility.
    - Open-closed: You should be able to extend the behavior of a component, without breaking its usage, or modifying its extensions.
    - Liskov Substitution: If you have a class of one type, and any subclasses of that class, you should be able to represent the base class usage with the subclass, without breaking the app.
    - Interface Segregation: It’s better to have many smaller interfaces than a large one, to prevent the class from implementing the methods that it doesn’t need.
    - Dependency Inversion: Components should depend on abstractions rather than concrete implementations. Also higher level modules shouldn’t depend on lower level modules.

4. Layers of Clean Architecture: 

![image](https://user-images.githubusercontent.com/26491505/138561330-369b7cc2-f06c-419e-a4b0-6bd236deb08b.png)

   # The Domain Layer
   
   Contains all the models and business rules of your app.
     
   # The Data Layer
   
   - This layer provides abstract definitions for accessing data sources like a database or the internet using Repository pattern.
   - The main purpose of the repository pattern is to abstract away the concrete implementation of data access.
   
       - DataSource interface: The interface that the Framework layer must implement.
       - Repository class: Provides methods for accessing the data that delegate to DataSource.
       
       
   ![image](https://user-images.githubusercontent.com/26491505/138561933-92616fe0-1433-49b2-a7b2-a0d99bf9ea8d.png)

   - The repository pattern is a good example of the Dependency Inversion Principle because
  
     - A Data layer which is of a higher, more abstract level doesn’t depend on a framework, lower-level layer.
     - The repository is an abstraction of Data Access and it does not depend on details. It depends on abstraction.
     
   # The Use Cases Layer

   - This layer converts and passes user actions, also known as use cases, to inner layers of the application.
   
   - Note app has three key functionalities:
     
      1. Showing and managing a list of notes.
      2. Enabling the user to add a note and manage it.
      3. Enabling the user to sort notes.

       
   - From that, you can list the actions users should be able to perform:
     
      1. Adding a new note.
      2. Editing a note.
      3. Removing a note.
      4. Getting all notes.
      5. Setting sort note.
      6. Getting sorted note. 
      
   - Each use case class has only one function that invokes the use case.
      
   # The Framework Layer
   
   Implements interaction with the Android SDK and provides concrete implementations for the data layer.

   # The Presentation Layer
   
   - This layer contains the User Interface-related code. This layer is in the same circle as the framework layer, so you can depend on its classes.
    
     # Using MVVM
     - Using MVVM pattern in this layer because it’s supported by Android Jetpack, but it doesn’t matter which pattern you use for this layer even if MVP, MVI or something else.
      - Model: This layer is responsible for the abstraction of the data sources. Model and ViewModel work together to get and save the data.
      - View: The purpose of this layer is to inform the ViewModel about the user’s action. This layer observes the ViewModel and does not contain any kind of application logic.
      - ViewModel: It exposes those data streams which are relevant to the View. Moreover, it servers as a link between the Model and the View.
  
     ![image](https://user-images.githubusercontent.com/26491505/137802023-883c2834-3b90-479a-ada8-f8ad129d4021.png) 

     # Providing Sources
     
     - we need a way to provide the Data sources to the data layer. You should usually do this using dependency Injection. 
     
       # Dependency Injection
      
       It is the process of separating provider functions or factories for dependencies, and their usage. This makes your classes cleaner, as they don’t create dependencies in their constructors.


5. Conclusion

  - The three most important things to remember are:

    - The communication between layers: Only outer layers can depend on inner layers.
    - The number of layers is arbitrary: Customize it to your needs.
    - Things become more abstract in inner circles.
   
  - Pros of using Clean Architecture:

    - Code is more decoupled and testable.
    - You can replace the framework and presentation layers and port your app to a different platform.
    - It’s easier to maintain the project and add new features.
   
  - Cons of using Clean Architecture:

    - You’ll have to write more code, but it pays off.
    - You have to learn and understand Clean Architecture to work on the project.






