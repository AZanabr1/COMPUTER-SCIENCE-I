
public class PropertyDriver {
    // Creates a ManagementCompany,
    // adds several Property objects, and prints the
    // company information
    // Demostrate array of objects, use of copy constructs,
    // aggregation(managementComapny "has-a" Property [])

    public static void main(String[] args) {
        ManagementCompany mc = new ManagementCompany("Gotham City Property Group", "98-7654321");
        Property p1 = new Property("Sunset Apartments", "Rockville", 1450.00, "Maria Lopez");
        Property copyp1 = new Property(p1);
        Property p2 = new Property("Oak Hill Townhouse", "Silver Spring", 2100.0, "James Carter");
        Property copyp2 = new Property(p2);
        Property p3 = new Property("Lakeview Condo", "Bethesda", 1850.00, "Priya Patel");
        Property copyp3 = new Property(p3);
        Property p4 = new Property("Downtown Loft", "Gaithersburg", 1600.00, "David Kim");
        Property copyp4 = new Property(p4);
        Property p5 = new Property("Maple Court Duplex", "Olney", 1750.00, "Sarah Johnson");
        Property copyp5 = new Property(p5);

        mc.addProperty(p1);
        copyp1.setCity("Silver Spring");
        System.out.println(p1);
        System.out.println(copyp1);

        mc.addProperty(p2);
        copyp2.setRentAmount(2500.00);
        System.out.println(p2);
        System.out.println(copyp2);

        mc.addProperty(p3);
        copyp3.setOwner("Darrow Of'Lykos");
        System.out.println(p3);
        System.out.println(copyp3);

        mc.addProperty(p4);
        copyp4.setPropertyName("Harbor View Flats");
        System.out.println(p4);
        System.out.println(copyp4);

        mc.addProperty(p5);
        copyp5.setRentAmount(1675.00);
        System.out.println(p5);
        System.out.println(copyp5);
        System.out.println();
        ManagementCompany copymc = new ManagementCompany(mc);
        copymc.getProperty(0).setCity("Germantown");
        System.out.println("Copied Company: " + "\n" + copymc);

        String str = mc.toString();
        System.out.println(str);

        double totalRent = mc.totalRent();
        System.out.println(totalRent);

        System.out.println("\n");
        System.out.println("Created by: Antonio Zanabria");

    }
}
