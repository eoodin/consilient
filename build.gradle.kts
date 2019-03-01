plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.20")
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.openpnp:opencv:3.4.2-1")
    implementation("com.jcraft:jsch:0.1.55")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

application {
    mainClassName = "guitest.AppKt"
}
