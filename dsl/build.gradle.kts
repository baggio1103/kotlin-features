plugins {
    id("java")
    kotlin("jvm") version "1.9.22"
}

group = "com.javajedi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.9.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(19)
}