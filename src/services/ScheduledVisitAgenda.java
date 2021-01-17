package services;

import data.HealthCardID;

import exceptions.*;

public interface ScheduledVisitAgenda { HealthCardID getHealthCarID() throws HealthCardException, NullArgumentException; }