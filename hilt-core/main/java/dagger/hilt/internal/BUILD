# Copyright (C) 2020 The Dagger Authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# Description:
#   Internal Hilt libraries

load("@rules_java//java:defs.bzl", "java_library")

package(default_visibility = ["//:src"])

java_library(
    name = "test_singleton_component",
    srcs = ["TestSingletonComponent.java"],
    deps = [":generated_component"],
)

java_library(
    name = "generated_component",
    srcs = ["GeneratedComponent.java"],
)

java_library(
    name = "component_manager",
    srcs = [
        "GeneratedComponentManager.java",
        "GeneratedComponentManagerHolder.java",
    ],
    exports = [
        "//hilt-core/main/java/dagger/hilt/internal:preconditions",
        "//hilt-core/main/java/dagger/hilt/internal:unsafe_casts",
    ],
)

java_library(
    name = "preconditions",
    srcs = [
        "Preconditions.java",
    ],
)

java_library(
    name = "unsafe_casts",
    srcs = [
        "UnsafeCasts.java",
    ],
)

filegroup(
    name = "srcs_filegroup",
    srcs = glob(["*"]),
)
