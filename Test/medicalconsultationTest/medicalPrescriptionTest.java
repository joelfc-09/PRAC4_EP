package medicalconsultationTest;

import data.DigitalSignature;
import data.HealthCardID;
import data.ProductID;
import exceptions.IncorrectTakingGuidelinesException;
import exceptions.NullArgumentException;
import exceptions.ProductNotInPrescription;
import medicalconsultation.*;
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
    public void addLineTest() throws NullArgumentException, IncorrectTakingGuidelinesException {
        ProductID productID = new ProductID("1234567890");
        Date currentdate = new Date();
        Date endDate = new Date();
        HealthCardID healthCardID = new HealthCardID("BBBBBBBBGJ123456854231456345");
        byte[] personalSignature = new byte[] {'A', 'B', 'C'};
        DigitalSignature eSign = new DigitalSignature(personalSignature);
        MedicalPrescription MP = new MedicalPrescription(4, currentdate, endDate, healthCardID, eSign);

        String[] instruc = new String[] {String.valueOf(medicalconsultation.dayMoment.BEFOREBREAKFAST), String.valueOf(4.0F), "Cada 8 hores", String.valueOf(4.0F), String.valueOf(4.0F), String.valueOf(FqUnit.DAY)};

        MP.addLine(productID, instruc);

        assertEquals(1, MP.hashMap.size());
    }

    @Test
    public void addNullInstructParameterTest() throws NullArgumentException {
        ProductID productID = new ProductID("1234567890");
        Date currentdate = new Date();
        Date endDate = new Date();
        HealthCardID healthCardID = new HealthCardID("BBBBBBBBGJ123456854231456345");
        byte[] personalSignature = new byte[] {'A', 'B', 'C'};
        DigitalSignature eSign = new DigitalSignature(personalSignature);
        MedicalPrescription MP = new MedicalPrescription(4, currentdate, endDate, healthCardID, eSign);

        String[] instruc = new String[] {String.valueOf(medicalconsultation.dayMoment.BEFOREBREAKFAST), String.valueOf(4.0F), null, String.valueOf(4.0F), String.valueOf(4.0F), String.valueOf(FqUnit.DAY)};

        try {
            MP.addLine(productID, instruc);
            fail();
        } catch (IncorrectTakingGuidelinesException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addNullProductTest() throws NullArgumentException, IncorrectTakingGuidelinesException {
        Date currentdate = new Date();
        Date endDate = new Date();
        HealthCardID healthCardID = new HealthCardID("BBBBBBBBGJ123456854231456345");
        byte[] personalSignature = new byte[] {'A', 'B', 'C'};
        DigitalSignature eSign = new DigitalSignature(personalSignature);
        MedicalPrescription MP = new MedicalPrescription(4, currentdate, endDate, healthCardID, eSign);

        String[] instruc = new String[] {String.valueOf(medicalconsultation.dayMoment.BEFOREBREAKFAST), String.valueOf(4.0F), "Cada 8 hores", String.valueOf(4.0F), String.valueOf(4.0F), String.valueOf(FqUnit.DAY)};

        try {
            MP.addLine(null, instruc);
            fail();
        } catch (NullArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addingLessParametersTest() throws NullArgumentException {
        ProductID productID = new ProductID("1234567890");
        Date currentdate = new Date();
        Date endDate = new Date();
        HealthCardID healthCardID = new HealthCardID("BBBBBBBBGJ123456854231456345");
        byte[] personalSignature = new byte[] {'A', 'B', 'C'};
        DigitalSignature eSign = new DigitalSignature(personalSignature);
        MedicalPrescription MP = new MedicalPrescription(4, currentdate, endDate, healthCardID, eSign);

        String[] instruc = new String[] {String.valueOf(medicalconsultation.dayMoment.BEFOREBREAKFAST), String.valueOf(4.0F), String.valueOf(4.0F), String.valueOf(4.0F), String.valueOf(FqUnit.DAY)};

        try {
            MP.addLine(productID, instruc);
        } catch (IncorrectTakingGuidelinesException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void modifyNullProductTest() throws NullArgumentException, IncorrectTakingGuidelinesException {
        ProductID productID = new ProductID("1234567890");
        Date currentdate = new Date();
        Date endDate = new Date();
        HealthCardID healthCardID = new HealthCardID("BBBBBBBBGJ123456854231456345");
        byte[] personalSignature = new byte[] {'A', 'B', 'C'};
        DigitalSignature eSign = new DigitalSignature(personalSignature);
        MedicalPrescription MP = new MedicalPrescription(4, currentdate, endDate, healthCardID, eSign);

        String[] instruc = new String[] {String.valueOf(medicalconsultation.dayMoment.BEFOREBREAKFAST), String.valueOf(4.0F), "Cada 8 hores", String.valueOf(4.0F), String.valueOf(4.0F), String.valueOf(FqUnit.DAY)};

        MP.addLine(productID, instruc);

        String[] instruc_2 = new String[] {String.valueOf(dayMoment.AFTERLUNCH), String.valueOf(4.0F), "Cada 8 hores", String.valueOf(4.0F), String.valueOf(4.0F), String.valueOf(FqUnit.DAY)};

        try {
            MP.modifyLine(null, instruc_2);
            fail();
        } catch (ProductNotInPrescription e) {
            e.printStackTrace();
        }
    }

    @Test
    public void modifyProductWithIncorrectInstruct() throws NullArgumentException, IncorrectTakingGuidelinesException, ProductNotInPrescription {
        ProductID productID = new ProductID("1234567890");
        Date currentdate = new Date();
        Date endDate = new Date();
        HealthCardID healthCardID = new HealthCardID("BBBBBBBBGJ123456854231456345");
        byte[] personalSignature = new byte[] {'A', 'B', 'C'};
        DigitalSignature eSign = new DigitalSignature(personalSignature);
        MedicalPrescription MP = new MedicalPrescription(4, currentdate, endDate, healthCardID, eSign);

        String[] instruc = new String[] {String.valueOf(medicalconsultation.dayMoment.BEFOREBREAKFAST), String.valueOf(4.0F), "Cada 8 hores", String.valueOf(4.0F), String.valueOf(4.0F), String.valueOf(FqUnit.DAY)};

        MP.addLine(productID, instruc);

        String[] instruc_2 = new String[] {String.valueOf(dayMoment.AFTERLUNCH), String.valueOf(4.0F), null, String.valueOf(4.0F), String.valueOf(4.0F), String.valueOf(FqUnit.DAY)};

        try {
            MP.modifyLine(productID, instruc_2);
            fail();
        } catch (IncorrectTakingGuidelinesException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void modifyParameterTest() throws NullArgumentException, IncorrectTakingGuidelinesException, ProductNotInPrescription {
        ProductID productID = new ProductID("1234567890");
        Date currentdate = new Date();
        Date endDate = new Date();
        HealthCardID healthCardID = new HealthCardID("BBBBBBBBGJ123456854231456345");
        byte[] personalSignature = new byte[] {'A', 'B', 'C'};
        DigitalSignature eSign = new DigitalSignature(personalSignature);
        MedicalPrescription MP = new MedicalPrescription(4, currentdate, endDate, healthCardID, eSign);

        String[] instruc = new String[] {String.valueOf(medicalconsultation.dayMoment.BEFOREBREAKFAST), String.valueOf(4.0F), "Cada 8 hores", String.valueOf(4.0F), String.valueOf(4.0F), String.valueOf(FqUnit.DAY)};

        MP.addLine(productID, instruc);

        String[] instruc_2 = new String[] {String.valueOf(dayMoment.AFTERLUNCH), String.valueOf(4.0F), "Cada 8 hores", String.valueOf(4.0F), String.valueOf(4.0F), String.valueOf(FqUnit.DAY)};

        MP.modifyLine(productID, instruc_2);

        MedicalPrescriptionLine MPL = MP.hashMap.get(productID);
        TakingGuideline TGL = MPL.getGuideline();

        assertEquals(dayMoment.AFTERLUNCH, TGL.getdMoment());
    }

    @Test
    public void removeLineTest() throws NullArgumentException, IncorrectTakingGuidelinesException, ProductNotInPrescription {
        ProductID productID = new ProductID("1234567890");
        ProductID productID_2 = new ProductID("1234567891");
        Date currentdate = new Date();
        Date endDate = new Date();
        HealthCardID healthCardID = new HealthCardID("BBBBBBBBGJ123456854231456345");
        byte[] personalSignature = new byte[] {'A', 'B', 'C'};
        DigitalSignature eSign = new DigitalSignature(personalSignature);
        MedicalPrescription MP = new MedicalPrescription(4, currentdate, endDate, healthCardID, eSign);

        String[] instruc = new String[] {String.valueOf(medicalconsultation.dayMoment.BEFOREBREAKFAST), String.valueOf(4.0F), "Cada 8 hores", String.valueOf(4.0F), String.valueOf(4.0F), String.valueOf(FqUnit.DAY)};

        MP.addLine(productID, instruc);
        MP.addLine(productID_2, instruc);

        assertEquals(2, MP.hashMap.size());

        MP.removeLine(productID);

        assertEquals(1, MP.hashMap.size());
    }

    @Test
    public void removeNullProductTest() throws NullArgumentException, IncorrectTakingGuidelinesException {
        ProductID productID = new ProductID("1234567890");
        Date currentdate = new Date();
        Date endDate = new Date();
        HealthCardID healthCardID = new HealthCardID("BBBBBBBBGJ123456854231456345");
        byte[] personalSignature = new byte[] {'A', 'B', 'C'};
        DigitalSignature eSign = new DigitalSignature(personalSignature);
        MedicalPrescription MP = new MedicalPrescription(4, currentdate, endDate, healthCardID, eSign);

        String[] instruc = new String[] {String.valueOf(medicalconsultation.dayMoment.BEFOREBREAKFAST), String.valueOf(4.0F), "Cada 8 hores", String.valueOf(4.0F), String.valueOf(4.0F), String.valueOf(FqUnit.DAY)};

        MP.addLine(productID, instruc);

        try {
            MP.removeLine(null);
            fail();
        } catch (ProductNotInPrescription e) {
            e.printStackTrace();
        }
    }
    @Test
    public void removeNotExistingProductTest() throws NullArgumentException, IncorrectTakingGuidelinesException {
        ProductID productID = new ProductID("1234567890");
        Date currentdate = new Date();
        Date endDate = new Date();
        HealthCardID healthCardID = new HealthCardID("BBBBBBBBGJ123456854231456345");
        byte[] personalSignature = new byte[] {'A', 'B', 'C'};
        DigitalSignature eSign = new DigitalSignature(personalSignature);
        MedicalPrescription MP = new MedicalPrescription(4, currentdate, endDate, healthCardID, eSign);

        String[] instruc = new String[] {String.valueOf(medicalconsultation.dayMoment.BEFOREBREAKFAST), String.valueOf(4.0F), "Cada 8 hores", String.valueOf(4.0F), String.valueOf(4.0F), String.valueOf(FqUnit.DAY)};

        MP.addLine(productID, instruc);

        ProductID productID_2 = new ProductID("1234567891");

        try {
            MP.removeLine(productID_2);
            fail();
        } catch (ProductNotInPrescription e) {
            e.printStackTrace();
        }
    }
}