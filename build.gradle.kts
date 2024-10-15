import dev.monosoul.jooq.GenerateJooqClassesTask

plugins {
    kotlin("jvm") version "2.0.20"
    kotlin("plugin.spring") version "2.0.20"
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
    id("dev.monosoul.jooq-docker") version "6.1.8"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.1"
}

group = "io.github.warfox"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-database-postgresql")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("jakarta.validation:jakarta.validation-api")
    implementation("org.hibernate.validator:hibernate-validator")

    developmentOnly("org.springframework.boot:spring-boot-devtools")

    jooqCodegen(platform("org.springframework.boot:spring-boot-dependencies:3.2.2"))
    jooqCodegen("org.jooq:jooq-codegen")
    jooqCodegen("org.postgresql:postgresql")

    runtimeOnly("io.micrometer:micrometer-registry-prometheus")
    runtimeOnly("org.postgresql:postgresql")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

task("run", JavaExec::class) {
    mainClass.set("io.github.warfox.LocalApplicationKt")
    classpath = sourceSets.test.get().runtimeClasspath
}

tasks.getByName<org.springframework.boot.gradle.tasks.run.BootRun>("bootRun") {
    mainClass.set("io.github.warfox.LocalApplicationKt")
    classpath = sourceSets.test.get().runtimeClasspath
}

tasks.withType<GenerateJooqClassesTask> {
    basePackageName = "io.github.warfox.demo.jooq"
    usingJavaConfig {
        database
            .withExcludes("flyway_schema_history")
    }
    outputSchemaToDefault = setOf("public")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
