public class NoKeyOrValueException extends Exception {

    public NoKeyOrValueException() {
        System.out.println("Missing Key or value.");
    }

    public NoKeyOrValueException(String err) {
        System.out.println(err);
    }
}
