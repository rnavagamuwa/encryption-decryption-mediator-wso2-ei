# encryption-decryption-mediator-wso2-ei

This mediator can used with [WSO2 Class Mediator](https://docs.wso2.com/display/EI600/Class+Mediator).

### Overview

Even though only AES256 is the only implemented algorithm here, any algorithm can be implemented according the 
requirement.

### How to use

1) Build the mediator by executing `mvn clean install`.
2) Copy the `target\encryption-mediator-1.0-SNAPSHOT.jar` jar into `<EI_Home>\lib` directory.
3) Provide the fully qualified class name as `com.rnavagamuwa.EncryptionMediator` or `com.rnavagamuwa.DecryptionMediator`
as required.
4) Encryption mediator read the "**string to be encrypted**" from "**stringToBeEncrypted**" property and set the 
"**encrypted String**" to "**encryptedString**" property.
5) Decryption mediator read the "**encrypted String**" from "**encryptedString**" property and set the 
   "**decrypted String**" to "**decryptedString**" property.