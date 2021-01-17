package medicalconsultationTest;
<<<<<<< Updated upstream
=======

import data.DigitalSignature;
import data.HealthCardID;
import data.ProductID;
import exceptions.IncorrectTakingGuidelinesException;
import exceptions.NullArgumentException;
import medicalconsultation.FqUnit;
import medicalconsultation.MedicalPrescription;
import medicalconsultation.MedicalPrescriptionLine;
import medicalconsultation.dayMoment;
>>>>>>> Stashed changes
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashMap;



public class medicalPrescriptionTest {

<<<<<<< Updated upstream
}
=======
    @Test
    public void addLineTest() throws NullArgumentException, IncorrectTakingGuidelinesException {
        ProductID productID = new ProductID("1234567890");
        dayMoment dayMoment = medicalconsultation.dayMoment.AFTERBREAKFAST;
        Date currentdate = new Date();
        Date endDate = new Date();
        int prescCode = 1;
        HealthCardID healthCardID = new HealthCardID("BBBBBBBBGJ123456854231456345");
        byte[] personalSignature = new byte[] {'A', 'B', 'C'};
        DigitalSignature eSign = new DigitalSignature(personalSignature);
        String instruc = "HOLA";
        MedicalPrescription MP = new MedicalPrescription(4, currentdate, endDate, healthCardID, eSign);
        MedicalPrescriptionLine MPL = new MedicalPrescriptionLine(medicalconsultation.dayMoment.BEFOREBREAKFAST, 4.0F, instruc, 5.0F,6.0F, FqUnit.DAY);
        String[] instruction = new String[] {String.valueOf(dayMoment),String.valueOf(prescCode), String.valueOf(currentdate), String.valueOf(endDate), String.valueOf(healthCardID),String.valueOf(eSign)};
        HashMap<ProductID, MedicalPrescriptionLine> hashMapTest = new HashMap<>();
        hashMapTest.put(productID,MPL);
        MP.addLine(productID,instruction);
        assertEquals(MP.getHashMap(),hashMapTest);

    }
    @Test
    public void addLineTest1() throws NullArgumentException, IncorrectTakingGuidelinesException {
        String[] instruc = new String[] {String.valueOf(medicalconsultation.dayMoment.BEFOREBREAKFAST),String.valueOf(4.0F),String.valueOf(4.0F),"Cada 8 hores",String.valueOf(4.0F),String.valueOf(4.0F),String.valueOf(FqUnit.DAY)};
        ProductID prodID = new ProductID("1234567890");
        byte[] personalSignature = new byte[] {'A', 'B', 'C'};
        DigitalSignature eSign = new DigitalSignature(personalSignature);
        Date currentdate = new Date();
        Date endDate = new Date();
        HealthCardID healthCardID = new HealthCardID("BBBBBBBBGJ123456854231456345");
        MedicalPrescription MP = new MedicalPrescription(4, currentdate, endDate, healthCardID, eSign);
        MP.addLine(prodID,instruc);
        assertEquals(1, MP.);

        MedicalPrescription
>>>>>>> Stashed changes
    }
}
