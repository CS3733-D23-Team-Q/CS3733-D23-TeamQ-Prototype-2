package edu.wpi.cs3733.D23.teamQ.db.obj;

import java.util.ArrayList;
import java.util.List;

//import edu.wpi.cs3733.D23.teamQ.Pathfinding.newNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
  private int nodeID;
  private int xCoord;
  private int yCoord;
  private String floor;
  private String building;
  private List<Edge> edges;
  private Location location;
  private int locID;
  private double f = Double.MAX_VALUE;
  private double g = Double.MAX_VALUE;
  private static int idCounter = 0;
  private int weight;
  Node parent = null;

  Node(
      int nodeID,
      int xCoord,
      int yCoord,
      String floor,
      String building,
      List<Edge> edges,
      Location location) {
    this.nodeID = nodeID;
    this.xCoord = xCoord;
    this.yCoord = yCoord;
    this.floor = floor;
    this.building = building;
    this.edges = edges;
    this.location = location;


    String x = Integer.toString(xCoord);
    String y = Integer.toString(yCoord);
    String xy = x + y;
    this.locID = Integer.parseInt(xy);
  }

  Node(int xCoord, int yCoord) {
    this.nodeID = idCounter++;
    this.edges = new ArrayList<>();
    this.weight = weight;
  }


  public Node() {}

  public String nodeToString() {
    return "nodeID: "
        + this.nodeID
        + ", xCoord: "
        + this.xCoord
        + ", yCoord: "
        + this.yCoord
        + ", floor: "
        + this.floor
        + ", building: "
        + this.building
        + ", edges: "
        + this.edges
        + ", location: "
        + this.location;
  }
  public int compareTo(Node n) {
    return Double.compare(this.f, n.f);
  }

  public void addBranch(int weight, Node node) {
    Edge newEdge = new Edge(weight, node);
    //    Edge inverseEdge = new Edge(weight, this);
    edges.add(newEdge);
    //    neighbors.add(inverseEdge);
  }
}
