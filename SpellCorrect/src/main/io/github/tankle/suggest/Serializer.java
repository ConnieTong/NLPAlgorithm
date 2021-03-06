package io.github.tankle.suggest;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by IDEA
 * User: hztancong
 * Date: 2017/6/26
 * Time: 16:49
 */
public class Serializer {
//    private static final Logger log = LoggerFactory.getLogger(Serializer.class);


    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Hessian2Output out = new Hessian2Output(bos);
        out.writeObject(obj);
        out.close();
        return bos.toByteArray();
    }

    public static Object deserialize(byte[] data) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        Hessian2Input in = new Hessian2Input(bis);
        return in.readObject();
    }
}
