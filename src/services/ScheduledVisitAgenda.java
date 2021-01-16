package services;

import dataTest.HealthCardID;

import exceptions.*;

public interface ScheduledVisitAgenda { HealthCardID getHealthCarID() throws HealthCardException; }