package com.codetest;

import java.util.Arrays;

import com.codetest.client.Client;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new Client(Arrays.asList(args)).run();
    }
}
