package org.gsm.software.highthon.model.schoolinfo

data class Row(
    var ATPT_OFCDC_SC_CODE: String,//시도교육청 코드
    var SD_SCHUL_CODE: String,//표준 학교 코드
    var ORG_RDNMA : String, //도로명 주소
    var SCHUL_NM : String // 학교명
)