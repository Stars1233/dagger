# Copyright (C) 2021 The Dagger Authors.
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
#   Import for including XProcessing in Dagger.

load("@rules_java//java:defs.bzl", "java_import", "java_library")
load("//tools:bazel_compat.bzl", "compat_kt_jvm_library")

package(default_visibility = ["//dagger-compiler:internal"])

XPOET_SRCS = [
    "Accessibility.java",
    "NullableTypeNames.java",
    "XAnnotationSpecs.java",
    "XCodeBlocks.java",
    "XExpression.java",
    "XExpressionType.java",
    "XFunSpecs.java",
    "XParameterSpecs.java",
    "XPropertySpecs.java",
    "XTypeSpecs.java",
]

java_library(
    name = "xpoet",
    srcs = XPOET_SRCS,
    deps = [
        ":xprocessing",
        "//dagger-compiler/main/java/dagger/internal/codegen/compileroption",
        "//dagger-spi",
        "//third_party/java/error_prone:annotations",
        "//third_party/java/guava/base",
        "//third_party/java/guava/collect",
        "//third_party/java/javapoet",
        "//third_party/kotlin/kotlinpoet",
    ],
)

compat_kt_jvm_library(
    name = "xprocessing",
    # TODO(b/181056551): Ideally, all of the methods in these utility classes
    # will move directly into XProcessing, and we can then remove these classes.
    srcs = glob(
        [
            "*.java",
            "*.kt",
        ],
        exclude = XPOET_SRCS,
    ),
    exports = [
        ":xprocessing-lib",
    ],
    deps = [
        ":xprocessing-lib",
        "//dagger-spi",
        "//third_party/java/auto:common",
        "//third_party/java/auto:value",
        "//third_party/java/guava/base",
        "//third_party/java/guava/collect",
        "//third_party/java/javapoet",
        "//third_party/java/jsr305_annotations",
        "//third_party/kotlin/kotlin:kotlin_stdlib",
        "//third_party/kotlin/kotlin_symbol_processing:symbol-processing-api",
        "//third_party/kotlin/kotlinpoet",
    ],
)

alias(
    name = "xprocessing-lib",
    actual = ":xprocessing-jar",
    visibility = ["//visibility:private"],
)

java_import(
    name = "xprocessing-jar",
    jars = ["xprocessing-internal.jar"],
    deps = [
        "//third_party/kotlin/kotlin_symbol_processing:symbol-processing-api",
        "//third_party/kotlin/kotlinpoet",
        "//third_party/kotlin/kotlinpoet/javapoet",
    ],
)

java_library(
    name = "xprocessing-testing",
    testonly = 1,
    exports = [
        ":xprocessing-testing-lib",
        "@maven//:com_google_devtools_ksp_symbol_processing",
        "@maven//:com_google_devtools_ksp_symbol_processing_aa_embeddable",
        "@maven//:com_google_devtools_ksp_symbol_processing_common_deps",
        "@maven//:org_jetbrains_kotlin_kotlin_annotation_processing_embeddable",
        "@maven//:org_jetbrains_kotlin_kotlin_compiler_embeddable",
        "@maven//:org_jetbrains_kotlin_kotlin_daemon_embeddable",
    ],
)

alias(
    name = "xprocessing-testing-lib",
    actual = ":xprocessing-testing-jar",
    visibility = ["//visibility:private"],
)

java_import(
    name = "xprocessing-testing-jar",
    jars = ["xprocessing-testing-internal.jar"],
    visibility = ["//visibility:private"],
)
