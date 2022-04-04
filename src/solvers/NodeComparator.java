package solvers;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node>
{
    public int compare(Node n1, Node n2)
    {
        return n1.heuristic > n2.heuristic ? 1 : n1.heuristic < n2.heuristic ? -1 : 0;
    }
}
