package com.zxp.task;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  当一个新的任务提交到线程池之后，线程池处理过程如下：
	线程池判断核心线程池里的线程是否已满。未满时，则创建一个新的工作线程来执行任务。如果核心线程池里的线程已满，则执行第二步。
	线程池判断工作队列是否已经满。如果工作队列没有满，则将新提交的任务存储在这个工作队列里等待执行。如果工作队列满了，则执行第三步。
	线程池判断线程池(核心线程池外的线程池部分)的线程是否都处于工作状态。如果没有，则创建一个新的工作线程来执行任务。如果已经满了，则交给饱和策略来处理这个任务。
	线程池饱和策略
	常用的饱和策略如下：
	它们是ThreadPoolExecutor类中的内部类，可以直接调用   也可自己实现自己的饱和策略
	切记ThreadPoolExecutor.execute需要try catch
 **/
public class MyThreadPoolExecutor {

	
	/**
	 * 线程池对象
	 * corePoolSize：4：核心线程数   一直在运行中的
	 * maximumPoolSize：10：阻塞队列的大小 如果运行的线程多于 corePoolSize 而少于 maximumPoolSize，则仅当阻塞队列满时才创建新线程
	 * keepAliveTime：60：除核心线程外其余增加的线程最大空闲时间
	 * unit ：时间单位即  60 为60秒
	 * workQueue：任务队列   
	 * 排队策略：1、SynchronousQueue 直接提交策略 要求maximumPoolSize足够大最好用Integer.Max  例子：Executors的newCacheThreadPool()
	 *       2、 LinkedBlockingQueue 无界队列策略--无界指的是工作队列大小没有上限，可以添加无数个任务进行等待。 maximumPoolSize没啥用一般跟corePoolSize设一样大
	 *       例子 Executors的newFixedThreadPool(int nThreads)
	 * 
	 */
	private ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
	private static MyThreadPoolExecutor instance;
	
	public static MyThreadPoolExecutor getInstance(){
		if(instance == null){
			instance = new MyThreadPoolExecutor();
		}
		return instance;
	}
	
	public void submitTask(Runnable task){
		poolExecutor.submit(task);
		
	}
	
	public Future<Object> submitTask(Callable<Object> task){
		return poolExecutor.submit(task);
	}
	
	
}
