package services;

import exceptions.*;
import data.*;
import medicalconsultation.*;

import java.net.ConnectException;
import java.util.List;

public interface HealthNationalService {
    MedicalPrescription getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException,
            ConnectException, NullArgumentException;
    List<ProductSpecification> getProductsByKW(String keyWord) throws AnyKeyWordMedicineException, ConnectException, NullArgumentException;
    ProductSpecification getProductSpecific(int opt) throws AnyMedicineSearchException, ConnectException, NullArgumentException;
    MedicalPrescription sendePrescription(MedicalPrescription ePresc) throws ConnectException, NotValidePrescription, eSignatureException,
            NotCompletedMedicalPrescription, NotValidePrescriptionException;
}