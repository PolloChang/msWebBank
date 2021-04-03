package bs

/**
 * 道路資料
 * @author JamesChang
 * @since Grails4.0.1
 */
class Bs203 {
    static auditable = [ignore: ['dateCreated', 'lastUpdated', 'manCreated', 'manLastUpdated']]
    UUID id

    Long		issure = 1
    String		notes
    Date		dateCreated
    String		manCreated
    Date		lastUpdated
    String		manLastUpdated
    String		bs201Code
    String		textShow
    String		textFull
    String		textEn
    String		areaName
    String		cityName
    String		status

    static mapping = {
        table:'BS203'
        comment:'道路資料'
        version:true
        //---1.資料流水號 PK0
        id					column:"UUID",generator: "uuid2", type: "uuid-binary", length: 16
        issure				column:"ISSURE",			        comment:"資料狀態"
        notes				column:"NOTES",				        comment:"資料註記"
        dateCreated			column:"DATE_CREATED",		        comment:"資料建立時間"
        manCreated			column:"MAN_CREATED",		        comment:"資料建立者"
        lastUpdated			column:"LAST_UPDATED",		        comment:"資料更新人"
        manLastUpdated		column:"MAN_LAST_UPDATED",	        comment:"資料更新者"
        bs201Code           column:"BS201_CODE",			    comment:"省市縣市鄉鎮市區代碼"
        textShow            column:"TEXT_SHOW",			        comment:"路名"
        textFull            column:"TEXT_FULL",			        comment:"全名"
        textEn              column:"TEXT_EN",			        comment:"英文名字"
        status              column:"STATUS",			        comment:"狀態"
        cityName            column:"CITY_NAME",			        comment:"縣市名稱"
        areaName            column:"AREA_NAME",			        comment:"行政區域名稱"
    }

    static constraints = {
        issure				(nullable:false, blank: false)
        notes				(nullable:true, maxSize: 1000)
        dateCreated			(nullable:false, blank: false)
        manCreated			(nullable:false, blank: false, maxSize: 200)
        lastUpdated			(nullable:true)
        manLastUpdated		(nullable:true, maxSize: 200)
        bs201Code		    (nullable:false, blank: false, maxSize: 100)
        textShow			(nullable:false, blank: false, maxSize: 1000)
        textFull			(nullable:false, blank: false, maxSize: 1000)
        textEn			    (nullable:false, blank: false, maxSize: 1000)
        status		        (nullable:true, blank: true, maxSize: 100)
        cityName			(nullable:false, blank: false, maxSize: 1000)
        areaName			(nullable:false, blank: false, maxSize: 1000)
    }
}
