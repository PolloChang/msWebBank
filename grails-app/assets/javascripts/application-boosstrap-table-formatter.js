/**
 * Date/檔案建立日期: 2021-04-24
 * bootsrtap-table 套件formatter
 * @author JamesChang
 * @since bootsrtap-table v1.17.1
 */

// bootstrapTable常用

/**
 * 資料流水號
 * @param value
 * @param row
 * @param index
 * @returns {number}
 */
function formatterDataSerialNumber(value, row, index) {
    return Number(index) + 1;
}

/**
 * 日期格式化
 * @param value
 * @param row
 * @returns {*}
 */
function formatterDatetime(value,row) {
    if(value != null){
        return new Date(value).Format("yyyy-MM-dd");
    }
    else{
        return '-'
    }
}

/**
 * 金錢格式化
 * @param value
 */
function formatterNumberAmt(value) {
    if(value!=null){
        return numeral(value).format('$0,0.00');
    }
}

/**
 * 數字格式化
 * @param value
 * @returns {*}
 */
function formatterNumber(value) {
    if(value!=null){
        return numeral(value).format('0,0');
    }
}

/**
 * 總計
 * @returns {string}
 */
function footerFormatterTotal(data) {
    return '總計：'+data.length
}

/**
 * 編輯資料
 */
function editDataFormatter(value,row){
    let returnVal;
    returnVal = '<button type="button" class="btn btn-primary" onclick="editData(\''+row.id+'\',\''+row.showPageName+'\')">編輯</button>';
    return returnVal;
}

function editDataFormatterModel(value,row){
    let returnVal;
    returnVal = '<button type="button" class="btn btn-primary" onclick="editDataModel(\''+row.id+'\')">編輯</button>';
    return returnVal;
}

/**
 * 日期顯示
 * @param value
 * @param row
 * @returns {string}
 */
function dateFormatter(value,row) {
    let returnVal;
    let dateValue = new Date(value);
    returnVal = dateValue.getFullYear()+"-"+(dateValue.getMonth()+1)+"-"+dateValue.getDate();
    return returnVal;

}


function textFormatter(value,row) {
    let returnVal;

    if(value){
        if(value.length >= 10){
            returnVal = value.substr(1,10)+'...';
        }
        else{
            returnVal = value;
        }
    }

    return returnVal;
}


