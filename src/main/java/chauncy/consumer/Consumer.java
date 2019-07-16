package chauncy.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import chauncy.entity.UserEntity;

/**   
 * @classDesc: 功能描述(点对点通信模式消费者代码)  
 * @author: ChauncyWang
 * @createTime: 2019年7月16日 下午7:46:25   
 * @version: 1.0  
 */  
@Component
public class Consumer {
	
	@JmsListener(destination="${queue}")
	public void receive(String msg){
		System.out.println(msg);
		UserEntity userEntity = new JSONObject().parseObject(msg,UserEntity.class);
		System.out.println(userEntity.toString());
	}
}
