package security

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.codehaus.groovy.util.HashCodeHelper
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@ToString(cache=true, includeNames=true, includePackage=false)
class UserRole implements Serializable {

	private static final long serialVersionUID = 1

	UUID id
	Long issure = 2
	String notes
	String		manCreated
	Date		dateCreated = new Date()
	String		manLastUpdated
	Date		lastUpdated = new Date()

	User user
	Role role

	static mapping = {
		version:false

		id					column:"UUID",generator: "uuid2", type: "uuid-binary", length: 16
		issure				column:"ISSURE"         ,comment:"資料狀態"
		notes				column:"NOTES"          ,comment:"資料註記"
		dateCreated			column:"DATE_CREATED",	comment:"資料建立時間"
		manCreated			column:"MAN_CREATED",	comment:"資料建立者"
		lastUpdated			column:"LAST_UPDATED",	comment:"資料更新人"
		manLastUpdated		column:"MAN_LAST_UPDATED",comment:"資料更新者"
		user				column:"USER_ID",comment:"使用者"
		role				column:"ROLE_ID",comment:"系統角色"

	}

	@Override
	boolean equals(other) {
		if (other instanceof UserRole) {
			other.userId == user?.id && other.roleId == role?.id
		}
	}

	@Override
	int hashCode() {
		int hashCode = HashCodeHelper.initHash()
		if (user) {
			hashCode = HashCodeHelper.updateHash(hashCode, user.id)
		}
		if (role) {
			hashCode = HashCodeHelper.updateHash(hashCode, role.id)
		}
		hashCode
	}

	static UserRole get(UUID userId, UUID roleId) {
		criteriaFor(userId, roleId).get()
	}

	static boolean exists(UUID userId, UUID roleId) {
		criteriaFor(userId, roleId).count()
	}

	private static DetachedCriteria criteriaFor(UUID userId, UUID roleId) {
		UserRole.where {
			user == User.load(userId) &&
					role == Role.load(roleId)
		}
	}

	static UserRole create(User user, Role role, boolean flush = false) {
		def instance = new UserRole(user: user, role: role)
		instance.save(flush: flush)
		instance
	}

	static boolean remove(User u, Role r) {
		if (u != null && r != null) {
			UserRole.where { user == u && role == r }.deleteAll()
		}
	}

	static int removeAll(User u) {
		u == null ? 0 : UserRole.where { user == u }.deleteAll() as int
	}

	static int removeAll(Role r) {
		r == null ? 0 : UserRole.where { role == r }.deleteAll() as int
	}

	static constraints = {
		issure				(nullable:false, blank: false)
		notes				(nullable:true, maxSize: 1000)
		dateCreated			(nullable:false, blank: false)
		manCreated			(nullable:false, blank: false, maxSize: 200)
		lastUpdated			(nullable:true)
		manLastUpdated		(nullable:true, maxSize: 200)

		user nullable: false
		role nullable: false, validator: { Role r, UserRole ur ->
			if (ur.user?.id) {
				if (UserRole.exists(ur.user.id, r.id)) {
					return ['userRole.exists']
				}
			}
		}
	}
}
