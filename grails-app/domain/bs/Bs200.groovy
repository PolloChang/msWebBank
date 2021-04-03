package bs

/**
 *  省市縣市代碼
 * @author JamesChang
 * @since Grails4.0.1
 */
class Bs200 {
    static auditable = [ignore: ['dateCreated', 'lastUpdated', 'manCreated', 'manLastUpdated']]
    UUID id

    Long		issure = 1
    String		notes
    Date		dateCreated
    String		manCreated
    Date		lastUpdated
    String		manLastUpdated
    String		code
    String		textShow
    String		textFull
    String		textEn

    static mapping = {
        table:'BS200'
        comment:'省市縣市代碼'
        version:true
        //---1.資料流水號 PK0
        id					column:"UUID",generator: "uuid2", type: "uuid-binary", length: 16
        issure				column:"ISSURE",			        comment:"資料狀態"
        notes				column:"NOTES",				        comment:"資料註記"
        dateCreated			column:"DATE_CREATED",		        comment:"資料建立時間"
        manCreated			column:"MAN_CREATED",		        comment:"資料建立者"
        lastUpdated			column:"LAST_UPDATED",		        comment:"資料更新人"
        manLastUpdated		column:"MAN_LAST_UPDATED",	        comment:"資料更新者"
        code                column:"CODE",			            comment:"代碼"
        textShow            column:"TEXT_SHOW",			        comment:"顯示文字"
        textFull            column:"TEXT_FULL",			        comment:"全名"
        textEn              column:"TEXT_EN",			        comment:"英文名字"
    }

    static constraints = {
        issure				(nullable:false, blank: false)
        notes				(nullable:true, maxSize: 1000)
        dateCreated			(nullable:false, blank: false)
        manCreated			(nullable:false, blank: false, maxSize: 200)
        lastUpdated			(nullable:true)
        manLastUpdated		(nullable:true, maxSize: 200)
        code		        (nullable:false, blank: false, maxSize: 100)
        textShow			(nullable:false, blank: false, maxSize: 1000)
        textFull			(nullable:true, blank: true, maxSize: 1000)
        textEn			    (nullable:true, blank: true, maxSize: 1000)
    }
}
