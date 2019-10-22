// Assume: multiple levels, several size Vehicles

public class ParkingLot {
  // multiple levels
  private final Level[] levels;
  
  public ParkingLot(int numOfLevels, int numsOfSpotsPerLevel) {
    
  }
  public boolean hasSpot(Vehicle v) {
    
  }
  
  public boolean park(Vehicle v) {
    
  }
  
  public boolean leave(Vehivle v) {
    
  }
}

class Level {
  // has many spots --> a list of spots
  private final List<ParkingSpot> spots;
  
  Level(int numOfSpots) {
    List<ParkingSpot> list = new ArrayList<>(numOfSpots);
    ...
    spots = Collections.unmodifiableList(list);
  }
  boolean hasSpot(Vehicle v) {
    for(ParkingSpot s : spots) {
      if(s.fit(v)) {
        return true;
      }
    }
    return false;
  }
  
