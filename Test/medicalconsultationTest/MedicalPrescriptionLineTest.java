package medicalconsultationTest;

import exceptions.NullArgumentException;
import medicalconsultation.MedicalPrescriptionLine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicalPrescriptionLineTest {
    @Test
    public void nullTest() {
        try {
            MedicalPrescriptionLine mpl = new MedicalPrescriptionLine(null, 2.0f, null, 2.5f, 3.0f, null);
            fail();
        } catch (NullArgumentException e) {
            e.printStackTrace();
        }
    }
}