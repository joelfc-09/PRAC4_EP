package dataTest;

import data.DigitalSignature;
import exceptions.NullArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitalSignatureTest {
    @Test
    public void nullTest() {
        byte[] sing = null;
        try {
            DigitalSignature dSign = new DigitalSignature(sing);
            fail();
        } catch (NullArgumentException e) {
            e.printStackTrace();
        }
    }
}