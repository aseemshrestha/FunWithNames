package exceptions;

public class FileNameNotFoundException extends Exception {
    public FileNameNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
