public class ParametrosInvalidosException extends Exception {
    private static final String ERROR_MESSAGE = "O segundo parâmetro deve ser maior que o primeiro";

    public ParametrosInvalidosException() {
        super(ERROR_MESSAGE);
    }
}