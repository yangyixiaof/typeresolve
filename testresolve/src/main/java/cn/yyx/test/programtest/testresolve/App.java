package cn.yyx.test.programtest.testresolve;

import java.io.File;

import cn.yyx.test.JDTAST.ASTMain;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        new ASTMain().ParseOneFileAndVisit(new File("D:/Java_RCP_Workspace2/testresolve/src/main/java/cn/yyx/test/files/test.java"));
    }
}
