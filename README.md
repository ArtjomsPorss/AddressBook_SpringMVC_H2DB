# Address Book web app powered by Spring MVC and H2 database

## General
An example Spring Web MVC app that can store/retreive/edit address book entries (CRUD functionality).
For myself it is a way to learn Spring Framework and database storage.
For people who are a little bit familiar with Spring MVC and would like to learn more, they can run project on their machine and explore how it is built.

## Usage Examples
**When application runs you have following functionalities:**
### Adding Entries:
Home screen -> Create Entry -> *fill in details* -> Add Entry -> *a list of entries is displayed*
![create entries](https://user-images.githubusercontent.com/11411618/27771905-36df359e-5f50-11e7-8fe4-d5f14fc72f08.gif)

### Searching for Entries & Editing Entries:
Home screen -> Search For Entries -> *type letters to search for* -> Find Entry -> *list of entries opens* -> Edit -> *edit details* -> Update Entry -> *updated list is displayed*
![editing entries](https://user-images.githubusercontent.com/11411618/27772236-e0c15a24-5f55-11e7-80b9-7a7399b74e46.gif)

### Deleting Entries:
Home screen -> Get All Entries (alternatively Search For Entry) -> *a list of entries is displayed* -> Delete -> *updated list is displayed*
![delete entries](https://user-images.githubusercontent.com/11411618/27772379-eceddd4c-5f58-11e7-9cdf-bc5d35cee4ec.gif)

## Techs used
It Utilises following technologies:
* Spring MVC
* Spring Annotations, Java Configuration
* JSP, Bootstrap
* Maven (version 3.5) Build Tool
* Tomcat (version 8.5)
* H2 (version 1.4.195) database to store Address Book Entres
I guess, newer versions of tools can be used as well, but just for stable experience I would stick with versions I used.

## Using this project
### Preparation
* Download and install latest [Java SE](http://www.oracle.com/technetwork/java/javase/downloads/index.html) (if you haven't done so already)
* Download and install [Maven](https://maven.apache.org/download.cgi) build Tool
* Download and unzip [Tomcat](https://tomcat.apache.org/) application Server
* Download and install/unzip [STS](https://spring.io/tools/sts/all)(it's a flavour of Eclipse IDE)
* I think Maven dependency management inside project will automatically download H2 database library and there is no need to manually install it. Otherwise, download it [here](http://www.h2database.com/html/main.html)
### Setting up STS and importing project
* Open STS and create a workspace
* Download and extract this project to workspace folder
* In STS in Project Explorer *right-click* -> Import -> Maven -> Existing Maven Projects -> *select the project you've just downloaded* -> Finish -> *selected project will appear in workspace*
* Done!
### Adding Tomcat Server to STS
This application is run on Tomcat Server from within STS. In order to do so, we need to create a Server entry withing STS.
* *right-click in Servers tab on the bottom left of STS* -> New -> Server -> Apache -> *pick Tomcat with version you downloaded, 8.5 in mu case* -> Next -> *Click on imported project and click Add* -> Finish -> *in servers tab newly created Tomcat server will be listed*
### Running Application
* click on Tomcat server in Servers tab
* click button with play icon in Servers tab
* server will start (takes about 15 seconds)
* once finished console will display something like *INFO: Server startup in 12508 ms*
* go to application URL: **http://localhost:8080/AddressBook_SpringMVC_H2DB/home.html**
* play with the app

##What's next?
###Learning by Debugging
* Set some breakpoints in all ApplicationController.java methods
* Start Tomcat as debug (bug icon button to the left from play button in Servers Tab)
* Go to URL: **http://localhost:8080/AddressBook_SpringMVC_H2DB/home.html**
* click on any application buttons
* STS should stop at debugging breakpoints you set
* Explore the application structure by going in/out through the code

### Project Structure
* *config* package contains Spring configuration
* *controller* package contains MVC controller. Basically it handles any button clicks from the browser. You can debug it's methods with STS to explore method calls and overall application architecture
* *persistence* handles database layer of the app
* *persistence/jdbc* contains specific JDBC calls to the database
* *service* is a glue between *persistence* and *controller* layers of the app. It's responsibility to pass and modify data between *controller*, which handles UI and *persistence* to the database, and backwards.
