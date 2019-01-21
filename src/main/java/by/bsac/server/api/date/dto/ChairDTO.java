package by.bsac.server.api.date.dto;



import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChairDTO {

    private Byte idChair;
    private String nameChair;


    public ChairDTO(Byte idChair, String nameChair) {
        this.idChair = idChair;
        this.nameChair = nameChair;
    }


    public ChairDTO() {
    }

    public Byte getIdChair() {
        return idChair;
    }

    public void setIdChair(Byte idChair) {
        this.idChair = idChair;
    }

    public String getNameChair() {
        return nameChair;
    }

    public void setNameChair(String nameChair) {
        this.nameChair = nameChair;
    }

}
