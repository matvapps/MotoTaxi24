package agency.yad.mototaxi24.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alexandr.
 */
public class BaseResponse {

    public static final int CODE_ERROR = 1;
    public static final int CODE_SUCCESS = 0;

    @SerializedName("code")
    @Expose
    protected Integer code;

    @SerializedName("message")
    @Expose
    protected String message;


    public BaseResponse() {
    }

    public BaseResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "code = " + code + ", message = " + message;
    }
}
