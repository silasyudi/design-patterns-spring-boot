package silas.yudi.design.patterns.facade;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SignatureFacadesTest {

    @Autowired
    private SignerFacade signerFacade;
    @Autowired
    private ValidatorFacade validatorFacade;

    private static KeyPair certificate;
    private static byte[] input;

    @BeforeAll
    public static void setup() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(1024);
        certificate = generator.generateKeyPair();

        input = "ILoveDesignPatterns".getBytes(StandardCharsets.UTF_8);
    }

    @Test
    public void shouldSignAndValidateDocument() throws GeneralSecurityException {
        byte[] signedDocument = signerFacade.signDocument(certificate.getPrivate(), input);
        boolean isValid = validatorFacade.validateSignature(certificate.getPublic(), input, signedDocument);
        assertTrue(isValid);
    }
}
