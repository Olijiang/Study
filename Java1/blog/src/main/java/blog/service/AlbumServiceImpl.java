package blog.service;

import blog.config.ComResult;
import blog.config.LocalCatch;
import blog.entity.Album;
import blog.mapper.AlbumMapper;
import blog.utils.myUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/11/21 14:14
 */
@Service
@Slf4j
public class AlbumServiceImpl {

	@Resource
	private AlbumMapper albumMapper;

	public ComResult update(String authorId, Album[] albums) {
		// 获取 全部 的 id
		Integer theId = albumMapper.getIdByName(authorId, "全部");
		// 获取当前作者的全部相册
		List<Album> rawAlbums = getAlbums(authorId);

		Album album1;
		for (Album album : albums) {
			if (album.getId()<0){
				// 负id表示新加标签
				album.setId(null);
				album.setAuthorId(authorId);
				String path = myUtil.saveImg(album.getCoverImg(),authorId);
				album.setCoverImg(path);
				albumMapper.insert(album);
				log.info("新增相册："+album.getAlbumName());
			}else{
				// 修改和删除都需要验证身份， 确保当前登录用户只能操作自己的内容
				album1 = getAlbum(album.getId());
				if (album1==null) return ComResult.error("相册不存在");
				if (!album1.getAuthorId().equals(authorId)) return ComResult.error("非法操作");
				// 重设 authorId
				album.setAuthorId(authorId);
				if (album.getId().equals(theId)){
					album.setAlbumName("全部");
				}
				if (!album.getCoverImg().equals("")){
					// 图片修改过, 删除原图片, 写入新图片
					myUtil.deleteFile(album1.getCoverImg());
					String path = myUtil.saveImg(album.getCoverImg(),authorId);
					album.setCoverImg(path);
				}else{
					album.setCoverImg(album1.getCoverImg());
				}
				albumMapper.updateById(album);
				// 移除 rawAlbums 的原本相册信息
				for (int i = 0; i < rawAlbums.size(); i++) {
					if (rawAlbums.get(i).getId().equals(album.getId())){
						rawAlbums.remove(i);
						break;
					}
				}
			}
		}
		// 删除 rawAlbums 剩余的相册
		for (Album album : rawAlbums) {
			albumMapper.deleteById(album);
			log.info("删除相册："+album.getAlbumName());
		}
		LocalCatch.remove("albums" + authorId);
		return ComResult.success("相册编辑成功");
	}

	// 根据 authorId 获取相册分类信息
	public List<Album> getAlbums(String authorId) {
		List<Album> albums;
		String key = "albums" + authorId;
		if ((albums = (List<Album>) LocalCatch.get(key)) == null) {
			log.info("缓存未命中：" + key);
			albums = albumMapper.getAlbums(authorId);
			LocalCatch.put(key, albums);
			return albums;
		}
		//  缓存命中
		log.info("缓存命中：" + key);
		return albums;
	}

	private Album getAlbum(Integer albumId) {
		Album album;
		String key = "album" + albumId;
		if ((album = (Album) LocalCatch.get(key)) == null) {
			log.info("缓存未命中：" + key);
			album = albumMapper.selectById(albumId);
			if (album==null) return null;
			LocalCatch.put(key, album);
			return album;
		}
		//  缓存命中
		log.info("缓存命中：" + key);
		return album;
	}











}
