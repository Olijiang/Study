import org.junit.jupiter.api.Test;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/10/28 13:58
 */
public class demo {

	@Test
	public void demo1(){
		float y = 1000;
		int n = 100;
		float step = y/(n/2);
		float a = step/n;
		int t = 0;
		step = step - a/2;
		while (y>0 && step>0){
			System.out.println(t++ +";步长："+step+"  y:"+y);
			y = y-step;
			step = step - a;

		}
	}
}
