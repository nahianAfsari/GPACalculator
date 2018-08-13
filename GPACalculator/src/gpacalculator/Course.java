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
    double grade;
    
   
    
    Course(String c, int h, double g)
    {
       
        course = c;
        hours = h;
        grade = g;
        
    }
    
    public String toString()
    {
        return course+","+calculateGrade(grade)+","+hours;
    }
    public String calculateGrade(double grade)
    {
        String g = "";//grade
        if(grade == 4.0)
        {
            g = "A";
        }
        if(grade == 3.67)
        {
            g = "A-";
        }
        if(grade == 3.33)
        {
            g = "B+";
        }
        if(grade == 3)
        {
            g = "B";
        }
        if(grade == 2.67)
        {
            g = "B-";
        }
        if(grade == 2.33)
        {
            g = "C+";
        }
        if(grade == 2)
        {
            g = "C";
        }
        if(grade == 1.67)
        {
            g = "C-";
        }
        if(grade == 1.33)
        {
            g = "D+";
        }
        if(grade == 1)
        {
            g = "D";
        }
        if(grade == .67)
        {
            g = "D-";
        }
        if(grade == 0)
        {
            g = "F";
        }
       
        
         
         
        return g;
    }
    
   
    
    
}
