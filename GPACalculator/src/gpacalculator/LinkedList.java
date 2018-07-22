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
public class LinkedList {
    
    private static Node head;
    private static int numOfnodes;
    
    LinkedList()
    {
        head = null;
    }
    public LinkedList(Course c)
    {
        head = new Node(c);
    }
    public void addCourse(Course c)
    {
        if(head == null)
        {
            head = new Node(c);
        }
        Node temp = head;
        head = new Node(c);
        head.next = temp;
        
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
        
        public Node(Course d)
        {
            data = d;
        }
        
        public Course getData()
        {
            return data;
        }
    }
    
    
}
