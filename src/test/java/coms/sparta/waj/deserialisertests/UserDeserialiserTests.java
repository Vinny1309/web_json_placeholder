package coms.sparta.waj.deserialisertests;

import coms.sparta.waj.deserialisers.UserDeserialiser;
import coms.sparta.waj.dtos.UserDto;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDeserialiserTests
{
    private static final String FILE_LOC = "resources/user2.json";

    private static UserDeserialiser userDeserialiser;
    private static UserDto userDto;

    @BeforeClass
    public static void setUp()
    {
        userDeserialiser = new UserDeserialiser(FILE_LOC);
        userDto = userDeserialiser.getUserDto();
    }

    @Test
    public void testUsername()
    {
        assertTrue(userDto.getUsername().contains("Anton"));
    }

    @Test
    public void testStreet()
    {
        assertTrue(userDto.getAddress().getZipcode().contains("90566"));
    }

    @Test
    public void testLat()
    {
        assertTrue(userDto.getAddress().getGeo().getLng().contains("-34.4"));
    }

    @Test
    public void testPhrase()
    {
        assertTrue(userDto.getCompany().getCatchPhrase().contains("didactic"));
    }





}
