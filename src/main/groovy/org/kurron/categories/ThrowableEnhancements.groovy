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

import org.apache.commons.lang3.exception.ExceptionUtils

/**
 * Convenience methods that can be added to any Throwable.
 */
class ThrowableEnhancements {

    /**
     * Walks through the exception chain to the last element, "root" of the tree.
     * @param receiver the instance to transform.
     * @return the root cause of the Throwable, null if none found or null throwable input.
     */
    static Throwable getRootCause( Throwable receiver ) {
        ExceptionUtils.getRootCause( receiver )
    }

    /**
     * Returns the list of Throwable objects in the exception chain.
     * @param receiver the instance to transform.
     * @return the list of throwables, never null.
     */
    static List<Throwable> toList( Throwable receiver ) {
        ExceptionUtils.getThrowableList( receiver )
    }

}
