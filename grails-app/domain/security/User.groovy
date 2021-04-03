package security

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    UUID id
    int issure = 2
    String notes
    Date dateCreated = new Date()
    String manCreated
    Date lastUpdated
    String manLastUpdated


    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    String email
    String firstName
    String lastName

    String fullname



    static constraints = {
        password            nullable: false     , blank: false  , password: true ,maxSize:500
        username            nullable: false     , blank: false  , unique: true  ,maxSize:20
        issure              nullable: true      , blank: true
        notes               nullable: true      , blank: true   ,maxSize: 100
        dateCreated         nullable: false     , blank: false
        manCreated          nullable: false     , blank: false  ,maxSize:20
        lastUpdated         nullable: true      , blank: true
        manLastUpdated      nullable: true      , blank: true   ,maxSize:20
        enabled             nullable: true      , blank: true
        accountExpired      nullable: true      , blank: true
        accountLocked       nullable: true      , blank: true
        passwordExpired     nullable: true      , blank: true
        email               nullable: false     , blank: false  , unique: true  ,email: true,maxSize:100
        firstName           nullable: true      , blank: true   ,maxSize:50
        lastName            nullable: true      , blank: true   ,maxSize:50

        fullname            nullable: true      , blank: true
    }

    static mapping = {
        comment :'使用者資料'
        varsion:false

        id              column: 'UUID'              ,comment: 'ID'      ,generator: 'uuid2', type: "uuid-binary", length: 16
        issure          column: 'ISSURE'            ,comment: '0：刪除、1：新增中、2：使用中'
        notes           column: 'NOTES'             ,comment: '資料註記'
        dateCreated     column: 'DATE_CREATED'      ,comment: '資料建立時間'
        manCreated      column: 'MAN_CREATED'       ,comment: '資料建立者'
        lastUpdated     column: 'LAST_UPDATED'      ,comment: '資料更新時間'
        manLastUpdated  column: 'MAN_LAST_UPDATED'  ,comment: '資料更新者'
        username        column: 'USERNAME'          ,comment: '帳號'
        password        column: 'PASSWORD'          ,comment: '密碼'
        enabled         column: 'ENABLED'           ,comment: '帳戶是否可用'
        accountExpired  column: 'ACCOUNT_EXPIRED'   ,comment: '帳戶是否過期'
        accountLocked   column: 'ACCOUNT_LOCKED'    ,comment: '帳戶是否被鎖定'
        passwordExpired column: 'PASSWORD_EXPIRED'  ,comment: '密碼是否過期'
        email           column: 'EMAIL'             ,comment: '電子信箱'
        firstName       column: 'FIRST_NAME'        ,comment: '姓氏'
        lastName        column: 'LAST_NAME'         ,comment: '名字'

        fullname        comment: '全名'              ,ignoreNotFound: true    ,formula:"(FIRST_NAME||LAST_NAME)"
    }

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }
}
