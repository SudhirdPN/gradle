/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import gradlebuild.integrationtests.integrationTestUsesSampleDir

plugins {
    id("gradlebuild.distribution.api-java")
}

dependencies {
    implementation(project(":baseServices"))
    implementation(project(":messaging"))
    implementation(project(":logging"))
    implementation(project(":processServices"))
    implementation(project(":coreApi"))
    implementation(project(":modelCore"))
    implementation(project(":core"))
    implementation(project(":files"))
    implementation(project(":fileCollections"))
    implementation(project(":persistentCache"))
    implementation(project(":snapshots"))
    implementation(project(":dependencyManagement"))
    implementation(project(":platformBase"))
    implementation(project(":platformNative"))
    implementation(project(":plugins"))
    implementation(project(":publish"))
    implementation(project(":maven"))
    implementation(project(":ivy"))
    implementation(project(":toolingApi"))
    implementation(project(":versionControl"))

    implementation(libs.groovy)
    implementation(libs.slf4jApi)
    implementation(libs.guava)
    implementation(libs.commonsLang)
    implementation(libs.commonsIo)
    implementation(libs.inject)

    testFixturesApi(project(":baseServices")) {
        because("Test fixtures export the Named class")
    }
    testFixturesApi(project(":platformBase")) {
        because("Test fixtures export the Platform class")
    }

    testFixturesImplementation(project(":internalIntegTesting"))
    testFixturesImplementation(testFixtures(project(":platformNative")))

    testImplementation(project(":native"))
    testImplementation(project(":resources"))
    testImplementation(project(":baseServicesGroovy"))
    testImplementation(testFixtures(project(":core")))
    testImplementation(testFixtures(project(":versionControl")))
    testImplementation(testFixtures(project(":platformNative")))
    testImplementation(testFixtures(project(":platformBase")))
    testImplementation(testFixtures(project(":messaging")))
    testImplementation(testFixtures(project(":snapshots")))

    integTestImplementation(project(":native"))
    integTestImplementation(project(":resources"))
    integTestImplementation(libs.nativePlatform)
    integTestImplementation(libs.ant)
    integTestImplementation(libs.jgit)

    testRuntimeOnly(project(":distributionsCore")) {
        because("ProjectBuilder tests load services from a Gradle distribution.")
    }
    integTestDistributionRuntimeOnly(project(":distributionsNative"))
}

classycle {
    excludePatterns.set(listOf("org/gradle/language/nativeplatform/internal/**"))
}

integrationTestUsesSampleDir("subprojects/language-native/src/main")
