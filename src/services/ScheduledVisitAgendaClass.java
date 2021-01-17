package services;

import data.HealthCardID;
import exceptions.HealthCardException;
import exceptions.NullArgumentException;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class ScheduledVisitAgendaClass implements ScheduledVisitAgenda {

    public Date visitDate;

    public HashMap<Date, HealthCardID> agenda = new HashMap<>();

    public ScheduledVisitAgendaClass(Date visitDate) { this.visitDate = visitDate; }

    @Override
    public HealthCardID getHealthCarID() throws NullArgumentException, HealthCardException {
        agenda.put(new Date(2021, Calendar.JANUARY, 18, 9, 25), new HealthCardID("BBBBBBBBGJ123456854231456345"));
        agenda.put(new Date(2021, Calendar.JANUARY, 18, 11, 5), new HealthCardID("BBBBBBBBFP123456854231456345"));
        agenda.put(new Date(2021, Calendar.JANUARY, 19, 17, 50), new HealthCardID("BBBBBBBBGJ123456854298256345"));

        for (int i = 0; i < agenda.size(); i++) {
            if (agenda.containsKey(visitDate)) {
                return agenda.get(visitDate);
            }
        }
        throw new HealthCardException();
    }
}
