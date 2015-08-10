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
import org.junit.experimental.categories.Category
import org.kurron.traits.GenerationAbility
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Unit-level test.
 */
@Category( UnitTest )
@Unroll
class ByteArrayEnhancementsUnitTest extends Specification implements GenerationAbility {

    def data = randomByteArray( 128 )
    def key = randomByteArray( 128 )

    def setup() {
        // this is just help JaCoCo past some of the Groovy magic that goes on
        new ByteArrayEnhancements()
    }

    def 'exercise MD5 string'() {

        when: 'enhanced method is applied'
        def hash = use( ByteArrayEnhancements ) { ->
            data.toMD5()
        }

        then: 'the expected digest is generated'
        DigestUtils.md5Hex( data ) == hash
   }

    def 'exercise SHA-1 string'() {

        when: 'enhanced method is applied'
        def hash = use( ByteArrayEnhancements ) { ->
            data.toSha1()
        }

        then: 'the expected digest is generated'
        DigestUtils.sha1Hex( data ) == hash
    }

    def 'exercise SHA-256 string'() {

        when: 'enhanced method is applied'
        def hash = use( ByteArrayEnhancements ) { ->
            data.toSha256()
        }

        then: 'the expected digest is generated'
        DigestUtils.sha256Hex( data ) == hash
    }

    def 'exercise SHA-384 string'() {

        when: 'enhanced method is applied'
        def hash = use( ByteArrayEnhancements ) { ->
            data.toSha384()
        }

        then: 'the expected digest is generated'
        DigestUtils.sha384Hex( data ) == hash
    }

    def 'exercise SHA-512 string'() {

        when: 'enhanced method is applied'
        def hash = use( ByteArrayEnhancements ) { ->
            data.toSha512()
        }

        then: 'the expected digest is generated'
        DigestUtils.sha512Hex( data ) == hash
    }

    def 'exercise SHA-256 HMAC'() {

        when: 'enhanced method is applied'
        def mac = use( ByteArrayEnhancements ) { ->
            data.toSha256Mac( key )
        }

        then: 'the expected authentication code is generated'
        HmacUtils.hmacSha256Hex( key, data ) == mac
    }

    def 'exercise SHA-384 HMAC'() {

        when: 'enhanced method is applied'
        def mac = use( ByteArrayEnhancements ) { ->
            data.toSha384Mac( key )
        }

        then: 'the expected authentication code is generated'
        HmacUtils.hmacSha384Hex( key, data ) == mac
    }

    def 'exercise SHA-512 HMAC'() {

        when: 'enhanced method is applied'
        def mac = use( ByteArrayEnhancements ) { ->
            data.toSha512Mac( key )
        }

        then: 'the expected authentication code is generated'
        HmacUtils.hmacSha512Hex( key, data ) == mac
    }

    def 'exercise scrambling'() {

        when: 'enhanced method is applied'
        def beforeScramble = Arrays.copyOf( data, data.length )
        use( ByteArrayEnhancements ) { ->
            data.scramble()
        }

        then: 'the data is different after the scramble'
        data.size() == beforeScramble.size()
        data != beforeScramble
    }
}
