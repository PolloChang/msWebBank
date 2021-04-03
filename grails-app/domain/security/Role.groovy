package security

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='authority')
@ToString(includes='authority', includeNames=true, includePackage=false)
class Role implements Serializable {

	private static final long serialVersionUID = 1
	UUID 		id
	Long 		issure = 2
	String 		notes
	String		manCreated
	Date		dateCreated = new Date()
	String		manLastUpdated
	Date		lastUpdated = new Date()

	String 		authority
	String		authorityName

	static mapping = {
		cache:true
		comment:'系統角色'
		varsion:false

		id					column:"UUID",generator: "uuid2", type: "uuid-binary", length: 16
		issure				column:"ISSURE"         	,comment:"資料狀態"
		notes				column:"NOTES"          	,comment:"資料註記"
		dateCreated			column:"DATE_CREATED"		,comment:"資料建立時間"
		manCreated			column:"MAN_CREATED"		,comment:"資料建立者"
		lastUpdated			column:"LAST_UPDATED"		,comment:"資料更新人"
		manLastUpdated		column:"MAN_LAST_UPDATED"	,comment:"資料更新者"
		authority           column:"AUTHORITY"       	,comment:"角色"
		authorityName		column:"AUTHORITY_NAME"		,comment:"角色說明"
	}

	static constraints = {

		issure				nullable:false, blank: false
		notes				nullable:true , maxSize: 100
		dateCreated			nullable:false, blank: false
		manCreated			nullable:false, blank: false, maxSize: 200
		lastUpdated			nullable:true
		manLastUpdated		nullable:true , maxSize: 200
		authority 			nullable:false, blank: false, unique: true,maxSize: 20
		authorityName		nullable:true	,maxSize: 100
	}
}
