package org.carlspring.strongbox.configuration;

import org.carlspring.strongbox.resource.ConfigurationResourceResolver;
import org.carlspring.strongbox.yaml.YAMLMapperFactory;
import org.carlspring.strongbox.yaml.YamlFileManager;
import org.carlspring.strongbox.yaml.repository.RepositoryConfiguration;
import org.carlspring.strongbox.yaml.repository.remote.RemoteRepositoryConfiguration;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

/**
 * @author Przemyslaw Fusik
 */
@Component
public class ConfigurationFileManager
        extends YamlFileManager<MutableConfiguration>
{

    @Inject
    private ConfigurationResourceResolver configurationResourceResolver;

    @Inject
    public ConfigurationFileManager(YAMLMapperFactory yamlMapperFactory)
    {
        super(yamlMapperFactory, RepositoryConfiguration.class, RemoteRepositoryConfiguration.class);
    }

    @Override
    public String getPropertyKey()
    {
        return "strongbox.config.file";
    }

    @Override
    public String getDefaultLocation()
    {
        return "etc/conf/strongbox.yaml";
    }

    @Override
    public ConfigurationResourceResolver getConfigurationResourceResolver()
    {
        return configurationResourceResolver;
    }

}
