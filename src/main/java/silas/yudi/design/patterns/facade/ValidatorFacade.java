package silas.yudi.design.patterns.facade;

import org.springframework.stereotype.Component;

import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.util.Arrays;

@Component
public class ValidatorFacade {

    private final Hasher hasher;
    private final Crypter crypter;

    public ValidatorFacade(Hasher hasher, Crypter crypter) {
        this.hasher = hasher;
        this.crypter = crypter;
    }

    public boolean validateSignature(PublicKey publicKey, byte[] originalDocument, byte[] signedDocument)
            throws GeneralSecurityException {
        byte[] decrypt = crypter.decrypt(publicKey, signedDocument);
        byte[] hashDocument = hasher.makeHash(originalDocument);
        return Arrays.equals(hashDocument, decrypt);
    }
}
