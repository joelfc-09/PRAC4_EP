package medicalconsultation;

import exceptions.NullArgumentException;

final public class TakingGuideline {

    private dayMoment dMoment;
    private float duration;
    private String instructions;
    private Posology posology;

    public TakingGuideline (dayMoment dM, float du, String i, float d, float f, FqUnit u) throws NullArgumentException {
        if (dM == null || i == null) {
            throw new NullArgumentException();
        }
        this.dMoment = dM;
        this.duration = du;
        this.instructions = i;
        this.posology = new Posology(d, f, u);
    }

    // Getters and Setters
    public dayMoment getdMoment() { return dMoment; }

    public void setdMoment(dayMoment dMoment) { this.dMoment = dMoment; }

    public float getDuration() { return duration; }

    public void setDuration(float duration) { this.duration = duration; }

    public String getInstructions() { return instructions; }

    public void setInstructions(String instructions) { this.instructions = instructions; }

    public Posology getPosology() { return posology; }

    public void setPosology(Posology posology) { this.posology = posology; }
}