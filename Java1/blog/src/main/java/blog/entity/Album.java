package blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZGB
 * @since 2022-11-18
 */
@ApiModel(value = "Album对象", description = "")
public class Album implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer authorId;

    private String albumName;

    private String simplifyImg;

    private String originalImg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
    public String getSimplifyImg() {
        return simplifyImg;
    }

    public void setSimplifyImg(String simplifyImg) {
        this.simplifyImg = simplifyImg;
    }
    public String getOriginalImg() {
        return originalImg;
    }

    public void setOriginalImg(String originnalImg) {
        this.originalImg = originnalImg;
    }

    @Override
    public String toString() {
        return "Album{" +
            "id=" + id +
            ", authorId=" + authorId +
            ", albumName=" + albumName +
            ", simplifyImg=" + simplifyImg +
            ", originalImg=" + originalImg +
        "}";
    }
}
