# Copyright (C) 2022 The Dagger Authors.
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
#   Functional tests for Dagger multibinding usages.

load(
    "//:build_defs.bzl",
    "DOCLINT_HTML_AND_SYNTAX",
    "DOCLINT_REFERENCES",
)
load("//:test_defs.bzl", "GenJavaTests")

package(default_visibility = ["//:src"])

GenJavaTests(
    name = "MultibindingTest",
    srcs = [
        "BooleanKey.java",
        "ByteKey.java",
        "CharKey.java",
        "MultibindingComponent.java",
        "MultibindingDependency.java",
        "MultibindingModule.java",
        "MultibindingTest.java",
        "MultibindsModule.java",
        "NestedAnnotationContainer.java",
        "NumberClassKey.java",
        "RequiresFieldInjection.java",
        "ShortKey.java",
        "UnwrappedAnnotationKey.java",
        "WrappedAnnotationKey.java",
    ],
    gen_library_deps = [
        "//javatests/dagger/functional/multibindings/subpackage:ContributionsModule",
    ],
    javacopts = DOCLINT_HTML_AND_SYNTAX + DOCLINT_REFERENCES,
    deps = [
        "//third_party/java/auto:value",
        "//third_party/java/dagger",
        "//third_party/java/junit",
        "//third_party/java/truth",
    ],
)

GenJavaTests(
    name = "BindsInaccessibleMapKeyTest",
    srcs = ["BindsInaccessibleMapKeyTest.java"],
    gen_library_deps = [
        "//javatests/dagger/functional/multibindings/subpackage:BindsInaccessibleMapKeyModule",
    ],
    javacopts = DOCLINT_HTML_AND_SYNTAX + DOCLINT_REFERENCES,
    deps = [
        "//third_party/java/dagger",
        "//third_party/java/guava/collect",
        "//third_party/java/junit",
        "//third_party/java/truth",
    ],
)

GenJavaTests(
    name = "ClassKeyWithGenericsTest",
    srcs = ["ClassKeyWithGenericsTest.java"],
    javacopts = DOCLINT_HTML_AND_SYNTAX + DOCLINT_REFERENCES,
    deps = [
        "//third_party/java/dagger",
        "//third_party/java/junit",
        "//third_party/java/truth",
    ],
)

GenJavaTests(
    name = "LazyClassKeyWithGenericsTest",
    srcs = ["LazyClassKeyWithGenericsTest.java"],
    javacopts = DOCLINT_HTML_AND_SYNTAX + DOCLINT_REFERENCES,
    deps = [
        "//third_party/java/dagger",
        "//third_party/java/junit",
        "//third_party/java/truth",
    ],
)

GenJavaTests(
    name = "ComplexMapKeysInDifferentOrderTest",
    srcs = ["ComplexMapKeysInDifferentOrderTest.java"],
    javacopts = DOCLINT_HTML_AND_SYNTAX + DOCLINT_REFERENCES,
    deps = [
        "//third_party/java/auto:value",
        "//third_party/java/dagger",
        "//third_party/java/junit",
        "//third_party/java/truth",
    ],
)

GenJavaTests(
    name = "MapKeyWithDefaultTest",
    srcs = ["MapKeyWithDefaultTest.java"],
    javacopts = DOCLINT_HTML_AND_SYNTAX + DOCLINT_REFERENCES,
    deps = [
        "//third_party/java/auto:value",
        "//third_party/java/dagger",
        "//third_party/java/junit",
        "//third_party/java/truth",
    ],
)

GenJavaTests(
    name = "LazyMapsTest",
    srcs = [
        "LazyMaps.java",
        "LazyMapsTest.java",
    ],
    javacopts = DOCLINT_HTML_AND_SYNTAX + DOCLINT_REFERENCES,
    deps = [
        "//third_party/java/dagger",
        "//third_party/java/junit",
        "//third_party/java/truth",
    ],
)
