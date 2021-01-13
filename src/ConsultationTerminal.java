import java.net.ConnectException;

import exceptions.*;

import java.util.Date;

final public class ConsultationTerminal {

    public void initRevision() throws HealthCardException, NotValidePrescriptionException, ConnectException {
        //TODO
    }

    public void initPrescriptionEdition() throws AnyCurrentPrescriptionException, NotFinishedTreatmentException {
        //TODO
    }

    public void searchForProducts(String keyWord) throws AnyKeyWordMedicineException,ConnectException {
        //TODO
    }

    public void selectProduct(int option) throws AnyMedicineSearchException, ConnectException {
        //TODO
    }

    public void enterMedicineGuidelines (String[] instruc) throws AnySelectMedicineExpcetion, IncorrectTakingGuidelinesException {
        //TODO
    }

    public void enterTreatmentEndingDate (Date date) throws IncorrectEndingDateException {
        //TODO
    }

    public void sendePrescription() throws ConnectException, NotValidePrescription, eSignatureException, NotCompletedMedicalPrescription {
        //TODO
    }

    public void printePresc() throws printingException {
        //TODO
    }
}
