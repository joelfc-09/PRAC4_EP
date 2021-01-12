import java.net.ConnectException;

final public class ConsultationTerminal {
    //TODO

    public void initRevision() { }throws HealthCardException, NotValidePresciptionException, ConnectException;

    public void initPrescriptionEdition(){ } throws AnyCurrentPrescriptionException, NotFinishedTreatmentException;

    public void searchForProducts(String keyWord){ } throws AnyKeyWordMedicineException,ConnectException;

    public void selectProduct(int option) { } throws AnyMedicineSearchException, ConnectException;

    public void enterMedicineGuidelines (String[] instruc){ } throws AnySelectMedicineExpcetion, IncorrectTakingGuidelinesException;

    public void enterTreatmentEndingDate (Date date){ } throws IncorrectEndingDateException;

    public void sendePrescription() { } throws ConnectException, NotValidePrescription, eSignatureException, NotCompletedMedicalPrescription;

    public void printePresc() { } throws printingException;
}
