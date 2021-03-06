import gradlebuild.cleanup.WhenNotEmpty

plugins {
    id("gradlebuild.distribution.api-java")
}

dependencies {
    implementation(project(":baseServices"))
    implementation(project(":baseServicesGroovy"))
    implementation(project(":files"))
    implementation(project(":logging"))
    implementation(project(":persistentCache"))
    implementation(project(":processServices"))
    implementation(project(":resources"))

    implementation(libs.slf4jApi)
    implementation(libs.groovy)
    implementation(libs.ant)
    implementation(libs.guava)
    implementation(libs.commonsIo)
    implementation(libs.commonsLang)
    implementation(libs.inject)

    testImplementation(libs.asm)
    testImplementation(libs.asmCommons)
    testImplementation(testFixtures(project(":logging")))

    testFixturesImplementation(project(":baseServices"))
}

classycle {
    excludePatterns.set(listOf("org/gradle/**"))
}

strictCompile {
    ignoreRawTypes() // raw types used in public API
    ignoreParameterizedVarargType() // [unchecked] Possible heap pollution from parameterized vararg type: ArtifactResolutionQuery, RepositoryContentDescriptor, HasMultipleValues
}

testFilesCleanup {
    policy.set(WhenNotEmpty.REPORT)
}
