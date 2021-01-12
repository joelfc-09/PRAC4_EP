package services;

import data.HealthCardID;

public interface ScheduledVisitAgenda {

    /* comprovar si el HealthCardId té un visita concertada en aquest centre de salut*/

    HealthCardID getHealthCarID() throws HealthCardException;
}
