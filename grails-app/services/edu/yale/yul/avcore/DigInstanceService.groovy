package edu.yale.yul.avcore
import java.util.regex.*

class DigInstanceService {

    static transactional = true

    def test() {
        return "test"
    }
    
    def fileSize(String s) {
        Pattern p = Pattern.compile("\\d* ");
        Matcher m = p.matcher(s)
        if(m.find()) {
            return Integer.parseInt(m.group().trim())
        }
    }
    
    def fileSizeType(String s) {
        Pattern p = Pattern.compile(" \\w*\$");
        Matcher m = p.matcher(s)
        if(m.find()) {
            if(m.group().trim().equals("MiB"))
                return "mb"
        }
    }
    
    def date(String s) {
        encDate = java.sql.Date.valueOf(s);
        
        return encDate
    }
}
