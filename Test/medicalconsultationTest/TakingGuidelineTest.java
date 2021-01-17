package medicalconsultationTest;

import exceptions.NullArgumentException;
import medicalconsultation.TakingGuideline;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TakingGuidelineTest {

    @Test
    public void nullTest() {
        try {
            TakingGuideline takingGuideline = new TakingGuideline(null, 2.0f, null, 2.5f, 3.0f, null);
            fail();
        } catch (NullArgumentException e) {
            e.printStackTrace();
        }
    }
}
    
}

