/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 15: Database Applications with JDBC
Topic:  CallableStatement
*/

import java.math.BigDecimal;
import java.sql.*;

public class CallableExample {
    public static void main(String[] args) throws SQLException {

        // Wrap connection in a try-with-resources, so connection
        // automatically closed when completes or gets exception
        try (Connection connection =
                     ConnectionExamples.getConnection(
                             ConnectionExamples.derbyFileConnectionString);
        ) {
            // This method will create derby table PERSONS and populate
            // with data.
            setUpData(connection);

            // Retrieve and Print List of Person
            CRUDExamples.getPersonList(connection)
                    .forEach(System.out::println);

            // Execute DDL to create average stored procedure in DERBY
            createFunctionForDerby(connection);

            // Execute the stored procedure to get average age.
            int averageAge = executeAvgStoredProcedure(connection);
            System.out.println("The average age of population = " +
                    averageAge);

            // Execute DDL to create the stored procedure in DERBY
            createProcForDerby(connection);

            // Execute the stored procedure with different values
            executeStoredProcedure(connection, "CHANGED NAME TO BOB", 101);
            executeStoredProcedure(connection, "CHANGED NAME TO CAROL", 102);

            // Retrieve and Print List of Person
            CRUDExamples.getPersonList(connection)
                    .forEach(System.out::println);

            // Execute DDL to create the stored procedure in DERBY
            createProcForDerby(connection);

            // Execute the stored procedure with different values
            executeStoredProcedure(connection, "CHANGED NAME TO BOB", 101);
            executeStoredProcedure(connection, "CHANGED NAME TO CAROL", 102);

            // Retrieve and Print List of Person
            CRUDExamples.getPersonList(connection)
                    .forEach(System.out::println);

            // Retrieve and Print List of Person
            CRUDExamples.getPersonList(connection)
                    .forEach(System.out::println);

        }//try (Connection connection =
    }//public static void main(String[] args) throws SQLException {

    // Pass thru to other methods, to create a Table, PERSONS in the
    // Derby database, and add Data to it.
    public static void setUpData(Connection connection)
            throws SQLException {

        try {
            ConnectionExamples.dropTable(connection);
        } catch (SQLException se) {//try {
            System.out.println(se);
        }//catch (SQLException se) {

        // Example of DDL -
        ConnectionExamples.createTable(connection);

        // Example of DML - create data
        CRUDExamples.addData(connection);
    }//public static void setUpData(Connection connection)

    // This is the java method which the Derby stored procedure will execute.
    public static void javaUpdatePassThrough(String name, int personId)
            throws SQLException {

        // Java code to do the actual update
        String query = "update person set name = ? where person_id = ?";

        try (Connection connection =
                     ConnectionExamples.getConnection(
                             ConnectionExamples.derbyFileConnectionString);
             PreparedStatement pstmt = connection.prepareStatement(query)
        ) {
            pstmt.setString(1, name);
            pstmt.setInt(2, personId);
            int result = pstmt.executeUpdate();
            if (result == 1) System.out.println("Row was updated");

        }//try (Connection connection =
    }//public static void javaUpdatePassThrough(String name, int personId)

    // Method creates a stored procedure in Derby based on java code
    public static void createProcForDerby(Connection connection)
            throws SQLException {

        // Derby let's you create a stored procedure based on java code,
        // in this case, the method CallableExample.testProc is defined in
        // current class.
        String createProcedure =
                "create procedure" +
                        " UPDATE_PERSON(" +
                        "IN name VARCHAR(255)," +
                        "IN pid INTEGER) " +
                        "PARAMETER STYLE JAVA READS SQL" +
                        " DATA LANGUAGE JAVA EXTERNAL NAME " +
                        "'CallableExample.javaUpdatePassThrough'";

        try (Statement stmt = connection.createStatement()) {
            try {
                // First drop Procedure
                stmt.execute("drop procedure UPDATE_PERSON");
            } catch (Exception e) {//try {
                // Ignore error, might occur if procedure does not exist
            }//catch (Exception e) {
            // Create the stored procedure in Derby
            stmt.executeUpdate(createProcedure);

        }//try (Statement stmt = connection.createStatement()) {
    }//public static void createProcForDerby(Connection connection)

    // Executes the Derby stored procedure, keeps connection open
    public static void executeStoredProcedure(
            Connection connection, String name, int personId)
            throws SQLException {

        try (
                // CallableStatement similar to PreparedStatement except
                // calls a named stored procedure and passes it values
                CallableStatement cs =
                        connection.prepareCall("{ call UPDATE_PERSON(?, ?)}")) {
            cs.setString(1, name);
            cs.setInt(2, personId);
            cs.execute();
        }//try (
    }//public static void executeStoredProcedure(

    // This is the java method which the Derby stored procedure will execute.
    public static void javaGetAverageMethod(BigDecimal[] n)
            throws SQLException {

        int average = -1;
        // Java code to do the actual update
        String query = "select AVG(age) from PERSON";

        try (Connection connection =
                     ConnectionExamples.getConnection(
                             ConnectionExamples.derbyFileConnectionString);
             PreparedStatement pstmt = connection.prepareStatement(query)
        ) {
            ResultSet rs  = pstmt.executeQuery();

            if (rs.next()) {
                n[0] = rs.getBigDecimal(1);
            }//if (rs.next()) {
        }//try (Connection connection =
    }//public static void javaGetAverageMethod(BigDecimal[] n)

    // Method creates a stored procedure in Derby based on java code
    public static void createFunctionForDerby(Connection connection)
            throws SQLException {

        // Derby let's you create a stored procedure based on java code,
        // this case, the method CallableExample.testProc defined in this
        // class - real world stored procedure would exist in your database
        String createProcedure =
                "create procedure" +
                        " GET_AVERAGE(" +
                        " OUT DECIMAL) " +
                        "PARAMETER STYLE JAVA READS SQL" +
                        " DATA LANGUAGE JAVA EXTERNAL NAME " +
                        "'CallableExample.javaGetAverageMethod'";

        try (Statement stmt = connection.createStatement()) {
            try {
                // First drop Procedure
                stmt.execute("drop procedure GET_AVERAGE");
            } catch (Exception e) {//try {
                // Ignore error, might occur if procedure does not exist
            }//catch (Exception e) {
            // Create the stored procedure in Derby
            stmt.executeUpdate(createProcedure);

        }//try (Statement stmt = connection.createStatement()) {
    }//public static void createFunctionForDerby(Connection connection)

    // Executes the Derby stored procedure, keeps connection open
    public static int executeAvgStoredProcedure(Connection connection)
            throws SQLException {

        int average = -1;
        try (
                // CallableStatement similar to PreparedStatement except
                // calls a named stored procedure and passes it values
                CallableStatement cs =
                        connection.prepareCall("{ call GET_AVERAGE(?)}")) {
            cs.registerOutParameter(1, Types.DECIMAL);
            cs.execute();
            BigDecimal bigDecimal = cs.getBigDecimal(1);

            average = bigDecimal.intValue();
        }//try (
        return average;
    }//public static int executeAvgStoredProcedure(Connection connection)
}//public class CallableExample {