# spring-common-exceptions
Common Spring boot exceptions
A library that sets up the common exceptions encountered in a Spring boot project.

### Scenarios catered for include
- Entity not found
- Entity already exits
- Invalid identifier provided for example if you try to get a user with a `String` id yet a `Long` id is expected
- General error for other scenarios

### Usage
For example during a user creation, you will have to test if there's already a user with the specified username.
You can do a check like one below and if it fails, then throw exception with details about the User class and the indentifier.

**Note**: The identifier can either be a `String` or a `Long`

```java
if(userRepository.findByIdEquals(user.getId()).isEmpty()){
    throw new NotFoundException(User.class, user.getId());
}
else if(userRepository.findByUsername(user.getUsername()).isPresent()){
    throw new AlreadyExistsException(User.class, user.getUsername());
}
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
