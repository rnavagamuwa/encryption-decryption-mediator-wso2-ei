package com.rnavagamuwa;

import com.rnavagamuwa.cipher.AES256Cipher;
import com.rnavagamuwa.cipher.CipherAPI;
import org.apache.synapse.MessageContext;
import org.apache.synapse.mediators.AbstractMediator;

/**
 * @author Randika Navagamuwa
 */
public class DecryptionMediator extends AbstractMediator {

    private CipherAPI cipherAPI;

    public DecryptionMediator() {
        this.cipherAPI = new AES256Cipher();
    }


    @Override
    public boolean mediate(MessageContext messageContext) {

        try {
            String stringToBeDecrypted = (String) messageContext.getProperty("encryptedString");
            String decryptedString = this.cipherAPI.decrypt(stringToBeDecrypted);
            messageContext.setProperty("decryptedString", decryptedString);
            return true;

        } catch (Exception e) {

            log.error("Decryption failed for the message with id :" + messageContext.getMessageID(), e);
            throw new RuntimeException(e);
        }
    }
}
