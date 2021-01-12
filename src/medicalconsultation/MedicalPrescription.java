package medicalconsultation;

import data.DigitalSignature;
import data.HealthCardID;
import data.ProductID;

public class MedicalPrescription {
    private int prescCode;
    private Date prescDate;
    private Date endDate;
    private HealthCardID hcID;
    private DigitalSignature eSign;

    public MedicalPrescription(){ }

    public void addLine(ProductID prodID, String[] instruc){ } throws ProductNotInPrescription, IncorrectTakingGuidelinesException;

    public void removeLine(ProductID proID){ } throws ProductNotInPrescription;
}
