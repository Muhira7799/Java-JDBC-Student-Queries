# Java JDBC Student Queries

A Java console application that connects to a MySQL database and runs four queries on a `students` table.

## What It Does

| Task | Query condition |
|------|-----------------|
| i. Last names starting with J | `LName LIKE 'J%'` |
| ii. Students whose country starts with R | `Country LIKE 'R%'` |
| iii. All information for ID 2012 | `Id = 2012` |
| iv. All IT students | `Course = 'IT'` |

Each query prints the full rows as `Id LName Course Country`.

## Requirements

- Java Development Kit (JDK) 8 or higher
- MySQL Server
- [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) (JDBC driver)

## Database Setup

The program expects a database named `University` with a `students` table:

```sql
CREATE DATABASE University;
USE University;

CREATE TABLE students (
    Id INT PRIMARY KEY,
    LName VARCHAR(50),
    Course VARCHAR(50),
    Country VARCHAR(50)
);

INSERT INTO students (Id, LName, Course, Country) VALUES
(2010, 'James', 'IT',   'Rwanda'),
(2011, 'Smith', 'Math', 'Kenya'),
(2012, 'Jean',  'IT',   'Uganda'),
(2013, 'Ruth',  'Law',  'Rwanda');
```

## Configuration

```java
Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/University",
        "root",
        ""
);
```

Change the URL, username, and password to match your MySQL setup.

## Getting Started

```bash
javac JDBCStudents.java
```

Run with the MySQL Connector/J jar on the classpath (replace the jar name with your version):

```bash
# Windows
java -cp ".;mysql-connector-j-8.x.x.jar" JDBCStudents

# Linux / macOS
java -cp ".:mysql-connector-j-8.x.x.jar" JDBCStudents
```

## Sample Output

Using the sample data above:

```
LName started by J:
2010 James IT Rwanda
2012 Jean IT Uganda

Countries started by R:
2010 James IT Rwanda
2013 Ruth Law Rwanda

Information of Id 2012:
2012 Jean IT Uganda

IT courses:
2010 James IT Rwanda
2012 Jean IT Uganda
```

## Notes

- Errors, such as a wrong password or a missing database, are caught and printed as a stack trace.
- The `Statement` and `ResultSet` objects are not closed explicitly. Only the connection is closed.

## Project Structure

```
.
├── JDBCStudents.java
└── README.md
```

## Possible Improvements

- Use `PreparedStatement` instead of `Statement`
- Use try-with-resources so connections close automatically
- Move the repeated printing code into a helper method
- Store database credentials in a config file or environment variables
