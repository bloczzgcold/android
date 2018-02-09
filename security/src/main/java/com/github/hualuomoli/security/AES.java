package com.github.hualuomoli.security;

import com.github.hualuomoli.logger.Logger;

/**
 * Created by admin on 2018/2/9.
 */

public class AES {

    private static final String TAG = "com.github.hualuomoli.security.AES";

    public static final String KEY_ALGORITHM = "AES";

    public static final String ALGORITHM_ECB_PKCS5 = "AES/ECB/PKCS5Padding";


    /**
     * 加密
     *
     * @param key     Key
     * @param content 明文
     * @return 密文。如果加密失败返回null
     */
    public static String encryptPkcs5(String key, String content) {
        Logger.info(TAG, "[encryptPkcs5] content={}", content);
        return Cipher.encrypt(key, KEY_ALGORITHM, ALGORITHM_ECB_PKCS5, content);
    }

    /**
     * 解密
     *
     * @param key           Key
     * @param cipherContent 密文
     * @return 明文。如果解密失败返回null
     */
    public static String decryptPkcs5(String key, String cipherContent) {
        Logger.info(TAG, "[decryptPkcs5] cipherContent={}", cipherContent);
        return Cipher.decrypt(key, KEY_ALGORITHM, ALGORITHM_ECB_PKCS5, cipherContent);
    }

}
