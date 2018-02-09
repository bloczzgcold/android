package com.github.hualuomoli.security;

import com.github.hualuomoli.codec.Base64;
import com.github.hualuomoli.logger.Logger;

import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA
 */
public class RSA {

    private static final String TAG = "RSA";

    private static final String CHARSET = "UTF-8";

    private static final String ALGORITHM_SHA1 = "SHA1withRSA";

    /**
     * 签名 使用默认编码集{@linkplain #CHARSET} ,使用默认SHA1算法{@link #ALGORITHM_SHA1}
     *
     * @param privateKey 私钥
     * @param origin     签名原文
     * @return 签名, 如果获取签名失败返回null
     */
    public static String sha1(String privateKey, String origin) throws RuntimeException {
        return sign(privateKey, ALGORITHM_SHA1, origin, CHARSET);
    }

    /**
     * 签名
     *
     * @param privateKey 私钥
     * @param origin     签名原文
     * @param charset    数据编码
     * @return 签名, 如果获取签名失败返回null
     */
    public static String sign(String privateKey, String algorithm, String origin, String charset) throws RuntimeException {
        try {
            byte[] privateKeyBytes = Base64.decode(privateKey);
            byte[] originBytes = origin.getBytes(charset);
            byte[] signBytes = sign(privateKeyBytes, algorithm, originBytes);
            return Base64.encode(signBytes);
        } catch (Exception e) {
            Logger.error(TAG, "{}", e);
            return null;
        }
    }

    /**
     * 签名
     *
     * @param privateKey 私钥
     * @param algorithm  算法
     * @param origin     签名原文
     * @return 签名, 如果获取签名失败返回null
     */
    public static byte[] sign(byte[] privateKey, String algorithm, byte[] origin) {
        try {
            // 获取私钥
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);

            // 签名
            Signature signature = Signature.getInstance(algorithm);
            signature.initSign(priKey);
            signature.update(origin);
            return signature.sign();
        } catch (Exception e) {
            Logger.error(TAG, "{}", e);
            return null;
        }
        // end
    }

    /**
     * 验证签名.使用默认编码集{@linkplain #CHARSET} ,使用默认SHA1算法{@link #ALGORITHM_SHA1}
     *
     * @param publicKey 公钥
     * @param origin    签名原文
     * @param sign      签名
     * @return 签名是否合法
     */
    public static boolean verifySha1(String publicKey, String origin, String sign) throws RuntimeException {
        return verify(publicKey, ALGORITHM_SHA1, origin, CHARSET, sign);
    }

    /**
     * 验证签名
     *
     * @param publicKey 公钥
     * @param algorithm 算法
     * @param origin    签名原文
     * @param charset   签名原文编码集
     * @param sign      签名
     * @return 签名是否合法
     */
    public static boolean verify(String publicKey, String algorithm, String origin, String charset, String sign) {
        try {
            byte[] publicKeyBytes = Base64.decode(publicKey);
            byte[] originBytes = origin.getBytes(charset);
            byte[] signBytes = Base64.decode(sign);
            return verify(publicKeyBytes, algorithm, originBytes, signBytes);
        } catch (Exception e) {
            Logger.error(TAG, "{}", e);
            return false;
        }
    }


    /**
     * 验证签名
     *
     * @param publicKey 公钥
     * @param algorithm 算法
     * @param origin    签名原文
     * @param sign      签名
     * @return 签名是否合法
     */
    public static boolean verify(byte[] publicKey, String algorithm, byte[] origin, byte[] sign) {
        try {
            // 获取公钥
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);

            // 验证签名
            Signature verifier = Signature.getInstance(algorithm);
            verifier.initVerify(pubKey);
            verifier.update(origin);
            return verifier.verify(sign);
        } catch (Exception e) {
            Logger.error(TAG, "{}", e);
            return false;
        }
        // end
    }


}
