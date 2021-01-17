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
    public void searchForProductsNullTest() throws ConnectException, NullArgumentException, AnyKeyWordMedicineException {

        assertThrows(AnyKeyWordMedicineException.class, () -> CT.searchForProducts(null));

    }

    @Test
    public void selectProductTest() throws HealthCardException, NullArgumentException, ConnectException, NotValidePrescriptionException {
    }

    @Test
    public void enterMedicineGuidelinesTest() {

    }

    @Test
    public void enterTreatmentEndingDateTest() {

    }

    @Test
    public void sendePrescriptionTest() {

    }

}