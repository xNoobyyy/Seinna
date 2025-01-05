plugins {
    kotlin("jvm") version "2.1.0"

    id("io.papermc.paperweight.userdev") version "2.0.0-beta.11"
}

group = "de.leander"
version = "0.1-ALPHA"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    paperweight.paperDevBundle("1.21.4-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}