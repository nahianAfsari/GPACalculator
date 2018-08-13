/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpacalculator;

import static gpacalculator.GPACalculator.courseList;
import gpacalculator.LinkedList.Node;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author nahianAfsari
 */
public class FileIO {
    
    public void openFileForUser()
    { 
       Scanner input = new Scanner(System.in);
       
       String fileName = "";
       String password = "";
       String validUser = "";
       String validPass = "";
       boolean access = false;
       
       System.out.println("Please enter your file name. For ex : \"file.txt\"");
       
       fileName = input.next();
       
       
       while(fileName.equals(null))
       {
          System.out.println("Please enter your valid file name. For ex : \"file.txt\"");
          fileName = input.next();
          
       }
       
       
       
     
       
       try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String info;
            String[] arr;
            String courseName;
            String grade;
            int hours;
            double g; //grade converted from 'string grade'
            
            System.out.println("Courses added  : ");
            while ((info = in.readLine()) != null) {
               arr=info.split(",");
               
               if(arr.length != 3 )
               {
                   throw new InputMismatchException();
               }
               
               System.out.println("class : " + arr[0] + " Grade : "+ arr[1] + " Hours : "+arr[2]);
               courseName = arr[0];
               grade = arr[1];
               hours = Integer.valueOf(arr[2]);
               g = calculateGrade(grade);
               Course course = new Course(courseName, hours, g);
               courseList.addCourse(course);
               
               
               
            }
            in.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
       catch (InputMismatchException i)
       {
           System.out.println("Input file must contain ALL 3 values(Course name, grade, hours) separated by a comma");
           System.out.println("For ex : CS3340, A-, 3");
           
       }
      
       
    
    }
    
    public double calculateGrade(String grade)
    {
        double g;//grade
        Scanner keyboard = new Scanner(System.in);
        Character minValue = 'A';
        Character maxValue = 'F';
        grade = grade.toUpperCase();
        Character input = grade.charAt(0);
         while(input < minValue || input > maxValue)
         {
             System.out.println("Please enter a valid letter grade you received for the course between 'A+' and 'F' ");
             grade = (keyboard.next()).toUpperCase();
             input = grade.charAt(0);
         }
         switch(grade){
             case "A+" : g = 4;
                         break;
                         
             case "A"  : g = 4;
                         break;
             case "A-" : g = 3.67;
                         break;
             case "B+" : g = 3.33;
                         break;
             case "B" :  g = 3;
                         break;
                         
             case "B-" : g = 2.67;
                         break;
             case "C+" : g = 2.33;
                         break;
             case "C" :  g = 2;
                         break;
             case "C-" : g = 1.67;
                         break;
             case "D+" : g = 1.33;
                         break;
             case "D" :  g = 1;
                         break;
             case "D-" : g = .67;
                         break;
             case "F" :  g = 0;
                         break;
             default   : g = 0;
                         break;
         }
         
         return g;
    }
    public void makeListForUser(Node head)
    {
        try{
           PrintWriter writer = new PrintWriter("courseList.txt", "UTF-8");
           Node currNode = head;
           while(currNode != null)
           {
               writer.println(currNode.getData().toString());
               currNode = currNode.getNext();
           }
            writer.close();
            
        }
        catch(IOException e)
        {
            System.out.println("Could not write to file named \"courseList.txt\"");
        }
    }
    
    
}
