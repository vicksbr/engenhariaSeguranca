/**
 * Created by puzzi on 27/05/17.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class GenerateAESKey {

    private SecretKeySpec secretKey;

    public GenerateAESKey(int size) throws UnsupportedEncodingException, NoSuchAlgorithmException,NoSuchPaddingException  {

        SecureRandom rnd = new SecureRandom();
        byte [] key = new byte [size];
        rnd.nextBytes(key);
        this.secretKey = new SecretKeySpec(key,"AES");
    }

    public SecretKeySpec getKey(){
        return this.secretKey;
    }


    public static void main(String[] args)
            throws NoSuchAlgorithmException, NoSuchPaddingException, IOException {

        GenerateAESKey genAES = new GenerateAESKey(16);
        FileUtil.writeToFile("AES/secretKey", genAES.getKey().getEncoded());

    }
}

