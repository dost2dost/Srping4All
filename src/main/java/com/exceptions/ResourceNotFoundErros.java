package com.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by DostM on 6/16/2020.
 */
public class ResourceNotFoundErros extends RuntimeException {

    public static Logger logger= LoggerFactory.getLogger(ResourceNotFoundErros.class);


    public ResourceNotFoundErros(String msg) {

        super(msg);
        logger.info("Custom Exception is clalled! ");
    }
}
