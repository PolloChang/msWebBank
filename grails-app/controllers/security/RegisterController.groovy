package security

import grails.validation.ValidationException
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

/**
 * 帳號註冊
 * @author JamesChang
 * @since Grails4.0.1
 * @see {@link # https://www.djamware.com/post/5db9a359fe53660ee3228772/grails-4-tutorial-spring-security-core-login-example#install-spring-security}
 * @see {@link # http://plugins.grails.org/plugin/grails/spring-security-core}
 */
@Transactional
@Secured('permitAll')
class RegisterController {

    static allowedMethods = [register: "POST"]

    def index() {
    }

    /**
     * 帳號註冊
     * @return
     */
    def register() {
        if(!params.password.equals(params.repassword)) {
            flash.message = "Password and Re-Password not match"
            redirect action: "index"
        } else {
            try {
                def userI = User.findByUsername(params.username)
                if(!userI){
                    userI = new User()
                    userI.dateCreated = new Date()
                    userI.manCreated = '前台申請'
                    userI.username = params.username
                    userI.password = params.password
                    userI.email = params?.email
                    userI.firstName = params?.firstName
                    userI.lastName = params?.lastName

                    userI.validate()
                    if (userI.hasErrors() || !userI.save(flush: true)) { //失敗
                        def errorColumn = []
                        userI.errors.allErrors.eachWithIndex  {item, index ->
                            errorColumn[index] = [item?.arguments,item?.defaultMessage]
                        }
                        userI.discard()
                        flash.message = errorColumn
                        render view: "index"
                    }
                    def role = Role.get(params.role.id)
                    if(userI && role) {
                        UserRole.create userI, role

                        UserRole.withSession {
                            it.flush()
                            it.clear()
                        }

                        UserRole userRoleI = new UserRole()
                        userRoleI.manCreated = '前台申請'
                        userRoleI.dateCreated = new Date()
                        userRoleI.user = userI
                        userRoleI.role = role
                        userRoleI.validate()
                        if (userRoleI.hasErrors() || !userRoleI.save(flush: true)) { //失敗
                            def errorColumn = []
                            userRoleI.errors.allErrors.eachWithIndex  {item, index ->
                                errorColumn[index] = [item?.arguments,item?.defaultMessage]
                            }
                            userRoleI.discard()
                                flash.message = message(code: "springSecurity.register.error.message")
                            render view: "index"
                        }
                        flash.message = message(code: "springSecurity.register.success.message")
                        redirect controller: "login", action: "auth"
                    } else {
                        flash.message = "Register failed"
                        render view: "index"
                    }
                }
                else{
                    flash.message = message(code: "springSecurity.register.fail.message")
                    redirect controller: "login", action: "auth"
                }
            } catch (ValidationException e) {
                e.printStackTrace()
                flash.message = message(code: "springSecurity.register.error.message")
                redirect action: "index"
            }
        }
    }
}
