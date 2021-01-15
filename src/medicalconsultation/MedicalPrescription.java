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

    public MedicalPrescription(int code, Date prescDate, Date endDate, HealthCardID hcID, DigitalSignature eSign) {

        this.prescCode = code;
        this.prescDate = prescDate;
        this.endDate = endDate;
        this.hcID = hcID;
        this.eSign = eSign;

    }
    public int getPrescCode () {
        return prescCode;
    }
    public Date getPrescDate () {
        return prescDate;
    }
    public Date getEndDate () {
        return endDate;
    }
    public HealthCardID getHcID () {
        return hcID;
    }
    public DigitalSignature geteSign () {
        return eSign;
    }


    public void addLine(ProductID prodID, String[] instruc) throws IncorrectTakingGuidelinesException {
        //crear un medicalprescriptioline i comproves que estigui correcte tot, despres afegir hashmap

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

    public void modifyLine(ProductID prodID, String instruct[]) throws ProductNotInPrescription {
        if (prodID == null){
            throw new ProductNotInPrescription();
        }
        hashMap.replace(prodID, instruct);
    }

    public void removeLine(ProductID prodID) throws ProductNotInPrescription {
        if (prodID == null){
            throw new ProductNotInPrescription();
        }
        hashMap.remove(prodID);
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

    
}