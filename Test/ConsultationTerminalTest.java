import exceptions.HealthCardException;
import exceptions.NotValidePrescriptionException;
import exceptions.NullArgumentException;
import org.junit.jupiter.api.Test;
import services.ScheduledVisitAgenda;

import java.net.ConnectException;

import static org.junit.jupiter.api.Assertions.*;

class ConsultationTerminalTest {
    @Test
    public void initRevisionTest() throws NotValidePrescriptionException, HealthCardException, ConnectException {
        ConsultationTerminal consultationTerminal = new ConsultationTerminal();
        consultationTerminal.initRevision();
    }

}