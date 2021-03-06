/*
 * Copyright 2016 The BigDL Authors.
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
package com.intel.analytics.bigdl.nn

import com.intel.analytics.bigdl.nn.ops.Ceil
import org.scalatest.{FlatSpec, Matchers}

class SequentialSpec extends FlatSpec with Matchers {
  "A Sequential Container " should "not contain operation" in {
    val model = Sequential[Double]()
    model.add(Linear(10, 100))  // this should work
    intercept[IllegalArgumentException] {
      model.add(Ceil[Double, Double]()) // this is not allowed
    }
  }
}
