package trianglecheck;

/**
 * Project: 15. Exception & Debug
 * Package: trianglecheck
 * User: lomahs
 * Date time: 11/06/2021 18:18
 * Created with IntelliJ IDEA
 */
public class IllegalTriangleException extends Exception{
    private String message;

    public IllegalTriangleException(String message){
        this.message = message;
    }

    public String getMessage(){
        return "Illegal Triangle";
    }
}
