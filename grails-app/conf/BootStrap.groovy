import edu.yale.yul.avcore.*

class BootStrap {

    def init = { servletContext ->
        new PBCoreVocab(concept: "1/4 inch audio tape", type: "PhysicalInstance").save(failOnError: true)
        new PBCoreVocab(concept: "Audio cassette", type: "PhysicalInstance").save(failOnError: true)
        new PBCoreVocab(concept: "Film: 16mm", type: "PhysicalInstance").save(failOnError: true)
        new PBCoreVocab(concept: "CD", type: "PhysicalInstance").save(failOnError: true)
        new PBCoreVocab(concept: "CDR", type: "PhysicalInstance").save(failOnError: true)
        new PBCoreVocab(concept: "Interviewer", type: "CreatorRole").save(failOnError: true)
        new PBCoreVocab(concept: "Composer", type: "CreatorRole").save(failOnError: true)
        new PBCoreVocab(concept: "Director", type: "CreatorRole").save(failOnError: true)
        new PBCoreVocab(concept: "Event", type: "AssetType").save(failOnError: true)
        new PBCoreVocab(concept: "Series", type: "AssetType").save(failOnError: true)
        new PBCoreVocab(concept: "Season", type: "AssetType").save(failOnError: true)
        new PBCoreVocab(concept: "Created", type: "DateType").save(failOnError: true)
        new PBCoreVocab(concept: "Copyright holder", type: "PublisherRole").save(failOnError: true)
        
        def p = new Person(name: "John W. Cook");
        p.save(failOnError: true)
        
        def corePerson = new CorePerson(person: p, type:"Creator", role: "Interviewer");
        corePerson.save(failOnError: true)
        
        def col = new Collection(title: "Test Collection", 
            identifier: "ms.0",
            description: "This is a test collection",
            source: "ms atk"
        ).save(failOnError: true);
        
        col.save(failOnError: true);
        
        def core = new  DocCore(
            identifier: "ms.1873.kahn",
            assetDate: new Date(),
            assetType: "Event",
            collection: col,
            creator: corePerson,
            description: "Interview with Louis I. Kahn (2 audiotapes)",
            title: "Kahn, Louis"
        )
        
        core.save(failOnError: true);
        
        
        
    }
    def destroy = {
    }
}
