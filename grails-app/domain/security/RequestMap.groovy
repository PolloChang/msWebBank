package security

import org.springframework.http.HttpMethod

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes=['configAttribute', 'httpMethod', 'url'])
@ToString(includes=['configAttribute', 'httpMethod', 'url'], cache=true, includeNames=true, includePackage=false)
class RequestMap implements Serializable {

	private static final long serialVersionUID = 1
	UUID 		id
	Long 		issure = 2
	String 		notes
	String		manCreated
	Date		dateCreated = new Date()
	String		manLastUpdated
	Date		lastUpdated = new Date()

	String configAttribute
	HttpMethod httpMethod
	String url

	static mapping = {
		cache:true
		table:'REQUEST_MAP'
		comment:'系統角色可使用程式對應檔'
		varsion:false

		id					column:"UUID",generator: "uuid2", type: "uuid-binary", length: 16
		issure				column:"ISSURE"         	,comment:"資料狀態"
		notes				column:"NOTES"          	,comment:"資料註記"
		dateCreated			column:"DATE_CREATED"		,comment:"資料建立時間"
		manCreated			column:"MAN_CREATED"		,comment:"資料建立者"
		lastUpdated			column:"LAST_UPDATED"		,comment:"資料更新人"
		manLastUpdated		column:"MAN_LAST_UPDATED"	,comment:"資料更新者"

		configAttribute     column:"CONFIG_ATTRIBUTE"	,comment:"配置屬性"
		httpMethod          column:"HTTP_METHOD"	    ,comment:"HTTP_METHOD"
		url                 column:"URL"	            ,comment:"URL"
	}

	static constraints = {
		issure				nullable:false, blank: false
		notes				nullable:true , maxSize: 100
		dateCreated			nullable:false, blank: false
		manCreated			nullable:false, blank: false, maxSize: 200
		lastUpdated			nullable:true
		manLastUpdated		nullable:true , maxSize: 200
		configAttribute     blank: false
		httpMethod          nullable: true
		url                 blank: false, unique: 'httpMethod'
	}
}
