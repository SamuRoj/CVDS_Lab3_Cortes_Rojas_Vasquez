package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person person = new Person("Samuel", 1, 21, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validateDuplicated() {
        Person person = new Person("Samuel", 1, 21, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Person person2 = new Person("Sebastián", 1, 21, Gender.MALE, true);
        result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }

    @Test
    public void validateDead() {
        Person person = new Person("Samuel", 1, 21, Gender.MALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void validateUnderAge() {
        Person person = new Person("Samuel", 1, 17, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validateInvalidAge() {
        Person person = new Person("Samuel", 1, -1, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void validateOverTheAge() {
        Person person = new Person("Samuel", 1, 101, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    // TODO Complete with more test cases
}