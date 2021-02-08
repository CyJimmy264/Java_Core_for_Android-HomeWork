package ru.cj264.geekbrains.java_core_for_android.hw9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Main {
    private static Connection connection;
    private static Statement statement;

    private static String dropCats = "DROP TABLE IF EXISTS `Cats`;";
    private static String primaryLoad =
        "CREATE TABLE IF NOT EXISTS `Cats` (" +
        "  `CatID` INTEGER NOT NULL," +
        "  `Name` TEXT NOT NULL," +
        "  `Birthday` DATE NOT NULL," +
        "  `Color` TEXT NOT NULL," +
        "  `Breed` TEXT NOT NULL," +
        "  PRIMARY KEY(`CatID` AUTOINCREMENT)" +
        ");";

    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:cats.db");
    }

    private static void close() throws SQLException {
        connection.close();
    }

    private static void database() {
        try {
            connect();

            statement = connection.createStatement();
            statement.execute(dropCats);
            statement.execute(primaryLoad);

            Cat cat = new Cat("Barsik", LocalDate.of(2007, 11, 13),
                    "white and black", "siamese");

            long catId = cat.create(statement);
            System.out.println("Cat record with id " + catId + " created");

            close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 1. Создать класс кота

        // 2. Создать в бд таблицу с котами
        // 4. Метод добавления котов

        // 3. Написать метод извлечения котов
        // 5. Метод удаления котов
        // 6. Метод изменения котов
        database();
    }
}
