package rsa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PublicKeyTest {
    private static final String TEXT = "Hello World";
    private AsymmetricCryptography asymmetricCryptography;
    
    @Before
    public void setUp() {
        asymmetricCryptography = new AsymmetricCryptography();
    }

    @Test
    public void encryptUsingPublicKeyAndDecryptUsingPrivateKey() {
        Encryption encryption = new Encryption();
        byte[] encryptedText = encryption.encrypt(TEXT, asymmetricCryptography.getPublicKey());
        String dectyptedText = encryption.decryption(encryptedText, asymmetricCryptography.getPrivateKey()); 
        Assert.assertEquals(TEXT, dectyptedText);  
    }
    
    @Test(expected=NullPointerException.class)
    public void encryptUsingPublicKeyAndDoesNotDecryptUsingDifferentPrivateKey() {
        AsymmetricCryptography asymmetricCryptographyOther = new AsymmetricCryptography();
        Encryption encryption = new Encryption();
        byte[] encryptedText = encryption.encrypt(TEXT, asymmetricCryptography.getPublicKey());
        fail(encryption.decryption(encryptedText, asymmetricCryptographyOther.getPrivateKey()));
    }   
}
