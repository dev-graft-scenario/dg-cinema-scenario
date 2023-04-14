import org.asciidoctor.gradle.jvm.AsciidoctorTask

plugins {
    id("org.asciidoctor.jvm.convert") version "3.3.2"
}

dependencies {
    implementation(project(":dg-cinema-domain"))
    testImplementation(testFixtures(project(":dg-cinema-domain")))
    implementation(project(":dg-cinema-infrastructure"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    runtimeOnly("com.h2database:h2")
    testRuntimeOnly("com.h2database:h2")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")//:2.0.5.RELEASE
}

tasks.named("asciidoctor", AsciidoctorTask::class) {
    dependsOn("test")
    setSourceDir("src/main/asciidoc")
    setOutputDir(layout.buildDirectory.dir("docs/asciidoc").get().asFile)
}

tasks.named("build") {
    dependsOn("asciidoctor")
}
