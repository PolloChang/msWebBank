package bs

/**
 * 系統選單參數第二階層
 * @author JamesChang
 * @since Grails4.0.1
 */
class Bs101 {

    static auditable = [ignore: ['dateCreated', 'lastUpdated', 'manCreated', 'manLastUpdated']]
    UUID id
    Long		pcode
    String		ptype
    String		typedesc
    Integer		issure = 2
    String		notes
    Date		dateCreated
    String		manCreated
    Date		lastUpdated
    String		manLastUpdated
    Integer     idx
    String      exceptionString1
    String      exceptionString2
    String      exceptionString3
    Integer     exceptionInt1
    Integer     exceptionInt2
    Integer     exceptionInt3
    String      remark


    static mapping = {
        table:'BS101'
        comment:'bs101'
        version true
        id					column:"UUID",generator: "uuid2", type: "uuid-binary", length: 16
        pcode				column:"PCODE",				comment:"代碼"
        ptype				column:"PTYPE",				comment:"類型"
        typedesc			column:"TYPEDESC",			comment:"類型名稱"
        issure				column:"ISSURE",			comment:"資料狀態"
        notes				column:"NOTES",				comment:"資料註記"
        dateCreated			column:"DATE_CREATED",		comment:"資料建立時間"
        manCreated			column:"MAN_CREATED",		comment:"資料建立者"
        lastUpdated			column:"LAST_UPDATED",		comment:"資料更新人"
        manLastUpdated		column:"MAN_LAST_UPDATED",	comment:"資料更新者"
        idx                 column:"IDX",			    comment:"排序"
        exceptionString1    column: "EXCEPTION_STRING1",comment:"例外字串1"
        exceptionString2    column: "EXCEPTION_STRING2",comment:"例外字串2"
        exceptionString3    column: "EXCEPTION_STRING3",comment:"例外字串3"
        exceptionInt1       column: "EXCEPTION_INT1",   comment:"例外數字1"
        exceptionInt2       column: "EXCEPTION_INT2",   comment:"例外數字2"
        exceptionInt3       column: "EXCEPTION_INT3",   comment:"例外數字3"
        remark              column: "REMARK",           comment:"備註"

        sort idx: "asc" // or "asc"
    }


    static constraints = {
        pcode				(nullable:false, blank: false)
        ptype				(nullable:false, blank: false, maxSize: 20)
        typedesc			(nullable:true, maxSize: 100)
        issure				(nullable:true)
        notes				(nullable:true, maxSize: 1000)
        dateCreated			(nullable:false, blank: false)
        manCreated			(nullable:false, blank: false, maxSize: 200)
        lastUpdated			(nullable:true)
        manLastUpdated		(nullable:true, maxSize: 200)
        idx                 (nullable:true)
        exceptionString1    (nullable:true)
        exceptionString2    (nullable:true)
        exceptionString3    (nullable:true)
        exceptionInt1       (nullable:true)
        exceptionInt2       (nullable:true)
        exceptionInt3       (nullable:true)
        remark              (nullable:true)
    }


    /**
     * 共同儲存欄位
     */
    ArrayList updateBindMap = [
            'typedesc','idx',
            'exceptionString1','exceptionString2','exceptionString3',
            'exceptionInt1','exceptionInt2','exceptionInt3','remark'
    ]
}
