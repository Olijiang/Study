package blog.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private String username;

    private String password;

    private String blogName;

    private String blogInfo;

    private Integer articleNum;

    private Integer categoryNum;

    private Integer visitNum;

    private String img;

    private String coverImg;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }
    public String getBlogInfo() {
        return blogInfo;
    }

    public void setBlogInfo(String blogInfo) {
        this.blogInfo = blogInfo;
    }
    public Integer getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Integer articleNum) {
        this.articleNum = articleNum;
    }
    public Integer getCategoryNum() {
        return categoryNum;
    }

    public void setCategoryNum(Integer categoryNum) {
        this.categoryNum = categoryNum;
    }
    public Integer getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(Integer visitNum) {
        this.visitNum = visitNum;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    @Override
    public String toString() {
        return "User{" +
            "username=" + username +
            ", password=" + password +
            ", blogName=" + blogName +
            ", blogInfo=" + blogInfo +
            ", articleNum=" + articleNum +
            ", categoryNum=" + categoryNum +
            ", visitNum=" + visitNum +
            ", img=" + img +
                ", coverImg=" + coverImg +
        "}";
    }
}
