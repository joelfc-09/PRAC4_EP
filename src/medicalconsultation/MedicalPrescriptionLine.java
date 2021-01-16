package medicalconsultation;

import exceptions.NullArgumentException;

public class MedicalPrescriptionLine {

    private TakingGuideline guideline;

    public MedicalPrescriptionLine(dayMoment dayMoment, float duration, String instruction, float dose, float f, FqUnit freqUnit) throws NullArgumentException {
        if (dayMoment == null || instruction == null || freqUnit == null) {
            throw new NullArgumentException();
        }
        this.guideline = new TakingGuideline(dayMoment, duration, instruction, dose, f, freqUnit);
    }

    // Getters and Setters
    public TakingGuideline getGuideline() { return guideline; }

    public void setGuideline(TakingGuideline guideline) { this.guideline = guideline; }
}