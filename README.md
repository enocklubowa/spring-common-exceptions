# spring-common-exceptions
![build workflow](https://github.com/enocklubowa/spring-common-exceptions/actions/workflows/build.yml/badge.svg)

### Introduction
A library that sets up the common exceptions encountered in a Spring boot project.

### Scenarios catered for include
- Entity not found
- Entity already exits
- Invalid identifier provided for example if you try to get a user with a `String` id yet a `Long` id is expected
- General error for other scenarios

### Usage

#### Dependency

For Maven projects:

```
<dependency>
  <groupId>com.enocklubowa</groupId>
  <artifactId>spring-common-exceptions</artifactId>
  <version>0.0.1</version>
</dependency>
```

For Gradle projects:

```
implementation 'com.enocklubowa:spring-common-exceptions:0.0.1'
```

For Gradle Kotlin DSL projects:

```
implementation("com.enocklubowa:spring-common-exceptions:0.0.1")
```
#### Code

See available Exceptions classes [here](https://enocklubowa.com/spring-common-exceptions/com/enocklubowa/springcommonexceptions/exception/package-summary.html):

For example during a user update, you will have to test if there's a user with the specified username.
You can do a check like one below and if it fails, then throw exception with details about the User class and the indentifier.

**Note**: The identifier can either be a `String` or a `Long`

```java
if(userRepository.findByIdEquals(user.getId()).isEmpty()){
    throw new NotFoundException(User.class, user.getId());
}
// more code
```
You can still throw the exception by just providing customing message instead of the library default by:

```java
throw new AlreadyExistsException("The user already exists");
```

When these exceptions are thrown inside a controller method then an error with will be returned to the client in the format:

```json
{
    "message":"",
    "details":"",
    "timestamp":""
}
```
