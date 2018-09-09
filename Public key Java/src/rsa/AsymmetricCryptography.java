
package rsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AsymmetricCryptography {
    
    public static final String ALGORITHM = "RSA";
    private final KeyPair keyPair;
    private KeyPairGenerator keyPairGenerator;
    
    public AsymmetricCryptography(){  
        try {
            keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AsymmetricCryptography.class.getName()).log(Level.SEVERE, null, ex);
        } 
        keyPairGenerator.initialize(1024);
        keyPair = keyPairGenerator.generateKeyPair();
    }
    
    public PublicKey getPublicKey(){
        return keyPair.getPublic();
    }
    
    public PrivateKey getPrivateKey(){
        return keyPair.getPrivate();
    }
}
