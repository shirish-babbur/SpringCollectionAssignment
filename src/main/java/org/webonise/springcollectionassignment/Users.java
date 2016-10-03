package org.webonise.springcollectionassignment;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

public class Users {
    private static final Logger LOGGER = Logger.getLogger(Users.class.getName());
    @Autowired
    private LoggerManager loggerManager;
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void showDetails() {
        LOGGER.info(id + "\t" + firstName + "\t" + lastName + "\t");
        LOGGER.info(age + "\t" + email + "\t" + salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Users)) {
            return false;
        }
        Users users = (Users) o;
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(age, users.age).append(salary, users.salary).append(firstName, users.firstName);
        equalsBuilder.append(lastName, users.lastName).append(email, users.email).append(id, users.id);
        return equalsBuilder.isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(age).append(firstName).append(lastName).append(email).append(id);
        return hashCodeBuilder.toHashCode();
    }
}
