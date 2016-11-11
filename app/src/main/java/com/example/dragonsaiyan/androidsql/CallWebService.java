package com.example.dragonsaiyan.androidsql;

/**
 * Created by DraGoNSaiYaN on 11/10/2016.
 */


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class CallWebService {
    private final String NAMESPACE ="http://tempuri.org/ ";
    private final String URL = "http://10.0.2.2/services1/WebService1.asmx";
public void getcount (String x) {
    final String METHOD_NAME = "getcount";
    final String SOAP_ACTION = "http://tempuri.org/getcount";
    SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
    request.addProperty("x", x);
    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    envelope.dotNet = true;
    envelope.setOutputSoapObject(request);
    HttpTransportSE androidHttpTransport = new HttpTransportSE(URL,8000);
    Object respose = null;
    try {
        androidHttpTransport.call(SOAP_ACTION, envelope);
        SoapObject result = (SoapObject) envelope.getResponse();
        ContactResult.getcountResult = result.getProperty("").toString();
    }  catch (HttpResponseException e) {
        e.printStackTrace();
    } catch (XmlPullParserException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}






