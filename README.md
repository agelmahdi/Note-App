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
   - Presentation: A layer that interacts with the UI.
   - Use cases: Sometimes called interactors. Defines actions the user can trigger.
   - Domain: Contains the business logic of the app.
   - Data: Abstract definition of all the data sources.
   - Framework: Implements interaction with the Android SDK and provides concrete implementations for the data layer.


![image](https://user-images.githubusercontent.com/26491505/138540672-d123dbe6-faf1-4e03-8cfe-8d9e47581219.png)

5. Conclusion

![image](https://user-images.githubusercontent.com/26491505/138559779-49b8c6a2-e1cd-49d7-ab3c-eeaba5ca40ca.png)

    The three most important things to remember are:

   - The communication between layers: Only outer layers can depend on inner layers.
   - The number of layers is arbitrary: Customize it to your needs.
   - Things become more abstract in inner circles.
   
6. Pros of using Clean Architecture:

   - Code is more decoupled and testable.
   - You can replace the framework and presentation layers and port your app to a different platform.
   - It’s easier to maintain the project and add new features.
   
7. Cons of using Clean Architecture:

   - You’ll have to write more code, but it pays off.
   - You have to learn and understand Clean Architecture to work on the project.






