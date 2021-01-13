package medicalconsultation;

import data.*;
import exceptions.ProductNotInPrescription;

import java.util.Date;

public class MedicalPrescription {
    private int prescCode;
    private Date prescDate;
    private Date endDate;
    private HealthCardID hcID;
    private DigitalSignature eSign;

    //TODO Its components, that is, the set of medical prescription lines

    public MedicalPrescription(){
        this.prescCode = prescCode;
        this.prescDate = new Date();
        this.endDate = new Date();
        this.hcID = hcID;
    }

    public void addLine(ProductID prodID, String[] instruc){
        //TODO
    }

    public void modifyLine(ProductID prodID, String instruct) throws ProductNotInPrescription {
        //TODO
    }

    public void removeLine(ProductID proID) throws ProductNotInPrescription {
        //TODO
    }

    //TODO the getters and setters
}