package services;

import data.HealthCardID;

import exceptions.*;

import java.util.Date;

public interface ScheduledVisitAgenda {
    HealthCardID getHealthCarID() throws HealthCardException, NullArgumentException;
}