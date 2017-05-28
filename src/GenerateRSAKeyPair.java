/**
 * Created by puzzi on 27/05/17.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

public class GenerateRSAKeyPair {

    private KeyPairGenerator keyGen;
    private KeyPair pair;
    private PrivateKey privateKey;
    private PublicKey publicKey;


    public GenerateRSAKeyPair(int size) throws NoSuchAlgorithmException, NoSuchProviderException {
        this.keyGen = KeyPairGenerator.getInstance("RSA");
        this.keyGen.initialize(size);

    }

    public void createKeys() {

        this.pair = this.keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();

    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;

    }

    public static void main(String args[]) throws NoSuchAlgorithmException, NoSuchProviderException, IOException {

        GenerateRSAKeyPair keysjoao;
        GenerateRSAKeyPair keysmaquinas;

        keysjoao = new GenerateRSAKeyPair(1024);
        keysjoao.createKeys();

        keysmaquinas = new GenerateRSAKeyPair(1024);
        keysmaquinas.createKeys();


        FileUtil.writeToFile("KeyPair/ChavePublicaJoao",keysjoao.getPublicKey().getEncoded());
        FileUtil.writeToFile("KeyPair/ChavePrivadaJoao",keysjoao.getPrivateKey().getEncoded());

        FileUtil.writeToFile("KeyPair/ChavePublicaMaquina",keysmaquinas.getPublicKey().getEncoded());
        FileUtil.writeToFile("KeyPair/ChavePrivadaMaquina",keysmaquinas.getPrivateKey().getEncoded());


    }

}
