# Address Book web app powered by Spring MVC and H2 database

## General
An example Spring Web MVC app that can store/retreive/edit address book entries (CRUD functionality).
For myself it is a way to learn Spring Framework and database storage.
For people who are a little bit familiar with Spring MVC and would like to learn more, they can run project on their machine and explore how it is built.
I added as much comments in code files as possible to help reader understand how everything works.

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
* H2 (version 1.4.195) database to store Address Book Entries

I guess, newer versions of tools can be used as well, but just for stable experience I would stick with versions I used.

## Using this project
### Preparation
* Download and install latest [Java SE](http://www.oracle.com/technetwork/java/javase/downloads/index.html) (if you haven't done so already)
* Download and install [Maven](https://maven.apache.org/download.cgi) build Tool
* Download and unzip [Tomcat](https://tomcat.apache.org/) application Server
* Download and install/unzip [STS](https://spring.io/tools/sts/all)(it's a flavour of Eclipse IDE)
* Download and unzip [H2](http://www.h2database.com/html/main.html) database.
### Running STS and importing the project
* Run STS and create a workspace
* Download and extract **AddressBook_SpringMVC_H2DB** project to workspace folder
* In STS in Project Explorer *right-click* -> Import -> Maven -> Existing Maven Projects -> *select the project you've just downloaded* -> Finish -> *selected project will appear in workspace*
* Done!
### Adding Tomcat Server to STS
This application is run on Tomcat Server from within STS. In order to do so, we need to create a Server entry withing STS.
* *right-click in Servers tab on the bottom left of STS* -> New -> Server -> Apache -> *pick Tomcat with version you downloaded, 8.5 in my case* -> Next -> *Click on imported project and click Add* -> Finish -> *in servers tab newly created Tomcat server will be listed*
### Creating database
Let's create **address_book** database and **ENTRIES** table in it. Without this application won't work.
* Navigate to downloaded and unzipped h2 folder **/h2/bin/** and run **h2-1.4.195.jar** or it may have different numbers in name due to a different version
* A database console login page should open up in the browser. Fill it with details as follows:
![021 database console](https://user-images.githubusercontent.com/11411618/27842266-50d63572-6100-11e7-96be-8f844be84bc2.JPG)
* Press **Connect**
* A H2 Console should open up:
![022 console open](https://user-images.githubusercontent.com/11411618/27842689-1f52b134-6104-11e7-83ce-5a9bf6f434c4.jpg)
* Enter following query and press **Run**:
```
CREATE TABLE ENTRIES (
ID INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(255),
SURNAME VARCHAR(255),
ADDRESS VARCHAR(255),
PHONE_NUMBER VARCHAR(255),
EMAIL VARCHAR(255),
ZIP VARCHAR(255)
);
```
* It should table named "ENTRIES" (look at top left):
![024 console with table](https://user-images.githubusercontent.com/11411618/27842691-1f552072-6104-11e7-8380-0e7bba543f32.jpg)
* Now press red button in very top-left of H2 Console to disconnect from database. **IT IS IMPORTANT TO DO THIS!** Otherwise Application won't work, I guess because it uses same connection(login details) as we used to enter H2 Console.
### Running Application
* click on Tomcat server in Servers tab
* click button with play icon in Servers tab
* server will start (takes about 15 seconds)
* cross the fingers, hope everythings works fine
* once Server startup finished the console will display something like *INFO: Server startup in 12508 ms*
* go to application URL: **http://localhost:8080/AddressBook_SpringMVC_H2DB/home.html**
* use the app
## What's next?
### Learning by Debugging
* Set some breakpoints in all ApplicationController.java methods
* Start Tomcat as debug (bug icon button to the left from play button in Servers Tab)
* Go to URL: **http://localhost:8080/AddressBook_SpringMVC_H2DB/home.html**
* click on any application buttons
* STS should stop at debugging breakpoints you set
* Explore the application structure by traversing in/out through application methods
# Project Structure
## Packages
* *config* package contains Spring configuration
* *controller* package contains MVC controller. Basically it handles any button clicks from the browser. You can debug it's methods with STS to explore method calls and overall application architecture
* *persistence* handles database layer of the app
* *persistence/jdbc* contains specific JDBC calls to the database
* *service* is a glue between *persistence* and *controller* layers of the app. It's responsibility is to pass and modify entries between *controller*, which handles UI, and *persistence* to store to/retreive from the database.
## Views
Webpages that we see in the browser are compiled from JSP files (*JSP stands for Java Server Pages. They get compiled on the server into HTMLs and sent to the browser*)
JSP files are located in **src/main/webapp/WEB-INF/jsp/** folder
They contain HTML + JSTL tags for use of if/else statements + Spring forms for sumbiting data to Spring Controllers
## Resources
Resources can be folders with CSS, JavaScript files etc..
They are located in **src/main/webapp/resources/**
## Method calls
### From Browser to Database
* Browser *button is clicked* -> 
* ApplicationController -> 
* ApplicationService -> 
* AddressBookRepositoryJdbcImpl -> 
* DAO files *Store entry to database or retreive entry from database*
*DAO stands for Data Access Object class. In this applciation they are classes with single responsibility, e.g. AddEntryDAO only adds new entry to database, GetAllEntriesDAO retreives all entries from the database*
### From Database Back to Browser
* DAO file *returns entry* ->
* AddressBookRepositoryJdbcImpl ->
* ApplicationService ->
* ApplicationController *stores entry in Model object* ->
* JSP's html tables and values get populated by entry data ->
* Browser
## Spring Configuration
I think, the hardest part in creating Spring application is the configuration. Once it's done and the application is running - the rest is just pure joy of developing functionalities: adding webpages, styling them, creating Controller and Service methods to support UI calls, writing SQL queries to store/modify/retreive database data.
In this project Spring configuration is scattered over 3 classes inside *config* package:
* PersistenceConfig - contains database configuration. It will create database on startup if doesn't exist yet.
* WebApplicationInitializerImpl - creates dispatcher servlet. It will handle URL requests that end with *.html*
* WebConfig - adds to application: folder with JSP views, folders with JS, CSS resources

Spring Configuration is the hardest part for me and I will need to spend some more time understanding it.
