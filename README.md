# MIM Software DevOps Pre-Interview Example Project
This project is a very simple Kotlin/KTOR web application.
When built/run it will start up a Netty based HTTP server listening
on port 8080.  Though it is only a simple HelloWorld, it serves as a good
example introduction to some of the technologies we use at scale.

### Pre-Requisites
This project uses Kotlin/JVM and the KTOR web framework.  It is built to compile to the Azul JDK 11,
and specifies all of its dependencies using the Gradle build system.

Before you begin, you will need to have a linux machine with:
* Azul JDK 11 installed [(Link)](https://www.azul.com/downloads/zulu-community/?version=java-11-lts&os=rhel&architecture=x86-64-bit&package=jdk)
* Gradle version 6+ installed [(Link)](https://gradle.org/install/)
* Git installed [(Link)](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

You will also need your container management and build tools of choice in order to 
complete the pre-interview task.  Use whatever you are familiar with.

### Clone the Project
Use `git` to clone the project to the location on your machine where you intend to work,
and `cd` into that directory before continuing.
**Note: Instructions on how to clone are intentionally not listed.  If you don't remember, take
a look around GitHub.**

### Building the Project
The project uses Gradle to build itself, relying on the standard Gradle Wrapper
system to ensure the correct Gradle version is used, regardless
of which version you installed.  Make sure you are running commands with `./gradlew`
and not `gradle`

* Step 1: Make sure that gradle is installed on your system.
* Step 2: Run `./gradlew clean` to ensure you are starting from a clean state.
* Step 3: Run `./gradlew build` which should compile the project in its entirety.
* Step 4: To verify that the system is working as intended, run `./gradlew test`

### Creating the Distributable
This project uses Gradle's `Application` plugin, so creation of the necessary
runtime artifacts can be done by running `./gradlew installDist`

Once `./gradlew installDist` has completed, you will find everything you need to run
the application in either `build/install` (unpacked) or `build/distributions` (packed.)

Running `./build/install/ExampleProject/bin/ExampleProject` will launch the webserver, listening on
at `0.0.0.0:8080`.  Use your browser of choice and navigate to `localhost:8080` to verify.
You can use `^C` to kill the application when you're finished.

### Thoughts on Containerizing
Depending on how you choose to build the container from this project, you can pull from either
the raw folder structure in `build/install/ExampleProject` or by grabbing one of the packed (`.tar` or `.zip`)
files from the `build/distributions` folder, whichever your container building system of choice prefers.

We are looking for resourcefulness, automation, and reusability from your solution.  Try to think about what
you would do if you were creating a container that would be used in a production environment.  How should ports map?
What about security?  What does the system need to have for the executable to run?
