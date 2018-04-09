package bisnesslogic.addpublication;

import java.util.List;
import bisnesslogic.Error;



public class AddPublicationResponse {

    private boolean success;

    private List<Error> errors;


    public AddPublicationResponse(boolean success, List<Error> errors) {
        this.success = success;
        this.errors = errors;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }


}