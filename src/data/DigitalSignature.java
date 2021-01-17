package data;

import exceptions.NullArgumentException;

final public class DigitalSignature {

    private final byte[] personalSignature;

    public DigitalSignature(byte[] personalSignature) throws NullArgumentException {
        if (personalSignature == null) {
            throw new NullArgumentException();
        }
        this.personalSignature = personalSignature;
    }

    public byte[] getSignature() { return personalSignature; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalSignature digitalS = (DigitalSignature) o;
        return personalSignature.equals(digitalS.personalSignature) || same(this.personalSignature, digitalS.personalSignature);
    }
    public boolean same(byte[] signature1, byte[] signature2){
        if(signature1.length == signature2.length){
            for(int i = 0; i <signature2.length; i++){
                if(signature1[i] != signature2[i]){
                    return false;
                }
            }
        }
        return true;
    }

}