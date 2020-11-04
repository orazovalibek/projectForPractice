package com.library.utilities;

import java.io.IOException;

public class Thread {

    public static void wait(int sec) {

        try {
            java.lang.Thread.sleep(sec*1000);
        }catch (InterruptedException e){

        }

    }

}