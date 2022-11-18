package blog.utils;


import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ZGB
 * @version 1.0
 * @description: 图片操作工具类
 * @date 2022/11/9 22:21
 */
@Slf4j
@Component
public class myUtil {

	public static boolean writeBase64Img(String base64ImgData, String storagePath) {
		byte[] bs = Base64.decodeBase64(base64ImgData);
		try (FileOutputStream fos = new FileOutputStream(storagePath)){
			fos.write(bs);
			fos.flush();
			log.info("base64文件保存成功"+storagePath);
			return true;
		} catch (Exception e) {
			log.warn("base64文件保存异常"+e);
			return false;
		}
	}

	public static boolean writeTxt(String content,String storagePath) {
		File file=new File(storagePath);//定义操作文件
		try (PrintWriter pw=new PrintWriter(new FileOutputStream(file))){
			pw.write(content);
			log.info("TXT文件保存成功"+storagePath);
			return true;
		}catch (Exception e){
			log.warn("TXT文件保存失败"+e);
			return false;
		}
	}
	public static String readTxt(String path){
		/*
		* 读取 resources 下面的文件, path 为相对于 resources 目前的地址
		* */
//		String projectParentPath = getProjectParentPath();
//		String filePath = projectParentPath + dataPath +"articles" +File.separator + path;
		File file=new File(path);
		if(!file.exists()) {
			log.warn("文件不存在："+path);
			return "";
		}
		try(FileReader fileReader = new FileReader(ResourceUtils.getFile(path))) {
			int ch = 0;
			StringBuilder sb = new StringBuilder();
			while ((ch = fileReader.read()) != -1) {
				sb.append((char) ch);
			}
			return sb.toString();
		}catch (Exception e){
			log.warn("读取文件失败"+path);
			log.warn(""+e);
			return "";
		}
	}
	/**
	 * @return: 返回两个数组的并集
	 * @date: 2022/11/11 10:26
	 */
	public static String[] union(String[] arr1, String[] arr2) {
		Set<String> set = new HashSet<String>();
		if (arr1!=null) set.addAll(Arrays.asList(arr1));
		if (arr2!=null) set.addAll(Arrays.asList(arr2));
		return set.toArray(new String[0]);
	}


	public static void tmain(String[] args) {
		String projectPath = System.getProperty("user.dir");
		String[] temp = projectPath.split("\\"+File.separator);
		String projectName = temp[temp.length-1];
		projectPath = projectPath.substring(0,projectPath.length()-projectName.length());
		System.out.println(projectPath);
	}

}
