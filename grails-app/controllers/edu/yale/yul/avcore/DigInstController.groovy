package edu.yale.yul.avcore

class DigInstController {
    def helper = new DigInstanceService()
    static scaffold = DigInst
    
    def instance = {
        [ins: DigInst.get(params.id)]
    }
    
    def addInstance = {
        DocCore core = DocCore.get(params.id)
        [core: core, mediaType: params.mediaType]
        
    }
    
    def readMediaInfo = {
        DocCore core = DocCore.get(params.id)
        def uploadedFile = request.getFile('payload')
        if(!uploadedFile.empty){
            /*
            render "Class: ${uploadedFile.class}"
            render "<br />Name: ${uploadedFile.name}"
            render "<br />OriginalFileName: ${uploadedFile.originalFilename}"
            render "<br />Size: ${uploadedFile.size}"
            render "<br />ContentType: ${uploadedFile.contentType}"
            */
            def webRootDir = servletContext.getRealPath("/")
            def userDir = new File(webRootDir, "/uploads")
            userDir.mkdirs()
            uploadedFile.transferTo( new File( userDir, uploadedFile.originalFilename))
      
            File f = new File((userDir.toString() + "/" + uploadedFile.originalFilename))
            if(f.exists()){
                //render ("Upload Successful<br />")
            }
            
            def doc = new XmlSlurper().parse(f)
            
            DigInst di = new DigInst();
            doc.File.track.each{
                if(it.@type.equals("General")) {
                    
                    di.fileName = it.Complete_name
                    di.fileSize = helper.fileSize(it.File_size.toString())
                    di.fileSizeType = helper.fileSizeType(it.File_size.toString())
                    di.dateType = "encoded"
                    di.date = java.sql.Date.valueOf(it.Encoded_date.toString().substring(4,14).trim())
                    di.standard = it.Format
                    di.dataRate = helper.dataRate(it.Overall_bit_rate.toString())
                    /*
                    render "Collection: " + core.collection.title + "<br />" 
                    render "Core: " + core.title + "<br />" 
                    render "Complete_name: " + it.Complete_name + "<br />"
                    render "Format: " + it.Format + "<br />"
                    render "Format_profile: " + it.Format_profile + "<br />"
                    render "Codec_ID: " + it.Codec_ID + "<br />"
                    render "File_size: " + it.File_size + "<br />"
                    render "Duration: " + it.Duration + "<br />"
                    render "Encoded_date: " + it.Encoded_date + "<br />"
                    render "Overall_bit_rate: " + it.Overall_bit_rate + "<br />"
                    */
                }
            }
            di.docCore = core
            di.mediaType = params.mediaType
            
            
            di.save(flush: true, failOnError: true)
            redirect(action: instance, id: di.id)
        }
        
        
    }
}