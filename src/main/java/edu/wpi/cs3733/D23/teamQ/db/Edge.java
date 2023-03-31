package edu.wpi.cs3733.D23.teamQ.db;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Edge {
    private String edgeID;
    private Node startNode;
    private Node endNode;

    Edge(String edgeID, Node startNode, Node endNode) {
        this.edgeID = edgeID;
        this.startNode = startNode;
        this.endNode = endNode;
    }

    public String edgeToString() {
        return "edgeID: "
                + this.edgeID
                + ", startNode: "
                + this.startNode
                + ", endNode: "
                + this.endNode;
    }
}