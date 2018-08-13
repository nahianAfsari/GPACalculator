
package gpacalculator;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author nahianAfsari
 */

public class GPACalculator {
public static LinkedList courseList = new LinkedList(); 
   
    
    public static void main(String[] args) {
        
       
        mainMenu();
        if(courseList != null)
        {
            courseList.printList();
            System.out.println("Making a .txt file named \"courseList.txt\" and printing the entire list of ");
            System.out.print("course in a format such that the file can be uploaded to the program for reading, experimenting and");
            System.out.print(" other modifications");
            FileIO io = new FileIO();
            io.makeListForUser(courseList.getHead());
        }
        else
        {
            System.out.println("Course list is empty");
        }
    }
     public static void manualInput(){
         
         String courseName = "0";
         String letterGrade = "";
         double grade;
         int hour;
         
         Scanner keyboard = new Scanner(System.in);
         System.out.println("Please enter the course name");
         courseName = keyboard.next();
         
         //****Remeber to implement input validation*****
         System.out.println("Please enter the number of credit hours you received for the course");
         hour = keyboard.nextInt();
         System.out.println("Please enter the letter grade you received for the course");
         letterGrade = (keyboard.next()).toUpperCase();
         Character minValue = 'A';
         Character maxValue = 'F';
         Character input = letterGrade.charAt(0);
         while(input < minValue || input > maxValue)
         {
             System.out.println("Please enter a valid letter grade you received for the course between 'A+' and 'F' ");
             letterGrade = (keyboard.next()).toUpperCase();
             input = letterGrade.charAt(0);
         }
         switch(letterGrade){
             case "A+" : grade = 4;
                         break;
                         
             case "A"  :  grade = 4;
                         break;
             case "A-" : grade = 3.67;
                         break;
             case "B+" : grade = 3.33;
                         break;
             case "B" : grade = 3;
                         break;
                         
             case "B-" : grade = 2.67;
                         break;
             case "C+" : grade = 2.33;
                         break;
             case "C" : grade = 2;
                         break;
             case "C-" : grade = 1.67;
                         break;
             case "D+" : grade = 1.33;
                         break;
             case "D" : grade = 1;
                         break;
             case "D-" : grade = .67;
                         break;
             case "F" : grade = 0;
                         break;
             default   : grade = 0;
                         break;
         }
         
         System.out.println(grade);
         Course course = new Course(courseName, hour, grade);
         courseList.addCourse(course);
         
        
        
           
         
        
    }
     public static void experimentGPA()
     {
         int option = 0;
         Scanner keyboard = new Scanner(System.in);
         System.out.println("What would you like to do?");
         System.out.println("Please enter an option number to continue. For example : 2");
         System.out.println("1. Calculate my GPA");
         System.out.println("2. Add temporary classes to see how GPA changes");
         System.out.println("3. Calculate grade needed to attain a specific GPA");
         System.out.println("4. Return to main menu");
         option = keyboard.nextInt();
            while(option != 1 && option != 2 && option != 3 && option != 4)
         {
            System.out.println("What would you like to do?");
            System.out.println("Please enter an option number to continue. For example : 2");
            System.out.println("1. Calculate my GPA");
            System.out.println("2. Add temporary classes to see how GPA changes");
            System.out.println("3. Calculate grade needed to attain a specific GPA");
            System.out.println("4. Return to main menu");
            option = keyboard.nextInt();
             
         }
        //creating a new class to do all the experiments on the gpa
        GPAExperiment experiment1 = new GPAExperiment(courseList.getHead());
        double avg = 0;
        DecimalFormat numberFormat = new DecimalFormat("#.00"); //limiting gpa to two decimal places
        avg = experiment1.calculateGPA();
        
         switch (option) {
             
             case 1 : System.out.println("Your GPA is : "+numberFormat.format(avg));
                      break;
             case 2 : String answer = "";
                      int numTemp = 0; //will track how many temporary classes were added 
                                       //so that it is easy to delete that many classes from the list
                 
                      do{
                          System.out.println("Would you like to add a temporary class?");
                          System.out.println("Enter Y for Yes or N for No");
                          answer = keyboard.next().toUpperCase();
                          
                          if(answer.equals("Y"))
                          {
                              manualInput();
                              numTemp++;
                          }
                          
                 
                       }
                       while(!answer.equals("N"));
                       GPAExperiment experiment2 = new GPAExperiment(courseList.getHead());
                       double tempAvg = 0.0; //temporary average for the new classes
                       tempAvg = experiment2.calculateGPA();
                       System.out.println("If you received the grades that you inputted, your GPA would be " + tempAvg);
                       courseList.deteteTempCourses(numTemp);
                       break;
             case 3 : double wantedGPA = 0;
                      double gradeNeeded = 0.0;
                      System.out.println("What GPA (on a 4.0 scale) would you like to attain?");
                      wantedGPA = keyboard.nextDouble();
                      while(wantedGPA < 0 || wantedGPA > 4)
                      {
                        System.out.println("The GPA you entered is not on a 4.0 scale. Please try again.");
                        System.out.println("What GPA (on a 4.0 scale) would you like to attain?");
                        wantedGPA = keyboard.nextInt();
                          
                      }
                      int hour = 0;
                      System.out.println("How many credit hours is the class?(the class you want to calculate the grade needed for)");
                      hour = keyboard.nextInt();
                      
                      gradeNeeded = (((wantedGPA)*(experiment1.getTotalHours() + hour))-(experiment1.getTotalAvg()))/(hour);
                      System.out.println(gradeNeeded);
                      if(gradeNeeded > 4.0)
                      {
                          System.out.println(wantedGPA + " is not attainable with "+hour+" credit hours");
                          mainMenu();
                      }
                    if(gradeNeeded > 3.67 && gradeNeeded <= 4.0)
                    {
                        System.out.println("Grade needed in the class to attain "+wantedGPA+" is an A+ or A");
                        mainMenu();
                    }
                     if(gradeNeeded > 3.33 && gradeNeeded <= 3.67)
                    {
                        System.out.println("Grade needed in the class to attain "+wantedGPA+" is an A-");
                        mainMenu();
                    }
                     if(gradeNeeded > 3 && gradeNeeded <= 3.33 )
                    {
                        System.out.println("Grade needed in the class to attain "+wantedGPA+" is a B+");
                        mainMenu();
                    }
                     if(gradeNeeded > 2.67 && gradeNeeded <= 3)
                    {
                        System.out.println("Grade needed in the class to attain "+wantedGPA+" is a B");
                    }
                     if(gradeNeeded > 2.33 && gradeNeeded <= 2.67)
                    {
                        System.out.println("Grade needed in the class to attain "+wantedGPA+" is a B-");
                        mainMenu();
                    }
                     if(gradeNeeded > 2 && gradeNeeded <= 2.33)
                    {
                        System.out.println("Grade needed in the class to attain "+wantedGPA+" is a C+");
                        mainMenu();
                    }
                     if(gradeNeeded > 1.67 && gradeNeeded <= 2)
                    {
                        System.out.println("Grade needed in the class to attain "+wantedGPA+" is a C");
                        mainMenu();
                    }
                     if(gradeNeeded > 1.33 && gradeNeeded <= 1.67)
                    {
                        System.out.println("Grade needed in the class to attain "+wantedGPA+" is a C-");
                        mainMenu();
                    }
                      if(gradeNeeded > 1  && gradeNeeded <= 1.33)
                    {
                        System.out.println("Grade needed in the class to attain "+wantedGPA+" is a D+");
                        mainMenu();
                    }
                      if(gradeNeeded > .67 && gradeNeeded <= 1)
                    {
                        System.out.println("Grade needed in the class to attain "+wantedGPA+" is a D");
                        mainMenu();
                    }
                      if(gradeNeeded > 0 && gradeNeeded <= .67)
                    {
                        System.out.println("Grade needed in the class to attain "+wantedGPA+" is a D-");
                        mainMenu();
                    }
                      if(gradeNeeded == 0  || gradeNeeded < 0)
                    {
                        System.out.println("Grade needed in the class to attain "+wantedGPA+" is an F.");
                        System.out.println("You could fail the class and still maintain that GPA!");
                        mainMenu();
                        
                    }
                    break;
          case 4 :  mainMenu();
                    break;
          default : mainMenu();
                    break;
                      
             
                       
                       
                      
         }
         
         
         
         
          
     }
     
     public static void mainMenu()
     {
          Scanner keyboard = new Scanner(System.in);
         
         int option = 0;
         do{
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
         if(option == 1)
         {
             FileIO io = new FileIO();
             io.openFileForUser();
         }
         
         if(option == 2)
         {
             String answer = "";
             do{
                          System.out.println("Would you like to add a class?");
                          System.out.println("Enter Y for Yes or N for No");
                          answer = keyboard.next().toUpperCase();
                          if(answer.equals("Y"))
                          {
                              manualInput();
                          }
                          
                 
                }
                while(!answer.equals("N"));
             
         }
         if(option == 3)
         {
             experimentGPA();
         }
         if(option == 4)
         {
             
         }
         
       }while(option != 4);
     }
   
    
}
