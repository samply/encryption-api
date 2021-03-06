package de.samply.encryption.encryptionapi.controller;

import de.samply.common.encrypt.string.implementation.asymmetric.AsymmetricException;
import de.samply.common.encrypt.string.implementation.asymmetric.AsymmetricEncryption;
import de.samply.common.encrypt.string.implementation.symmetric.SymmetricEncryption;
import de.samply.common.encrypt.string.implementation.symmetric.SymmetricException;
import de.samply.common.encrypt.string.implementation.StringEncryptionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {
    private AsymmetricEncryption asymmetricImplementation = StringEncryptionFactory.getAsymmetricEncryption(StringEncryptionFactory.Implementation.DEFAULT);
    private SymmetricEncryption symmetricImplementation = StringEncryptionFactory.getSymmetricEncryption(StringEncryptionFactory.Implementation.DEFAULT);

    // Asymmetric cryptography.

    /**
     * Return the public key used in asymmetric encryption.
     *
     * @return
     */
    public String getPublicKeyAsymmetric() {
        try {
            return asymmetricImplementation.getPublicKey();
        } catch (AsymmetricException e) {
            return e.getMessage();
        }
    }

    /**
     * Return the private key used in asymmetric encryption.
     *
     * @return
     */
    public String getPrivateKeyAsymmetric() {
        try {
            return asymmetricImplementation.getPrivateKey();
        } catch (AsymmetricException e) {
            return e.getMessage();
        }
    }

    /**
     * Set the public key used in asymmetric encryption.
     *
     * Note that keys are generally not portable between different encryption implementations.
     * E.g. a key generated by a BouncyCastle implementation won't work if you feed it
     * into a Tink implementation.
     *
     * @param publicKey
     */
    public String setPublicKeyAsymmetric(String publicKey) {
        try {
            asymmetricImplementation.setPublicKey(publicKey);
            return publicKey;
        } catch (AsymmetricException e) {
            return e.getMessage();
        }
    }

    /**
     * Set the private key used in asymmetric encryption.
     *
     * Note that keys are generally not portable between different encryption implementations.
     * E.g. a key generated by a BouncyCastle implementation won't work if you feed it
     * into a Tink implementation.
     *
     * @param publicKey
     */
    public String setPrivateKeyAsymmetric(String privateKey) {
        try {
            asymmetricImplementation.setPrivateKey(privateKey);
            return privateKey;
        } catch (AsymmetricException e) {
            return e.getMessage();
        }
    }

    /**
     * Encrypt the supplied string using the asymmetric public key.
     *
     * @param unencryptedString
     * @return
     */
    public String encryptAsymmetric(String unencryptedString) {
        String encryptedString = null;
        try {
            encryptedString = asymmetricImplementation.encrypt(unencryptedString);
        } catch (AsymmetricException e) {
            return e.getMessage();
        }

        return encryptedString;
    }

    /**
     * Decrypt the supplied (encrypted) string using the asymmetric private key.
     * @param encryptedString
     * @return
     */
    public String decryptAsymmetric(String encryptedString) {
        String unencryptedString = null;
        try {
            unencryptedString = asymmetricImplementation.decrypt(encryptedString);
        } catch (AsymmetricException e) {
            return e.getMessage();
        }

        return unencryptedString;
    }

    // Symmetric cryptography.

    /**
     * Return the secret key used in symmetric encryption.
     *
     * @return
     */
    public String getKeySymmetric() {
        try {
            return symmetricImplementation.getKey();
        } catch (SymmetricException e) {
            return e.getMessage();
        }
    }

    /**
     * Set the key used in symmetric encryption.
     *
     * Note that keys are generally not portable between different encryption implementations.
     * E.g. a key generated by a BouncyCastle implementation won't work if you feed it
     * into a Tink implementation.
     *
     * @param key
     */
    public String setKeySymmetric(String key) {
        try {
            symmetricImplementation.setKey(key);
            return key;
        } catch (SymmetricException e) {
            return e.getMessage();
        }
    }

    /**
     * Encrypt the supplied string using the symmetric key.
     *
     * @param unencryptedString
     * @return
     */
    public String encryptSymmetric(String unencryptedString) {
        String encryptedString = null;
        try {
            encryptedString = symmetricImplementation.encrypt(unencryptedString);
        } catch (SymmetricException e) {
            return e.getMessage();
        }

        return encryptedString;
    }

    /**
     * Decrypt the supplied (encrypted) string using the symmetric secret key.
     * @param encryptedString
     * @return
     */
    public String decryptSymmetric(String encryptedString) {
        String unencryptedString = null;
        try {
            unencryptedString = symmetricImplementation.decrypt(encryptedString);
        } catch (SymmetricException e) {
            return e.getMessage();
        }

        return unencryptedString;
    }
}
