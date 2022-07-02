package silas.yudi.design.patterns.facade;

import org.springframework.stereotype.Component;

import java.security.GeneralSecurityException;
import java.security.PrivateKey;

@Component
public class SignerFacade {

    private final Hasher hasher;
    private final Crypter crypter;

    public SignerFacade(Hasher hasher, Crypter crypter) {
        this.hasher = hasher;
        this.crypter = crypter;
    }

    public byte[] signDocument(PrivateKey certificate, byte[] document) throws GeneralSecurityException {
        byte[] hashDocument = hasher.makeHash(document);
        return crypter.encrypt(certificate, hashDocument);
    }
}
