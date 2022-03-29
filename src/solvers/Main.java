package solvers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import game.*;
import gamegui.*;

public class Main 
{
    public static void main(String[] args) 
    {
        ArrayList<Node> al = new ArrayList<Node>();
        
        Move m = new Move(1, 0, 0, 2, 0);
        Node n1 = new Node(1, 1, 6, m);
        Node n2 = new Node(2, 2, 4, m);
        Node n3 = new Node(3, 2, 3, m);

        al.add(n1);
        al.add(n3);
        al.add(n2);
        
        System.out.println(Arrays.toString(al.toArray()));
        Collections.sort(al);
        System.out.println(Arrays.toString(al.toArray()));
    }
}
