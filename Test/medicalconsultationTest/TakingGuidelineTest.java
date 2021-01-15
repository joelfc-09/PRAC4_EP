package medicalconsultationTest;

import exceptions.NullArgumentException;
import medicalconsultation.FqUnit;
import medicalconsultation.TakingGuideline;
import medicalconsultation.dayMoment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class TakingGuidelineTest {
    @Test
    public void nullTest() {
        dayMoment dm = null;
        float du = Float.parseFloat(null);
        String i = null;
        float d = Float.parseFloat(null);
        float f = Float.parseFloat(null);
        FqUnit fqUnit = null;
        try {
            TakingGuideline takingGuideline = new TakingGuideline(dm, du, i, d, f, fqUnit);
            fail();
        } catch (NullArgumentException e) {
            e.printStackTrace();
        }
    }
}