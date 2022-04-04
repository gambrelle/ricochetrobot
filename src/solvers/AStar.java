package solvers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

import game.*;

public class AStar extends Solver
{
    public AStar(State state) throws IOException, InterruptedException
    {
        super(state);
    }

    //Reconstitue le chemin a partir du dernier noeud
    public ArrayList<Move> reconstituerChemin(Node n)
    {
        ArrayList<Move> path = new ArrayList<>();
        path.add(n.getMove());
        while (n.getNoeudPrecedent() != null)
        {
            n = n.getNoeudPrecedent();
            path.add(n.getMove());
        }
        return path;
    }
    // Vérifie si le noeud est intéressent : n'est pas dans closed list ou est dans open list avec un cout supérieur.
    public boolean isInterestingNode(PriorityQueue<Node> openList, HashSet<Node> closedList, Node n)
    {
        if (!(closedList.isEmpty()))
        {
            for (Node nodeClose : closedList)
            {
                if (nodeClose.equals(n))
                {
                    return false;
                }
            }
           for (Node nodeOpen : openList)
           {
                if (n.equals(nodeOpen))
                {
                    if (nodeOpen.cout > n.cout)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    //Boucle pricipale de l'A*
    public Node getBestPath()
    {
        int cout = 1;
        // Initialise le noeud de départ.
        Node startNode = new Node(manhattanDistance(this.posActiveRobot, this.posActiveGoal) + cout, cout, this.initialState, null, null);
        // File de priorité ordonnée selon les heuristiques des noeud
        PriorityQueue<Node> openList = new PriorityQueue<Node>(new NodeComparator());
        openList.add(startNode);
        // Liste des noeuds deja parcourus
        HashSet<Node> closeList = new HashSet<>();

        while (!(openList.isEmpty()))
        {
            Node n = openList.poll();
            //closeList.add(n); 
            cout ++;

            //Condition de fin (niveau complété)
            if (n.getState().Get_Robot()[n.getState().getActiveGoal()][0] == this.posActiveGoal[0] && n.getState().Get_Robot()[n.getState().getActiveGoal()][1] == this.posActiveGoal[1])
            {
                return n;
            }

            for (int i = 0; i <= 3; i++)
            {
                for (Move move : n.getState().getMove(i))
                {
                    State s;

                    try {
                        // Récupère le state du noeud précédent et joue le mouvement actuel.
                        s = n.getState().getClone();
                        s.play(move, i);
                    }
                    catch (Exception e) {return null;}

                    // Création d'un nouveau noeud
                    int[] newPosRobot = s.Get_Robot()[s.getActiveGoal()];

                    Node node = new Node(manhattanDistance(newPosRobot, this.posActiveGoal) + cout, cout, s, n, move);

                    // Ajoute le noeud au noeud deja vérifié
                    if (isInterestingNode(openList, closeList, node))
                    {
                        // Ajoute le noeud au mouvement a vérifier
                        openList.add(node);
                    }
                }
            }
        }
        return null;
    }

}
