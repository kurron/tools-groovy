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

    def 'exercise MD5 string'() {

        when: 'enhanced method is applied'
        def hash = use( ByteArrayEnhancements ) { ->
            data.toMd5String()
        }

        then: 'the expected digest is generated'
        DigestUtils.md5Hex( data ) == hash
   }

    def 'exercise SHA-1 string'() {

        when: 'enhanced method is applied'
        def hash = use( ByteArrayEnhancements ) { ->
            data.toSha1String()
        }

        then: 'the expected digest is generated'
        DigestUtils.sha1Hex( data ) == hash
    }
}
