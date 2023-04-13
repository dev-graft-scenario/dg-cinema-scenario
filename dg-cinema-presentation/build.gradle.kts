dependencies {
    implementation(project(":dg-cinema-domain"))
    testImplementation(testFixtures(project(":dg-cinema-domain")))
    implementation(project(":dg-cinema-infrastructure"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    runtimeOnly("com.h2database:h2")
    testRuntimeOnly("com.h2database:h2")
}
