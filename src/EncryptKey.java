/**
 * Created by puzzi on 27/05/17.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class EncryptKey {

    private Cipher cipher;

    public EncryptKey(PublicKey key, File originalKeyFile, File encryptedKeyFile, String cipherAlgorithm)
            throws IOException, GeneralSecurityException{

        this.cipher = Cipher.getInstance(cipherAlgorithm);
        encryptFile(FileUtil.getFileInBytes(originalKeyFile), encryptedKeyFile, key);

    }

    public void encryptFile(byte[] input, File output, PublicKey key)
            throws IOException, GeneralSecurityException {

        this.cipher.init(Cipher.ENCRYPT_MODE, key);
        FileUtil.writeToFileByte(output, this.cipher.doFinal(input));
        System.out.println("A chave foi cifrada com sucesso e armazenada em: " + output.getPath());

    }

}



