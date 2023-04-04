package edu.wpi.cs3733.D23.teamQ.db.obj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConferenceRequest extends ServiceRequest {
  private String dateTime;
  private String foodChoice;

  public ConferenceRequest(
      int requestID,
      String requester,
      int progress,
      String assignee,
      String roomNumber,
      String specialInstructions,
      String dateTime,
      String foodChoice) {
    super(requestID, requester, progress, assignee, roomNumber, specialInstructions);
    this.dateTime = dateTime;
    this.foodChoice = foodChoice;
  }

  public ConferenceRequest(
      String requester,
      int progress,
      String assignee,
      String roomNumber,
      String specialInstructions,
      String dateTime,
      String foodChoice) {
    super(0, requester, progress, assignee, roomNumber, specialInstructions);
    this.dateTime = dateTime;
    this.foodChoice = foodChoice;
  }

  public ConferenceRequest(
      int progress,
      String requester,
      String assignee,
      String roomNumber,
      String specialInstructions,
      String dateTime,
      String foodChoice) {
    super(0, requester, progress, assignee, roomNumber, specialInstructions);
    this.dateTime = dateTime;
    this.foodChoice = foodChoice;
  }
}
