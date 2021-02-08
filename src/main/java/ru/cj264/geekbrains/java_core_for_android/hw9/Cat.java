package ru.cj264.geekbrains.java_core_for_android.hw9;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Cat {
    long id;
    String name;
    LocalDate birthday;
    String color;
    String breed;

    public Cat(String name, LocalDate birthday, String color, String breed) {
        this.name = name;
        this.birthday = birthday;
        this.color = color;
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", color='" + color + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }

    public long create(Statement statement) throws SQLException {
        int affectedRows = statement.executeUpdate(
                String.format("INSERT INTO `Cats` (`Name`, `Birthday`, `Color`, `Breed`) "+
                                "VALUES ('%s', '%s', '%s', '%s');",
                        name, birthday, color, breed)
        );

        if (affectedRows == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }

        ResultSet generatedKeys = statement.getGeneratedKeys();

        if (generatedKeys.next()) {
            id = generatedKeys.getLong(1);
        }
        else {
            throw new SQLException("Creating user failed, no ID obtained.");
        }

        return id;
    }
}
