package blog.entity;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZGB
 * @since 2022-11-06
 */
@ApiModel(value = "Category对象", description = "")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
            "id=" + id +
            ", name=" + name +
        "}";
    }
}
