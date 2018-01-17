package mx.infotec.dads.kukulkan.generator.angularjs.domain;

/**
 * 
 * @author Daniel Cortes Pichardo
 *
 */
public class Template {

    private String name;

    private TemplateType type;


    public Template(TemplateType type, String name) {
        this.type = type;
        this.name = name;
    }

    public TemplateType getType() {
        return type;
    }

    public void setType(TemplateType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}