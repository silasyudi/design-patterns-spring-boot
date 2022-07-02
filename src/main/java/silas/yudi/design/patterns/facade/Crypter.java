package silas.yudi.design.patterns.facade;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.PublicKey;

@Component
public class Crypter {

    public byte[] encrypt(PrivateKey certificate, byte[] hashedDocument) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(CryptoStandarts.TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, certificate);
        return cipher.doFinal(hashedDocument);
    }

    public byte[] decrypt(PublicKey publicKey, byte[] signedDocument) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(CryptoStandarts.TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(signedDocument);
    }
}
