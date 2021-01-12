package medicalconsultation;

import data.DigitalSignature;
import data.HealthCardID;
import data.ProductID;
import java.util.Date;

public class MedicalPrescription {
    private int prescCode;
    private Date prescDate;
    private Date endDate;
    private HealthCardID hcID;
    private DigitalSignature eSign;

    public MedicalPrescription(){
        this.prescCode = ;
        this.prescDate = new Date();
        this.endDate = new Date();
        this.hcID = hcID;
    }

    public void addLine(ProductID prodID, String[] instruc){ } throws ProductNotInPrescription, IncorrectTakingGuidelinesException;

    public void removeLine(ProductID proID){ } throws ProductNotInPrescription;
}
