package com.ssm.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;

public class RedisUtils{
	
    private RedisTemplate<String, String> commonRedisTemplate;
 
	public Boolean set(String key,String value) {
		if (commonRedisTemplate != null) {
			commonRedisTemplate.execute(new RedisCallback<Boolean>() {
				public Boolean doInRedis(RedisConnection connection)
						throws DataAccessException {
					RedisSerializer<String> serializer = (RedisSerializer<String>) commonRedisTemplate.getHashKeySerializer();
					byte[] keys = serializer.serialize(key);
					byte[] values = serializer.serialize((String)value);
					connection.set(keys, values);
					return true;
				}
			});
		}
		return false;
	}
	
	public String get(String key) {
		if (commonRedisTemplate != null) {
			return commonRedisTemplate.execute(new RedisCallback<String>() {
				public String doInRedis(RedisConnection connection)
						throws DataAccessException {
					RedisSerializer<String> serializer = (RedisSerializer<String>) commonRedisTemplate.getHashKeySerializer();
					byte[] keys = serializer.serialize(key);
					byte[] values = connection.get(keys);
					if(values == null || values.length ==0) {
						return null;
					}
					return new String(values);
				}
			});
		}
		return null;
	}
	// <T> ValueOperations<String,T>
	public <T> Boolean setObject(String key, T value) {
		if (commonRedisTemplate != null) {
			commonRedisTemplate.execute(new RedisCallback<Boolean>() {
				public Boolean doInRedis(RedisConnection connection)
						throws DataAccessException {
					RedisSerializer<String> serializer = (RedisSerializer<String>) commonRedisTemplate.getHashKeySerializer();
					byte[] keys = serializer.serialize(key);
					byte[] values = serializer.serialize((String)value);
					connection.set(keys, values);
					return true;
				}
			});
		}
		return false;
	}
	
