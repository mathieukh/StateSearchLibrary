package fr.khalypso.statesearchlib.model;

import java.util.List;

/**
 * L'interface State permet de modéliser un état
 *
 * @author Mathieu KHALEM
 * @version 1.0
 */
public abstract class State {

    /**
     * Stocke l'opérateur qui a permit d'arriver à cet état
     */
    public Operator operator = null;

    /**
     * Stocke l'heuristique de l'état
     */
    public int heuristic = 0;

    /**
     * Savoir si un état est un état terminal
     *
     * @return Un booléen pour spécifier si l'état est terminal ou non
     */
    public abstract boolean isTerminal();

    /**
     * Retourne la liste des états successeurs depuis cet état
     *
     * @return La liste des State qui représenteront les successeurs
     */
    public abstract List<State> successors();

    /**
     * Retourne une copie de l'état
     *
     * @return State, copie de celui-ci
     */
    public abstract State copy();
}
