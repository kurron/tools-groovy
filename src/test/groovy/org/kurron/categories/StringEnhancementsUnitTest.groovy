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

import java.nio.charset.StandardCharsets
import org.junit.experimental.categories.Category
import org.kurron.traits.GenerationAbility
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Unit-level test.
 */
@Category( UnitTest )
@Unroll
class StringEnhancementsUnitTest extends Specification implements GenerationAbility {

    def data = randomHexString()

    def setup() {
        // this is just help JaCoCo past some of the Groovy magic that goes on
        new StringEnhancements()
    }

    def 'exercise UTF-8 encoding'() {

        when: 'enhanced method is applied'
        def encoded = use( StringEnhancements ) { ->
            data.toUTF8()
        }

        then: 'the expected encoding is generated'
        data.getBytes( StandardCharsets.UTF_8 ) == encoded
   }

    def 'exercise UTF-16 encoding'() {

        when: 'enhanced method is applied'
        def encoded = use( StringEnhancements ) { ->
            data.toUTF16()
        }

        then: 'the expected encoding is generated'
        data.getBytes( StandardCharsets.UTF_16 ) == encoded
    }

}
