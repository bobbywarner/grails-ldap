grails.project.work.dir = 'target'
grails.project.dependency.resolution = {
    inherits("global") {
    }
    log "warn"
    repositories {
        mavenRepo "http://repo.grails.org/grails/plugins/"
        mavenRepo "http://repo.grails.org/grails/repo/"
        mavenCentral()
    }
    dependencies {
        compile('org.codehaus:gldapo:0.8.5') {
            excludes 'spring-core', 'spring-beans', 'servlet-api', 'commons-logging', 'commons-lang'
        }
    }
}
