package com.example.puissance4tcp;

import com.example.puissance4tcp.IContext;

import java.io.InputStream;
import java.io.OutputStream;

public interface IProtocole {

    public void execute(IContext aContext , InputStream anInputStream , OutputStream anOutputStream );

}