	private byte[] toByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }
	
    /**
     * 缓存基本的对象，Integer、String、实体类等
     * @param key 缓存的键值
     * @param value 缓存的值
     * @return  缓存的对象
     */
    public <T> ValueOperations<String,T> setCacheObject(String key,T value){
	    ValueOperations<String,T> operation = (ValueOperations<String, T>) commonRedisTemplate.opsForValue();
	    operation.set(key,value);
	    return operation;
    }
    
     
    /**
     * 获得缓存的基本对象。
     * @param key  缓存键值
     * @param operation
     * @return   缓存键值对应的数据
     */
    public <T> T getCacheObject(String key){
	    ValueOperations<String,T> operation = (ValueOperations<String, T>) commonRedisTemplate.opsForValue(); 
	    return operation.get(key);
    }
    
    
    
    /**
     * 实体hash存储
     * @param key
     * @param hashKey
     * @param tvalue
     * @return
     */
    public <T> HashOperations<String, Object, Object> saveHash(String key,Object hashKey,T tvalue){
	    HashOperations<String, Object, Object> operation = (HashOperations<String, Object, Object>) commonRedisTemplate.opsForHash(); 
	    operation.put(key, hashKey, tvalue);
	    return operation;
    }
    
    
    /**
     * 获取hash缓存
     * @param key
     * @param hashKey
     * @return
     */
    public <T> Object getHash(String key,Object hashKey){
    	HashOperations<String, Object, Object> operation = (HashOperations<String, Object, Object>) commonRedisTemplate.opsForHash(); 
	    return operation.get(key, hashKey);
    }
    
    
    /**
     * 缓存List数据
     * @param key  缓存的键值
     * @param dataList 待缓存的List数据
     * @return   缓存的对象
     */
    public <T> ListOperations<String, T> setCacheList(String key,List<T> dataList){
    	ListOperations listOperation = commonRedisTemplate.opsForList();
    	if(null != dataList){
    		int size = dataList.size();
    		for(int i = 0; i < size ; i++){
    				listOperation.rightPush(key,dataList.get(i));
    		}
    	}
     return listOperation;
    }
    
    /**
     * 获得缓存的list对象
     * @param key 缓存的键值
     * @return  缓存键值对应的数据
     */
    public <T> List<T> getCacheList(String key){
    	List<T> dataList = new ArrayList<T>();
    	ListOperations<String,T> listOperation = (ListOperations<String, T>) commonRedisTemplate.opsForList();
    	Long size = listOperation.size(key); 
    	for(int i = 0 ; i < size ; i++){
    		dataList.add((T) listOperation.leftPop(key));
    	}
    	return dataList;
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public Boolean exists(String key) {
		if (commonRedisTemplate != null) {
			commonRedisTemplate.execute(new RedisCallback<Boolean>() {
				public Boolean doInRedis(RedisConnection connection)
						throws DataAccessException {
					RedisSerializer<String> serializer = (RedisSerializer<String>) commonRedisTemplate.getHashKeySerializer();
					byte[] keys = serializer.serialize(key);
					return connection.exists(keys);
				}
			});
		}
		return false;
	}
    
    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public Boolean del(String key) {
		if (commonRedisTemplate != null) {
			commonRedisTemplate.delete(key);
			return true;
		}
		return false;
	}
    
    
    /**
     * 设置过期时间
     * @param key
     * @param seconds
     * @return
     */
    public Boolean expire(String key, int seconds) {
		if (commonRedisTemplate != null) {
			return commonRedisTemplate.execute(new RedisCallback<Boolean>() {
				public Boolean doInRedis(RedisConnection connection)
						throws DataAccessException {
					RedisSerializer<String> serializer = (RedisSerializer<String>) commonRedisTemplate.getHashKeySerializer();
					byte[] keys = serializer.serialize(key);
					return connection.expire(keys, seconds);
				}
			});
		}
		return false;
	}
    
    /**
     * 自增
     * @param key
     * @return
     */
    public Long incr(String key) {
		if (commonRedisTemplate != null) {
			return commonRedisTemplate.execute(new RedisCallback<Long>() {
				public Long doInRedis(RedisConnection connection)
						throws DataAccessException {
					RedisSerializer<String> serializer = (RedisSerializer<String>) commonRedisTemplate.getHashKeySerializer();
					byte[] keys = serializer.serialize(key);
					return connection.incr(keys);
				}
			});
		}
		return 0L;
	}
    
    /**
     * 自减
     * @param key
     * @return
     */
    public Long decr(String key) {
		if (commonRedisTemplate != null) {
			return commonRedisTemplate.execute(new RedisCallback<Long>() {
				public Long doInRedis(RedisConnection connection)
						throws DataAccessException {
					RedisSerializer<String> serializer = (RedisSerializer<String>) commonRedisTemplate.getHashKeySerializer();
					byte[] keys = serializer.serialize(key);
					return connection.decr(keys);
				}
			});
		}
		return 0L;
	}
    
    /**
     * 获取int值
     * @param <T>
     * @param key
     * @return
     */
    public <T> Long getNum(String key) {
    	if (commonRedisTemplate != null) {
			return commonRedisTemplate.execute(new RedisCallback<Long>() {
				public Long doInRedis(RedisConnection connection)
						throws DataAccessException {
					RedisSerializer<String> serializer = (RedisSerializer<String>) commonRedisTemplate.getHashKeySerializer();
					byte[] keys = serializer.serialize(key);
					byte[] value = connection.get(keys);
					if(value == null) {
						return 0L;
					}
					return new Long(new String(value));
				}
			});
		}
		return 0L;
	}
    
    
	public RedisTemplate<String, String> getCommonRedisTemplate() {
		return commonRedisTemplate;
	}

	public void setCommonRedisTemplate(RedisTemplate<String, String> commonRedisTemplate) {
		this.commonRedisTemplate = commonRedisTemplate;
	}
    
}
