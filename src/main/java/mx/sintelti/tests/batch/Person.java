package mx.sintelti.tests.batch;

/**
 * Author: Javier Ramirez Jr
 * Date: 31/12/17
 * Time: 19:55
 * Project: SpringBatchTest
 * www.sintelti.mx
 */
public class Person{
    private String firstName;
    private String lastName;

    public Person() {}

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " + lastName;
    }
}