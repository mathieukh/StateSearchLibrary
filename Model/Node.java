package Model;

/**
 * Created by sylom on 13/01/2016.
 */

/**
 * L'interface Node permet de modéliser un noeud qui sera associé à un état
 *
 * @author Mathieu KHALEM
 * @version 1.0
 */
public class Node {
    /**
     * Stocke le père du noeud
     */
    public Node parent = null;

    /**
     * Stocke l'état associé au noeud
     */
    public State state = null;

    /**
     * Stocke le cout vers ce noeud
     */
    public int cost = 0;

    /**
     * Constructeur complet de la classe Node
     * @param state Etat associé au noeud
     * @param parent Noeud parent de celui-ci
     */
    public Node(State state, Node parent){
        this.state = state;
        this.parent = parent;
        this.cost = parent.cost + state.operator.cost;
    }

    /**
     * Constructeur partiel de classe Node. Appelera le constructeur complet avec les paramètres null
     * @param state Etat associé au noeud
     */
    public Node(State state){
        this(state,null);
    }
}
