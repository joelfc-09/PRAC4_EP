package medicalconsultation;


final public class TakingGuideline {

    private dayMoment dMoment;
    private float duration;
    private String instructions;
    private Posology posology;

    public TakingGuideline (dayMoment dM, float du, String i, float d, float f, FqUnit u){

        this.dMoment = dM;
        this.duration = du;
        this.instructions = i;
        this.posology = posology;
    }

    public dayMoment getdMoment(){
        return dMoment;
    }
    public float getDuration(){
        return duration;
    }
    public String getInstructions(){
        return instructions;
    }
    public Posology getPosology() {
        return posology;
    }
}
