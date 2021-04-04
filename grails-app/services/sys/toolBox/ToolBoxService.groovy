package sys.toolBox

import bs.Bs200
import bs.Bs201
import bs.Bs202
import bs.Bs203
import grails.gorm.transactions.Transactional

import java.sql.Date
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * 工具箱
 * @author JamesChang
 * @since Grails4.0.1
 */
@Transactional
class ToolBoxService {

    /**
     *getBs2xxSelect 取得行政區資料
     * @param bsType
     * @param whereCode
     * @return result[Map]
     */
    def getBs2xxSelect(String bsType,String whereCode) {
        LinkedHashMap result = [:]
        switch (bsType){
            case "Bs200":
                result.dataBean = Bs200.findAllByIssure(2,[sort:'code', order:'asc'])
                break
            case "Bs201":
                if(!whereCode){
                    throw new Exception("function [serviceMethod] is missing [whereCode] can't null if bsType equal Bs201 ")
                }
                result.dataBean = Bs201.findAllByIssureAndBs200Code(2,whereCode,[sort:'code', order:'asc'])
                break
            case "Bs202":
                if(!whereCode){
                    throw new Exception("function [serviceMethod] is missing [whereCode] can't null if bsType equal Bs202 ")
                }
                result.dataBean = Bs202.findAllByIssureAndBs201Code(2,whereCode,[sort:'code', order:'asc'])
                break
            case "Bs203":
                if(!whereCode){
                    throw new Exception("function [serviceMethod] is missing [whereCode] can't null if bsType equal Bs202 ")
                }
                result.dataBean = Bs203.findAllByIssureAndBs201Code(2,whereCode,[sort:'code', order:'asc'])
                break
            default:
                throw new Exception("function [serviceMethod] 未定義此項目")
        }
        return result
    }


    /**
     * 字串轉日期
     */
    def paramsTextDateTransform  = { attrs ->

        def returnValue = [:]
        def params = attrs.params
        def list = attrs.list
        def domain = attrs.domain
        def s = (attrs.sqldate == "true" || attrs.sqldate == true)
        params.each{ key, val ->
            if(domain){
                list.each{
                    if(key=="${domain}.${it}" && val){
                    }
                }
            }
            else{
                list.each{

                    if(key=="${it}" && val){
                        Date date = Date.valueOf(val.toString())
                        returnValue << ["${it}":date]
                    }
                }
            }
        }

        return  returnValue
    }

    /*方法1)：推薦，速度最快
      * 利用正則表達式判斷字符串是否是數字
      * @param str 傳入的字符串
      * @return 是整數返回true,否則返回false
     */
    def boolean isNumeric(String str){
        println 'isNumeric'
        println str
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }

    /**
     * 資料新增前處理
     * @param domain 原domain
     * @param domainI 新domain
     * @return  domainI [domain]
     */
    def beforeInsert(def domain,def domainI){
        domainI = domain
        domainI.version = 0
        domainI.dateCreated = new java.util.Date()
        domainI.manCreated = '系統管理員'

        return domainI
    }

    /**
     * 資料更新前處理
     * @param domain 原domain
     * @param domainI 新domain
     * @return  domainI [domain]
     */
    def beforeUpdate(def domain,def domainI){
        domainI = domain
        domainI.version = domain.version +1
        domainI.lastUpdated = new java.util.Date()
        domainI.manLastUpdated = '系統管理員'

        return domainI
    }

}
