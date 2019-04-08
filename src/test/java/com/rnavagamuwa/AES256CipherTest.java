package com.rnavagamuwa;

import com.rnavagamuwa.cipher.AES256Cipher;
import com.rnavagamuwa.cipher.CipherAPI;
import junit.framework.TestCase;
import org.junit.Test;


public class AES256CipherTest extends TestCase {

    @Test
    public void testEncryptionDecryption() {
        String stringToBeEncrypted = "message";
        CipherAPI cipherAPI = new AES256Cipher();
        assertEquals(stringToBeEncrypted, cipherAPI.decrypt(cipherAPI.encrypt(stringToBeEncrypted)));
    }
}
