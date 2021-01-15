package data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitalSignatureTest {
    @Test
    public void getDigitalSignature_Test() {
        byte[] byte_ARR = {'S', 'I', 'G', 'N'};
        DigitalSignature signature = new DigitalSignature(byte_ARR);
        assertEquals(signature.getSignature(), byte_ARR);
    }

    @Test
    public void getDigitalSignature_TestV2() {
        //TODO
        byte[] byte_ARR = {'S', 'I', 'G', 'N'};
        DigitalSignature signature = new DigitalSignature(byte_ARR);
        byte[] byte_ARR_EXP = {'S', 'I', 'G', 'N'};
        assertEquals(signature.getSignature(), byte_ARR_EXP);
    }

    @Test
    public void getDigitalSignature_TestV3() {
        DigitalSignature signature = new DigitalSignature(null);
        assertNull(signature.getSignature());
    }

    @Test
    public void getDigitalSignature_TestV4() {
        DigitalSignature signature = new DigitalSignature(null);
        byte[] byte_ARR_EXP = {'S', 'I', 'G', 'N'};
        assertNotEquals(signature.getSignature(), byte_ARR_EXP);
    }

    @Test
    public void DigitalSignatureObject_Test() {
        byte[] byte_ARR = {'S', 'I', 'G', 'N'};
        DigitalSignature signature = new DigitalSignature(byte_ARR);
        Object byte_ARR_EXP = new Object();
        assertNotEquals(signature, byte_ARR_EXP);
    }

    @Test
    public void equalsFunctionTest() {
        byte[] byte_ARR = {'S', 'I', 'G', 'N'};
        DigitalSignature signature = new DigitalSignature(byte_ARR);
        DigitalSignature signature_2 = new DigitalSignature(byte_ARR);
        assertTrue(signature.equals(signature_2));
    }

    @Test
    public void notEqualsFunctionTest() {
        byte[] byte_ARR = {'S', 'I', 'G', 'N'};
        byte[] byte_ARR_2 = {'H', 'E', 'L', 'L', 'O'};
        DigitalSignature signature = new DigitalSignature(byte_ARR);
        DigitalSignature signature_2 = new DigitalSignature(byte_ARR_2);
        assertFalse(signature.equals(signature_2));
    }
}