package edu.eci.cvds.tdd.registry;
import java.util.*;

public class Registry {
    ArrayList<Integer> ids = new ArrayList<Integer>(); 
    
    public boolean verifyAge(int age){
        if(age > 0 && age < 100) return true;
        return false;
    }
    
    public RegisterResult registerVoter(Person p) {
        // TODO Validate person and return real result.
        int age = p.getAge();
        boolean alive = p.isAlive();
        int id = p.getId();

        if(!alive) return RegisterResult.DEAD;
        else if (!verifyAge(age)) return RegisterResult.INVALID_AGE;
        else if(age < 18) return RegisterResult.UNDERAGE;
        else if (ids.contains(id)) return RegisterResult.DUPLICATED;

        ids.add(id);
        return RegisterResult.VALID;
    }
}