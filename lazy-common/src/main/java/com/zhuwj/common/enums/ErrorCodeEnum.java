package com.zhuwj.common.enums;

/**
 * @desc：错误码，参考《Java开发手册》泰山版
 * @author：zhuwj
 * @date：2020.05.10
 * @version：1.0.0
 */
public enum ErrorCodeEnum {
    OK("00000", "OK"),
    ERROR("11111", "ERROR"),
    DELETED("A0001", "已删除"),
    DATA_NOT_EXIST("A0002", "数据不存在"),
    USER_REGISTRATION_ERROR("A0100", "用户注册错误"),
    USER_NOT_AGREE_AGREEMENT("A0101", "用户未同意隐私协议"),
    REGISTRATION_IS_LIMITED_BY_COUNTRY_OR_REGION("A0102", "注册国家或地区受限"),
    USERNAME_VALIDATION_FAILED("A0110", "用户名校验失败"),
    USERNAME_ALREADY_EXISTS("A0111", "用户名已存在"),
    USERNAME_CONTAINS_SENSITIVE_WORDS("A0112", "用户名包含敏感词"),
    USERNAME_CONTAINS_SPECIAL_CHARACTERS("A0113", "用户名包含特殊字符"),
    TOKEN_VALIDATE_FAIL("A0114", "token校验失败"),
    TOKEN_OVERDUE("A0115", "token已过期"),
    PASSWORD_CHECK_FAILED("A0120", "密码校验失败"),
    INSUFFICIENT_PASSWORD_LENGTH("A0121", "密码长度不够"),
    INSUFFICIENT_PASSWORD_STRENGTH("A0122", "密码强度不够"),
    INCORRECT_CHECK_CODE_INPUT("A0130", "校验码输入错误"),
    INCORRECT_INPUT_OF_SMS_CHECK_CODE("A0131", "短信校验码输入错误"),
    INCORRECT_MESSAGE_CHECK_CODE_INPUT("A0132", "邮件校验码输入错误"),
    INCORRECT_SPEECH_CHECK_CODE_INPUT("A0133", "语音校验码输入错误"),
    ABNORMAL_USER_ID("A0140", "用户证件异常"),
    USER_ID_TYPE_NOT_SELECTED("A0141", "用户证件类型未选择"),
    MAINLAND_ID_NUMBER_VERIFICATION_IS_ILLEGAL("A0142", "大陆身份证编号校验非法"),
    PASSPORT_NUMBER_CHECK_IS_ILLEGAL("A0143", "护照编号校验非法"),
    MILITARY_ID_NUMBER_CHECK_IS_ILLEGAL("A0144", "军官证编号校验非法"),
    USER_BASIC_INFORMATION_VALIDATION_FAILED("A0150", "用户基本信息校验失败"),
    MOBILE_FORMAT_VALIDATION_FAILED("A0151", "手机格式校验失败"),
    ADDRESS_FORMAT_VALIDATION_FAILED("A0152", "地址格式校验失败"),
    MAILBOX_FORMAT_VALIDATION_FAILED("A0153", "邮箱格式校验失败"),
    USER_LOGIN_EXCEPTION("A0200", "用户登陆异常"),
    USER_ACCOUNT_DOES_NOT_EXIST("A0201", "用户账户不存在"),
    USER_ACCOUNTS_HAVE_BEEN_FROZEN("A0202", "用户账户被冻结"),
    USER_ACCOUNT_HAS_BEEN_INVALIDATED("A0203", "用户账户已作废"),
    USER_PASSWORD_ERROR("A0210", "用户密码错误"),
    USER_ENTERS_TIMES_EXCEEDS_LIMIT("A0211", "用户输入密码次数超限"),
    USER_IDENTITY_VERIFICATION_FAILED("A0220", "用户身份校验失败"),
    USER_FINGERPRINT_RECOGNITION_FAILED("A0221", "用户指纹识别失败"),
    USER_FACE_RECOGNITION_FAILED("A0222", "用户面容识别失败"),
    USER_NOT_AUTHORIZED_THIRTY_PART("A0223", "用户未获得第三方登陆授权"),
    USER_LOGIN_HAS_EXPIRED("A0230", "用户登陆已过期"),
    USER_VERIFICATION_CODE_ERROR("A0240", "用户验证码错误"),
    USER_VERIFICATION_CODE_EXPECT_TIMES("A0241", "用户验证码尝试次数超限"),
    ACCESS_EXCEPTION("A0300", "访问权限异常二级宏观错误码"),
    UNAUTHORIZED_ACCESS("A0301", "访问未授权"),
    UNDER_AUTHORIZATION("A0302", "正在授权中"),
    USER_AUTHORIZATION_APPLICATION_WAS_REJECTED("A0303", "用户授权申请被拒绝"),
    ACCESSED_OBJECT_PRIVACY_SETTINGS_BLOCKED("A0310", "因访问对象隐私设置被拦截"),
    AUTHORIZATION_EXPIRED("A0311", "授权已过期"),
    NO_PERMISSION_TO_USE_API("A0312", "无权限使用 API"),
    USER_ACCESS_BLOCKED("A0320", "用户访问被拦截"),
    BLACKLIST_USER("A0321", "黑名单用户"),
    ACCOUNT_HAS_BEEN_FROZEN("A0322", "账号被冻结"),
    ILLEGAL_IP_ADDRESS("A0323", "非法 IP 地址"),
    GATEWAY_ACCESS_RESTRICTED("A0324", "网关访问受限"),
    REGIONAL_BLACKLIST("A0325", "地域黑名单"),
    SERVICE_IS_OVERDUE("A0330", "服务已欠费"),
    USER_SIGNATURE_EXCEPTION("A0340", "用户签名异常"),
    RSA_SIGN_ERROR("A0341", "RSA 签名错误"),
    USER_REQUEST_PARAMETER_ERROR("A0400", "用户请求参数错误"),
    CONTAINS_ILLEGAL_AND_MALICIOUS_JUMP_LINKS("A0401", "包含非法恶意跳转链接"),
    INVALID_USER_INPUT("A0402", "无效的用户输入"),
    REQUIRED_PARAMETER_FOR_THE_REQUEST_IS_EMPTY("A0410", "请求必填参数为空"),
    USER_ORDER_NUMBER_IS_EMPTY("A0411", "用户订单号为空"),
    ORDER_QUANTITY_IS_EMPTY("A0412", "订购数量为空"),
    MISSING_TIMESTAMP("A0413", "缺少时间戳参数"),
    INVALID_TIMESTAMP("A0414", "非法的时间戳参数"),
    REQUEST_PARAMETER_VALUE_IS_OUT_OF_THE_ALLOWED_RANGE("A0420", "请求参数值超出允许的范围"),
    PARAMETER_FORMAT_DOES_NOT_MATCH("A0421", "参数格式不匹配"),
    ADDRESS_IS_NOT_IN_SERVICE("A0422", "地址不在服务范围"),
    TIME_OUT_OF_SERVICE("A0423", "时间不在服务范围"),
    AMOUNT_EXCEEDING_LIMIT("A0424", "金额超出限制"),
    EXCEEDING_QUANTITY_LIMIT("A0425", "数量超出限制"),
    TOTAL_NUMBER_OF_REQUESTS_FOR_BATCH_PROCESSING_EXCEEDED_THE_LIMIT("A0426", "请求批量处理总个数超出限制"),
    REQUEST_FOR_JSON_PARSING_FAILED("A0427", "请求 JSON 解析失败"),
    ILLEGAL_USER_INPUT("A0430", "用户输入内容非法"),
    CONTAINS_CONTRABAND_SENSITIVE_WORDS("A0431", "包含违禁敏感词"),
    PICTURES_CONTAIN_PROHIBITED_INFORMATION("A0432", "图片包含违禁信息"),
    FILE_INFRINGEMENT("A0433", "文件侵犯版权"),
    USER_OPERATION_EXCEPTION("A0440", "用户操作异常"),
    USER_PAYMENT_TIMEOUT("A0441", "用户支付超时"),
    CONFIRM_ORDER_TIMEOUT("A0442", "确认订单超时"),
    ORDER_CLOSED("A0443", "订单已关闭"),
    USER_REQUESTED_A_SERVICE_EXCEPTION("A0500", "用户请求服务异常"),
    NUMBER_OF_REQUESTS_EXCEEDED_THE_LIMIT("A0501", "请求次数超出限制"),
    NUMBER_OF_CONCURRENT_REQUESTS_EXCEEDED_THE_LIMIT("A0502", "请求并发数超出限制"),
    PLEASE_WAIT_FOR_USER_ACTION("A0503", "用户操作请等待"),
    WEBSOCKET_LINK_EXCEPTION("A0504", "WebSocket 连接异常"),
    WEBSOCKET_LINK_BREAK("A0505", "WebSocket 连接断开"),
    USER_REPEAT_REQUEST("A0506", "用户重复请求"),
    USER_RESOURCE_EXCEPTION("A0600", "用户资源异常"),
    INSUFFICIENT_ACCOUNT_BALANCE("A0601", "账户余额不足"),
    INSUFFICIENT_USER_DISK_SPACE("A0602", "用户磁盘空间不足"),
    NOT_ENOUGH_USER_MEMORY("A0603", "用户内存空间不足"),
    INSUFFICIENT_USER_OSS_CAPACITY("A0604", "用户 OSS 容量不足"),
    USER_QUOTA_HAS_BEEN_USED_UP("A0605", "用户配额已用光 蚂蚁森林浇水数或每天抽奖数"),
    USER_UPLOAD_FILE_IS_ABNORMAL("A0700", "用户上传文件异常"),
    USER_UPLOAD_FILE_TYPE_DOES_NOT_MATCH("A0701", "用户上传文件类型不匹配"),
    USER_UPLOADS_FILE_TOO_LARGE("A0702", "用户上传文件太大"),
    USERS_UPLOAD_PICTURES_THAT_ARE_TOO_BIG("A0703", "用户上传图片太大"),
    USER_UPLOADS_THE_VIDEO_TOO_BIG("A0704", "用户上传视频太大"),
    USER_UPLOADED_THE_COMPRESSED_FILE_IS_TOO_LARGE("A0705", "用户上传压缩文件太大"),
    USER_CURRENT_VERSION_EXCEPTION("A0800", "用户当前版本异常"),
    USER_INSTALLED_VERSION_DOES_NOT_MATCH_THE_SYSTEM("A0801", "用户安装版本与系统不匹配"),
    USER_INSTALLED_VERSION_TOO_LOW("A0802", "用户安装版本过低"),
    USER_INSTALLED_VERSION_TOO_HIGH("A0803", "用户安装版本过高"),
    USER_INSTALLED_VERSION_HAS_EXPIRED("A0804", "用户安装版本已过期"),
    USER_API_REQUEST_VERSION_DOES_NOT_MATCH("A0805", "用户 API 请求版本不匹配"),
    USER_API_REQUEST_VERSION_TOO_HIGH("A0806", "用户 API 请求版本过高"),
    USER_API_REQUEST_VERSION_IS_TOO_LOW("A0807", "用户 API 请求版本过低"),
    USER_PRIVACY_IS_NOT_AUTHORIZED("A0900", "用户隐私未授权"),
    USER_PRIVACY_NOT_SIGNED("A0901", "用户隐私未签署"),
    USER_WEBCAM_IS_NOT_AUTHORIZED("A0902", "用户摄像头未授权"),
    USER_CAMERA_IS_NOT_AUTHORIZED("A0903", "用户相机未授权"),
    USER_IMAGE_LIBRARY_IS_NOT_AUTHORIZED("A0904", "用户图片库未授权"),
    USER_FILE_IS_NOT_AUTHORIZED("A0905", "用户文件未授权"),
    USER_LOCATION_INFORMATION_IS_NOT_AUTHORIZED("A0906", "用户位置信息未授权"),
    USER_ADDRESS_BOOK_NOT_AUTHORIZED("A0907", "用户通讯录未授权"),
    ABNORMAL_USER_EQUIPMENT("A1000", "用户设备异常"),
    USER_CAMERA_ANOMALY("A1001", "用户相机异常"),
    USER_MICROPHONE_ABNORMAL("A1002", "用户麦克风异常"),
    USER_RECEIVER_IS_ABNORMAL("A1003", "用户听筒异常"),
    SUBSCRIBER_SPEAKER_ANOMALY("A1004", "用户扬声器异常"),
    USER_GPS_POSITION_IS_ABNORMAL("A1005", "用户 GPS 定位异常"),
    SYSTEM_EXECUTION_ERROR("B0001", "系统执行出错 一级宏观错误码"),
    SYSTEM_EXECUTION_TIMEOUT("B0100", "系统执行超时"),
    SYSTEM_ORDER_PROCESSING_TIMEOUT("B0101", "系统订单处理超时"),
    SYSTEM_DISASTER_RECOVERY_FUNCTION_IS_TRIGGERED("B0200", "系统容灾功能被触发"),
    SYSTEM_CURRENT_LIMITING("B0210", "系统限流"),
    SYSTEM_FUNCTION_DEGRADATION("B0220", "系统功能降级"),
    SYSTEM_RESOURCE_ANOMALY("B0300", "系统资源异常"),
    SYSTEM_RESOURCE_DEPLETION("B0310", "系统资源耗尽"),
    SYSTEM_DISK_SPACE_IS_EXHAUSTED("B0311", "系统磁盘空间耗尽"),
    SYSTEM_MEMORY_DEPLETION("B0312", "系统内存耗尽"),
    FILE_HANDLE_IS_EXHAUSTED("B0313", "文件句柄耗尽"),
    SYSTEM_CONNECTION_POOL_EXHAUSTED("B0314", "系统连接池耗尽"),
    SYSTEM_THREAD_POOL_IS_EXHAUSTED("B0315", "系统线程池耗尽"),
    SYSTEM_RESOURCE_ACCESS_EXCEPTION("B0320", "系统资源访问异常"),
    SYSTEM_FAILED_TO_READ_THE_DISK_FILE("B0321", "系统读取磁盘文件失败"),
    ERROR_INVOKING_THIRD_PARTY_SERVICE("C0001", "调用第三方服务出错 一级宏观错误码"),
    MIDDLEWARE_SERVICE_ERROR("C0100", "中间件服务出错"),
    RPC_SERVICE_ERROR("C0110", "RPC 服务出错"),
    RPC_SERVICE_NOT_FOUND("C0111", "RPC 服务未找到"),
    RPC_SERVICE_NO_REGISTER("C0112", "RPC 服务未注册"),
    REQUEST_API_NOT_FOUND("C0113", "接口不存在"),
    MESSAGE_SERVICE_ERROR("C0120", "消息服务出错"),
    MESSAGE_DELIVERY_ERROR("C0121", "消息投递出错"),
    MESSAGE_CONSUMPTION_ERROR("C0122", "消息消费出错"),
    MESSAGE_SUBSCRIPTION_ERROR("C0123", "消息订阅出错"),
    MESSAGE_GROUPING_NOT_FOUND("C0124", "消息分组未查到"),
    CACHE_SERVICE_ERROR("C0130", "缓存服务出错"),
    KEY_LENGTH_EXCEEDS_THE_LIMIT("C0131", "key 长度超过限制"),
    VALUE_LENGTH_EXCEEDS_THE_LIMIT("C0132", "value 长度超过限制"),
    THE_STORAGE_CAPACITY_IS_FULL("C0133", "存储容量已满"),
    UNSUPPORTED_DATA_FORMATS("C0134", "不支持的数据格式"),
    CONFIGURATION_SERVICE_ERROR("C0140", "配置服务出错"),
    NETWORK_RESOURCE_SERVICE_ERROR_OCCURRED("C0150", "网络资源服务出错"),
    VPN_SERVICE_ERROR("C0151", "VPN 服务出错"),
    CDN_SERVICE_ERROR("C0152", "CDN 服务出错"),
    OMAIN_NAME_RESOLUTION_SERVICE_ERROR("C0153", "域名解析服务出错"),
    GATEWAY_SERVICE_ERROR("C0154", "网关服务出错"),
    THIRD_PARTY_SYSTEM_EXECUTION_TIMEOUT("C0200", "第三方系统执行超时"),
    RPC_EXEC_TIMEOUT("C0210", "RPC 执行超时"),
    MESSAGE_DELIVERY_TIMEOUT("C0220", "消息投递超时"),
    CACHE_SERVICE_TIMEOUT("C0230", "缓存服务超时"),
    CONFIGURE_SERVICE_TIMEOUT("C0240", "配置服务超时"),
    DATABASE_SERVICE_TIMEOUT("C0250", "数据库服务超时"),
    DATABASE_SERVICE_ERROR("C0300", "数据库服务出错"),
    TABLE_DOES_NOT_EXIST("C0311", "表不存在"),
    COLUMN_DOES_NOT_EXIST("C0312", "列不存在"),
    MULTIPLE_COLUMNS_WITH_THE_SAME_NAME_EXIST_IN_MULTITABLE_ASSOCIATION("C0321", "多表关联中存在多个相同名称的列"),
    NUMBER_OF_DEADLOCKS("C0331", "数据库死锁"),
    THE_PRIMARY_KEY_CONFLICT("C0341", "主键冲突"),
    THE_THIRD_PARTY_DISASTER_RECOVERY_SYSTEM_IS_TRIGGERED("C0400", "第三方容灾系统被触发"),
    THIRD_PARTY_SYSTEMS_ARE_CURRENT_LIMITING("C0401", "第三方系统限流"),
    THIRD_PARTY_FUNCTION_DEGRADATION("C0402", "第三方功能降级"),
    NOTIFICATION_SERVICE_ERROR("C0500", "通知服务出错"),
    THE_SMS_ALERT_SERVICE_FAILED("C0501", "短信提醒服务失败"),
    THE_VOICE_REMINDER_SERVICE_FAILED("C0502", "语音提醒服务失败"),
    MAIL_REMINDER_SERVICE_FAILED("C0503", "邮件提醒服务失败");


    private String code;
    private String msg;

    ErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
