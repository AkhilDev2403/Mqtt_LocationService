package com.example.Mqtt.Repository;

import com.example.Mqtt.Entity.MqttEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MqttRepository extends JpaRepository<MqttEntity, Long> {
}
