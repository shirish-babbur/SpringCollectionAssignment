package org.webonise.springcollectionassignment;

import java.util.Comparator;

public class UserComparator implements Comparator<Users> {
    public int compare(Users user1, Users user2) {
        int result = 0;
        result = user1.getId() - user2.getId();
        if (result == 0) {
            result = user1.getFirstName().compareTo(user2.getFirstName());
        } else if (result == 0) {
            result = user1.getLastName().compareTo(user2.getLastName());
        } else if (result == 0) {
            result = user1.getSalary() - user2.getSalary();
        } else if (result == 0) {
            result = user1.getAge() - user2.getAge();
        }
        return result;
    }
}
