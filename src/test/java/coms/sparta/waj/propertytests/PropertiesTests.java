package coms.sparta.waj.propertytests;

import coms.sparta.waj.Utility.PropertiesReader;
import org.junit.Test;

public class PropertiesTests
{
    PropertiesReader reader = new PropertiesReader();

    //Checking that the exception throws when the user_id field is blank.
    //Properties file must be manually updated for this to work.
    @Test
    public void testException()
    {
        System.out.println(reader.getSingleUserUrl());
    }


}
