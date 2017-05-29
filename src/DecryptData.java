/**
 Universidade de São Paulo - Disciplinas de Engenharia de Segurança

 Pedro Naidhig Puzzi                  - 6513497
 Alisson Mateus de Oliveira Magalhães - 8066287

 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;

public class DecryptData {

    private Cipher cipher;

    public DecryptData(File encryptedFileReceived, File decryptedFile, SecretKeySpec secretKey, String algorithm)
            throws IOException, GeneralSecurityException {

        this.cipher = Cipher.getInstance(algorithm);
        decryptFile(FileUtil.getFileInBytes(encryptedFileReceived), decryptedFile, secretKey);

    }

    public void decryptFile(byte[] input, File output, SecretKeySpec key) throws IOException, GeneralSecurityException {

        this.cipher.init(Cipher.DECRYPT_MODE, key);
        FileUtil.writeToFileByte(output, this.cipher.doFinal(input));
        System.out.println("O arquivo foi decifrado com sucesso. Arquivo gerado: " + output.getPath());
    }
}