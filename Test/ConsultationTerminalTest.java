import data.DigitalSignature;
import data.HealthCardID;
import data.ProductID;
import exceptions.*;
import medicalconsultation.MedicalPrescription;
import medicalconsultation.ProductSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicesTest.HealthNationalServiceClass;
import servicesTest.ScheduledVisitAgendaClass;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ConsultationTerminalTest {

    ConsultationTerminal CT = new ConsultationTerminal();
    HashMap<String, ProductSpecification> productsCatalogue = new HashMap<>();

    ConsultationTerminalTest() throws NullArgumentException {
    }

    @BeforeEach
    public void beforeEach() throws NullArgumentException {
        ScheduledVisitAgendaClass agendaClass = new ScheduledVisitAgendaClass();
        agendaClass.addVisit(new HealthCardID("BBBBBBBBGJ123456854231456345"));

        CT.HNS = new HealthNationalServiceClass();

        CT.Agenda = agendaClass;

    }

    @Test
    public void initRevisionTest() throws NotValidePrescriptionException, HealthCardException, ConnectException, NullArgumentException {
        CT.Agenda = new ScheduledVisitAgendaClass();
        try {
            CT.initRevision();
            fail();
        } catch (HealthCardException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void initRevisionGoodTest()throws NotValidePrescriptionException, HealthCardException, ConnectException, NullArgumentException {

        ConsultationTerminal expectedCT = new ConsultationTerminal();
        CT.initRevision();
        HealthCardID HcIDnew = CT.getHealthCardID();
        expectedCT.setMedicalPrescription(SetUpMedicalPrescription(HcIDnew));
        assertTrue(expectedCT.getMP().equals(CT.getMP()));

    }

    public MedicalPrescription SetUpMedicalPrescription(HealthCardID hcID) throws HealthCardException, NullArgumentException, ConnectException, NotValidePrescriptionException {
        return CT.HNS.getePrescription(hcID);

    }
    @Test
    public void initPrescriptionEditionTest() {

        try{
            CT.initPrescriptionEdition();
            fail();
        }catch (AnyCurrentPrescriptionException | NotFinishedTreatmentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchForProductsTest() throws ConnectException, NullArgumentException, AnyKeyWordMedicineException {

        assertThrows(AnyKeyWordMedicineException.class, () -> CT.searchForProducts(null));

    }

    @Test
    public void selectProductTest() throws HealthCardException, NullArgumentException, ConnectException, NotValidePrescriptionException, AnyKeyWordMedicineException, AnyMedicineSearchException {
        CT.initRevision();
        CT.searchForProducts("Mal de cap");
        CT.selectProduct(1);
        ProductSpecification expProduct = new ProductSpecification(new ProductID("78565"),"Dalsy per a nens", new BigDecimal(5));
        assertEquals(CT.getProduct(),expProduct);

    }

    @Test
    public void enterMedicineGuidelinesTest() throws HealthCardException, NullArgumentException, ConnectException, NotValidePrescriptionException, AnyKeyWordMedicineException, AnyMedicineSearchException, IncorrectTakingGuidelinesException, AnySelectMedicineExpcetion {
        CT.initRevision();
        CT.searchForProducts("Mal de cap");
        CT.selectProduct(1);
        String[] instruc = {"DURINGDINNER", "6", "Maxim 5 pastilles per dia", "8", "7", "MONTH"};
        CT.enterMedicineGuidelines(instruc);
        MedicalPrescription expMP= new MedicalPrescription(6547, new Date(2021, Calendar.JANUARY, 17, 10, 41), new Date(2021, Calendar.FEBRUARY, 4, 12, 0), new HealthCardID("BBBBBBBBGJ123456854231456345"), new DigitalSignature(new byte[]{'P', 'A', 'U'}));

        expMP.addLine(new ProductID("78565"), instruc);
        assertEquals(expMP,CT.getMP());

    }

    @Test
    public void enterTreatmentEndingDateTest() throws HealthCardException, NullArgumentException, ConnectException, NotValidePrescriptionException, AnyKeyWordMedicineException, AnyMedicineSearchException, IncorrectTakingGuidelinesException, AnySelectMedicineExpcetion, IncorrectEndingDateException {
        CT.initRevision();
        CT.searchForProducts("Mal de cap");
        CT.selectProduct(1);
        String[] instruc = {"DURINGDINNER", "6", "Maxim 5 pastilles per dia", "8", "7", "MONTH"};
        CT.enterMedicineGuidelines(instruc);
        Date expPrescDate = new Date(2021,Calendar.JANUARY,17);
        Date expEndDate = new Date(2021, Calendar.JANUARY,20);
        CT.enterTreatmentEndingDate(expEndDate);
        assertEquals(expPrescDate,CT.MP.getPrescDate());
        assertEquals(expEndDate, CT.MP.getEndDate());

    }

    @Test
    public void sendePrescriptionTest() throws HealthCardException, NullArgumentException, ConnectException, NotValidePrescriptionException, AnyKeyWordMedicineException, AnyMedicineSearchException, IncorrectTakingGuidelinesException, AnySelectMedicineExpcetion, IncorrectEndingDateException, NotCompletedMedicalPrescription, NotValidePrescription, eSignatureException {

        CT.initRevision();
        CT.searchForProducts("Mal de cap");
        CT.selectProduct(1);
        String[] instruc = {"DURINGDINNER", "6", "Maxim 5 pastilles per dia", "8", "7", "MONTH"};
        CT.enterMedicineGuidelines(instruc);
        Date expEndDate = new Date(2021, Calendar.JANUARY,20);
        CT.enterTreatmentEndingDate(expEndDate);
        CT.sendePrescription();
        assertEquals(20,CT.MP.getPrescCode());

    }

}