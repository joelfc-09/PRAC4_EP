package servicesTest;

import data.HealthCardID;
import exceptions.HealthCardException;
import exceptions.NullArgumentException;
import services.ScheduledVisitAgenda;

import java.util.*;

public class ScheduledVisitAgendaClass implements ScheduledVisitAgenda {

    public Queue<HealthCardID> agenda = new LinkedList<>();

    public ScheduledVisitAgendaClass() {}

    @Override
    public HealthCardID getHealthCarID() throws NullArgumentException, HealthCardException {
        if (agenda.isEmpty()) {
            throw new HealthCardException();
        }
        return agenda.poll();
    }

    public void addVisit(HealthCardID healthCardID) {
        agenda.add(healthCardID);
    }
}
