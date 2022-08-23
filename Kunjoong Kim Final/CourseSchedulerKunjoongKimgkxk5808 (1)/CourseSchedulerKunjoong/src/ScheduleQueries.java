/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Timestamp;
/**
 *
 * @author kunmi
 */
public class ScheduleQueries {
    
    private static Connection connection;
    private static PreparedStatement addScheduleEntry;
    private static PreparedStatement selectStudentCourse;
    private static PreparedStatement selectedCount;
    private static ResultSet resultSet;
    
    
    public static void addScheduleEntry(ScheduleEntry entry)
    {
        connection = DBConnection.getConnection();
        String semester = entry.getSemester();
        String courseCode = entry.getCourseCode();
        String studentID = entry.getStudentID();
        String status = entry.getStatus();
        Timestamp timeStamp = entry.getTimestamp();
        
        try
        {
            addScheduleEntry = connection.prepareStatement(
            "insert into app.schedule" +
            "(semester, courseCode, studentID, status, timestamp)" +
            "values (?,?,?,?,?)");
            addScheduleEntry.setString(1, semester);
            addScheduleEntry.setString(2, courseCode);
            addScheduleEntry.setString(3, studentID);
            addScheduleEntry.setString(4, status);
            addScheduleEntry.setTimestamp(5, timeStamp);
            addScheduleEntry.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
    public static ArrayList<ScheduleEntry> getScheduleByStudent(String semester, String studentID)
    {
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> scheduleList = new ArrayList<ScheduleEntry>();
        try
        {
            selectStudentCourse = connection.prepareStatement("SELECT * FROM APP.SCHEDULE "
                    + "WHERE semester = (?) AND studentID = (?)");
            selectStudentCourse.setString(1, semester);
            selectStudentCourse.setString(2, studentID);
            resultSet = selectStudentCourse.executeQuery();
            
            while (resultSet.next())
            {
                scheduleList.add(new ScheduleEntry(
                resultSet.getString("semester"),
                resultSet.getString("courseCode"),
                resultSet.getString("studentID"),
                resultSet.getString("status"),
                resultSet.getTimestamp("timeStamp")));
            }
            
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return scheduleList;
    }
    
    public static int getScheduledStudentCount(String currentSemester, String courseCode)
    {
        connection = DBConnection.getConnection();
        int studentCount = 0;
        
        try
        {
            selectedCount = connection.prepareStatement("SELECT count(STUDENTID) FROM APP.SCHEDULE WHERE semester = (?) and courseCode = (?)");
            selectedCount.setString(1, currentSemester);
            selectedCount.setString(2, courseCode);
            resultSet = selectedCount.executeQuery();
            if (resultSet.next()){
                studentCount = resultSet.getInt(1);
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return studentCount;
    }
}
