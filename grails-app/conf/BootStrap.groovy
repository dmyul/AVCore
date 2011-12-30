import edu.yale.yul.avcore.PBCoreVocab
import edu.yale.yul.avcore.Collection

class BootStrap {

    def init = { servletContext ->
        new PBCoreVocab(concept: "1/4 inch audio tape", type: "PhysicalInstance").save(failOnError: true)
        new PBCoreVocab(concept: "Audio cassette", type: "PhysicalInstance").save(failOnError: true)
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
        
        new Collection(title: "Test Collection", 
            identifier: "ms.0",
            description: "This is a test collection",
            source: "ms atk"
        ).save(failOnError: true);
    }
    def destroy = {
    }
}
