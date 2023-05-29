package utilities.exceptions;

public class PropertyNotFound extends Throwable{
    public PropertyNotFound(String key){
        super("Property: "+key+" not found in properties file");
    }
}
