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
public class CourseQueries {
    
    private static Connection connection;
    private static PreparedStatement addCourse;
    private static PreparedStatement selectAllCourses;
    private static PreparedStatement selectAllCourseCodes;
    private static PreparedStatement selectedSeat;
    private static ResultSet resultSet;
   
    
    public static ArrayList<CourseEntry> getAllCourses(String semester)
    {
        connection = DBConnection.getConnection();
        ArrayList<CourseEntry> results = null;
        try
        {
            selectAllCourses = connection.prepareStatement("SELECT * FROM APP.COURSE where semester = (?)");
            selectAllCourses.setString(1, semester);
            resultSet = selectAllCourses.executeQuery();
            results = new ArrayList<CourseEntry>();
            
            
            while (resultSet.next())
            {
                results.add(new CourseEntry(
                resultSet.getString("semester"),
                resultSet.getString("courseCode"),
                resultSet.getString("Description"),
                resultSet.getInt("seats")));
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return results;
    }
    
    public static void addCourse(CourseEntry Course){
        connection = DBConnection.getConnection();
        String semester = Course.getSemester();
        String courseCode = Course.getCourseCode();
        String courseDescription = Course.getCourseDescription();
        int seats = Course.getSeats();
        
        try
        {
            addCourse = connection.prepareStatement(
                    "insert into app.course" +
                    "(semester,courseCode,Description,seats)" +
                    "values (?,?,?,?)");
            addCourse.setString(1, semester);
            addCourse.setString(2,courseCode);
            addCourse.setString(3,courseDescription);
            addCourse.setInt(4, seats);
            addCourse.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
    public static ArrayList<String> getAllCourseCodes(String semester){
        connection = DBConnection.getConnection();
        ArrayList<String> courseCodeList = new ArrayList<String>();
        try
        {
            selectAllCourseCodes = connection.prepareStatement("SELECT COURSECODE FROM APP.COURSE where semester = (?)");
            selectAllCourseCodes.setString(1, semester);
            resultSet = selectAllCourseCodes.executeQuery();

            while (resultSet.next())
            {
                courseCodeList.add(resultSet.getString(1));
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return courseCodeList;
    }
    
    public static int getCourseSeats(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        int seats = 0;
        
        try
        {
            selectedSeat = connection.prepareStatement("SELECT SEATS FROM APP.COURSE WHERE semester = (?) and courseCode = (?)");
            selectedSeat.setString(1, semester);
            selectedSeat.setString(2, courseCode);
            resultSet = selectedSeat.executeQuery();
            if (resultSet.next()){
                seats = resultSet.getInt(1);
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return seats;
    }

}
