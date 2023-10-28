package RestAPINew.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonFilter("SomeBeanFilter")
//@JsonIgnoreProperties({"filed1","field2"})
public class SomeBean {
    private String filed1;
    @JsonIgnore
    private String field2;
    private String field3;

    public SomeBean(String filed1, String field2, String field3) {
        this.filed1 = filed1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getFiled1() {
        return filed1;
    }

    public void setFiled1(String filed1) {
        this.filed1 = filed1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "filed1='" + filed1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                '}';
    }
}
