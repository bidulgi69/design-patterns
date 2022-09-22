class FileExtensionNotSupportedException extends Throwable {
    public FileExtensionNotSupportedException(String message) {
        super(message);
    }

    public FileExtensionNotSupportedException(String message, Throwable throwable) {
        super(message, throwable);
    }
}