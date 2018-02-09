package com.github.hualuomoli.security;

import com.github.hualuomoli.codec.Base64;
import com.github.hualuomoli.logger.Logger;

import javax.crypto.spec.SecretKeySpec;

import java.io.UnsupportedEncodingException;

/**
 * 加密解密
 */
public class Cipher {

    private static final String TAG = "com.github.hualuomoli.security.Cipher";

    private static final String CHARSET = "UTF-8";

    /**
     * 加密 {@linkplain #CHARSET}
     *
     * @param key          Key
     * @param keyAlgorithm 密钥算法
     * @param algorithm    算法
     * @param content      明文
     * @return 密文。如果加密失败返回null
     */
    public static String encrypt(String key, String keyAlgorithm, String algorithm, String content) {
        return encrypt(key, keyAlgorithm, algorithm, content, CHARSET);
    }

    /**
     * 加密
     *
     * @param key          Key
     * @param keyAlgorithm 密钥算法
     * @param algorithm    算法
     * @param content      明文
     * @param charset      数据编码
     * @return 密文。如果加密失败返回null
     */
    public static String encrypt(String key, String keyAlgorithm, String algorithm, String content, String charset) {
        try {
            byte[] keyBytes = Base64.decode(key);
            byte[] contentBytes = content.getBytes(charset);

            byte[] cipherContentBytes = encrypt(keyBytes, keyAlgorithm, algorithm, contentBytes);

            return Base64.encode(cipherContentBytes);
        } catch (UnsupportedEncodingException e) {
            Logger.error(TAG, "{}", e);
            return null;
        }
    }

    /**
     * 加密
     *
     * @param key          Key
     * @param keyAlgorithm 密钥算法
     * @param algorithm    算法
     * @param content      明文
     * @return 密文。如果加密失败返回null
     */
    public static byte[] encrypt(byte[] key, String keyAlgorithm, String algorithm, byte[] content) {
        try {
            // 获取key
            SecretKeySpec secretKey = new SecretKeySpec(key, keyAlgorithm);

            // 加密
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(algorithm);
            cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(content);
        } catch (Exception e) {
            Logger.error(TAG, "{}", e);
            return null;
        }
        // end
    }

    /**
     * 解密 {@linkplain #CHARSET}
     *
     * @param key           Key
     * @param keyAlgorithm  密钥算法
     * @param algorithm     算法
     * @param cipherContent 密文
     * @return 明文。如果解密失败返回null
     */
    public static String decrypt(String key, String keyAlgorithm, String algorithm, String cipherContent) {
        return decrypt(key, keyAlgorithm, algorithm, cipherContent, CHARSET);
    }


    /**
     * 解密
     *
     * @param key           Key
     * @param keyAlgorithm  密钥算法
     * @param algorithm     算法
     * @param cipherContent 密文
     * @param charset       数据编码
     * @return 明文。如果解密失败返回null
     */
    public static String decrypt(String key, String keyAlgorithm, String algorithm, String cipherContent, String charset) {
        try {
            byte[] keyBytes = Base64.decode(key);
            byte[] cipherContentBytes = Base64.decode(cipherContent);
            byte[] contentBytes = decrypt(keyBytes, keyAlgorithm, algorithm, cipherContentBytes);
            return new String(contentBytes, charset);
        } catch (UnsupportedEncodingException e) {
            Logger.error(TAG, "{}", e);
            return null;
        }
    }


    /**
     * 解密
     *
     * @param key           Key
     * @param keyAlgorithm  密钥算法
     * @param algorithm     算法
     * @param cipherContent 密文
     * @return 明文。如果解密失败返回null
     */
    public static byte[] decrypt(byte[] key, String keyAlgorithm, String algorithm, byte[] cipherContent) {
        try {
            // 获取key
            SecretKeySpec secretKey = new SecretKeySpec(key, keyAlgorithm);

            // 解密
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(algorithm);
            cipher.init(javax.crypto.Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(cipherContent);
        } catch (Exception e) {
            Logger.error(TAG, "{}", e);
            return null;
        }
        // end
    }


}
