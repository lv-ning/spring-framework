package com.spring.automodel.lockup;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-07
 */
@Component(value = "la")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)// prototype
public class LA {
}
