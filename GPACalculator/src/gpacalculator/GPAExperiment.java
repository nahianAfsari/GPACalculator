
package gpacalculator;

import gpacalculator.LinkedList.Node;

class GPAExperiment{
    private Node head;
    private double totalAvg;
    private int totalHours;
    
    GPAExperiment()
    {
        head = null;
        totalAvg = 0;
        totalHours = 0;
    }
    GPAExperiment(Node h)
    {
        head = h;
        totalAvg = 0;
        totalHours = 0;
    }
    public double calculateGPA()
    {
        double GPA = 0.0;
        int hours = 0;
        totalHours = 0; //safety
        totalAvg = 0.0; //safety
        double avg = 0.0;
        Node start = head;
        while(start != null)
        {
            GPA = start.getData().grade;
            hours = start.getData().hours;
            totalHours += hours;
            totalAvg += GPA*hours;
            start = start.getNext();
            
             
        }
        
        avg = totalAvg/totalHours;
        return avg;
    }
    public double getTotalAvg()
    {
        return totalAvg;
    }
    
    
    public int getTotalHours()
    {
        return totalHours;
    }
    
    
    
    
}