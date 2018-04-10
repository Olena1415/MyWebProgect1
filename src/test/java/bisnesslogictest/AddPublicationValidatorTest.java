package bisnesslogictest;
import mainpackage.bisnesslogic.addpublication.*;
import mainpackage.database.*;
import mainpackage.bisnesslogic.Error;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;





public class AddPublicationValidatorTest {

    private PublicationDataBase database;
    private AddPublicationValidator validator;

    @Before

    public void init() {
        database = Mockito.mock(PublicationDataBase.class);
        validator = new AddPublicationValidator(database);

    }

    @Test
    public void shouldReturnErrorWhenTitleIsNull() {
        List<Error> errors = validator.validate(null, "desc");
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "title");
        assertEquals(errors.get(0).getErrorMessage(), "Must not be empty");
    }



    // дописать тест с проверкой description  и копией title
}