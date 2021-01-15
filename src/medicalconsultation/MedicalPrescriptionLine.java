package medicalconsultation;

public class MedicalPrescriptionLine {

    private TakingGuideline guideline;

    public MedicalPrescriptionLine(dayMoment dayMoment, float duration, String instruction, float dose, float f, FqUnit freqUnit) {
        this.guideline = new TakingGuideline(dayMoment, duration, instruction, dose, f, freqUnit);
    }

    public void setGuideline(TakingGuideline guideline){
        this.guideline = guideline;
    }

    public TakingGuideline getGuideLine() {
        return guideline;
    }
}