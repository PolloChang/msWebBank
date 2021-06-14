package bs

/**
 * 程式清單
 * @author JamesChang
 * @since Grails4.0.1
 */
class Bs000 {

    static auditable = [ignore: ['dateCreated', 'lastUpdated', 'manCreated', 'manLastUpdated']]
    UUID id
    Long		issure = 1
    String		notes
    Date		dateCreated = new Date()
    String		manCreated
    Date		lastUpdated = new Date()
    String		manLastUpdated
    String		appName
    String		parentApp
    String		appCname
    String		appCnameI18n
    String		status
    String		controller
    String		action
    Integer		idx
    String 		actionType
    boolean 	showOnMenu

    String      statusDesc
    String      showOnMenuDesc

    static mapping = {
        table:'BS000'
        comment:'程式清單'
        version true
        id					column:"UUID",generator: "uuid2", type: "uuid-binary", length: 16
        issure				column:"ISSURE",			comment:"資料狀態"
        notes				column:"NOTES",				comment:"資料註記"
        dateCreated			column:"DATE_CREATED",		comment:"資料建立時間"
        manCreated			column:"MAN_CREATED",		comment:"資料建立者"
        lastUpdated			column:"LAST_UPDATED",		comment:"資料更新人"
        manLastUpdated		column:"MAN_LAST_UPDATED",	comment:"資料更新者"
        appName				column:"APP_NAME",			comment:"程式名稱_E"
        parentApp			column:"PARENT_APP",		comment:"上層APP"
        appCname			column:"APP_CNAME",			comment:"程式名稱"
        appCnameI18n		column:"APP_CNAME_I18N",	comment:"程式名稱_I18N"
        status				column:"STATUS",			comment:"狀態"
        statusDesc          ignoreNotFound: true    ,comment:"狀態中文敘述"              ,formula: "(SELECT BS.TYPEDESC FROM BS101 BS WHERE BS.PTYPE='APP_LIST_STATUS' AND BS.PCODE=STATUS  )"
        controller			column:"CONTROLLER",		comment:"CONTROLLER"
        action				column:"ACTION",			comment:"ACTION"
        idx					column:"IDX",				comment:"排序"
        actionType			column:"ACTION_TYPE",		comment:"onlyFunction:單純執行程式,isDropdown:底下還有執行程式"
        showOnMenu			column: "SHOW_ON_MENU",		comment:"顯示在程式清單上"
        showOnMenuDesc      ignoreNotFound: true    ,comment:"顯示在程式清單上中文敘述"              ,formula: "(SELECT BS.TYPEDESC FROM BS101 BS WHERE BS.PTYPE='BS000_SHOW_ON_MENU' AND BS.PCODE=SHOW_ON_MENU  )"
    }


    static constraints = {
        issure				(nullable:false, blank: false)
        notes				(nullable:true, maxSize: 1000)
        dateCreated			(nullable:false, blank: false)
        manCreated			(nullable:false, blank: false, maxSize: 200)
        lastUpdated			(nullable:true)
        manLastUpdated		(nullable:true, maxSize: 200)
        appName				(nullable:false, blank: false, maxSize: 100)
        parentApp			(nullable:true, maxSize: 100)
        appCname			(nullable:true, maxSize: 500)
        appCnameI18n		(nullable:true, maxSize: 200)
        status				(nullable:false, blank: false, maxSize: 200)
        controller			(nullable:true, maxSize: 100)
        action				(nullable:true, maxSize: 100)
        actionType			(nullable:true, maxSize: 100)
        idx					(nullable:false, blank: false)
    }

    /**
     * 共同儲存欄位
     */
    ArrayList updateBindMap = ['appName','parentApp','appCname','appCnameI18n','status','controller','action','idx','actionType','showOnMenu']

}
