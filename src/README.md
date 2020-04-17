# Packages
Below you can find how the project is divided in packages.
## com.company 
```
Contains the main function that initiate the project.
```

## domain.products
```
Contains the service class (ManageProducts) and POJOs (Plain Old Java Objects).
```

## exceptions
```
Contains exception classes such as invalid data or not having administrator 
privileges.
```

## file_management 
```
Contains classes for reading and writing from/in a CSV file.
```

## files
```
Contains the database of each type of product and the actions stamp that are 
executed during the execution of the program.
```

## permits
```
Contains the singleton Administrator class that gives more privileges 
and control over the repositoriesand the Client class with normal privileges. 
```
## persistence
```
Contains the repositories for the products/objects.
```

## service
```
Contains the service class that manages the repositories for the products/objects.
```
