dependencies {
    implementation(project(":dg-cinema-infrastructure"))
    implementation("org.springframework.boot:spring-boot-starter-web")

    runtimeOnly("com.h2database:h2")
    testRuntimeOnly("com.h2database:h2")
}
