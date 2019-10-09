package com.example.zzmdemo.common;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

/***
 * 分布式ID生成器 参考Twitter的snowflake算法
 * 集群环境需要配置 workerId datacenterId属性，否则会导致集群环境ID冲突
 * @author pzy
 *
 */
@Component
@NoArgsConstructor
public class IdGenerator {

	private long workerId = 0;

	private long datacenterId = 0;

	private long sequence = 0L;
	
	private long twepoch = 1288834974657L;
	
	private long workerIdBits = 5L;
	/**
	 *节点ID长度
	 */
	private long datacenterIdBits = 5L;
	/**
	 * 数据中心ID长度
	 */
	private long maxWorkerId = -1L ^ (-1L << workerIdBits);
	/**
	 *最大支持机器节点数0~31，一共32个
	 */
	private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
	/**
	 *最大支持数据中心节点数0~31，一共32个
	 */
	private long sequenceBits = 9L;
	/**
	 *序列号12位
	 */
	private long workerIdShift = sequenceBits;
	/**
	 *机器节点左移12位
	 */
	private long datacenterIdShift = sequenceBits + workerIdBits;
	/**
	 *数据中心节点左移17位
	 */
	private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
	/**
	 *时间毫秒数左移22位
	 */
	private long sequenceMask = -1L ^ (-1L << sequenceBits);
	/**
	 *最大为4095
	 */
	private long lastTimestamp = -1L;


	public IdGenerator(long workerId, long datacenterId) {
		if (workerId > maxWorkerId || workerId < 0) {
			throw new IllegalArgumentException(
					String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
		}
		if (datacenterId > maxDatacenterId || datacenterId < 0) {
			throw new IllegalArgumentException(
					String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
		}
		this.workerId = workerId;
		this.datacenterId = datacenterId;
	}

	public synchronized String nextId() {
		long timestamp = timeGen();
		if (timestamp < lastTimestamp) {
			throw new IllegalArgumentException(String.format(
					"Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
		}
		if (lastTimestamp == timestamp) {
			sequence = (sequence + 1) & sequenceMask;
			if (sequence == 0) {
				timestamp = tilNextMillis(lastTimestamp);
			}
		} else {
			sequence = 0L;
		}
		lastTimestamp = timestamp;
		long longStr = ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift)
				| (workerId << workerIdShift) | sequence;
		return String.valueOf(longStr);
	}

	private long tilNextMillis(long lastTimestamp) {
		long timestamp = timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = timeGen();
		}
		return timestamp;
	}

	private long timeGen() {
		return System.currentTimeMillis();
	}

	public String getUid(){
		String uid = UUID.randomUUID().toString().replace("-", "");
		return uid;
	}

	public static void main (String[] args) {
//		IdGenerator idGenerator = new IdGenerator(0,0);
//		System.out.println(idGenerator.getUid());

		int code = (int)((Math.random()*9+1)*100000);
		System.out.println("验证码："+code);
	}
}
