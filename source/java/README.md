# LogStarBook Java Project

![Made with Java](https://forthebadge.com/images/badges/made-with-java.svg)

> Logging the amount of books my kids read, so they can be rewarded after predetermined amount of books.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for testing purposes.

### Prerequisites

You will need Java 11 or higher installed and configured on your system PATH.  
It's best to use the [OpenJDK][openjdk], Windows users can get binaries from [AdoptOpenJDK][adoptopenjdk].

### Installing

Clone the repository: `git clone https://github.com/Skerwe/logstarbook.git`

1. In bash/terminal/command line, cd into the project directory:  
    `cd source/java/logstarbook`
2. Compile the application:  
   `gradlew compileJava`
3. Execute the application by passing in the full name of the main class to run:  
   `gradlew -PmainClass=app.skerwe.logstarbook. run`

The final output of the challenge is printed to the console or the log file for the specific day under the *logs* folder.

### Running Tests

1. Compile the tests:  
    `gradlew compileTestJava`
2. Execute the tests:  
    `gradlew test`

## This project was built with

- [Java](https://www.java.com/en/) programming language
- [Gradle][gradle] build tool
- [JUnit Jupiter][junit] (JUnit 5) testing framework
- [Apache Log4j 2](https://logging.apache.org/log4j/2.x/) logging framework

## License

The source code is free -- see the [LICENSE](../../LICENSE) file for details

[openjdk]: https://openjdk.java.net/
[adoptopenjdk]: https://adoptopenjdk.net/
[gradle]: https://gradle.org/
[junit]:  https://junit.org/junit5/
