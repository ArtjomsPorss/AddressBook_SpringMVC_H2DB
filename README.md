# AddressBook_SpringMVC_H2DB

## General
An example Spring Web MVC application. 
It is an address book application where you can store/retreive/edit address book entries (CRUD functionality).
The purpose of this is learning to build web applications using Spring MVC, Java and H2 database from scratch.
You can download this code, import to [**STS**](https://spring.io/tools/sts/all)(it's a flavour of Eclipse IDE) workspace as **Maven** project and debug the code for learning.

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
* Maven 3.5 Build Tool
* Tomcat 8
* H2 database to store Address Book Entres

## Using this project
### Preparation
* Download and install latest [Java SE](http://www.oracle.com/technetwork/java/javase/downloads/index.html) (if you haven't done so already)
* Download and install [Maven](https://maven.apache.org/download.cgi) build Tool
* Download and unzip [Tomcat](https://tomcat.apache.org/) application Server
* Download and install/unzip [STS](https://spring.io/tools/sts/all)(it's a flavour of Eclipse IDE)
* I think Maven dependency management inside project will automatically download H2 database library and there is no need to manually install it. Otherwise, download it [here](http://www.h2database.com/html/main.html)
### Setting up project
* Open STS and create a workspace
* Download and extract this project to workspace folder
* In STS in Project Explorer *right-click* -> Import -> Maven -> Existing Maven Projects -> *select the project you've just downloaded* -> Finish -> *selected project will appear in workspace*
* Done!






