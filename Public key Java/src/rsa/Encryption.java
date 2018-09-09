package rsa;

import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;
import static rsa.AsymmetricCryptography.ALGORITHM;

public class Encryption {
    
    public byte[] encrypt(String texto, PublicKey chave) {
        byte[] encryptedText = null;

        try {
          final Cipher cipher = Cipher.getInstance(ALGORITHM);
          cipher.init(Cipher.ENCRYPT_MODE, chave);
          encryptedText = cipher.doFinal(texto.getBytes());
        } catch (Exception e) {
          e.printStackTrace();
        }
        return encryptedText;
    }
    
    public String decryption(byte[] text, PrivateKey key) {
        byte[] dectyptedText = null;

        try {
          final Cipher cipher = Cipher.getInstance(ALGORITHM);
          cipher.init(Cipher.DECRYPT_MODE, key);
          dectyptedText = cipher.doFinal(text);
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        return new String(dectyptedText);
    }
}
