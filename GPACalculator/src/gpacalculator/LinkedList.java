/*
Data structure to maintain the actual grades in the system
*/
package gpacalculator;

/**
 *
 * @author nahianAfsari
 */
public class LinkedList {
    
    private static Node head;
    private static int numOfnodes;
    
    LinkedList()
    {
        head = null;
    }
    
    public Node getHead()
    {
        return head;
    }
    public LinkedList(Course c)
    {
        head = new Node(c);
    }
    public void addCourse(Course c)
    {
        /*if(head == null)
        {
            head = new Node(c);
        }*/
        Node temp = head;
        head = new Node(c);
        head.next = temp;
        
    }
    /*
    This method is to facilitate one the GPA experiments the user will do on their grades. When
    the user wants to add temporary grades to see how their GPA might flunctuate, we don't want it 
    in the actual system after the user is done experimenting. The program keeps a tally on how many
    courses were added and that number is sent to this function and based on that number, courses are 
    removed from the head since courses are inserted at the head.
    */
    public void deteteTempCourses(int tempNum)
    {
        for(int i = 0; i < tempNum; i++)
        {
            Node temp = head.next;
            head.next = null;
            head = temp;
            
        }
    }
    
    public Node findCourse(Course c)
    {
        Node currNode;
        Node foundNode = null;
        currNode = head;
        while(currNode != null)
        {
            if(c.course.equals(currNode.data.course))
            {
                foundNode = currNode;
            }
            
            currNode = currNode.next;
        }
        
        if(foundNode == null)
        {
            return null;
        }
        
        return foundNode; //once this is returned, check foundNode.data.course - or whatever 
    }
    
    public void removeCourse(Course c)
    {
        Node currNode;
        Node prevNode = null;
        
        currNode = head;
        while(currNode != null)
        {
            if(c.course.equals(head.data.course))
            {
                head = head.next;
                break;
            }
            if(c.course.equals(currNode.data.course))
            {
                prevNode.next = currNode.next;
                break;
                
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        
        
    
        
    }
    
    public void printList()
    {
        Node currNode = head;
        while(currNode != null)
        {
            System.out.println(currNode.data.toString());
            currNode = currNode.next;
        }
    }
    public class Node {
        
        private Node next;
        private Course data;
        
        Node()
        {
            next = null;
            data = null;
        }
        public Node(Course d)
        {
            data = d;
        }
        
        public Course getData()
        {
            return data;
        }
        
        public Node getNext()
        {
            return next;
        }
    }
    
    
}
