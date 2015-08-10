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

import org.apache.commons.codec.digest.DigestUtils
import org.apache.commons.codec.digest.HmacUtils
import org.apache.commons.io.IOUtils

/**
 * Convenience methods that can be added to any input stream.
 */
class InputStreamEnhancements {

    /**
     * The buffer size to use if the caller does not provide a buffer to use.
     */
    private static final BUFFER_SIZE = 1024 * 4

    /**
     * Transforms the stream into a hex representation of the stream's MD5 hash.
     * @param receiver the stream to transform.
     * @return 32 character hex string of the hash.
     */
    static String toMD5( InputStream receiver ) {
        DigestUtils.md5Hex( receiver )
    }

    /**
     * Transforms the stream into a hex representation of the stream's SHA-1 hash.
     * @param receiver the stream to transform.
     * @return hex string of the hash.
     */
    static String toSha1( InputStream receiver ) {
        DigestUtils.sha1Hex( receiver )
    }

    /**
     * Transforms the stream into a hex representation of the stream's SHA-256 hash.
     * @param receiver the stream to transform.
     * @return hex string of the hash.
     */
    static String toSha256( InputStream receiver ) {
        DigestUtils.sha256Hex( receiver )
    }

    /**
     * Transforms the stream into a hex representation of the stream's SHA-384 hash.
     * @param receiver the stream to transform.
     * @return hex string of the hash.
     */
    static String toSha384( InputStream receiver ) {
        DigestUtils.sha384Hex( receiver )
    }

    /**
     * Transforms the stream into a hex representation of the stream's SHA-512 hash.
     * @param receiver the stream to transform.
     * @return hex string of the hash.
     */
    static String toSha512( InputStream receiver ) {
        DigestUtils.sha512Hex( receiver )
    }

    /**
     * Transforms the stream into a hex representation of the stream's SHA-256 HMAC.
     * @param receiver the stream to transform.
     * @param key the private key to use in the transformation.
     * @return hex string of the HMAC.
     */
    static String toSha256Mac( InputStream receiver, byte[] key ) {
        HmacUtils.hmacSha256Hex( key, receiver )
    }

    /**
     * Transforms the stream into a hex representation of the stream's SHA-384 HMAC.
     * @param receiver the stream to transform.
     * @param key the private key to use in the transformation.
     * @return hex string of the HMAC.
     */
    static String toSha384Mac( InputStream receiver, byte[] key ) {
        HmacUtils.hmacSha384Hex( key, receiver )
    }

    /**
     * Transforms the stream into a hex representation of the stream's SHA-512 HMAC.
     * @param receiver the stream to transform.
     * @param key the private key to use in the transformation.
     * @return hex string of the HMAC.
     */
    static String toSha512Mac( InputStream receiver, byte[] key ) {
        HmacUtils.hmacSha512Hex( key, receiver )
    }

    /**
     * Copies the bytes from the input stream to the output stream.
     * @param receiver the stream to transform.
     * @param destination the stream to copy to.
     * @return the number of bytes that were transferred.
     */
    static long copy( InputStream receiver, OutputStream destination, byte[] buffer = new byte[BUFFER_SIZE] ) {
        IOUtils.copyLarge( receiver, destination, buffer )
    }

    /**
     * Transforms the stream into a byte array.
     * @param receiver the stream to transform.
     * @return the bytes read from the stream.
     */
    static byte[] toByteArray( InputStream receiver ) {
        IOUtils.toByteArray( receiver )
    }

}
