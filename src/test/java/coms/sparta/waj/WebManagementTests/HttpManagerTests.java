package coms.sparta.waj.WebManagementTests;

import coms.sparta.waj.Utility.PropertiesReader;
import coms.sparta.waj.webmanagement.HttpManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class HttpManagerTests
{
    private static HttpManager manager;
    private static PropertiesReader propertiesReader;

    @BeforeClass
    public static void setUp()
    {
        manager = new HttpManager();
        propertiesReader = new PropertiesReader();
    }

    //regex match checks that the string is bounded by square brackets. i.e. that
    //an array is returned.
    @Test
    public void testUsersRetrieval()
    {
        String returnString = manager.getAllUserJson();
        System.out.println(returnString);
        Assert.assertTrue(returnString.matches("\\u005b[\\s\\S]*\\u005d"));
    }

    //Checks that the string is bounded by braces, so not an array.
    @Test
    public void testSingleUserRetrieval()
    {
        String returnString = manager.getSingleUserJson();
        System.out.println(returnString);
        Assert.assertTrue(returnString.matches("\\u007b[\\s\\S]*\\u007d"));
    }







}
