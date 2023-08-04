package caseStudy.model.product;

import java.io.Serializable;

public class Category implements Serializable {
    private static final long serialVersionUID = 234122996006267687L;
    private String name ;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category() {
    }

    @Override
    public String toString() {
        return name + "" ;

    }
}
