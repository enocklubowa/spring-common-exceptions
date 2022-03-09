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
  <version>0.1.1</version>
</dependency>
```

For Gradle projects:

```
implementation 'com.enocklubowa:spring-common-exceptions:0.1.0'
```

For Gradle Kotlin DSL projects:

```
implementation("com.enocklubowa:spring-common-exceptions:0.1.0")
```
Scan for the components in the library with

```java
@SpringBootApplication(scanBasePackages = {"com.enocklubowa.springcommonexceptions", "your other packages"})
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

}

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
### Additional Exception Handling

If you are using the native Spring validation on your request objects then you can customize the response a client receives by extending `ResponseEntityExceptionHandler`.

Create a class for example `CustomValidationResponse`

```java
@ControllerAdvice
public class GeneralExceptionAdvice extends ResponseEntityExceptionHandler {
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return generateValidationError(ex);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse error = new ErrorResponse("Message not readable", null);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return generateValidationError(ex);
    }

    private ResponseEntity<Object> generateValidationError(BindException ex){
        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()){
            details.add(error.getDefaultMessage());
        }

        ErrorResponse error = new ErrorResponse("Validation Failed", details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
```
The class above uses an `ErrorResponse` class I already included in the library for standard error parsing.

`handleMethodArgumentNotValid` is called when an argument annotated with `@Valid` fails.

`handleHttpMessageNotReadable` is called when a request body is completely out of this world.

`handleBindException` is called when there are fatal binding errors.

You can override more methods from `ResponseEntityExceptionHandler` in case you need more customization, but you have to do this in only one class so that the application doesn't have conflicts on how to respond to the requesting system.
