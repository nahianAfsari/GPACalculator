
package gpacalculator;

import gpacalculator.LinkedList.Node;

class GPAExperiment{
    private Node head;
    
    
    GPAExperiment()
    {
        head = null;
    }
    GPAExperiment(Node h)
    {
        head = h;
    }
    public double calculateGPA()
    {
        double GPA = 0.0;
        int hours = 0;
        int totalHours = 0;
        double avg = 0.0;
        Node start = head;
        while(start != null)
        {
            GPA = start.getData().grade;
            hours = start.getData().hours;
            totalHours += hours;
            avg += GPA*hours;
            start = start.getNext();
            
             
        }
        
        avg = avg/totalHours;
        return avg;
    }
    
    
    
    
}