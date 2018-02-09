package com.github.hualuomoli.security;

import com.github.hualuomoli.codec.Base64;
import com.github.hualuomoli.logger.Logger;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 签名/验证
 */
public class Signature {

    private static final String TAG = "Signature";

    private static final String CHARSET = "UTF-8";

    /**
     * 签名 {@linkplain #CHARSET}
     *
     * @param privateKey   私钥
     * @param keyAlgorithm 密钥算法
     * @param origin       签名原文
     * @return 签名, 如果获取签名失败返回null
     */
    public static String sign(String privateKey, String keyAlgorithm, String algorithm, String origin) {
        return sign(privateKey, keyAlgorithm, algorithm, origin, CHARSET);
    }

    /**
     * 签名
     *
     * @param privateKey   私钥
     * @param keyAlgorithm 密钥算法
     * @param origin       签名原文
     * @param charset      数据编码
     * @return 签名, 如果获取签名失败返回null
     */
    public static String sign(String privateKey, String keyAlgorithm, String algorithm, String origin, String charset) {
        try {
            byte[] privateKeyBytes = Base64.decode(privateKey);
            byte[] originBytes = origin.getBytes(charset);
            byte[] signBytes = sign(privateKeyBytes, keyAlgorithm, algorithm, originBytes);
            return Base64.encode(signBytes);
        } catch (Exception e) {
            Logger.error(TAG, "{}", e);
            return null;
        }
    }

    /**
     * 签名
     *
     * @param privateKey   私钥
     * @param keyAlgorithm 密钥算法
     * @param algorithm    算法
     * @param origin       签名原文
     * @return 签名, 如果获取签名失败返回null
     */
    public static byte[] sign(byte[] privateKey, String keyAlgorithm, String algorithm, byte[] origin) {
        try {
            // 获取私钥
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey);
            KeyFactory keyFactory = KeyFactory.getInstance(keyAlgorithm);
            PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);

            // 签名
            java.security.Signature signature = java.security.Signature.getInstance(algorithm);
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
     * 验证签名 {@linkplain #CHARSET}
     *
     * @param publicKey    公钥
     * @param keyAlgorithm 密钥算法
     * @param algorithm    算法
     * @param origin       签名原文
     * @param sign         签名
     * @return 签名是否合法
     */
    public static boolean verify(String publicKey, String keyAlgorithm, String algorithm, String origin, String sign) {
        return verify(publicKey, keyAlgorithm, algorithm, origin, CHARSET, sign);
    }

    /**
     * 验证签名
     *
     * @param publicKey    公钥
     * @param keyAlgorithm 密钥算法
     * @param algorithm    算法
     * @param origin       签名原文
     * @param charset      签名原文编码集
     * @param sign         签名
     * @return 签名是否合法
     */
    public static boolean verify(String publicKey, String keyAlgorithm, String algorithm, String origin, String charset, String sign) {
        try {
            byte[] publicKeyBytes = Base64.decode(publicKey);
            byte[] originBytes = origin.getBytes(charset);
            byte[] signBytes = Base64.decode(sign);
            return verify(publicKeyBytes, keyAlgorithm, algorithm, originBytes, signBytes);
        } catch (Exception e) {
            Logger.error(TAG, "{}", e);
            return false;
        }
    }


    /**
     * 验证签名
     *
     * @param publicKey    公钥
     * @param keyAlgorithm 密钥算法
     * @param algorithm    算法
     * @param origin       签名原文
     * @param sign         签名
     * @return 签名是否合法
     */
    public static boolean verify(byte[] publicKey, String keyAlgorithm, String algorithm, byte[] origin, byte[] sign) {
        try {
            // 获取公钥
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey);
            KeyFactory keyFactory = KeyFactory.getInstance(keyAlgorithm);
            PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);

            // 验证签名
            java.security.Signature verifier = java.security.Signature.getInstance(algorithm);
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
