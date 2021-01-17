package servicesTest;

import data.DigitalSignature;
import data.HealthCardID;
import data.ProductID;
import exceptions.*;
import medicalconsultation.MedicalPrescription;
import medicalconsultation.ProductSpecification;
import services.HealthNationalService;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.*;

public class HealthNationalServiceClass implements HealthNationalService {

    public HealthCardID hcID;
    public String keyWord;
    public int opt;
    public MedicalPrescription MP;

    HashMap<HealthCardID, MedicalPrescription> patientsePrescriptions = new HashMap<>();

    HashMap<String, ProductSpecification> productsCatalogue = new HashMap<>();
    List<ProductSpecification> productsFound = new ArrayList<>();

    HashMap<Integer, ProductSpecification> productsSpecifications = new HashMap<>();

    public int prescCode;

    public HealthNationalServiceClass() {}

    @Override
    public MedicalPrescription getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException, NullArgumentException {
        patientsePrescriptions.put(new HealthCardID("BBBBBBBBGJ123456854231456345"), new MedicalPrescription(6547, new Date(2021, Calendar.JANUARY, 17, 10, 41), new Date(2021, Calendar.FEBRUARY, 4, 12, 0), new HealthCardID("BBBBBBBBGJ123456854231456345"), new DigitalSignature(new byte[]{'P', 'A', 'U'})));
        patientsePrescriptions.put(new HealthCardID("BBBBBBBBFT123456854231456345"), new MedicalPrescription(4567, new Date(2021, Calendar.JANUARY, 17, 10, 41), new Date(2021, Calendar.APRIL, 25, 18, 30), new HealthCardID("BBBBBBBBFT123456854231456345"), new DigitalSignature(new byte[]{'L', 'L', 'U', 'C'})));
        patientsePrescriptions.put(new HealthCardID("BBBBBBBBPO123456898631456345"), new MedicalPrescription(6547, new Date(2021, Calendar.JANUARY, 17, 10, 41), new Date(2021, Calendar.DECEMBER, 9, 16, 5), new HealthCardID("BBBBBBBBPO123456898631456345"), new DigitalSignature(new byte[]{'M', 'A', 'R', 'C'})));

        for (int i = 0; i < patientsePrescriptions.size(); i++) {
            if (patientsePrescriptions.containsKey(hcID)) {
                return patientsePrescriptions.get(hcID);
            }
        }
        throw new HealthCardException();
    }

    @Override
    public List<ProductSpecification> getProductsByKW(String keyWord) throws AnyKeyWordMedicineException, ConnectException, NullArgumentException {
        productsCatalogue.put("Paracetamol", new ProductSpecification(new ProductID("45656"),"Paracetamol en sobres", new BigDecimal(1)));
        productsCatalogue.put("Dalsy", new ProductSpecification(new ProductID("78565"),"Dalsy per a nens", new BigDecimal(5)));
        productsCatalogue.put("600mg", new ProductSpecification(new ProductID("24344"),"Ibuprofeo 600mg", new BigDecimal(3)));

        for (int i = 0; i < productsCatalogue.size(); i++) {
            if (productsCatalogue.containsKey(keyWord)) {
                productsFound.add(productsCatalogue.get(keyWord));
            }
        }
        return productsFound;
    }

    @Override
    public ProductSpecification getProductSpecific(int opt) throws AnyMedicineSearchException, ConnectException, NullArgumentException {
        productsSpecifications.put(5443, new ProductSpecification(new ProductID("45656"),"Paracetamol en sobres", new BigDecimal(1)));
        productsSpecifications.put(7453, new ProductSpecification(new ProductID("78565"),"Dalsy per a nens", new BigDecimal(5)));
        productsSpecifications.put(9882, new ProductSpecification(new ProductID("24344"),"Ibuprofeo 600mg", new BigDecimal(3)));

        for (int i = 0; i < productsSpecifications.size(); i++) {
            if (productsSpecifications.containsKey(opt)) {
                return productsSpecifications.get(opt);
            }
        }
        throw new AnyMedicineSearchException();
    }

    @Override
    public MedicalPrescription sendePrescription(MedicalPrescription ePresc) throws ConnectException, NotValidePrescription, eSignatureException, NotCompletedMedicalPrescription, NotValidePrescriptionException {
        Random random = new Random();
        int random_code = random.nextInt(500);
        ePresc.setPrescCode(random_code);
        if (ePresc.getPrescDate().before(new Date()) || ePresc.getEndDate().after(new Date())) {
            throw new NotValidePrescriptionException();
        }
        if (ePresc.hashMap.size() < 1) {
            throw new NotCompletedMedicalPrescription();
        }
        return ePresc;
    }

    public void addProduct(ProductSpecification productSpecification) {

    }

    public void addPrescription(MedicalPrescription medicalPrescription) {

    }
}