package data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealthCardIDTest {
    @Test
    public void getPersonalID_Test() {
        HealthCardID card = new HealthCardID("BBBBBBBBOP593285318567456723");
        assertEquals(card.getPersonalID(), "BBBBBBBBOP593285318567456723");
    }

    @Test
    public void getPersonalID_TestV2() {
        HealthCardID card = new HealthCardID("BBBBBBBBOP593285318567456723");
        String id_expected = "BBBBBBBBOP593285318567456723";
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
        assertNotEquals(card.getPersonalID(), "BBBBBBBBOP593285318567456723");
    }

    @Test
    public void HealthCardObject_Test() {
        HealthCardID card = new HealthCardID("BBBBBBBBOP593285318567456723");
        Object id_expected = new Object();
        assertNotEquals(card, id_expected);
    }

    @Test
    public void equalsFunctionTest() {
        HealthCardID id = new HealthCardID("BBBBBBBBOP593285318567456723");
        HealthCardID id_2 = new HealthCardID("BBBBBBBBOP593285318567456723");
        assertTrue(id.equals(id_2));
    }

    @Test
    public void notEqualsFunctionTest() {
        HealthCardID id = new HealthCardID("BBBBBBBBOP593285318567456723");
        HealthCardID id_2 = new HealthCardID("BBBBBBBBOP593285318567456724");
        assertFalse(id.equals(id_2));
    }
}