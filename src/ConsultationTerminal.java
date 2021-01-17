import data.HealthCardID;
import exceptions.*;
import medicalconsultation.MedicalPrescription;
import medicalconsultation.ProductSpecification;
import services.HealthNationalService;
import services.ScheduledVisitAgenda;

import java.net.ConnectException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

final public class ConsultationTerminal {

    public HealthNationalService HNS;
    public ScheduledVisitAgenda Agenda;

    public MedicalPrescription MP;
    private HealthCardID patientID;

    public Date dateActual = new Date(2021, Calendar.JANUARY, 17);

    public List<ProductSpecification> productList;

    public ProductSpecification product;

    // Setters
    public void setMedicalPrescription (MedicalPrescription MP) { this.MP = MP; }

    public MedicalPrescription getMP(){
        return MP;
    }
    public HealthCardID getHealthCardID(){
        return patientID;
    }
    public ProductSpecification getProduct(){
        return product;
    }

    public void initRevision() throws HealthCardException, NotValidePrescriptionException, ConnectException, NullArgumentException {
        patientID = Agenda.getHealthCarID();

        if (patientID == null) {
            throw new HealthCardException();
        }

        setMedicalPrescription(HNS.getePrescription(patientID));

        if (MP == null) {
            throw new NotValidePrescriptionException();
        }
        MP.printMP();
    }

    public void initPrescriptionEdition() throws AnyCurrentPrescriptionException, NotFinishedTreatmentException {
        if (MP == null) {
            throw new AnyCurrentPrescriptionException();
        }

        if (dateActual.before(MP.getEndDate())) {
            throw new NotFinishedTreatmentException();
        }
    }

    public void searchForProducts(String keyWord) throws AnyKeyWordMedicineException, ConnectException, NullArgumentException {
        if (keyWord == null) {
            throw new AnyKeyWordMedicineException();
        }
        productList = HNS.getProductsByKW(keyWord);

    }

    public void selectProduct(int option) throws AnyMedicineSearchException, ConnectException, NullArgumentException {
        product = HNS.getProductSpecific(option);
    }

    public void enterMedicineGuidelines(String[] instruc) throws AnySelectMedicineExpcetion, IncorrectTakingGuidelinesException, NullArgumentException {
        if (instruc == null) {
            throw new AnySelectMedicineExpcetion();
        }

        if (!MP.checkAllParameters(instruc)) {
            throw new IncorrectTakingGuidelinesException();
        }
        MP.addLine(product.UPCcode, instruc);
    }

    public void enterTreatmentEndingDate(Date date) throws IncorrectEndingDateException {
        if (date.before(dateActual)) {
            throw new IncorrectEndingDateException();
        }
        MP.setPrescDate(dateActual);
        MP.setEndDate(date);
    }


    public void sendePrescription() throws ConnectException, NotValidePrescription, eSignatureException, NotCompletedMedicalPrescription, NotValidePrescriptionException {

        MP = HNS.sendePrescription(MP);
    }

    public void printePresc() throws printingException {

        // Nothing

    }
}