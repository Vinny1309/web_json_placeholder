package coms.sparta.waj;

import coms.sparta.waj.deserialisers.UserDeserialiser;
import coms.sparta.waj.deserialisers.UsersDeserialiser;
import coms.sparta.waj.deserialisertests.UserDeserialiserTests;
import coms.sparta.waj.deserialisertests.UsersDeserialiserTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                UserDeserialiserTests.class,
                UsersDeserialiserTests.class
        }
)

public class TestRunner
{
}
