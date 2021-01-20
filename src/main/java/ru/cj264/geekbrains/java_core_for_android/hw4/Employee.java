package ru.cj264.geekbrains.java_core_for_android.hw4;

public class Employee {
    private String firstName;
    private String lastName;
    private String middleName;
    private String position;
    private String email;
    private String phoneNumber;
    private float salary;
    private int age;

    public Employee(String firstName, String lastName, String middleName, String position,
                    String email, String phoneNumber, float salary, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.printf("Employee: %s %s %s\nPosition: %s\nE-mail: %s\nPhone number: %s\nSalary: $%.2f\nAge: %d\n",
                firstName, middleName, lastName, position, email, phoneNumber, salary, age);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public float getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
}
