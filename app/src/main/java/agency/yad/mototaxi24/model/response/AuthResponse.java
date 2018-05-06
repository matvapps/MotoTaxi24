package agency.yad.mototaxi24.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alexandr
 */

public class AuthResponse extends BaseResponse {

    @SerializedName("token")
    @Expose
    private String token;


    public AuthResponse() {
    }

    public AuthResponse(Integer code, String message, String token) {
        this.code = code;
        this.message = message;
        this.token = token;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @Override
    public String toString() {
        return "code = " + code + ", token = " + token;
    }
}
