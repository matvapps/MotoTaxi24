package agency.yad.mototaxi24.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alexandr.
 */
public class PhotoResponse  {

    @SerializedName("photo")
    @Expose
    protected String photo;

    @SerializedName("code")
    @Expose
    protected Integer code;


    public PhotoResponse() {
    }


    public PhotoResponse(String photo, Integer code) {
        this.photo = photo;
        this.code = code;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    @Override
    public String toString() {
        return "photo = " + photo + ", code = " + code;
    }
}
