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
        return personalSignature.equals(digitalS.personalSignature);
    }
}