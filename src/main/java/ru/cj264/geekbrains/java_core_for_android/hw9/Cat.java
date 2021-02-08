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

    Statement statement;

    public Cat(String name, LocalDate birthday, String color, String breed) {
        this.name = name;
        this.birthday = birthday;
        this.color = color;
        this.breed = breed;
    }

    public Cat(long id) {
        this.id = id;
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

    public long create() throws SQLException {
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

    public void read() throws SQLException {
        ResultSet rs = statement.executeQuery(
                String.format("SELECT * FROM `Cats` WHERE `CatID` = %s;", id)
        );

        while (rs.next()) {
            name = rs.getString("Name");
            birthday = LocalDate.parse(rs.getString("Birthday"));
            color = rs.getString("Color");
            breed = rs.getString("Breed");
        }
    }

    public int delete() throws SQLException {
        return statement.executeUpdate(
                String.format("DELETE FROM `Cats` WHERE `CatID` = %s;", id)
        );
    }

    public int setBirthday(LocalDate birthday) throws SQLException {
        this.birthday = birthday;
        return statement.executeUpdate(
                String.format("UPDATE `Cats` SET `Birthday` = '%s' WHERE `CatID` = %s;", birthday, id)
        );
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
