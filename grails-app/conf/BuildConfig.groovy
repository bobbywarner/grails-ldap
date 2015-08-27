grails.project.work.dir = 'target'
grails.project.dependency.resolver = "maven"
grails.project.dependency.resolution = {
    inherits("global")
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

        test 'org.apache.directory.server:apacheds-all:1.5.4'
        test 'org.apache.directory.shared:shared-asn1:0.9.12'
        test 'org.apache.directory.shared:shared-ldap:0.9.12'
        test 'org.apache.directory.shared:shared-ldap-constants:0.9.12'
    }
    plugins {
        build(":release:3.1.1",
              ":rest-client-builder:2.1.1") {
            export = false
        }
    }
}
