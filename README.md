# Note App

This is a practical project for Senior Android Developers that covers clean Architecture basics using the following: skills: Real-like coding with Kotlin, MVVM Design pattern, Kotlin Coroutines, Room database, Recyclerview , Navigation Controller,Jetpack compose , Use cases, and Dependancy injection using Dagger-Hilt.

# MVVM Design pattern, Kotlin Coroutines, Room database.

for more information https://github.com/agelmahdi/News-APP

# 1. Why Clean Architecture Is Important?

   - to manage the complexity of your application. You may not need to worry about it on a smaller project, but it becomes a lifesaver on larger ones.
 
 
 ![image](https://user-images.githubusercontent.com/26491505/138539745-1be43639-a348-44da-8df6-4ac1d322591e.png)


# 2. Principles of Clean Architecture

   - Abstraction Principle: The Abstraction Principle specifies that inner circles should contain business logic, and outer circles should contain implementation details.
   
   - Dependency Rule: This rule specifies that each level can depend only on the nearest inward level — this is what makes the architecture work.


# 3. SOLID Principles:

 - Five design principles make software design more understandable, flexible and maintainable. 
  
   - Single Responsibility: Each software component should have only one reason to change – one responsibility.
   
   - Open-closed: You should be able to extend the behavior of a component, without breaking its usage, or modifying its extensions.
   
   - Liskov Substitution: If you have a class of one type, and any subclasses of that class, you should be able to represent the base class usage with the subclass, without breaking the app.
   
   - Interface Segregation: It’s better to have many smaller interfaces than a large one, to prevent the class from implementing the methods that it doesn’t need.
   
    - Dependency Inversion: Components should depend on abstractions rather than concrete implementations. Also higher level modules shouldn’t depend on lower level modules.


# 4. Layers of Clean Architecture

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
       
       - A dependency of class A is any class B that is used by A.
       
       - Generally, a class should not be responsible for both creating and using its dependencies.
       
       - Rather than have a class create its own dependencies, you should create those dependencies outside and pass them into the class via its constructor.
       
       - Dependency injection is a pattern where dependencies are passed into a class from an external entity.
       
       - Injecting dependencies into a class allows for greater reusability of that class.
       
       - Dependency injection is especially important for unit testing a class, as passing in dependencies through a class’s constructor allows for mock objects to be passed into that class during unit tests.
       
       - For more complex dependencies in a project, you can use an external dependency injection framework like Dagger-hilt, koin, Dagger2.
       
     # Reactive Extension(ReactiveX)
     
     - It is a library for composing asynchronous and event-based programs by using observable sequences.
     
     - It extends the observer pattern to support sequences of data and/or events and adds operators that allow you to compose sequences together declaratively while abstracting away concerns about things like low-level threading, synchronization, thread-safety, concurrent data structures, and non-blocking I/O.

       - Asynchronous: It implies that the different parts of a program run simultaneously.
       
       - Event-Based: The program executes the codes based on the events generated while the program is running. For Example, a Button click triggers an event and then the program’s event handler receives this event and does some work.
       
       - Observable sequences: all Publishers like Observable and Flowable take some items and pass onto its subscribers. So, these items are called as Observable sequences or Data Stream.
       
     - The RxJava is an implementation of a Reactive Stream specification.
     
     -  Reactive Streams is a programming concept for handling asynchronous data streams in a non-blocking manner while providing backpressure to stream publishers.
     
     - It has evolved into a specification that is based on the concept of Publisher<T> and Subscriber<T>.
   
     - A Publisher is the source of events T in the stream, and a Subscriber is a consumer for those events.
   
     - A Subscriber subscribes to a Publisher by invoking a “factory method” in the Publisher that will push the stream items <T> starting a new Subscription. This is also called Reactor Pattern.
   
       - Data Stream: It is the flow of data(events/objects/items) in a sequence.
   
       - Non-blocking: The thread does not have to wait for the monitor lock. In concurrent programming, a monitor is a synchronization construct that allows threads to have both mutual exclusion and the ability to wait (block) for a certain condition to become true.
   
       - Backpressure: relates to a feedback mechanism through which the subscriber can signal to the producer how much data it can consume and so to produce only that amount.
   
        - Mechanism of Publisher and Subscriber: It is described below:
   
       
      How does this Reactive Stream work?
   
      # 1.The Publisher
   
     - The interfaces(APIs) define the structure of RxJava with following types of event publishers:
   
       - Flowable: A Publisher that emits 0..N elements, and then completes successfully or with an error.
   
       - Observable: Similar to Flowables but without a backpressure strategy. They were introduced in RxJava 1.x.
   
       - Single: It completes with a value successfully or an error.(doesn’t have onComplete callback, instead onSuccess(val)).
   
       - Maybe: It completes with/without a value or completes with an error.
   
       - Completable: It just signals if it has completed successfully or with an error.
   
     - Cold publishers: They only begin emitting when there is a subscriber, and all subscribers receive the exact set of historical data, regardless of when they subscribe.
   
     - Hot publishers: They begins generating items and emits them immediately when they are created. causing OutOfMemoryException.
       - Subjects: are one way to handle hot observables. Subjects keep the reference to their subscribers and allow ‘multicasting’ an event to them.
   
   
      # 2. Subscriber 
   
      - subscribes to a Publisher and then receives events in one of its callback methods.
   
        - onSubscribe(Subscription s)  //signals to the Publisher to start sending events
   
        - onNext(T t)
   
        - onError(Throwable t)
   
        - onComplete()
   
     # 3. Subscription
   
     - When the Subscriber becomes ready to start handling events, it signals the Publisher through its Subscription.

     # 4. Canceling subscription
     
     - When a Subscriber subscribes a Publisher then in RxJava2, a Disposable instance is returned which can be used to cancelled/disposed a Subscriber externally via Disposable::dispose().
   
     # 5. Error handling
   
       -  Since streams are generally asynchronous, it doesn’t make sense to throw an exception, so instead any exception is passed as an event in the stream

     # 6. Operators
   
     - There are a lot of operators available in RxJava that simplifies this process. They are applied between the source Observable / Flowable and the Subscriber.
   
     - e.g. flatMap: It takes the emissions (objects, collections, or arrays) from an Observable, and maps those elements to individual Observables, then flattens the emissions from all of those into a single Observable.
   
     - important operators are:
       - filter, map, delay, interval, reduce, collect, defer, zipWith, merge, concat, timeout, retry, onErrorReturn, toList.
   
     # 7. Schedulers (Processor)
   
     - It represents a processing stage—which is both a Subscriber and a Publisher and obeys the contracts of both.
   
     - There are two methods through which we can introduce Schedulers into our chain of operations:
   
       - subscribeOn: It specify which Scheduler invokes the code contained in Observable.create().
   
       - observeOn: It allows control to which Scheduler executes the code in the downstream operators.
   
     - RxJava provides some general use Schedulers:
   
       - Schedulers.computation() : Used for CPU intensive tasks.
   
       - Schedulers.io(): Used for IO bound tasks.
   
       - Schedulers.from(Executor): Use with custom ExecutorService.
   
       - Schedulers.newThread(): It always creates a new thread when a worker is needed. Since it’s not thread pooled and always creates a new thread instead of reusing one, this scheduler is not very useful.
   
     # RxJava VS Coroutines
   
     - Coroutines are a lower lever and more general concept than RxJava, they serve others use-cases. That said, there is one use-case where you could compare RxJava and coroutines (channel), it's passing around data asynchronously. Coroutines have a clear advantage over RxJava here:
   
       - Coroutines are better to deal with resources.
   
         - Every coroutine is given a thread context and return to parent context. For a channel, both side (producer, consumer) execute on his own context.
   
         - Coroutines are more intuitive on thread or thread pool affectation.
   
         - Due to it's reactive nature, backpressure doesn't fit well in RxJava. In the other end send() to channel is a suspensive function that suspend when channel capacity is reached. It's out-of-the-box backpressure given by nature. 
   
         - Coroutine now have flow, an API very, very similar to Rx. One could compare pro/cons of each, but the truth is the differences are minor.
   
       - Coroutines give more control on when those computation occur.
   
       - Coroutines are better at removing callback from your code.
   
       - Coroutines as it's core is a concurrency design pattern, with add-on libraries, one of those being a stream API similar to Rx. Obviously, Coroutines having a far broader scope than Rx, there is a lot of things that Coroutines can that Rx can't.

# 5. Conclusion

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

6. Refernces:

  - raywenderlich.com shorturl.at/moyLQ
  - mindorks.com shorturl.at/bfjJ4





