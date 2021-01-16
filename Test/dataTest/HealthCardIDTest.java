package dataTest;

import exceptions.NullArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealthCardIDTest {
    @Test
    public void nullTest() {
        String code = null;
        try {
            HealthCardID healthCardID = new HealthCardID(code);
            fail();
        } catch (NullArgumentException e) {
            e.printStackTrace();
        }
    }
}