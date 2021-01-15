package medicalconsultation;

import data.*;
import exceptions.IncorrectTakingGuidelinesException;
import exceptions.ProductNotInPrescription;

import java.util.Date;
import java.util.HashMap;

public class MedicalPrescription {
    private int prescCode;
    private Date prescDate;
    private Date endDate;
    private HealthCardID hcID;
    private DigitalSignature eSign;

    public HashMap<ProductID, String[]> hashMap = new HashMap<>();

    //TODO Its components, that is, the set of medical prescription lines

    public MedicalPrescription(){
        this.prescCode = prescCode;
        this.prescDate = new Date();
        this.endDate = new Date();
        this.hcID = hcID;
    }

    public void addLine(ProductID prodID, String[] instruc) throws IncorrectTakingGuidelinesException {

        if(instruc.length != 6) {
            throw  new IncorrectTakingGuidelinesException();

        }
        for (String s : instruc) {
            if (s == null) {
                throw new IncorrectTakingGuidelinesException();
            }
        }

        if (checkAllParameters(instruc)) {
            hashMap.put(prodID, instruc);
        }
    }

    public void modifyLine(ProductID prodID, String[] instruct) throws ProductNotInPrescription {
        hashMap.replace(prodID, instruct);
    }

    public void removeLine(ProductID proID) throws ProductNotInPrescription {
        hashMap.remove(proID);
    }

    public boolean checkAllParameters(String[] instruc) throws IncorrectTakingGuidelinesException{
        try{
            dayMoment.valueOf(instruc[0]);
        }catch (Exception e) {
            throw new IncorrectTakingGuidelinesException();
        }

        try{
            Float.valueOf(instruc[1]);
        }catch ( Exception e) {
            throw new IncorrectTakingGuidelinesException();
        }

        try{
            String.valueOf(instruc[2]);
        }catch (Exception e) {
            throw new IncorrectTakingGuidelinesException();
        }

        try{
            Float.valueOf(instruc[3]);
        }catch (Exception e){
            throw new IncorrectTakingGuidelinesException();
        }

        try{
            Float.valueOf(instruc[4]);
        }catch (Exception e){
            throw new IncorrectTakingGuidelinesException();
        }

        try {
            FqUnit.valueOf(instruc[5]);
        }catch (Exception e){
            throw new IncorrectTakingGuidelinesException();
        }
        return true;
    }

    //TODO the getters and setters
}