package se.puzzle;

/**
 * Created by USER on 4/12/2016.
 */

import java.util.ArrayList;


public class Node {
    String name;
    ArrayList<Integer> state;
    Node parent;
    int distance;
    String chmove;
    String move;
    public int priority;
    Node states[];
    int count;
    int visited;
    public Node(String name){
        this.name = name;
    }

    public Node(){

    }


    public String getName(){
        return this.name;
    }
}

