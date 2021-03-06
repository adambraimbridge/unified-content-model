package com.ft.api.ucm.model.v1;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"headline", "intro"})
public class NumbersComponentFields {

    private String headline;
    private String intro;
    
    public NumbersComponentFields() {}
    
    public NumbersComponentFields(String headline, String intro) {
        this.headline = headline;
        this.intro = intro;
    }
    
    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
