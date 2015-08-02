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

import java.time.LocalDateTime

/**
 * Unit-level test.
 */
@Category( UnitTest )
@Unroll
class GenerationAbilityUnitTest extends Specification implements GenerationAbility {

    def 'exercise 0 arity method'( Closure sut ) {
        given: 'a collection of random data'
        def data = generateData( 10000, sut )

        expect: 'no duplicates are found'
        data.unique( false ) == data

        where:
        // problems using method references, probably because it lives off a trait, eg this.&randomHexString
        sut << [ { randomHexString() }, { randomPositiveInteger() }, { randomUUID() }, { randomLong() } ]
    }

    def 'exercise ranged random integers'() {
        given: 'a collection of random data'
        def data = generateData( 10000 ) { randomInteger( -100, 100 ) }

        expect: 'no data point exceeds the bounds'
        data.every { (it >= -100) && (it < 100) }
    }

    def 'exercise random byte arrays'() {
        given: 'a collection of random buffer sizes'
        def sizes = generateData( 10000 ) { randomInteger( 1, 256 ) } as List<Integer>

        when: 'random buffers are generated'
        def buffers = sizes.collect { randomByteArray( it ) }.sort()

        then: 'each buffer is of the specified size'
        def generatedSizes = buffers.collect { it.size() }.sort()
        sizes.sort() == generatedSizes
    }

    def 'exercise random boolean'() {
        given: 'a collection of random values'
        def values = generateData( 100000 ) { randomBoolean() }

        expect: 'about half are true and half are false'
        def positive = values.findAll { it }.size()
        def negative = values.findAll { !it }.size()
        def delta = (positive - negative).abs()
        def percentageOff = (delta / values.size() ) * 100
        percentageOff < 1 // a 1% epsilon is ok
    }

    def 'exercise random list element'() {
        given: 'a collection of random values'
        def values = generateData( 1000 ) { randomHexString() }

        expect: 'a unique selection of elements'
        def selected = (1..10).collect { randomElement( values ) }
        selected.unique( false ) == selected
    }

    enum Colors { RED, GREEN, BLUE }

    def 'exercise random enum'() {

        expect: 'a selected element'
        //TODO: grabbing and typing the list is painful.  Can we do better?
        def values = Colors.values() as List<Colors>
        def selected = randomElement( Colors.values() as List ) as Colors
        selected in values
    }

    def 'exercise random date time using #direction'() {

        expect:
        def generated = randomDateTime( direction, 100 )
        expected( generated )

        where:
        direction                          || expected
        GenerationAbility.Direction.Future || { it > LocalDateTime.now() }
        GenerationAbility.Direction.Past   || { it < LocalDateTime.now() }
    }
}
