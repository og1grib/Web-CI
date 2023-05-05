package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/local.properties")

public interface ProjectConfig extends Config{
    @Key("base_url")
    String baseUrl();
}
