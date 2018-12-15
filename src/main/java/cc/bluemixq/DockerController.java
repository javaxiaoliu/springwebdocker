package cc.bluemixq;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
public class DockerController {
	
    @RequestMapping("/")
    public String index() {
        String pcInfo = "";
        InetAddress inetAddress;//声明InetAddress对象
        try {
            inetAddress=InetAddress.getLocalHost();//实例化InetAddress对象，返回本地主机
            String hostName=inetAddress.getHostName();//获取本地主机名
            String canonicalHostName=inetAddress.getCanonicalHostName();//获取此 IP地址的完全限定域名
            byte[] address=inetAddress.getAddress();//获取原始IP地址
            int a=0;
            if(address[3]<0){
                a=address[3]+256;
            }
            String hostAddress=inetAddress.getHostAddress();//获取本地主机的IP地址
            boolean reachable=inetAddress.isReachable(2000);//获取布尔类型，看是否能到达此IP地址
            System.out.println(inetAddress.toString());
            System.out.println("主机名为："+hostName);//输出本地主机名
            System.out.println("此IP地址的完全限定域名："+canonicalHostName);//输出此IP地址的完全限定域名
            System.out.println("原始IP地址为："+address[0]+"."+address[1]+"."+address[2]+"."+a);//输出本地主机的原始IP地址
            System.out.println("IP地址为："+hostAddress);//输出本地主机的IP地址
            System.out.println("是否能到达此IP地址："+reachable);
            pcInfo+=inetAddress.toString()+"</br>";
            pcInfo+="主机名为："+hostName+"</br>";
            pcInfo+="此IP地址的完全限定域名："+canonicalHostName+"</br>";
            pcInfo+="原始IP地址为："+address[0]+"."+address[1]+"."+address[2]+"."+a+"</br>";
            pcInfo+="IP地址为："+hostAddress+"</br>";
            pcInfo+="是否能到达此IP地址:"+reachable+"</br>";


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return "Hello Docker!!!!!!!"+pcInfo;
    }
}