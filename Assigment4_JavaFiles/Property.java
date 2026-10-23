public class Property {
    // represents a single rental property

    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;

    // construors cannot return values
    // they simple execute when the object is called

    // default construct
    public Property() {
        this.propertyName = "";
        this.city = "";
        this.rentAmount = 0.0;
        this.owner = "";
    }

    // parametized constructor
    public Property(String propertyName, String city, double rentAmount, String owner) {
        setPropertyName(propertyName);
        setCity(city);
        setRentAmount(rentAmount);
        setOwner(owner);
    }

    // Copy Construct
    public Property(Property copy) {
        this.propertyName = copy.propertyName;
        this.city = copy.city;
        this.rentAmount = copy.rentAmount;
        this.owner = copy.owner;
    }

    // getters
    public String getPropertyName() {
        return propertyName;
    }

    public String getCity() {
        return city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    // setters
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    // toString
    public String toString() {
        String str = "Property Name: " + propertyName + ", " + "City:  " + city + ", " + " Rent Amount: "
                + rentAmount
                + ", " + " Owner: " + owner;
        return str;
    }
}
