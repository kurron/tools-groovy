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

import java.util.concurrent.ThreadLocalRandom

/**
 * This trait gives an object the ability to generate random data.  Typically useful in tests but also applicable in
 * production code.
 */
trait GenerationAbility {

    /**
     * Generates a hex value of a random integer between 0 (inclusive) and Integer.MAX_VALUE (exclusive).
     * @return hex string of the random number.
     */
    String randomHexString() {
        Integer.toHexString( randomPositiveInteger() ).toUpperCase()
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

    //TODO: random enum
    //TODO: random date

    /**
     * Randomly selects an element from a list. Signature is untyped so be careful.
     * @param list to select an element from.
     * @return randomly selected element.
     */
    Object randomElement( List list ) {
        list[ ThreadLocalRandom.current().nextInt( list.size() ) ]
    }
}
