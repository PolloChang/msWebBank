package ex

class Ex110 {
    static auditable = [ignore: ['dateCreated', 'lastUpdated', 'manCreated', 'manLastUpdated']]
    static belongsTo = [ex100I:Ex100]

    UUID        id
    Long        issure = 2
    String      notes
    String		manCreated
    Date		dateCreated = new Date()
    String		manLastUpdated
    Date		lastUpdated = new Date()
    String		string

    static mapping = {
        table:'EX110'
        comment:'資料範例'
        version true

        id					column:"UUID",generator: "uuid2", type: "uuid-binary", length: 16
        issure				column:"ISSURE"         ,comment:"資料狀態"
        notes				column:"NOTES"          ,comment:"資料註記"
        dateCreated			column:"DATE_CREATED",	comment:"資料建立時間"
        manCreated			column:"MAN_CREATED",	comment:"資料建立者"
        lastUpdated			column:"LAST_UPDATED",	comment:"資料更新人"
        manLastUpdated		column:"MAN_LAST_UPDATED",comment:"資料更新者"
        ex100I              column:"EX100ID",comment:"範例資料"
        string              column: "STRING"        ,comment: "字串"
    }

    static constraints = {
        issure				(nullable:false, blank: false)
        notes				(nullable:true, maxSize: 1000)
        dateCreated			(nullable:false, blank: false)
        manCreated			(nullable:false, blank: false, maxSize: 200)
        lastUpdated			(nullable:true)
        manLastUpdated		(nullable:true, maxSize: 200)
        ex100I				(nullable:false, blank: false)
        string              (nullable:false, blank: false, maxSize: 20)
    }
}
