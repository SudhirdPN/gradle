/*
 * Copyright 2018 the original author or authors.
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

plugins {
    `java-platform`
}

// Here you should declare versions which should be shared by the different modules of buildSrc itself
val javaParserVersion = "3.6.11"
val asmVersion = "7.1"

dependencies {
    constraints {
        // Gradle Plugins
        api("com.gradle:gradle-enterprise-gradle-plugin:3.3.4")
        api("com.gradle.publish:plugin-publish-plugin:0.11.0")
        api("gradle.plugin.org.jetbrains.gradle.plugin.idea-ext:gradle-idea-ext:0.7")
        api("me.champeau.gradle:japicmp-gradle-plugin:0.2.9")
        api("me.champeau.gradle:jmh-gradle-plugin:0.5.0")
        api("org.asciidoctor:asciidoctor-gradle-plugin:1.5.10")
        api("org.gradle:test-retry-gradle-plugin:1.1.6")
        api("org.gradle.kotlin:gradle-kotlin-dsl-conventions:0.5.0")

        // Java Libraries
        api("com.github.javaparser:javaparser-core:$javaParserVersion")
        api("com.github.javaparser:javaparser-symbol-solver-core:$javaParserVersion")
        api("com.google.guava:guava:27.1-jre")
        api("com.google.code.gson:gson:2.7")
        api("com.nhaarman:mockito-kotlin:1.6.0")
        api("com.thoughtworks.qdox:qdox:2.0-M9")
        api("com.uwyn:jhighlight:1.0")
        api("com.vladsch.flexmark:flexmark-all:0.34.56")
        api("commons-io:commons-io:2.6")
        api("commons-lang:commons-lang:2.6")
        api("io.mockk:mockk:1.8.13")
        api("javax.activation:activation:1.1.1")
        api("javax.xml.bind:jaxb-api:2.2.12")
        api("junit:junit:4.13")
        api("org.asciidoctor:asciidoctorj:1.5.8.1")
        api("org.asciidoctor:asciidoctorj-pdf:1.5.0-alpha.16")
        api("org.codehaus.groovy.modules.http-builder:http-builder:0.7.2")
        api("org.codenarc:CodeNarc:1.5")
        api("org.eclipse.jgit:org.eclipse.jgit:5.7.0.202003110725-r")
        api("org.javassist:javassist:3.23.0-GA")
        api("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.1.0")
        api("org.jsoup:jsoup:1.11.3")
        api("org.junit.jupiter:junit-jupiter-api:5.6.1")
        api("org.junit.jupiter:junit-jupiter-params:5.6.2")
        api("org.openmbee.junit:junit-xml-parser:1.0.0")
        api("org.ow2.asm:asm:$asmVersion")
        api("org.ow2.asm:asm-commons:$asmVersion")
        api("xerces:xercesImpl:2.12.0") {
            because("Maven Central and JCenter disagree on version 2.9.1 metadata")
        }
    }
}
