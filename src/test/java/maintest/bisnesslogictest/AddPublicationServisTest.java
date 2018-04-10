package maintest.bisnesslogictest;

import mainpackage.bisnesslogic.Error;
import mainpackage.bisnesslogic.addpublication.AddPublicationResponse;
import mainpackage.bisnesslogic.addpublication.AddPublicationServiss;
import mainpackage.bisnesslogic.addpublication.AddPublicationValidator;
import mainpackage.database.PublicationDataBase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class AddPublicationServisTest {

    private PublicationDataBase database;
    private AddPublicationValidator validator;
    private AddPublicationServiss service;


    @Before
    public void init() {
        database = Mockito.mock(PublicationDataBase.class);
        validator = Mockito.mock(AddPublicationValidator.class);
        service = new AddPublicationServiss(database, validator);
    }


    @Test
    public void shouldReturnSuccess() {
        List<Error> errors = new ArrayList<>();
        Mockito.when(validator.validate("title", "desc"))
                .thenReturn(errors);

        AddPublicationResponse response = service.addPublication("title", "desc");

        assertEquals(response.isSuccess(), true);
        assertEquals(response.getErrors(), null);
    }


    @Test
    public void shouldReturnFail() {
        List<Error> errors = new ArrayList<>();
        errors.add(new Error("title", "errortitle"));
        Mockito.when(validator.validate(null, "desc"))
                .thenReturn(errors);

        AddPublicationResponse response = service.addPublication(null, "desc");

        assertEquals(response.isSuccess(), false);
        assertEquals(response.getErrors(), errors);
    }




}
