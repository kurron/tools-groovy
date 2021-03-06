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

import java.time.LocalDateTime
import java.util.concurrent.ThreadLocalRandom
import org.apache.commons.lang3.RandomStringUtils

/**
 * This trait gives an object the ability to generate random data.  Typically useful in tests but also applicable in
 * production code.  The use of traits removes the need to use inheritance and, in some instances, provides a better
 * alternative.
 */
trait GenerationAbility {

    /**
     * Generates a hex value of a random integer between 0 (inclusive) and Integer.MAX_VALUE (exclusive).
     * @return hex string of the random number.
     */
    String randomHexString() {
        Integer.toHexString( ThreadLocalRandom.current().nextInt( Integer.MAX_VALUE ) ).toUpperCase()
    }

    /**
     * Generates a random string whose length is the number of characters specified.
     * @param size how large of a string to make.
     * @return the newly generated string
     */
    String randomString( int size ) {
        RandomStringUtils.random( size )
    }

    /**
     * Generates a random string whose length is the number of characters specified.
     * @param size how large of a string to make.
     * @param source the source of characters to generate the new string from.
     * @return the newly generated string
     */
    String randomString( int size, String source ) {
        RandomStringUtils.random( size, source )
    }

    /**
     * Generates a random integer between 0 (inclusive) and Integer.MAX_VALUE (exclusive).
     * @return random integer.
     */
    int randomPositiveInteger() {
        randomInteger( 0, Integer.MAX_VALUE )
    }

    /**
     * Generates a random number between the two ranges.
     * @param floor the smallest value to randomize (inclusive)
     * @param ceiling the largest value to randomize (exclusive)
     * @return random integer within the range.
     */
    int randomInteger( int floor, int ceiling ) {
        Math.max( floor, ThreadLocalRandom.current().nextInt( ceiling ) )
    }

    /**
     * Generates a buffer of the specified size filled with random data.
     * @param size size of the buffer to build.
     * @return random data buffer.
     */
    byte[] randomByteArray( int size ) {
        byte[] buffer = new byte[size]
        ThreadLocalRandom.current().nextBytes( buffer )
        buffer
    }

    /**
     * Generates a random UUID.
     * @return the random UUID.
     */
    UUID randomUUID() {
        UUID.randomUUID()
    }

    /**
     * Generates a random boolean value.
     * @return true or false.
     */
    boolean randomBoolean() {
        ThreadLocalRandom.current().nextBoolean()
    }

    /**
     * Generates a random long from 0 to Long.MAX_VALUE.
     * @return randomized long.
     */
    Long randomLong() {
        Math.abs( ThreadLocalRandom.current().nextLong() )
    }

    /**
     * Randomly selects an element from a list. Signature is untyped so be careful.
     * @param list to select an element from.
     * @return randomly selected element.
     */
    Object randomElement( List list ) {
        list[ ThreadLocalRandom.current().nextInt( list.size() ) ]
    }

    /**
     * Generate a list of data points using the provided closure.
     * @param size how many data points to generate.
     * @param generator the data point generator to use.
     * @return the list of generated data points
     */
    List generateData( int size, Closure generator ) {
        (1..size).collect( generator )
    }

    static enum Direction { FUTURE, PAST
    }

    /**
     * Generates a time point randomly offset from the current time point.
     * @param direction which direction to generate the point for, relative to now.
     * @param magnitude how many days we are allowed to travel from the current time point.
     * @return generated time point.
     */
    LocalDateTime randomDateTime( Direction direction, int magnitude ) {
        def now = LocalDateTime.now()
        def offset = randomInteger( 1, magnitude )
        direction == Direction.FUTURE ? now.plusDays( offset ) : now.minusDays( offset )
    }

    /**
     * Generates a randomized HTTP-based URI complete including query parameters and matrix variables.
     * @return randomized URI.
     */
    URI randomURI() {
        new URI( 'http', randomHexString(), randomHexString(), randomPositiveInteger(), "/${randomHexString()}", "key=${randomHexString()};x=1;y=2;z=3", randomHexString() )
    }

    /**
     * Generates a random byte value.
     * @return randomized value.
     */
    byte randomByte() {
        ThreadLocalRandom.current().nextInt()
    }
}
