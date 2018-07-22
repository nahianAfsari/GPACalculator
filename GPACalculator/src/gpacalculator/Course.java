/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpacalculator;

/**
 *
 * @author nahianAfsari
 */
public class Course {
    
    String course;
    int hours;
    String grade;
    
   
    
    Course(String c, int h, String g)
    {
       
        course = c;
        hours = h;
        grade = g;
        
    }
    
    public String toString()
    {
        return course+":"+grade;
    }
    
   
    
    
}
