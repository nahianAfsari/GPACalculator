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
public class GPACalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LinkedList courseList = new LinkedList();
        for(int i=0; i < 10; i++)
        {
            Course course = new Course("Dummy", 95, "A");
            courseList.addCourse(course);
        }
        
        courseList.printList();
    }
    
}
