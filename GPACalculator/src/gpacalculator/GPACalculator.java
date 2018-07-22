/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpacalculator;

import java.util.Scanner;

/**
 *
 * @author nahianAfsari
 */

public class GPACalculator {
public static LinkedList courseList = new LinkedList();
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
       
        mainMenu();
        if(courseList != null)
        {
            courseList.printList();
        }
        else
        {
            System.out.println("Course list is empty");
        }
    }
     public static void manualInput(){
         
         String courseName = "0";
         String grade;
         int hour;
         
         Scanner keyboard = new Scanner(System.in);
         System.out.println("Please enter the course name or enter 0 to return to main menu");
         courseName = keyboard.next();
         while(!courseName.equals("0")){
         //****Remeber to implement input validation*****
         System.out.println("Please enter the number of credit hours you received for the course");
         hour = keyboard.nextInt();
         System.out.println("Please enter the letter grade you received for the course");
         grade = keyboard.next();
         Course course = new Course(courseName, hour, grade);
         courseList.addCourse(course);
         
         System.out.println("Please enter the course name or press 0 to return to main menu");
         courseName = keyboard.next();
         }
         mainMenu();
        
           
         
        
    }
     public static void experimentGPA()
     {
          
     }
     
     public static void mainMenu()
     {
          Scanner keyboard = new Scanner(System.in);
         
         int option = 0;
         System.out.println("Main Menu");
         System.out.println("Please enter an option number to continue. For example : 2");
         System.out.println("1. I have a file to input my grades");
         System.out.println("2. I will manually input my grades");
         System.out.println("3. I want to experiment with my GPA");
         System.out.println("4. Exit the program");
         option = keyboard.nextInt();
         while(option != 1 && option != 2 && option != 3 && option != 4)
         {
            System.out.println("Please select a valid option number : ");
            System.out.println("Main Menu");
            System.out.println("Please enter an option number to continue. For example : 2");
            System.out.println("1. I have a file to input my grades");
            System.out.println("2. I will manually input my grades");
            System.out.println("3. I want to experiment with my GPA");
            System.out.println("4. Exit the program");
            option = keyboard.nextInt();
             
         }
         
         if(option == 2)
         {
             manualInput();
             
         }
         if(option == 3)
         {
             experimentGPA();
         }
         if(option == 4)
         {
             
         }
     }
   
    
}
