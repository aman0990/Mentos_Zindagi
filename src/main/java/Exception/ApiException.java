package Exception;

class ApiException extends Exception{
    ApiException(int code, String msg) {
        super(msg);
    }
}