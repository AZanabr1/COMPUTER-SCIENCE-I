public class ManagementCompany {
    // contains an array of Property Objects(Aggregation)
    // and related methods

    private String name;
    private String taxId;
    private Property[] properties;
    private int propertyCount;
    public static final int MAX_PROPERTIES = 5;

    // Parameterized Constructor
    public ManagementCompany(String name, String taxId) {
        this.name = name;
        this.taxId = taxId;
        this.properties = new Property[MAX_PROPERTIES];
    }

    // Copy Constructor
    public ManagementCompany(ManagementCompany copy) {
        this.name = copy.name;
        this.taxId = copy.taxId;
        this.properties = new Property[MAX_PROPERTIES];
        this.propertyCount = copy.propertyCount;

        for (int i = 0; i < copy.propertyCount; i++) {
            this.properties[i] = new Property(copy.properties[i]);
        }
    }

    // Adds a property to the array(Copy into the array) and returns index or error
    // code if full.
    public int addProperty(Property p) {
        if (propertyCount < MAX_PROPERTIES) {
            properties[propertyCount] = new Property(p);
            int addedIndex = propertyCount;
            propertyCount++;
            return addedIndex;
        } else {
            return -1;
        }
    }

    // return sums of all property rents;
    public double totalRent() {
        double total = 0.0;
        for (int i = 0; i < propertyCount; i++) {
            total += properties[i].getRentAmount();
        }

        return total;
    }

    // get the name
    public String getName() {
        return name;
    }

    // get Tax ID
    public String getTaxId() {
        return taxId;
    }

    // get property
    public Property getProperty(int n) {
        return properties[n];
    }

    // return current count
    public int getPropertyCount() {
        return propertyCount;
    }

    // summarizes company and its properties
    public String toString() {
        String str = "Name: " + name + "\n"
                + "Tax ID: " + taxId + "\n" + "Properties: " + "\n";

        for (int i = 0; i < propertyCount; i++) {
            str += properties[i] + "\n";
        }

        str = str + "Property Count: " + propertyCount;
        return str;
    }
}
