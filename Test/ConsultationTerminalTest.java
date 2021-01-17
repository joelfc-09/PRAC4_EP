import data.HealthCardID;
import exceptions.HealthCardException;
import exceptions.NotValidePrescriptionException;
import exceptions.NullArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicesTest.HealthNationalServiceClass;
import servicesTest.ScheduledVisitAgendaClass;

import java.net.ConnectException;

import static org.junit.jupiter.api.Assertions.*;

class ConsultationTerminalTest {

    ConsultationTerminal CT = new ConsultationTerminal();

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
    public void initPrescriptionEditionTest() {

    }

    @Test
    public void searchForProductsTest() {

    }

    @Test
    public void selectProductTest() {

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