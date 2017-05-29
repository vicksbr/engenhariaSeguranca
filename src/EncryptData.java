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

public class EncryptData {

    private Cipher cipher;

    public EncryptData(File originalFile, File encrypted, SecretKeySpec secretKey, String cipherAlgorithm)
            throws IOException, GeneralSecurityException{

        this.cipher = Cipher.getInstance(cipherAlgorithm);
        encryptFile(FileUtil.getFileInBytes(originalFile), encrypted, secretKey);

    }

    public void encryptFile(byte[] input, File output, SecretKeySpec key)
            throws IOException, GeneralSecurityException {

        this.cipher.init(Cipher.ENCRYPT_MODE, key);
        FileUtil.writeToFileByte(output, this.cipher.doFinal(input));
        System.out.println("O arquivo foi cifrado com sucesso e armazenado em: " + output.getPath());
    }
}