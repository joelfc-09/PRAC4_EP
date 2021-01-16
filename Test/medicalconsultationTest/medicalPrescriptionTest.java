package medicalconsultationTest;

import data.DigitalSignature;
import data.HealthCardID;
import data.ProductID;
import exceptions.NullArgumentException;
import medicalconsultation.MedicalPrescription;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class medicalPrescriptionTest {
    @Test
    public void nullTest() {
        try {
            MedicalPrescription MP = new MedicalPrescription(3, null, null, null, null);
        } catch (NullArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addLineTest() throws NullArgumentException {
        ProductID productID = new ProductID("1234567890");
        Date currentdate = new Date();
        Date endDate = new Date();
        endDate.set();
        HealthCardID healthCardID = new HealthCardID("BBBBBBBBGJ123456854231456345");
        byte[] personalSignature = new byte[] {'A', 'B', 'C'};
        DigitalSignature eSign = new DigitalSignature(personalSignature);
        MedicalPrescription MP = new MedicalPrescription(4, currentdate, endDate, healthCardID, eSign);
    }
}