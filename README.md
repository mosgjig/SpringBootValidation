## Synopsis

A simple web service that shows how Bean Validation is not being performed as expected.


## Installation

Pull and build & run with Maven.  Assure a local instance of mysql is running with default settings l/p of `root/root` (or adjust `pom.xml` properties) and schema `springbootvalidation` exists.

## Expectation

`UsersDAOIT.testSave_NullUsername()` should anticipate `ConstraintViolationException.class`

## Reality

`UsersDAOIT.testSave_NullUsername()` produces `org.springframework.orm.jpa.JpaSystemException` due to skipage of bean validation.