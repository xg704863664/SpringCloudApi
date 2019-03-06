package com.test.orderclient.FallBack;

import com.test.orderclient.client.RpcClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RpcClientFallBack implements RpcClient {
    @Override
    public List<String> getInfo() {
        List<String> strings = new ArrayList<>();
        strings.add("服务器断路了");
        return strings;
    }
}
