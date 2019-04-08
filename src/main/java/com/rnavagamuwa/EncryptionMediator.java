package com.rnavagamuwa;

import com.rnavagamuwa.cipher.AES256Cipher;
import com.rnavagamuwa.cipher.CipherAPI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.MessageContext;
import org.apache.synapse.mediators.AbstractMediator;

/**
 * @author Randika Navagamuwa
 */
public class EncryptionMediator extends AbstractMediator {

    private static final Log log = LogFactory.getLog(EncryptionMediator.class.getName());

    private CipherAPI cipherAPI;

    public EncryptionMediator() {
        this.cipherAPI = new AES256Cipher();
    }

    public boolean mediate(MessageContext messageContext) {


        try {
            String stringToBeEncrypted = (String) messageContext.getProperty("stringToBeEncrypted");
            String encryptedString = this.cipherAPI.encrypt(stringToBeEncrypted);
            messageContext.setProperty("encryptedString", encryptedString);
            return true;

        } catch (Exception e) {

            log.error("Encryption failed for the message with id :" + messageContext.getMessageID(), e);
            throw new RuntimeException(e);
        }
    }


}