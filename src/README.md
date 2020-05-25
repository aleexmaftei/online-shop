## Clean-up details
Packages and files tagged as _**outdated**_ will pe removed soon!

# Packages
Below you can find how the project is divided in packages.
## com.company 
```
Contains the main function that initiate the project.
```
## connection
```
Contains the class that connects the project to the SQL database.
```
## domain.products
```
Contains the POJOs (Plain Old Java Objects).
```

## exceptions
**File _oudated_**: NotAdministratorException
```
Contains exception classes such as invalid data or not having administrator 
privileges.
```

## file_management (_**outdated**_)
```
Contains classes for reading and writing from/in a CSV file.
```

## files (_**outdated**_)
```
Contains the database of each type of product and the actions stamp that are 
executed during the execution of the program.
```

## permits (_**outdated**_)
```
Contains the singleton Administrator class that gives more privileges 
and control over the repositoriesand the Client class with normal privileges. 
```
## persistence
**Packages _oudated_**: alcohol_repository, gaming_consoles_repository, non_alcohol_repository
```
Contains the JDBC repositories for the products/objects.
```

## service
**Files _oudated_**: ManageRepositories, TimeStampWriterService
```
Contains the service class that manages the JDBC repositories for the 
products/objects.
```
