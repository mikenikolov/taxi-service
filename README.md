# π Taxi Service π

### π Overview

Taxi Service - a simple web-application that allows you to do a taxi management.

***

### π Description
With this simple web-application taxi management becomes a lot easier!

**You can test this already deployed project at the following link:**

https://taxiservice-web.herokuapp.com/

The application supports:
- Authentication
- Registration
- Logout

You can easily manage _manufacturers_/_cars_/_drivers_ with these CRUD operations:
- ##### π­ Manufacturer
    - Add
    - Delete

- ##### π Car
    - Add
    - Delete
    - Add / Remove a driver

- ##### π Driver
    - Register
    - Delete

- ##### π List of all
    - Manufacturers
    - Cars
    - Drivers
- ##### πΌ Profile of the logged in driver with their cars

π _PS. The application provides a user-friendly web interface that is easy to work with!_ 

***

### π§± Project architecture
The application is implemented with the **3-tier** architecture:

`πΌPresentation layer πΌ  Service layer πΌ  Data layer πΌ`

***

### π¨ Technologies used in the project
- Java 11
- Maven 3.8.1
- PostgreSQL 14.2
- JDBC
- JSP
- JSTL 1.2
- Apache Tomcat 9.0.50
- Java Servlet 4.0.1
- HTML/CSS

***

### βοΈ How to setup?
1. Install PostgreSQL, Tomcat, Java, Maven, Git
2. Clone a newest version of the project
3. Configure a Tomcat and PostgreSQL
4. Execute an SQL query from `src/main/resources/init_db.sql`
   to create the necessary database and its tables
5. Change database properties in `src/main/resources/database.properties`
   to the actual properties for your database
6. Start a configured Tomcat
7. Enter the URL where the server is running and enjoy β¨

***

### πΈ Screenshots
![img.png](img/app/img.png)
![img_1.png](img/app/img_1.png)
![img_2.png](img/app/img_2.png)
![img_3.png](img/app/img_3.png)
![img_4.png](img/app/img_4.png)
![img_5.png](img/app/img_5.png)
***

### πΎ Data structure

#### DB diagram
![db.png](img/db.png)

#### UML diagram
![uml.png](img/uml.png)

***

### π€΅ Author
_Mykhailo Nikolov_

https://github.com/mikenikolov
