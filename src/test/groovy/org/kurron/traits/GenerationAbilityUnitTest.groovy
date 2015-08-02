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

package org.kurron.traits

import org.junit.experimental.categories.Category
import org.kurron.categories.UnitTest
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Unit-level test.
 */
@Category( UnitTest )
@Unroll
class GenerationAbilityUnitTest extends Specification implements GenerationAbility{

    def 'exercise 0 arity method'( Closure sut ) {
        given: 'a collection of random data'
        def data = (1..10000).collect( sut )

        expect: 'no duplicates are found'
        data.unique( false ) == data

        where:
        // problems using method references, probably because it lives off a trait, eg this.&randomHexString
        sut << [{ randomHexString() }, { randomPositiveInteger() }, { randomUUID() }, { randomLong() } ]
    }

    def 'exercise ranged random integers'() {
        given: 'a collection of random data'
        def data = (1..10000).collect{ randomInteger( -100, 100 ) }

        expect: 'no data point exceeds the bounds'
        data.every { (it >= -100) && (it < 100) }
    }

    def 'exercise random byte arrays'() {
        given: 'a collection of random buffer sizes'
        def sizes = (1..1000).collect{ randomInteger( 1, 256 ) }

        when: 'random buffers are generated'
        def buffers = sizes.collect { randomByteArray( it ) }.sort()

        then: 'each buffer is of the specified size'
        def generatedSizes = buffers.collect { it.size() }.sort()
        sizes.sort() == generatedSizes
    }

    def 'exercise random boolean'() {
        given: 'a collection of random values'
        def values = (1..100000).collect{ randomBoolean() }

        expect: 'about half are true and half are false'
        def positive = values.findAll { it }.size()
        def negative = values.findAll { !it }.size()
        def delta = (positive - negative).abs()
        def percentageOff = (delta / values.size() ) * 100
        percentageOff < 1 // a 1% epsilon is ok
    }

    def 'exercise random list element'() {
        given: 'a collection of random values'
        def values = (1..1000).collect{ randomHexString() }

        expect: 'a unique selection of elements'
        def selected = (1..10).collect{ randomElement( values ) }
        selected.unique( false ) == selected

    }
}
