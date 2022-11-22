package blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/11/19 19:27
 */
@Data
public class Album {

	@TableId(type = IdType.AUTO)
	private Integer id;

	private String authorId;

	private String albumName;

	private String coverImg;
}
