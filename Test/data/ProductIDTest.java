package data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ProductIDTest {

    @Test
    public void getProductID_Test() {
        ProductID id = new ProductID("1234567890");
        assertEquals(id.getProductID(), "1234567890");
    }

    @Test
    public void getProductID_TestV2() {
        ProductID id = new ProductID("1234567890");
        String id_expected = "1234567890";
        assertEquals(id.getProductID(), id_expected);
    }

    @Test
    public void getProductID_TestV3() {
        ProductID id = new ProductID(null);
        assertNull(id.getProductID());
    }

    @Test
    public void getProductID_TestV4() {
        ProductID id = new ProductID(null);
        assertNotEquals(id.getProductID(), "1234567890");
    }

    @Test
    public void ProductIdObject_Test() {
        ProductID id = new ProductID("1234567890");
        Object id_expected = new Object();
        assertNotEquals(id, id_expected);
    }

    @Test
    public void equalsFunctionTest() {
        HealthCardID id = new HealthCardID("67890023X");
        HealthCardID id_2 = new HealthCardID("67890023X");
        assertTrue(id.equals(id_2));
    }

    @Test
    public void notEqualsFunctionTest() {
        HealthCardID id = new HealthCardID("67890023X");
        HealthCardID id_2 = new HealthCardID("67890023R");
        assertFalse(id.equals(id_2));
    }
}

