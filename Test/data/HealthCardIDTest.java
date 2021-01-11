package data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealthCardIDTest {
    @Test
    public void getPersonalID_Test() {
        HealthCardID card = new HealthCardID("67890023X");
        assertEquals(card.getPersonalID(), "67890023X");
    }

    @Test
    public void getPersonalID_TestV2() {
        HealthCardID card = new HealthCardID("67890023X");
        String id_expected = "67890023X";
        assertEquals(card.getPersonalID(), id_expected);
    }

    @Test
    public void getPersonalID_TestV3() {
        HealthCardID card = new HealthCardID(null);
        assertNull(card.getPersonalID());
    }

    @Test
    public void getPersonalID_TestV4() {
        HealthCardID card = new HealthCardID(null);
        assertNotEquals(card.getPersonalID(), "67890023X");
    }

    @Test
    public void HealthCardObject_Test() {
        HealthCardID card = new HealthCardID("67890023X");
        Object id_expected = new Object();
        assertNotEquals(card, id_expected);
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