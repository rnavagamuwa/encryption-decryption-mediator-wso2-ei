package com.rnavagamuwa.cipher;

/**
 * @author Randika Navagamuwa
 */
public interface CipherAPI {

    String encrypt(String stringToBeEncrypted);

    String decrypt(String encryptedString);
}
