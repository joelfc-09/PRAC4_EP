package servicesTest;

import data.HealthCardID;
import exceptions.*;
import medicalconsultation.MedicalPrescription;
import medicalconsultation.ProductSpecification;
import services.HealthNationalService;

import java.net.ConnectException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HealthNationalServiceTest implements HealthNationalService {

    @Override
    public MedicalPrescription getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException {
        return null;
    }

    @Override
    public List<ProductSpecification> getProductsByKW(String keyWord) throws AnyKeyWordMedicineException, ConnectException {
        return null;
    }

    @Override
    public ProductSpecification getProductSpecific(int opt) throws AnyMedicineSearchException, ConnectException {
        return null;
    }

    @Override
    public MedicalPrescription sendePrescription(MedicalPrescription ePresc) throws ConnectException, NotValidePrescription, eSignatureException, NotCompletedMedicalPrescription {
        return null;
    }
}