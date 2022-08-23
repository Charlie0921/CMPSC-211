/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author kunmi
 */
public class StudentQueries {
    
    private static Connection connection;
    private static PreparedStatement addStudent;
    private static PreparedStatement selectAllStudents;
    private static ResultSet resultSet;
    
    public static void addStudent(StudentEntry student)
    {
        connection = DBConnection.getConnection();
        String studentID = student.getStudentID();
        String FirstName = student.getFirstName();
        String LastName = student.getLastName();
        
        try
        {
            addStudent = connection.prepareStatement(
                    "insert into app.student" +
                    "(studentID, FirstName, LastName)" +
                    "values (?,?,?)");
            addStudent.setString(1,studentID);
            addStudent.setString(2,FirstName);
            addStudent.setString(3,LastName);
            addStudent.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    public static ArrayList<StudentEntry> getAllStudents()
    {
        connection = DBConnection.getConnection();
        ArrayList<StudentEntry> studentsList = new ArrayList<StudentEntry>();
        try
        {
            selectAllStudents = connection.prepareStatement("select * FROM APP.STUDENT");
            resultSet = selectAllStudents.executeQuery();
            
            while(resultSet.next())
            {
                studentsList.add(new StudentEntry(
                resultSet.getString("studentID"),
                resultSet.getString("FirstName"),
                resultSet.getString("LastName")));
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace(); 
        }
        return studentsList;
    }
    
}
