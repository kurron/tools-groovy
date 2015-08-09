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

/**
 * Convenience methods that can be added to any byte array.
 */
class ByteArrayEnhancements {

    /**
     * Transforms the byte array in a hex representation of the buffer's MD5 hash.
     * @param receiver the buffer to transform.
     * @return 32 character hex string of the hash.
     */
    static String toMd5String( byte[] receiver ) {
        DigestUtils.md5Hex( receiver )
    }

    /**
     * Transforms the byte array in a hex representation of the buffer's SHA-1 hash.
     * @param receiver the buffer to transform.
     * @return hex string of the hash.
     */
    static String toSha1String( byte[] receiver ) {
        DigestUtils.sha1Hex( receiver )
    }

    /**
     * Transforms the byte array in a hex representation of the buffer's SHA-256 hash.
     * @param receiver the buffer to transform.
     * @return hex string of the hash.
     */
    static String toSha256String( byte[] receiver ) {
        DigestUtils.sha256Hex( receiver )
    }

    /**
     * Transforms the byte array in a hex representation of the buffer's SHA-384 hash.
     * @param receiver the buffer to transform.
     * @return hex string of the hash.
     */
    static String toSha384String( byte[] receiver ) {
        DigestUtils.sha384Hex( receiver )
    }

    /**
     * Transforms the byte array in a hex representation of the buffer's SHA-512 hash.
     * @param receiver the buffer to transform.
     * @return hex string of the hash.
     */
    static String toSha512String( byte[] receiver ) {
        DigestUtils.sha512Hex( receiver )
    }
}
