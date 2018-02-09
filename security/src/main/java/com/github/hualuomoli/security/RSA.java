package com.github.hualuomoli.security;

import com.github.hualuomoli.logger.Logger;

/**
 * RSA
 */
public class RSA {

    private static final String TAG = "com.github.hualuomoli.security.RSA";

    public static final String KEY_ALGORITHM = "RSA";

    public static final String ALGORITHM_SHA1 = "SHA1withRSA";

    /**
     * 签名
     *
     * @param privateKey 私钥
     * @param origin     签名原文
     * @return 签名, 如果获取签名失败返回null
     */
    public static String sha1(String privateKey, String origin) {
        Logger.info(TAG, "[sha1] origin={}", origin);
        return Signature.sign(privateKey, RSA.KEY_ALGORITHM, RSA.ALGORITHM_SHA1, origin);
    }

    /**
     * 验证签名
     *
     * @param publicKey 公钥
     * @param origin    签名原文
     * @param sign      签名
     * @return 签名是否合法
     */
    public static boolean verifySha1(String publicKey, String origin, String sign) {
        Logger.info(TAG, "[verifySha1] origin={},sign={}", origin, sign);
        return Signature.verify(publicKey, RSA.KEY_ALGORITHM, RSA.ALGORITHM_SHA1, origin, sign);
    }


}
