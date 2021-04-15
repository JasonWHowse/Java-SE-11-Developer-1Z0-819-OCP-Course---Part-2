/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 15: Database Applications with JDBC
Topic:  CRUD operations
*/

import java.sql.*;
import java.util.Random;

public class CRUDExamples {

    public static void main(String[] args) throws SQLException {

        // Wrap connection in a try-with-resources,
        // so connection automatically gets closed
        try (Connection connection =
                     ConnectionExamples.getConnection(
                             ConnectionExamples.derbyFileConnectionString)) {
            // Example of DDL -
            ConnectionExamples.createTable(connection);

            // Example of DML - create data
            addData(connection);

            // Example of DML - get (read) data
            getData(connection);

            // Example of DML - update data
            updateData(connection, "April", 21);

            // Example of DML - delete data
            deleteData(connection, 104);

            // Example of DML - get (read) data
            getData(connection);

            ConnectionExamples.dropTable(connection);

        }//try (Connection connection =

    }//public static void main(String[] args) throws SQLException {

    // insert a row of data into table
    public static void addData(Connection connection)
            throws SQLException {

        String[] names = {"Joe", "Carol", "April", "June", "Mark", "Don"};
        Random r = new Random();

        String insertSQL =
                "insert into PERSON (PERSON_ID, NAME, AGE) " +
                        "Values(?, ?, ?)";

        try (PreparedStatement stmt =
                     connection.prepareStatement(insertSQL)) {

            for (int i = 0; i < names.length; i++) {
                stmt.setInt(1, 101 + i);
                stmt.setObject(2, names[i]);
                stmt.setInt(3, r.nextInt(70));
                if (stmt.executeUpdate() == 1) {
                    System.out.println(names[i] + " was inserted");
                }//if (stmt.executeUpdate() == 1) {
            }//for (int i = 0; i < names.length; i++) {
        }//try (PreparedStatement stmt =
    }//public static void addData(Connection connection)

    // get data from a table
    public static void getData(Connection connection) throws SQLException {

        // Wild card * in select statement selects all column's data
        // for a record
        String retrieveSQL =
                "select * from PERSON ";

        try (Statement stmt = connection.createStatement()) {

            // ResultSet will be closed automatically when statement is
            // closed
            ResultSet rs = stmt.executeQuery(retrieveSQL);

            int columnCount = 0;

            if (rs != null) {
                // Use meta data to get information about the result set
                columnCount = rs.getMetaData().getColumnCount();
            }//if (rs != null) {

            // Result set is an iterable set of data, here representing
            // records returned from the select statement
            while (rs.next()) {
                // Loop through each column.  ResultSet meta data index
                // starts with 1, not 0.
                for (int i = 1; i <= columnCount; i++) {
                    // Print out column name and value.
                    System.out.print(((i > 1) ? ", " : "") +
                            // Get column name from meta data.
                            rs.getMetaData().getColumnName(i)
                            // Get data from result set
                            + " = " + rs.getObject(i));
                }//for (int i = 1; i <= columnCount; i++) {
                System.out.println();
            }//while (rs.next()) {
        }//try (Statement stmt = connection.createStatement()) {
    }//public static void getData(Connection connection) throws SQLException {

    // update data in a single record in table
    public static void updateData(Connection connection,
                                  String name, int age)
            throws SQLException {

        String updateSQL =
                "UPDATE PERSON SET AGE = ? WHERE NAME = ?";

        try (PreparedStatement stmt =
                     connection.prepareStatement(updateSQL)) {
            stmt.setInt(1, age);
            stmt.setObject(2, name);
            if (stmt.executeUpdate() == 1) {
                System.out.println(name + " was updated");
            }//if (stmt.executeUpdate() == 1) {

        }//try (PreparedStatement stmt =
    }//public static void updateData(Connection connection,

    // delete a record from table
    public static void deleteData(Connection connection, int person_id)
            throws SQLException {

        String deleteSQL =
                "DELETE FROM PERSON WHERE PERSON_ID = ?";

        try (PreparedStatement stmt =
                     connection.prepareStatement(deleteSQL)) {

            stmt.setInt(1, person_id);
            if (stmt.executeUpdate() == 1) {
                System.out.println(person_id + " was deleted");
            }//if (stmt.executeUpdate() == 1) {
        }//try (PreparedStatement stmt =
    }//public static void deleteData(Connection connection, int person_id)
}//public class CRUDExamples {