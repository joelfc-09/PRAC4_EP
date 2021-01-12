package services;

import data.HealthCardID;

public interface ScheduledVisitAgenda {

    HealthCardID getHealthCarID() throws HealthCardException;
}
