package com.rnavagamuwa;

import com.rnavagamuwa.cipher.AES256Cipher;
import com.rnavagamuwa.cipher.CipherAPI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class AES256CipherTest {

    private String stringToBeEncrypted;

    public AES256CipherTest(String stringToBeEncrypted) {
        this.stringToBeEncrypted = stringToBeEncrypted;
    }

    @Test
    public void testEncryptionDecryption() {
        CipherAPI cipherAPI = new AES256Cipher();
        assertEquals(stringToBeEncrypted, cipherAPI.decrypt(cipherAPI.encrypt(stringToBeEncrypted)));
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        List<Object[]> list = new ArrayList<>();
        byte[] array = new byte[10];

        for (int i = 0; i < 100; i++) {
            new Random().nextBytes(array);
            list.add(new Object[]{new String(array, Charset.forName("UTF-8"))});
        }

        return list;
    }
}
