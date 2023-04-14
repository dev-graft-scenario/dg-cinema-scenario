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
    setSourceDir("src/docs/asciidoc")
    setOutputDir(layout.buildDirectory.dir("docs/asciidoc").get().asFile)
}

tasks.named("build") {
    dependsOn("asciidoctor")
}
/**
 * 빌드하면 adoc파일들 잔뜩 나옴.
 * 이걸 한대 묶어서 내가 movie.adoc 이렇게 정의함
 * 이걸 html로 변환해야하니 특정 위치에 지정해야함
 * 뽑으면 어디에 html이 나올지 지정해야함
 */