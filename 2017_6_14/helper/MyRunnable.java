package com.example.lalalas.hci_ispit_2017_6_14.helper;

import java.io.Serializable;

/**
 * Created by Student on 09.12.2016..
 */
public interface MyRunnable<T> extends Serializable
{
    void  run(T t);
}

