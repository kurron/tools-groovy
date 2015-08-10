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

import org.junit.experimental.categories.Category
import org.kurron.traits.GenerationAbility
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Unit-level test.
 */
@Category( UnitTest )
@Unroll
class ThrowableEnhancementsUnitTest extends Specification implements GenerationAbility {

    def c = new RuntimeException( 'C' )
    def b = new RuntimeException( 'B', c )
    def a = new RuntimeException( 'A', b )

    def setup() {
        // this is just help JaCoCo past some of the Groovy magic that goes on
        new ThrowableEnhancements()
    }

    def 'exercise root cause'() {

        when: 'enhanced method is applied'
        def rootCause = use( ThrowableEnhancements ) { ->
            a.rootCause
        }

        then: 'the expected exception is returned'
        rootCause == c
   }

}
