package medicalconsultationTest;

import exceptions.NullArgumentException;
import medicalconsultation.Posology;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosologyTest {
    @Test
    public void nullTest() {
        try {
            Posology posology = new Posology(2.0f, 2.5f, null);
            fail();
        } catch (NullArgumentException e) {
            e.printStackTrace();
        }
    }
}