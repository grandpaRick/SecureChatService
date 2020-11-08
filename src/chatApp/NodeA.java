package chatApp;

import java.security.*;


public class NodeA {
//class fields
    private String user;//identity
    private Key privateKey;//private key
    private Key publicKey;//public key

    public NodeA(String user){
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public Key getPrivateKey() {
        return privateKey;
    }

    public Key getPublicKey() {
        return publicKey;
    }
//class methods
    //generate key pairs

    KeyPairGenerator keyPairGenerator;
{
    try {
        keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        this.privateKey = keyPair.getPrivate();
        this.publicKey = keyPair.getPublic();

    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
}

}
