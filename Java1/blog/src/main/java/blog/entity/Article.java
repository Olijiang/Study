package blog.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZGB
 * @since 2022-11-06
 */
@ApiModel(value = "Article对象", description = "")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id;

    private String title;

    private Integer authorId;

    private Integer categoryId;

    private String tag;

    private String content;

    private String digest;

    private String img;

    private LocalDateTime creatTime;

    private LocalDateTime updataTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public LocalDateTime getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(LocalDateTime creatTime) {
        this.creatTime = creatTime;
    }
    public LocalDateTime getUpdataTime() {
        return updataTime;
    }

    public void setUpdataTime(LocalDateTime updataTime) {
        this.updataTime = updataTime;
    }

    @Override
    public String toString() {
        return "Article{" +
            "id=" + id +
            ", title=" + title +
            ", authorId=" + authorId +
            ", categoryId=" + categoryId +
            ", tag=" + tag +
            ", content=" + content +
            ", digest=" + digest +
            ", img=" + img +
            ", creatTime=" + creatTime +
            ", updataTime=" + updataTime +
        "}";
    }
}
