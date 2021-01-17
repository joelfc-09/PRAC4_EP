package servicesTest;

import data.HealthCardID;
import exceptions.HealthCardException;
import services.ScheduledVisitAgenda;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class ScheduledVisitAgendaTest implements ScheduledVisitAgenda {

    public static Queue<HealthCardID> agendaQueue = new LinkedList<>();

    @Override
    public HealthCardID getHealthCarID() throws HealthCardException {
        return null;
    }

}