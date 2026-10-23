import static org.junit.Assert.*;
import org.junit.Test;

public class PropertyTest {

    @Test
    public void testPropertyParameterizedConstructor() {
        Property p1 = new Property("The Upton", "Rockville", 2150, "Greystar Real Estate Partners");
        Property p2 = new Property("The Blairs", "Silver Spring", 1980, "The Peterson Companies");
        Property p3 = new Property("Downtown Crown Apartments", "Gaithesburg", 2400, "Bozzuto Management");
        Property p4 = new Property("Gallery Bethesda", "Bethesda", 2750, "StonebridgeCarras");

        assertEquals("The Upton", p1.getPropertyName());
        assertEquals("Rockville", p1.getCity());
        assertEquals(2150, p1.getRentAmount(), 0.001);
        assertEquals("Greystar Real Estate Partners", p1.getOwner());

        assertEquals("The Blairs", p2.getPropertyName());
        assertEquals("Silver Spring", p2.getCity());
        assertEquals(1980, p2.getRentAmount(), 0.001);
        assertEquals("The Peterson Companies", p2.getOwner());

        assertEquals("Downtown Crown Apartments", p3.getPropertyName());
        assertEquals("Gaithesburg", p3.getCity());
        assertEquals(2400, p3.getRentAmount(), 0.001);
        assertEquals("Bozzuto Management", p3.getOwner());

        assertEquals("Gallery Bethesda", p4.getPropertyName());
        assertEquals("Bethesda", p4.getCity());
        assertEquals(2750, p4.getRentAmount(), 0.001);
        assertEquals("StonebridgeCarras", p4.getOwner());

    }

    @Test
    public void testPropertyCopyConstrutors() {
        Property p1 = new Property("The Upton", "Rockville", 2150, "Greystar Real Estate Partners");
        Property p2 = new Property("The Blairs", "Silver Spring", 1980, "The Peterson Companies");
        Property p3 = new Property("Downtown Crown Apartments", "Gaithesburg", 2400, "Bozzuto Management");
        Property p4 = new Property("Gallery Bethesda", "Bethesda", 2750, "StonebridgeCarras");

        Property copyp1 = new Property(p1);
        Property copyp2 = new Property(p2);
        Property copyp3 = new Property(p3);
        Property copyp4 = new Property(p4);

        assertNotEquals(p1, copyp1);
        assertNotEquals(p2, copyp2);
        assertNotEquals(p3, copyp3);
        assertNotEquals(p4, copyp4);

        assertEquals(p1.getPropertyName(), copyp1.getPropertyName());
        assertEquals(p1.getCity(), copyp1.getCity());
        assertEquals(p1.getRentAmount(), copyp1.getRentAmount(), 0.001);
        assertEquals(p1.getOwner(), copyp1.getOwner());

        assertEquals(p2.getPropertyName(), copyp2.getPropertyName());
        assertEquals(p2.getCity(), copyp2.getCity());
        assertEquals(p2.getRentAmount(), copyp2.getRentAmount(), 0.001);
        assertEquals(p2.getOwner(), copyp2.getOwner());

        assertEquals(p3.getPropertyName(), copyp3.getPropertyName());
        assertEquals(p3.getCity(), copyp3.getCity());
        assertEquals(p3.getRentAmount(), copyp3.getRentAmount(), 0.001);
        assertEquals(p3.getOwner(), copyp3.getOwner());

        assertEquals(p4.getPropertyName(), copyp4.getPropertyName());
        assertEquals(p4.getCity(), copyp4.getCity());
        assertEquals(p4.getRentAmount(), copyp4.getRentAmount(), 0.001);
        assertEquals(p4.getOwner(), copyp4.getOwner());

    }

    @Test
    public void testManagementCompanyAddAndTotalRent() {
        ManagementCompany mc = new ManagementCompany("Gotham City Management", "12-3456789");

        Property p1 = new Property("The Upton", "Rockville", 2150, "Greystar Real Estate Partners");
        Property p2 = new Property("The Blairs", "Silver Spring", 1980, "The Peterson Companies");
        Property p3 = new Property("Downtown Crown Apartments", "Gaithesburg", 2400, "Bozzuto Management");
        Property p4 = new Property("Gallery Bethesda", "Bethesda", 2750, "StonebridgeCarras");

        int index1 = mc.addProperty(p1);
        int index2 = mc.addProperty(p2);
        int index3 = mc.addProperty(p3);
        int index4 = mc.addProperty(p4);

        assertEquals(0, index1);
        assertEquals(1, index2);
        assertEquals(2, index3);
        assertEquals(3, index4);

        double t = mc.totalRent();
        assertEquals(9280, t, 0.001);

    }

    @Test
    public void testAddPropertyAndTotalRent() {
        ManagementCompany mc = new ManagementCompany("Campus Realty", "123-45-6789");
        Property p1 = new Property("Apt 1", "Rockville", 1200.0, "Bob");
        Property p2 = new Property("Apt 2", "Rockville", 1500.0, "Carol");

        int index1 = mc.addProperty(p1);
        int index2 = mc.addProperty(p2);

        assertEquals(0, index1);
        assertEquals(1, index2);
        assertEquals(2, mc.getPropertyCount());
        assertEquals(2700.0, mc.totalRent(), 0.001);
    }

    @Test
    public void testAddPropertyWhenFull() {
        ManagementCompany mc = new ManagementCompany("Campus Realty", "123-45-6789");
        for (int i = 0; i < ManagementCompany.MAX_PROPERTIES; i++) {
            mc.addProperty(new Property("P" + i, "City", 1000.0 + i, "Owner"));
        }
        int result = mc.addProperty(new Property("Extra", "City", 2000.0, "OwnerX"));
        assertEquals(-1, result);
    }

    @Test
    public void testManagementCompanyCopyConstructor() {
        ManagementCompany mc1 = new ManagementCompany("Campus Realty", "123-45-6789");
        mc1.addProperty(new Property("Apt 1", "Rockville", 1200.0, "Bob"));
        mc1.addProperty(new Property("Apt 2", "Rockville", 1500.0, "Carol"));

        ManagementCompany mc2 = new ManagementCompany(mc1);

        assertEquals(mc1.getName(), mc2.getName());
        assertEquals(mc1.getTaxId(), mc2.getTaxId());
        assertEquals(mc1.getPropertyCount(), mc2.getPropertyCount());
        assertEquals(mc1.totalRent(), mc2.totalRent(), 0.001);
        assertNotSame(mc1.getProperty(0), mc2.getProperty(0)); // deep copy
    }
}
