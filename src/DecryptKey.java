/**
 * Created by puzzi on 27/05/17.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class DecryptKey {

    private Cipher cipher;

    public DecryptKey(PrivateKey privateKey, File encryptedKeyReceived, File decreptedKeyFile, String algorithm)
            throws IOException, GeneralSecurityException {

        this.cipher = Cipher.getInstance(algorithm);
        decryptFile(FileUtil.getFileInBytes(encryptedKeyReceived), decreptedKeyFile, privateKey);

    }

    public void decryptFile(byte[] input, File output, PrivateKey key)
            throws IOException, GeneralSecurityException {

        this.cipher.init(Cipher.DECRYPT_MODE, key);
        FileUtil.writeToFileByte(output, this.cipher.doFinal(input));

    }
}