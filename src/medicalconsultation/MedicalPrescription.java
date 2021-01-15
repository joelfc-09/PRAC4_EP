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

    public MedicalPrescription(int prescCode, Date prescDate, Date endDate, HealthCardID hcID, DigitalSignature eSign){
        this.prescCode = prescCode;
        this.prescDate = prescDate;
        this.endDate = endDate;
        this.hcID = hcID;
        this.eSign = eSign;
    }

    // Getters
    public int getPrescCode () { return prescCode; }
    public Date getPrescDate () { return prescDate; }
    public Date getEndDate () { return endDate; }
    public HealthCardID getHcID () { return hcID; }
    public DigitalSignature geteSign () { return eSign; }

    // Setters
    public void setPrescCode(int prescCode) { this.prescCode = prescCode; }
    public void setPrescDate(Date prescDate) { this.prescDate = prescDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    public void setHcID(HealthCardID hcID) { this.hcID = hcID; }
    public void seteSign(DigitalSignature eSign) { this.eSign = eSign; }

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

    @Override
    public String toString() {
        return "MedicalPrescription{" +
                "prescCode=" + prescCode +
                ", prescDate=" + prescDate +
                ", endDate=" + endDate +
                ", hcID=" + hcID +
                ", eSign=" + eSign +
                ", hashMap=" + hashMap +
                '}';
    }

    public void printMP() {
        System.out.println(toString());
    }

    public boolean checkAllParameters(String[] instruc) throws IncorrectTakingGuidelinesException{
        try{
            dayMoment.valueOf(instruc[0]);
        } catch (Exception e) {
            throw new IncorrectTakingGuidelinesException();
        }

        try{
            Float.valueOf(instruc[1]);
        } catch ( Exception e) {
            throw new IncorrectTakingGuidelinesException();
        }

        try{
            String.valueOf(instruc[2]);
        } catch (Exception e) {
            throw new IncorrectTakingGuidelinesException();
        }

        try{
            Float.valueOf(instruc[3]);
        } catch (Exception e){
            throw new IncorrectTakingGuidelinesException();
        }

        try{
            Float.valueOf(instruc[4]);
        } catch (Exception e){
            throw new IncorrectTakingGuidelinesException();
        }

        try {
            FqUnit.valueOf(instruc[5]);
        } catch (Exception e){
            throw new IncorrectTakingGuidelinesException();
        }
        return true;
    }
}