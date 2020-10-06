/** Represents a Coordinate with latitude and longitude
 * @author ccomeau7
 * @version 1
*/
public class Coordinates {

    private final double latitude;
    private final double longitude;

    /** Creates a Coordinate and initializes its
     * latitude and longitude
     * @param latitude of a Coordinate
     * @param longitude of a Coordinate
    */
    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /** Getter method for the latitude field
     * @return Coordinate's latitude
    */
    public double getLatitude() {
        return latitude;
    }

    /** Getter method for longitude field
     * @return Coordinate's longitude
    */
    public double getLongitude() {
        return longitude;
    }

    /** Overrides Object's equality method, determines logical equality
     * for 2 Coordinates object
     * @param other An object to be compared
     * @return result of logical equality
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Coordinates)) {
            return false;
        }
        Coordinates that = (Coordinates) other;
        return this.getLatitude() == that.getLatitude()
            && this.getLongitude() == that.getLongitude();
    }

    /** Overrides Object's toString method, prints out Coordinates'
     * latitude and longitude
     * @return String representation of Coordinates' latitude and longitude
     */
    @Override
    public String toString() {
        return String.format("latitude: %.2f, longitude: %.2f",
                    getLatitude(), getLongitude());
    }
}