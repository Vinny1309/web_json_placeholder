package coms.sparta.waj.deserialisertests;

import coms.sparta.waj.deserialisers.UsersDeserialiser;
import coms.sparta.waj.dtos.UserDto;
import org.junit.BeforeClass;
import org.junit.Test;


import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

public class UsersDeserialiserTests
{
    private static UsersDeserialiser deserialiser;
    private static UserDto[] usersArray;
    private static List<UserDto> usersList;

    private static final String FILE_LOC = "resources/users.json";

    @BeforeClass
    public static void setUp()
    {
        deserialiser = new UsersDeserialiser(FILE_LOC);
        usersArray = deserialiser.getUsersDto();
        usersList = deserialiser.getUsersAsList();
    }

    //Tests that the array size and list size are the same
    @Test
    public void testSize()
    {
        assertEquals(usersArray.length, usersList.size());
    }

    //The assertion is to check that a null string is not returned
    @Test
    public void getNestedFromArray()
    {
        Random random = new Random();
        int index = random.nextInt(usersArray.length) - 1;

        assertTrue(usersArray[index].getAddress().getGeo().getLat().length() > 0);
    }

    @Test
    public void getNestedFromList()
    {
        Random random = new Random();
        int index = random.nextInt(usersList.size()) - 1;

        assertTrue(usersList.get(index).getAddress().getGeo().getLat().length() > 0);
    }


    //Not actually a test, utility to show some of the data being returned.
    @Test
    public void showSomeValuesFromMultiple()
    {
        Random random = new Random();

        int index = random.nextInt(usersList.size()) - 1;
        System.out.println("Sample data from element " + index);
        showSomeValues(index);

        System.out.println();

        index = random.nextInt(usersList.size()) - 1;
        System.out.println("Sample data from element " + index);
        showSomeValues(index);
    }

    private void showSomeValues(int element)
    {
        System.out.println();
        System.out.println("ID: " + usersList.get(element).getId());
        System.out.println("Username: " + usersList.get(element).getUsername());
        System.out.println("Address street: " + usersList.get(element).getAddress().getStreet());
        System.out.println("Address Latitude: " + usersList.get(element).getAddress().getGeo().getLat());
        System.out.println("Company Name: " + usersList.get(element).getCompany().getName());
    }



}
