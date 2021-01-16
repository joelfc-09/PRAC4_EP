package medicalconsultation;

import data.*;
import exceptions.IncorrectTakingGuidelinesException;
import exceptions.NullArgumentException;
import exceptions.ProductNotInPrescription;

import java.util.Date;
import java.util.HashMap;

public class MedicalPrescription {
    private int prescCode;
    private Date prescDate;
    private Date endDate;
    private HealthCardID hcID;
    private DigitalSignature eSign;

    public HashMap<ProductID, MedicalPrescriptionLine> hashMap = new HashMap<>();

    public MedicalPrescription(int prescCode, Date prescDate, Date endDate, HealthCardID hcID, DigitalSignature eSign) throws NullArgumentException {
        if (prescDate == null || endDate == null || hcID == null || eSign == null) {
            throw new NullArgumentException();
        }
        this.prescCode = prescCode;
        this.prescDate = prescDate;
        this.endDate = endDate;
        this.hcID = hcID;
        this.eSign = eSign;
    }

    // Getters and Setters
    public int getPrescCode() { return prescCode; }

    public void setPrescCode(int prescCode) { this.prescCode = prescCode; }

    public Date getPrescDate() { return prescDate; }

    public void setPrescDate(Date prescDate) { this.prescDate = prescDate; }

    public Date getEndDate() { return endDate; }

    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public HealthCardID getHcID() { return hcID; }

    public void setHcID(HealthCardID hcID) { this.hcID = hcID; }

    public DigitalSignature geteSign() { return eSign; }

    public void seteSign(DigitalSignature eSign) { this.eSign = eSign; }

    public HashMap<ProductID, MedicalPrescriptionLine> getHashMap() { return hashMap; }

    public void setHashMap(HashMap<ProductID, MedicalPrescriptionLine> hashMap) { this.hashMap = hashMap; }

    public void addLine(ProductID prodID, String[] instruc) throws IncorrectTakingGuidelinesException, NullArgumentException {
        if (prodID == null) {
            throw new NullArgumentException();
        } else if(instruc.length != 6) {
            throw new IncorrectTakingGuidelinesException();
        }
        for (String s : instruc) {
            if (s == null) {
                throw new IncorrectTakingGuidelinesException();
            }
        }

        if (checkAllParameters(instruc)) {
            MedicalPrescriptionLine mpl = new MedicalPrescriptionLine(dayMoment.valueOf(instruc[0]), Float.parseFloat(instruc[1]), instruc[2], Float.parseFloat(instruc[3]), Float.parseFloat(instruc[4]), FqUnit.valueOf(instruc[5]));
            hashMap.put(prodID, mpl);
        }
    }

    public void modifyLine(ProductID prodID, String[] instruc) throws ProductNotInPrescription, NullArgumentException, IncorrectTakingGuidelinesException {
        if (prodID == null){
            throw new ProductNotInPrescription();
        } else if (instruc.length != 6) {
            throw new IncorrectTakingGuidelinesException();
        }
        if (checkAllParameters(instruc)) {
            MedicalPrescriptionLine mpl = new MedicalPrescriptionLine(dayMoment.valueOf(instruc[0]), Float.parseFloat(instruc[1]), instruc[2], Float.parseFloat(instruc[3]), Float.parseFloat(instruc[4]), FqUnit.valueOf(instruc[5]));
            hashMap.replace(prodID, mpl);
        }
    }

    public void removeLine(ProductID prodID) throws ProductNotInPrescription {
        if (prodID == null){
            throw new ProductNotInPrescription();
        }

        if (!hashMap.containsKey(prodID)) {
            throw new ProductNotInPrescription();
        }
        hashMap.remove(prodID);
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

        if (instruc[2] == null) {
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