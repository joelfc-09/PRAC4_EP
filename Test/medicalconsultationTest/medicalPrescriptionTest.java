package medicalconsultationTest;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class medicalPrescriptionTest {
    @Test

    public void getPrescCode_test(){
        int prescCodeTest = 12;
        assertEquals(prescCodeTest.getPrescCode(), 12);


    }

    @Test
    public void getPrescDate() {

        Date prescDate = new Date(2021,1, 15);
        assertEquals(prescDate.getPrescDate(),"2021-1-15");
    }
}
