class BasicTests extends GroovyTestCase {

    def gldapo
    def grailsApplication

    void testFoundSchemas() {
        assert 2 == grailsApplication.ldapClasses.size()
    }

    void testGldapoBean() {
        assert gldapo
        assert 2 == gldapo.schemas.size()
        assert 1 == gldapo.directories.size()
    }

    void testAddPerson() {
        def p = new Person(cn: "add", sn: "person")
        p.save()

        def l = Person.find { eq("sn", "person") }
        assert l
    }

    void testAddGroupAndPeople() {
        def people = (1..10).collect {
            def p = new Person(cn: "groupperson$it", sn: "groupperson$it")
            p.save()
            p
        }
        def g = new Group(cn: "group", uniqueMember: people.dn)
        g.save()
    }
}
