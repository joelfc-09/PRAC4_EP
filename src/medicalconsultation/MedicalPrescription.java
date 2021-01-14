package medicalconsultation;

import data.*;
import exceptions.IncorrectTakingGuidelinesException;
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

    public void addLine(ProductID prodID, String[] instruc) throws IncorrectTakingGuidelinesException {
        //crear un medicalprescriptioline i comproves que estigui correcte tot, despres afegir hashmap

        if(instruc.length != 6) {
            throw  new IncorrectTakingGuidelinesException();

        }
        for(int i = 0; i < instruc.length; i++){
            if(instruc[i] == null){
                throw new IncorrectTakingGuidelinesException();
            }
        }
        checkAllParameters(instruc);

        //TODO CREAR EL HASHMAP I ACABAR LA FUNCIÓ:D


    }

    public void checkAllParameters(String instruc[]) throws IncorrectTakingGuidelinesException{
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

    }

    public void modifyLine(ProductID prodID, String instruct) throws ProductNotInPrescription {
        //TODO
    }

    public void removeLine(ProductID proID) throws ProductNotInPrescription {
        //TODO
    }



    //TODO the getters and setters
}