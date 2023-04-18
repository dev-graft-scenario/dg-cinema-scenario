plugins {
    id("org.asciidoctor.jvm.convert") version "3.3.2"
}

val asciidoctorExt: Configuration by configurations.creating

dependencies {
    implementation(project(":dg-cinema-domain"))
    testImplementation(testFixtures(project(":dg-cinema-domain")))
    implementation(project(":dg-cinema-infrastructure"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    runtimeOnly("com.h2database:h2")
    testRuntimeOnly("com.h2database:h2")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")//:2.0.5.RELEASE
    asciidoctorExt("org.springframework.restdocs:spring-restdocs-asciidoctor")
}


tasks {
    val snippetsDir = file("build/generated-snippets")
    val copyDocumentOutputDir = "../docs"//"src/main/resources/static/docs"

    test {
        outputs.dir(snippetsDir)
        useJUnitPlatform()
    }
    asciidoctor {
        configurations(asciidoctorExt.name)
        inputs.dir(snippetsDir)
        dependsOn(test)
    }
    build {
        dependsOn(asciidoctor)
    }

    bootJar {
        dependsOn(findByName("copyDocument"))
    }

    register("copyDocument", Copy::class) {
        from(file("build/docs/asciidoc"))
        into(file(copyDocumentOutputDir))
        dependsOn(asciidoctor)
    }

    clean {
        delete(files(copyDocumentOutputDir))
    }
}