package silas.yudi.design.patterns.facade;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class Hasher {

    public byte[] makeHash(byte[] document) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(CryptoStandarts.ALGORITHM);
        return messageDigest.digest(document);
    }
}
