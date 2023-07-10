package com.spring.aop.aspect;

import com.spring.aop.service.DeleteService;
import com.spring.aop.service.impl.DeleteAServiceImpl;
import com.spring.aop.service.impl.DeleteBServiceImpl;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * aop
 *
 * @author nning_l@163.com
 * @since 2023-07-10
 */
@Aspect
@Component
public class UsageTracking {

	/**
	 * value 目标 service 可以时具体的某个类，也可以是接口，接口后面需要 +
	 * defaultImpl 具体的 service 接口
	 */
	@DeclareParents(value = "com.spring.aop.service.UserService+", defaultImpl = DeleteBServiceImpl.class)
	public static DeleteService mixin;

//	@Pointcut("execution(public * com.spring.aop.service.UserService.*(..)) && this(deleteService)")
//	public void pointcut(DeleteService deleteService) {
//		System.out.println("deleteService is null ? " + (deleteService == null));
//	}

//	@Before("pointcut()")
	@After(value = "execution(public * com.spring.aop.service.UserService.*(..)) && this(deleteService)", argNames = "deleteService")
	public void recordUsage(DeleteService deleteService) {
		deleteService.delete();
	}
}
