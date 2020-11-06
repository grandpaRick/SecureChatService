import java.math.*;
import java.util.*;

public class RSAKeyPairGen {
    public static void main(String[] args) {

        //Creating two random number generators, each with a different seed
        Random random1 = new Random(System.currentTimeMillis());
        Random random2 = new Random(System.currentTimeMillis()*10);

        int pubKey = new Random().nextInt(); // generates user public key.

        //Returns a BigInteger that is not prime with probability less than 2^(-100)
        BigInteger big_p = BigInteger.probablePrime(32, random1);
        BigInteger big_q = BigInteger.probablePrime(32, random2);

        BigInteger big_n = big_p.multiply(big_q);

        BigInteger big_p_1 = big_p.subtract(new BigInteger("1")); //p-1
        BigInteger big_q_1 = big_q.subtract(new BigInteger("1")); //q-1
        BigInteger big_p_1_q_1 = big_p_1.multiply(big_q_1); //(p-1)*(q-1)

        //generating the correct public key

        while (true){
            BigInteger big_GCD = big_p_1_q_1.gcd(new BigInteger(""+pubKey));
            if (big_GCD.equals(BigInteger.ONE)){
                break;
            }

            ++pubKey;
        }

        BigInteger publicKey = new BigInteger(""+pubKey);
        BigInteger privateKey = publicKey.modInverse(big_p_1_q_1);

        System.out.println("public key: "+ publicKey+" , "+ big_n
                            +"\nprivate key: "+ privateKey+ " , "+ big_n);

    }
}
