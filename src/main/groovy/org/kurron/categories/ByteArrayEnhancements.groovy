/*
 * Copyright (c) 2015 Ronald D. Kurr kurr@jvmguy.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kurron.categories

import java.util.concurrent.ThreadLocalRandom
import org.apache.commons.codec.digest.DigestUtils
import org.apache.commons.codec.digest.HmacUtils

/**
 * Convenience methods that can be added to any byte array.
 */
class ByteArrayEnhancements {

    /**
     * Transforms the byte array into a hex representation of the buffer's MD5 hash.
     * @param receiver the buffer to transform.
     * @return 32 character hex string of the hash.
     */
    static String toMD5( byte[] receiver ) {
        DigestUtils.md5Hex( receiver )
    }

    /**
     * Transforms the byte array into a hex representation of the buffer's SHA-1 hash.
     * @param receiver the buffer to transform.
     * @return hex string of the hash.
     */
    static String toSha1( byte[] receiver ) {
        DigestUtils.sha1Hex( receiver )
    }

    /**
     * Transforms the byte array into a hex representation of the buffer's SHA-256 hash.
     * @param receiver the buffer to transform.
     * @return hex string of the hash.
     */
    static String toSha256( byte[] receiver ) {
        DigestUtils.sha256Hex( receiver )
    }

    /**
     * Transforms the byte array into a hex representation of the buffer's SHA-384 hash.
     * @param receiver the buffer to transform.
     * @return hex string of the hash.
     */
    static String toSha384( byte[] receiver ) {
        DigestUtils.sha384Hex( receiver )
    }

    /**
     * Transforms the byte array into a hex representation of the buffer's SHA-512 hash.
     * @param receiver the buffer to transform.
     * @return hex string of the hash.
     */
    static String toSha512( byte[] receiver ) {
        DigestUtils.sha512Hex( receiver )
    }

    /**
     * Transforms the byte array into a hex representation of the buffer's SHA-256 HMAC.
     * @param receiver the buffer to transform.
     * @param key the private key to use in the transformation.
     * @return hex string of the HMAC.
     */
    static String toSha256Mac( byte[] receiver, byte[] key ) {
        HmacUtils.hmacSha256Hex( key, receiver )
    }

    /**
     * Transforms the byte array into a hex representation of the buffer's SHA-384 HMAC.
     * @param receiver the buffer to transform.
     * @param key the private key to use in the transformation.
     * @return hex string of the HMAC.
     */
    static String toSha384Mac( byte[] receiver, byte[] key ) {
        HmacUtils.hmacSha384Hex( key, receiver )
    }

    /**
     * Transforms the byte array into a hex representation of the buffer's SHA-512 HMAC.
     * @param receiver the buffer to transform.
     * @param key the private key to use in the transformation.
     * @return hex string of the HMAC.
     */
    static String toSha512Mac( byte[] receiver, byte[] key ) {
        HmacUtils.hmacSha512Hex( key, receiver )
    }

    /**
     * Transforms the byte array into a collection of randomized bytes.
     * @param receiver the buffer to transform.
     */
    static void scramble( byte[] receiver ) {
        ThreadLocalRandom.current().nextBytes( receiver )
    }

    /**
     * Transforms the byte array into a duplicate copy.
     * @param receiver the buffer to transform.
     * @return the duplicated buffer
     */
    static byte[] copy( byte[] receiver ) {
        Arrays.copyOf( receiver, receiver.length )
    }
}
