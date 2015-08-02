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

/**
 * Unit-level test.
 */
@Category( UnitTest )
class GenerationAbilityUnitTest extends Specification {

    static class SubjectUnderTest implements GenerationAbility {}

    def sut = new SubjectUnderTest()

    def 'exercise randomHexString'() {
        given: 'a collection of random data'
        def data = (1..10000).collect { sut.randomHexString() }

        expect: 'no duplicates are found'
        data.unique( false ) == data
    }
}
