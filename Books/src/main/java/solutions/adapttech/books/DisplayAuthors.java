/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solutions.adapttech.books;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DisplayAuthors {
   public static void main(String args[]) {
      final String DATABASE_URL = "jdbc:derby:books";        
      final String SELECT_QUERY =                            
        //"SELECT firstName, lastName FROM authors";
        /*"SELECT authorID, firstName, lastName, title, copyright, isbn "
              +"FROM authorISBN "
              + "WHERE authorID Like '3'"
              + "INNER JOIN titles"
              + "ON authorID.titles = titles.lastName"
              + "ORDER BY copyright DESC";*/
        /*"SELECT title, firstName, lastName "
              + "FROM titles"
              + "WHERE isbn Like '0132151006'"
              + "INNER JOIN authors"
              + "ON titles.isbn = title.author"
              + "ORDER BY lastName, firstName DESC";*/
        /*"SELECT firstName, lastName, ISBN"
              + "FROM authors"
              + "INNER JOIN AuthorISBN"
              + "ON authors.authorID = authorISBN.AuthorID"
              + "ORDER BY lastName, firstName ASC";*/
        "SELECT authorID, firstName, lastName"
              + "FROM authors"
              + "ORDER BY firstName, lastName ASC";
         

      // use try-with-resources to connect to and query the database
      try (                                                        
         Connection connection = DriverManager.getConnection(      
            DATABASE_URL, "deitel", "deitel");                     
         Statement statement = connection.createStatement();       
         ResultSet resultSet = statement.executeQuery(SELECT_QUERY)) {

         // get ResultSet's meta data
         ResultSetMetaData metaData = resultSet.getMetaData();
         int numberOfColumns = metaData.getColumnCount();     
         
         System.out.printf("Authors Table of Books Database:%n%n");

         // display the names of the columns in the ResultSet
         for (int i = 1; i <= numberOfColumns; i++) {
            System.out.printf("%-8s\t", metaData.getColumnName(i));
         }
         System.out.println();
         
         // display query results
         while (resultSet.next()) {
            for (int i = 1; i <= numberOfColumns; i++) {
               System.out.printf("%-8s\t", resultSet.getObject(i));
            }
            System.out.println();
         } 
      }
      catch (SQLException sqlException) {
         sqlException.printStackTrace();
      }                                                   
   } 
} 
