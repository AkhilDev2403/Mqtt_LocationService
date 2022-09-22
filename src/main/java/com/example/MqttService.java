package com.example;

import com.example.Mqtt.Entity.MqttEntity;
import com.example.Mqtt.Repository.MqttRepository;
import lombok.extern.log4j.Log4j2;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.util.Objects;

@Configuration
@Log4j2
public class MqttService {

    @Autowired
    MqttRepository mqttRepository;

    @Value("${server_url}")
    private String serverUrl;

    @Value("${user_name}")
    private String userName;

    @Value("${password}")
    private String password;


    public MqttPahoClientFactory mqttPahoClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[]{serverUrl});
        options.setUserName(userName);
        String pwd = password;
        options.setPassword(pwd.toCharArray());
        options.setCleanSession(true);
        factory.setConnectionOptions(options);
        return factory;
    }

    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageProducer inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter("spring-client-id-Akhil1999",
                mqttPahoClientFactory(),"#");
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(2);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return message -> {
            String topic= Objects.requireNonNull(message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC)).toString();
            System.out.printf(topic.toString());
            if (topic.equals("akhil-test")) {

                JSONArray array = new JSONArray(message.getPayload().toString());
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    String Uuid = object.getString("ibeaconUuid");
                    Integer Major = object.getInt("ibeaconMajor");
                    Integer Minor = object.getInt("ibeaconMinor");

                    System.out.println(object.getString("ibeaconUuid"));
                    System.out.println(object.getInt("ibeaconMajor"));
                    System.out.println(object.getInt("ibeaconMinor"));

                    MqttEntity mqttEntity1 = new MqttEntity();
                    mqttEntity1.setUuid(Uuid);
                    mqttEntity1.setMajor(Major);
                    mqttEntity1.setMinor(Minor);

                    mqttRepository.save(mqttEntity1);

                }
            }

        };
    }

}
