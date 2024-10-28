package dev.v3ktor.minimaltask.exception;

public class EntityNotFindException extends RuntimeException {
    public EntityNotFindException(String message) { super(message); }
}
